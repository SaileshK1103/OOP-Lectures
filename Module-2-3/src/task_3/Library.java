package task_3;

import task_6.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // Adda book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Refer to task6 - add user method
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: "+user.getName());
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
    // Modify method with user refer to task-6
    public boolean borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                borrowedBooks.add(book);
                user.borrowBook(book);
                books.remove(book);
                System.out.println(user.getName() + " borrowed: " + title);
                return true;
            }
        }
        System.out.println("Book not available: " + title);
        return false;
    }

    // Return a book to the library
    public boolean returnBook(String title, User user) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                books.add(book);
                user.returnBook(book);
                System.out.println(user.getName() + " returned: " + title);
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

    // Task 4 Rate method
    public boolean rateBook(String title, double rating){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title.trim())){
                book.setRating(rating);
                System.out.println("Rated \""+title+"\"with"+rating+ "stars");
                return true;
            }
        }
        System.out.println("Book with title \""+title+"\" not found.");
        return false;
    }

    // Task4 Review method
    public boolean reviewBook(String title, String review) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                book.addReview(review);
                System.out.println("Review added for \"" + title + "\": " + review);
                return true;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
        return false;
    }

    // Refer to Task-5 - Calculate average rating of all books
    public double getAverageBookRating() {
        if(books.isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        int count = 0;
        for(Book book : books){
            if(book.getRating() > 0){
                // consider only rated books
                total += book.getRating();
                count++;
            }
        }
        return count > 0 ? total / count : 0.0;
    }

    // Refer to task-5 find most reviewed book
    public Book getMostReviewedBook() {
        if(books.isEmpty()){
            return null;
        }
        Book mostReviewed = books.get(0);
        for(Book book : books){
            if(book.getReviews().size() > mostReviewed.getReviews().size()){
                mostReviewed = book;
            }
        }
        return mostReviewed;
    }

    // Refer to task6 - list all users
    public void displayUsers() {
        if(users.isEmpty()){
            System.out.println("No registered users.");
        }
        else{
            System.out.println("Registered users:");
            for(User user : users){
                System.out.println(user);
            }
        }
    }

    // Refer to task-6 : Find user by name method
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name.trim())) {
                return user;
            }
        }
        return null;
    }
}
