// Nirav Patel #40248940
// COMP249
// Assignment # 4
// Due Date Monday, April 17, 2023

/**
 * This class is used to generate Book objects that contain information pertaining to a book.
 * @author Nirav
 */
public class Book {
    private String title;
    private String author;
    private double price;
    private long ISBN;
    private String genre;
    private int year;

    /**
     * The Book constructor creates a Book object containing six different pieces of information.
     * @param title The title of the book
     * @param author The author(s) of the book
     * @param price The price of the book
     * @param ISBN The ISBN of the book
     * @param genre The abbreviated genre of the book
     * @param year The year of publication of the book
     */
    public Book(String title, String author, double price, long ISBN, String genre, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.ISBN = ISBN;
        this.genre = genre;
        this.year = year;
    }

    /**
     * This method returns the String representation of the calling Book object.
     */
    public String toString() {
        return this.title + ", " + this.author + ", " + this.price + ", " + this.ISBN + ", " + this.genre + ", " + this.year;
    }

    /**
     * This method returns the title of the calling Book object.
     * @return The title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * This method returns the author(s) of the calling Book object.
     * @return The author(s) of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * This method returns the price of the calling Book object.
     * @return The price of the book
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This method returns the ISBN of the calling Book object.
     * @return The ISBN of the book
     */
    public long getISBN() {
        return this.ISBN;
    }

    /**
     * This method returns the genre of the calling Book object.
     * @return The genre of the book
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * This method returns the year of publication of the calling Book object.
     * @return The year of publication of the book
     */
    public int getYear() {
        return this.year;
    }
}