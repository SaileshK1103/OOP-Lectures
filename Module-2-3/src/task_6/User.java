package task_6;

import task_3.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private List<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public List<Book> getBorrowedBooks(Book book) {
        return borrowedBooks;
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", borrowedBooks=" + borrowedBooks.size() + "}";
    }
}
