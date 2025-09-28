package view;

import controller.NoteController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Note;

/**
 * Handles all user interactions and updates the UI
 * This class acts as the View in the MVC pattern and communicates with the NoteController.
 */
public class NoteViewController {
    // FXML injected UI components
    @FXML private TextField titleField;
    @FXML private ListView<Note> noteListView;
    @FXML private TextArea contentArea; // For note input
    @FXML private TextArea contentDisplayArea; // For viewing selected note content
    @FXML private Button addUpdateButton; // Used for both Add and Update actions.
    @FXML private Button editButton;
    @FXML private Button deleteButton;


    // Internal state tracking
    private NoteController controller;
    private Note selectedNote = null; // Tracks the note selected in the list.

    /**
     * Runs immediately after the FXML component are loaded.
     * Setup up listeners and initial UI state.
     */
    @FXML
    public void initialize() {
        // Set the output area to read-only
        contentDisplayArea.setEditable(false);
        // Buttons are initially disabled until a note is selected
        editButton.setDisable(true);
        deleteButton.setDisable(true);

        // Listener for selection changes in the ListView
        noteListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null) {
                        // Display the content in the dedicate area
                        contentDisplayArea.setText(newValue.getContent());
                        selectedNote = newValue;
                        // Enable edit/delete buttons
                        editButton.setDisable(false);
                        deleteButton.setDisable(false);
                    }
                    else  {
                        contentDisplayArea.setText("");
                        selectedNote = null;
                        editButton.setDisable(true);
                        deleteButton.setDisable(true);
                    }
        });
    }

    /**
     * Called by the main application class to inject the NoteController dependency
     * @param controller The application controller instance.
     */
    public void setController(NoteController controller){
        this.controller = controller;
        this.controller.setViewController(this);

        // Load initial data
        updateNoteList(); // Load initial data
    }

    /**
     * Event handler for the "Add Note" button click (linked via FXML).
     * Creates a new Note and updates the list
     */
    @FXML
    private void handleAddOrUpdateNote(){
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if(!title.isEmpty() && !content.isEmpty()){
            // Controller handles the business logic (create and save the note)
            controller.addNewNote(title, content);
            // After successful save, reset the UI
            resetInputFieldsAndButton();
        }
        else {
            // Simple feedback for the user
            Alert alert = new Alert(Alert.AlertType.WARNING, "Title and content cannot be empty", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * Handles the click for the "Edit" button. Loads selected note into input fields.
     */
    @FXML
    private void handleEditNote(){
        if(selectedNote != null){
            // Load data into input fields
            titleField.setText(selectedNote.getTitle());
            contentArea.setText(selectedNote.getContent());

            // Notify controller that editing has started and set the target note
            controller.startEdit(selectedNote);

            // Change the button text to prompt the user to save the update
            addUpdateButton.setText("Update Note");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a note to edit.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     * Handles the click for the "Delete" button
     */
    @FXML
    public void handleDeleteNote(){
        if(selectedNote != null){
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you sure you want to delete the note '" +selectedNote.getTitle() +"'?",
                    ButtonType.YES, ButtonType.NO);
            confirmation.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    controller.deleteNote(selectedNote);
                    resetInputFieldsAndButton();
                }
            });
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a note to delete.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    /**
     *
     * Resets the input fields and the action button state
     */
    public void resetInputFieldsAndButton(){
        titleField.clear();
        contentArea.clear();
        addUpdateButton.setText("Add Note");
        noteListView.getSelectionModel().clearSelection();
    }

    /**
     * Updates the ListView with the current list of notes from the Model.
     * This is called by the controller after a successful save or delete.
     */
    public void updateNoteList(){
        // clear the current list and populate it with notes from the Controller
        noteListView.getItems().clear();
        noteListView.getItems().addAll(controller.getNotesList());
    }


}
