package task_3;

import task_6.User;

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
            System.out.println("8. Rate book with title");
            System.out.println("9. Review book with title");
            System.out.println("10. Show Rating Statistics");
            System.out.println("11. Most Reviewed Book");
            System.out.println("12. Add a User");
            System.out.println("13. Display all users");
            System.out.println("14. Exit");
            System.out.print("Choose an option (1-14): ");

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
                    System.out.println("Enter user name: ");
                    String borrowUser = input.nextLine();

                    User userBorrow = library.getUserByName(borrowUser);;
                    if(userBorrow == null) {
                        System.out.println("User not found. Please add the user first.");
                        break;
                    }
                    System.out.println("Enter book title to borrow: ");
                    String borrowTitle = input.nextLine();
                    if(library.borrowBook(borrowTitle, userBorrow)) {
                        System.out.println(userBorrow.getName() + " borrowed " + borrowTitle + " successfully.");
                    }
                    else {
                        System.out.println("Book with title "+borrowTitle+"could not be borrowed.");
                    }
                    break;

                case 5: // Return a book - Modification for task-6
                    System.out.println("Enter user name: ");
                    String returnUser = input.nextLine();

                    User userReturn = library.getUserByName(returnUser);
                    if(userReturn == null) {
                        System.out.println("User not found. Please add the user first.");
                        break;
                    }
                    System.out.print("Enter a book title to return: ");
                    String returnTitle = input.nextLine();

                    if (library.returnBook(returnTitle, userReturn)) {
                        System.out.println(userReturn.getName() + " returned " + returnTitle + " successfully.");
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
               // Refer to task4 rating choice
                case 8:
                    System.out.print("Enter book title to rate: ");
                    String rateTitle = input.nextLine();
                    System.out.print("Enter rating (0-5): ");
                    double rating = input.nextDouble();
                    input.nextLine(); // consume newline
                    library.rateBook(rateTitle, rating);
                    break;
                // Refer to task4 review choice
                case 9:
                    System.out.print("Enter book title to review: ");
                    String reviewTitle = input.nextLine();
                    System.out.print("Enter your review: ");
                    String review = input.nextLine();
                    library.reviewBook(reviewTitle, review);
                    break;
                // Refer to task-5 : Rating statistics
                case 10:
                    System.out.println("Average book rating: "+library.getAverageBookRating());
                    break;
                // Refer to task-5 : books most reviews
                case 11:
                    Book mostReviewed = library.getMostReviewedBook();
                    if(mostReviewed != null) {
                        System.out.println("Most reviewed book: "+mostReviewed.getTitle()+"("+mostReviewed.getReviews().size()+" reviews");
                    }
                    else{
                        System.out.println("No books found.");
                    }
                    break;
                // Refer to task-6
                case 12:
                    System.out.println("Enter user name: ");
                    String name = input.nextLine();
                    System.out.println("Enter your age: ");
                    int age = input.nextInt();
                    input.nextLine(); // consume newline
                    library.addUser(new User(name,age));
                    break;
                // Refer to task-6
                case 13:
                    library.displayUsers();
                    break;

                case 14: // Exit
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

