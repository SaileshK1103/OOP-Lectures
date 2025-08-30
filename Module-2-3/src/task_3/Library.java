package task_3;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Adda book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library Catalog: ");
        int index = 1;
        for (Book book : books) {
            System.out.println(index+"."+book);
            index++;
        }
    }

    //  Borrow a book by title
    public boolean borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                borrowedBooks.add(book);
                books.remove(i);
                System.out.println("Borrowed: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book with title \"" + title + "\" could not be borrowed.");
        return false;
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
                System.out.println(i + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
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
                System.out.println("Title: " +book.getTitle() + ", Year: " +book.getPublicationYear());
                found = true;
            }
        }
        if(!found) {
            System.out.println("No books found by " + author);
        }
    }
    // isBookAvailable
    public boolean isBookAvailable(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }
}
