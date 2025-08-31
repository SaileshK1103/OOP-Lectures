package task_3;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String title;
    private final String author;
    private final int publication_year;

    // Task 4
    private double rating;
    private List<String> reviews;

    public Book(String title, String author, int publication_year){
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
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

    // getter rating - task4
    public double getRating(){
        return rating;
    }

    public List<String> getReviews(){return reviews;}

    // Set rating - refer to task4
    public void setRating(double rating){
        if(rating > 0 && rating<=5){
            this.rating = rating;
        }
        else {
            System.out.println("Invalid rating! Please enter between 0 and 5.");
        }
    }

    // Add review - refer to task4
    public void addReview(String review){
        reviews.add(review);
    }


    @Override
    public String toString(){
        return ("Title: \"" +title +"\", Author: \"" +author +"\", Year: " +publication_year+",Rating: " +rating+",Review: "+reviews);

    }

}
