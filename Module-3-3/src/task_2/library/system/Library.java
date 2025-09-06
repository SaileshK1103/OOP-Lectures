package task_2.library.system;

import task_2.library.model.Book;
import task_2.library.model.LibraryMember;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addMember(LibraryMember member){
        members.add(member);
    }

    // Refer to task-3 borrow
    public void borrowBook(LibraryMember member, Book book){
        if(books.contains(book) && !book.isReserved()){
            member.borrowBook(book);
            books.remove(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        }
        else{
            System.out.println("Book not available for borrowing: " + book.getTitle());
        }
    }

    // Return
    public void returnBook(LibraryMember member, Book book){
        if(member.getBorrowedBooks().contains(book)){
            member.returnBook(book);
            books.add(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        }
        else{
            System.out.println("This book was not borrowed by " + member.getName());
        }
    }

    // Refer to task-3 book reservation
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved() && books.contains(book)) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully: " + book.getTitle());
        } else {
            System.out.println("Book is already reserved or not available.");
        }
    }
    // Cancel reservation
    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled: " + book.getTitle());
        } else {
            System.out.println("This reservation cannot be canceled.");
        }
    }

    // Display reservation
    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book b : member.getReservedBooks()) {
            System.out.println(b.getTitle());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    public List<LibraryMember> getMembers() {
        return members;
    }

}
