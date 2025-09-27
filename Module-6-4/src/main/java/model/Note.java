package model;

/**
 * Represents a single note entry with a tile and content
 * Foolows the standard data model pattern with getters and setters
 */
public class Note {
    // Properties
    private String title;
    private String content;

    /**
     * Constructor to create a new Note
     * @param title
     * @param content
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters
    /**
     * @return The title of the note
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The content of the note
     */
    public String getContent() {
        return content;
    }

    // Setters
    /**
     * Sets a new title for the note.
     * @param title The new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets new content for the note.
     * @param content The new content.
     */
    public void setContent(String content) {
        this .content = content;
    }

    @Override
    public String toString() {
        return title;
    }
}
