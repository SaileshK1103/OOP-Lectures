package task_1;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while(running) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Find Books by Author");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = input.nextInt();
            input.nextLine();
            switch(choice) {
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

                case 4: // Exit
                    System.out.println("Exiting the Library System. Goodbye!");
                    running = false;
                    break;

                    default:
                        System.out.println("Invalid option! Please choose 1-4");
            }
        }
        input.close();

    }
}
