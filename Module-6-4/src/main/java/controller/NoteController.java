package controller;

import model.Note;
import model.NoteBook;
import view.NoteViewController;

import java.util.List;

/**
 * The Controller acts as the intermediary, handling user actions
 * (e.g adding, editing, deleting a note and managing communication with the NoteBook(Model)
 */
public class NoteController {
    // Reference to the Model layer
    private final NoteBook notebook;
    private NoteViewController view;
    // State variable to track which note is currently selecting for editing.
    private Note currentlyEditing;

    /**
     * Initialize the Controller by injecting the required NoteBook instance.
     * @param notebook The instance of the NoteBook model.
     */
    public NoteController(NoteBook notebook) {
        this.notebook = notebook;
    }

    /**
     * Inject the View Controller to establish the link
     */

    public void setViewController(NoteViewController view) {
        this.view = view;
    }
    /**
     * Handles the "Add"  or  "Update "user interaction.
     * Creates a new Note object and adds it to the Notebook model.
     * @param title The title entered by the user in the View
     * @param content The content entered by the user in the View.
     */
    public void addNewNote(String title, String content){
        // create the Note to the model
        if(currentlyEditing != null){
            // if edit mode, update existing note object
            currentlyEditing.setTitle(title);
            currentlyEditing.setContent(content);
            currentlyEditing = null; // Exit edit mode after update
        }
        else {
            // Otherwise create and add anew note
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
        }
        // notify the view to update it's display after a successful save/edit
        if(view != null){
            view.updateNoteList();
        }
    }

    /**
     * Handles the "Delete" user interaction
     */
    public void deleteNote(Note noteToDelete){
        notebook.removeNote(noteToDelete);

        // If the deleted note was the one being edited, clear the edit state
        if(currentlyEditing == noteToDelete){
            currentlyEditing = null;
        }
        // Notify the view to update.
        if(view != null){
            view.updateNoteList();
        }
    }

    /**
     * Puts the controller into edit mode for a selected note.
     * This is called by the View when the user clicks the "Edit" button.
     */
    public void startEdit(Note noteToEdit){
        this.currentlyEditing = noteToEdit;
    }

    /**
     * Retrieves all notes from the Model for display in the View.
     * @return a list of all Note objects currently in the Notebook
     */
    public List<Note> getNotesList(){
        return notebook.getAllNotes();
    }
}
