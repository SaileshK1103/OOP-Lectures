package task_1;

public class Book {
    private final String title;
    private final String author;
    private final int publication_year;

    public Book(String title, String author, int publication_year ) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public String toString() {
         return ("Title: \"" +title +"\", Author: \"" +author +"\", Year: " +publication_year);
    }
    public static void main(String[] args) {
       Book  book1 = new Book("Introduction to OOP Programming", "Jarkko Vuori", 2025);
       System.out.println(book1.toString());
    }
}
