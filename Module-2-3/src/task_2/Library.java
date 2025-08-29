package task_2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Library Catalog:");
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ". " + book);
            index++;
        }
    }

    //  Borrow a book by title
    public boolean borrowBook(String title) {
        title = title.trim();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                borrowedBooks.add(book);
                System.out.println("Borrowed: " + book.getTitle());
                return true; // borrowed successfully
            }
            System.out.println("Book not available: " + title);
            return false;
        }
        return false; // not found
    }
    // Return a book to the library
    public boolean returnBook(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                books.add(book);
                System.out.println("Returned: " + book.getTitle());
                return true;
            }
        }
        return false; // not borrowed
    }

    // Display all borrowed books
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            int i = 1;
            for (Book book : borrowedBooks) {
                System.out.println(i + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublication_year());
                i++;
            }
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
