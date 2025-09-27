package view;

import controller.NoteController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;

/**
 * Handles all user interactions and updates the UI
 * This class acts as the View in the MVC pattern and communicates with the NoteController.
 */
public class NoteViewController {
    // FXML injected UI components
    @FXML private TextField titleField;
    @FXML private ListView<Note> noteListView;
    @FXML private TextArea contentArea;
    @FXML private TextArea contentDisplayArea;

    // Reference to the application Controller to be injected by the main class
    private NoteController controller;

    /**
     * Runs immediately after the FXML component are loaded.
     */
    @FXML
    public void initialize() {
        // Set the output area to read-only
        contentDisplayArea.setEditable(false);
        // Listener for selection changes in the ListView, content content display is managed
        noteListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null) {
                        // When a Note is selected, display its content
                        contentDisplayArea.setText(newValue.getContent());
                    }
                    else  {
                        contentDisplayArea.setText("");
                    }

        });
    }

    /**
     * Called by the main application class to inject the NoteController dependency
     * @param controller The application controller instance.
     */
    public void setController(NoteController controller){
        this.controller = controller;
        updateNoteList(); // Load initial data
    }

    /**
     * Event handler for the "Add Note" button click (linked via FXML).
     * Creates a new Note and updates the list
     */
    @FXML
    private void handleAddNote(){
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if(!title.isEmpty() && !content.isEmpty()){
            // Controller handles the business logic (create and save the note)
            controller.addNewNote(title, content);
             // View updates its display based on the new Model state
            updateNoteList();

            // Clear input fields
            titleField.clear();
            contentArea.clear();
        }
        else {
            // Simple feedback for the user
            System.out.println("Error: Both title and content must be provided.");
        }
    }

    /**
     * Updates the ListView with the current list of notes from the Model.
     */
    private void updateNoteList(){
        // clear the current list and populate it with notes from the Controller
        noteListView.getItems().clear();
        noteListView.getItems().addAll(controller.getNotesList());
    }


}
