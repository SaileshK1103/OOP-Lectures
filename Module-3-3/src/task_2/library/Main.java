package task_2.library;

import task_2.library.model.Book;
import task_2.library.model.LibraryMember;
import task_2.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Books
        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", "ISBN003");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Members
        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        library.addMember(member1);
        library.addMember(member2);

        // Borrow + Return
        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);

        // Reservation
        library.reserveBook(member2, book2);
        library.displayReservedBooks(member2);
        library.cancelReservation(member2, book2);

    }
}
