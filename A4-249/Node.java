// Nirav Patel #40248940
// COMP249
// Assignment # 4
// Due Date Monday, April 17, 2023

/**
 * This class creates a Node object that is to be contained in a BookList
 * @author Nirav
 */
public class Node {
    private Book b;
    private Node next;

    /**
     * This method returns the Book object of the calling Node object.
     * @return The book of the Node object
     */
    public Book getB() {
        return this.b;
    }

    /**
     * This method sets the Book object of the calling Node object.
     * @param b The new Book object that is to be contained in the Node object
     */
    public void setB(Book b) {
        this.b = b;
    }

    /**
     * This method returns the next Node object of the calling Node object.
     * @return The next linked Node object
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * This method sets the next Node object of the calling Node object.
     * @param next The new next linked Node object
     */
    public void setNext(Node next) {
        this.next = next;
    }
}