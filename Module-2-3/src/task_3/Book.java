package task_3;

public class Book {
    private final String title;
    private final String author;
    private final int publication_year;

    public Book(String title, String author, int publication_year){
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublicationYear(){
        return publication_year;
    }

    @Override
    public String toString(){
        return ("Title: \"" +title +"\", Author: \"" +author +"\", Year: " +publication_year);

    }

}
