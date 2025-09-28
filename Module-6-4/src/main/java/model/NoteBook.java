package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection notebook for storing Note objects.
 * Provides method for adding, retrieving, and managing the notes.
 */
public class NoteBook {
    //List structure to store all the Note objects.
    private List<Note> notes;

    /**
     * Constructor initializes the notebook with an empty list of notes.
     */
    public NoteBook() {
        // Initialize ArrayList to hold notes
        this.notes = new ArrayList<>();
    }

    /**
     * Retrieves all notes currently stored in th notebook.
     * @return A list of Note objects.
     */
    public List<Note> getAllNotes() {
        // Return a copy of the list to prevent external modification of the internal state.
        return new ArrayList<>(notes);
    }

    /**
     * Adds a new Note object to the notebook.
     * @param note the Note object to add
     */
    public void addNote(Note note) {
        if(note != null) {
            this.notes.add(note);
        }
    }

    /**
     * Removed a specific Note object from the collection.
     * @param note The Note to remove
     * @return true if the note was found and removed, false otherwise.
     */
    public boolean removeNote(Note note) {
        return notes.remove(note);
    }

    /**
     * Retrieves a Note object by its index in the list
     * @param index The index of the note to retrieve (=-based)
     * @return The note object at the specified index, or null if the index is out of bounds.
     */
    public Note getNoteByIndex(int index) {
        if (index >= 0 && index < this.notes.size()) {
            return this.notes.get(index);
        }
        // Return null if the index is invalid
        return null;
    }

    /**
     * @return The total number of notes in te notebook
     */
    public int getNoteCount(){
        return this.notes.size();
    }
}
