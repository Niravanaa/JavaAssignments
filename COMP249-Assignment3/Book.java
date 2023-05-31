// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import java.io.Serializable;

/**
 * Book is a class that implements the Serializable interface.
 * It represents a book and contains information such as the title, authors, price, ISBN, genre, and year.
 */
public class Book implements Serializable {
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author(s) of the book.
     */
    private String authors;

    /**
     * The price of the book.
     */
    private double price;

    /**
     * The ISBN (International Standard Book Number) of the book.
     */
    private String isbn;

    /**
     * The genre of the book.
     */
    private String genre;

    /**
     * The year the book was published.
     */
    private int year;

    /**
     * Constructs a new Book object with the specified properties.
     *
     * @param title   the title of the book.
     * @param authors the author(s) of the book.
     * @param price   the price of the book.
     * @param isbn    the ISBN of the book.
     * @param genre   the genre of the book.
     * @param year    the year the book was published.
     */
    public Book(String title, String authors, double price, String isbn, String genre, int year) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Returns true if a Book object is equal to the current Book object, false otherwise.
     * 
     * @param other the other Book object to be compared
     * @return true if both Book objects are equal, false otherwise.
     */
    public boolean equals(Book other) {
        if (!this.title.equals(other.title) ||
            !this.authors.equals(other.authors) ||
            this.price != other.price ||
            !this.isbn.equals(other.isbn) ||
            !this.genre.equals(other.genre) ||
            this.year != other.year) {
            return false;
        }

        return true;
    }
    /**
     * Returns a string representation of the Book object.
     *
     * @return a string representation of the Book object.
     */
    public String toString() {
        return "Title: " + this.title + "; Authors: " + this.authors + "; Price: " + this.price + "; ISBN: " + this.isbn + "; Genre: " + this.genre + "; Year: " + this.year;
    }

    /**
     * Returns the title of the book
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the book
     * @param title the new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the authors of the book
     * @return the authors of the book
     */
    public String getAuthors() {
        return this.authors;
    }

    /**
     * Sets the authors of the book
     * @param authors the new authors of the book
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * Returns the price of the book
     * @return the price of the book
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the book
     * @param price the new price of the book
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the ISBN of the book
     * @return the ISBN of the book
     */
    public String getISBN() {
        return this.isbn;
    }

    /**
     * Sets the ISBN of the book
     * @param isbn the new ISBN of the book
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the genre of the book
     * @return the genre of the book
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Sets the genre of the book
     * @param genre the new genre of the book
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the year of the book
     * @return the year of the book
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year the book was published
     * @param year the new year the book was published
     */
    public void setYear(int year) {
        this.year = year;
    }
}