package task_3;

import java.util.Scanner;

public class AvailabilityMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        // Default books
        library.addBook(new Book("Introduction to Java Programming", "John Smith", 2020));
        library.addBook(new Book("Data Structures and Algorithms", "Jane Doe", 2018));
        library.addBook(new Book("The Art of Fiction", "Alice Johnson", 2019));

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Find Books by Author");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Check Book Availability");
            System.out.println("8. Exit");
            System.out.print("Choose an option (1-8): ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add book
                    System.out.print("Enter title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author: ");
                    String author = input.nextLine();

                    System.out.print("Enter1 publication year: ");
                    int year = input.nextInt();
                    input.nextLine(); // consume newLine

                    Book book = new Book(title, author, year);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;

                case 2: // Display all books
                    library.displayBooks();
                    break;
                case 3: // Find books by author
                    System.out.println("Enter author name: ");
                    String searchAuthor = input.nextLine();
                    library.findBookByAuthor(searchAuthor);
                    break;

                case 4: // Borrow a book
                    System.out.println("Enter book title to borrow: ");
                    String borrowTitle = input.nextLine();
                    if(library.borrowBook(borrowTitle)) {
                        System.out.println("Book with title "+borrowTitle+" borrowed successfully.");
                    }
                    else {
                        System.out.println("Book with title "+borrowTitle+"could not be borrowed.");
                    }
                    break;

                case 5: // Return a book
                    System.out.print("Enter a book title to return: ");
                    String returnTitle = input.nextLine();

                    if (library.returnBook(returnTitle)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("This book was not borrowed from the library.");
                    }
                    break;

                case 6: // Display borrowed books
                    library.displayBorrowedBooks();
                    break;

                case 7: // check is book available
                    System.out.println("Enter book title to check availability: ");
                    String checkTitle = input.nextLine();
                    if(library.isBookAvailable(checkTitle)) {
                        System.out.println("Book with title "+checkTitle+" is available");
                    }
                    else {
                        System.out.println("Book with title "+checkTitle+" is not available");
                    }
                    break;

                case 8: // Exit
                    System.out.println("Exiting the Library System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please choose 1-8");
            }
        }
        input.close();
    }
}

