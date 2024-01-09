package QuestionThree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {
    private final static Logger logger = (Logger) LoggerFactory.getLogger(Book.class);
    private String title;
    private String author;
    private int publicationYear;
    private double averageRating;
    private int ratingsCount;
    private String imageUrl;

    public String getTitle() {
        logger.info("get title executed");
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPublicationYear() {
        logger.info("get publication Year executed");
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getImageUrl() {
        logger.info("get Image Url executed");
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAuthor(String name){
        this.author = name;
    }

    public String getAuthor(){
        logger.info("get Author Name executed");
        return this.author;
    }

    public void setRatings(int ratings){
        this.ratingsCount = ratings;
    }

    public int getRatings(){
        logger.info("get Ratings Count executed");
        return this.ratingsCount;
    }

    public void setAverageRating(double averageRating){
        this.averageRating = averageRating;
    }

    public double getAverageRating(){
        logger.info("get title executed");
        return this.averageRating;
    }

}
