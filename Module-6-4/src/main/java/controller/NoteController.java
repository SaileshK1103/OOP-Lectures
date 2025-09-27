package controller;

import model.Note;
import model.NoteBook;

import java.util.List;

/**
 * The Controller acts as the intermediary, handling user actions
 * e.g adding note and managing communication with the NoteBook(Model)
 */
public class NoteController {
    // Reference to the Model layer
    private final NoteBook notebook;

    /**
     * Initialize the Controller by injecting the required NoteBook instance.
     * @param notebook The instance of the NoteBook model.
     */
    public NoteController(NoteBook notebook) {
        this.notebook = notebook;
    }

    /**
     * Handles the "Add" user interaction.
     * Creates a new Note object and adds it to the Notebook model.
     * @param title The title entered by the user in the View
     * @param content The content entered by the user in the View.
     */
    public void addNewNote(String title, String content){
        // create the Note to the model
        Note newNote = new Note(title, content);

        // Add the new Note to the Model
        notebook.addNote(newNote);

        // notify the view to update it's display
    }

    /**
     * Retrieves all notes from the Model for display in the View.
     * @return a list of all Note objects currently in the Notebook
     */
    public List<Note> getNotesList(){
        return notebook.getAllNotes();
    }

    /**
     * Retrieves a specific note from the Model by its index.
     * @param index The 0-based index of the note to retrieve.
     * @return The Note object, or null if the index is invalid
     */
    public Note getNote(int index){
        return notebook.getNoteByIndex(index);
    }
}
