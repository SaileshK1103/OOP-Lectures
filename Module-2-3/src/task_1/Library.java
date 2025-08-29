package task_1;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book>  books = new ArrayList<>();

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books
    public void displayBooks() {
        System.out.println("Library Catalog:");
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ". " + book);
            index++;
        }
    }

    // Find books by author
    public void findBookByAuthor(String author) {
        System.out.println("\nBooks by Author \"" +author+"\":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.getTitle() + ", Year: " +book.getPublication_year());
                found = true;
            }
        }
        if(!found) {
            System.out.println("No books found by " + author);
        }
    }
}
