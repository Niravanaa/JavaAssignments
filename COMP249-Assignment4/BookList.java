// Nirav Patel #40248940
// COMP249
// Assignment # 4
// Due Date Monday, April 17, 2023

import java.io.*;

/**
 * This class creates a list of Books, each linked to each other through a reference variable.
 * @author Nirav
 */
public class BookList {
    private Node head;

    /**
     * The BookList() constructor creates an empty list of Book objects.
     */
    public BookList() {
        head = null;
    }

    /**
     * This method returns the head node of the calling BookList object.
     * @return The head of the BookList
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * This method sets the head node of the calling BookList object.
     * @param head The new head of the BookList
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * This method adds a node to the calling BookList object.
     * @param b The book that is to be contained in the newly added node
     */
    public void addToStart(Book b) {
        Node newNode = new Node();

        newNode.setB(b);

        if (this.head == null) {
            this.head = newNode;
            this.head.setNext(newNode);
        } else {
            Node current = this.head;
            current.setNext(this.head.getNext());

            while (!current.getNext().getB().equals(this.head.getB())) {
                current = current.getNext();
                current.setNext(current.getNext());
            }

            current.setNext(newNode);

            newNode.setNext(this.head);
        }
    }

    /**
     * This method displays a list of Book objects matching the year specified.
     * @param year The year that is to be searched for
     */
    public void storeRecordsByYear(int year) {
        if (this.head == null) {
            System.out.println("\nThis BookList is empty!");
            return;
        }
        Node current = this.head;
        current.setNext(this.head.getNext());

        PrintWriter pw = null;
        boolean exists = false;

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getB().getYear() == year) {
                exists = true;
                break;
            }

            current = current.getNext();

        }

        current = this.head;
        current.setNext(this.head.getNext());

        if (exists) {
            try {
                pw = new PrintWriter(new FileOutputStream(year + ".txt"));

                while (!current.getNext().getB().equals(this.head.getB())) {
                    if (current.getB().getYear() == year) {
                        pw.println(current.getB());
                    }

                    current = current.getNext();

                    if (current.getNext().getB().equals(this.head.getB()) && current.getB().getYear() == year) {
                        pw.println(current.getB());

                        pw.close();

                        return;
                    }
                }

                pw.close();
            } catch (Exception e) {
                System.out.println("There was an error writing the year file!");
            }
        }
    }

    /**
     * This method inserts a Book node into the calling BookList object
     * @param isbn The ISBN of the Book node that the new node should be added before
     * @param b The Book object that is to be contained within the newly made node
     * @return True if the new node was added, false if the new node was not added
     */
    public boolean insertBefore(long isbn, Book b) {
        if (this.head == null) {
            return false;
        }

        Node current = this.head;
        current.setNext(this.head.getNext());

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getNext().getB().getISBN() == isbn) {
                Node newNode = new Node();

                newNode.setB(b);

                newNode.setNext(current.getNext());

                current.setNext(newNode);

                return true;
            }

            current = current.getNext();
            current.setNext(current.getNext());
        }

        return false;
    }

    /**
     * This method inserts a Book node in between two nodes having specified ISBNs
     * @param isbn1 The ISBN of the first Book node to be added between
     * @param isbn2 The ISBN of the second Book node to be added between
     * @param b The Book object that is to be contained within the new node.
     * @return True if the new node was added, False if the new node was not added
     */
    public boolean insertBetween(long isbn1, long isbn2, Book b) {
        if (this.head == null) {
            return false;
        }

        Node current = this.head;
        current.setNext(this.head.getNext());

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getB().getISBN() == isbn1 && current.getNext().getB().getISBN() == isbn2) {
                Node newNode = new Node();

                newNode.setB(b);

                newNode.setNext(current.getNext());

                current.setNext(newNode);

                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    /**
     * This method displays the contents of the calling BookList object.
     */
    public void displayContent() {
        if (this.head == null) {
            return;
        }

        Node current = this.head;

        if (current.getNext().getB().equals(this.head.getB())) {
            System.out.println(current.getB() + " ==>");
        } else {
            while (!current.getNext().getB().equals(this.head.getB())) {
                System.out.println(current.getB() + " ==>");

                current = current.getNext();

                if (current.getNext().getB().equals(this.head.getB())) {
                    System.out.println(current.getB() + " ==>");
                }
            }
        }

        System.out.println("===> head");
    }

    /**
     * This method deletes any Book nodes that repeat consecutively
     * @return True if identical and consecutive Book nodes were found, False if identical and consecutive Book nodes were not found
     */
    public boolean delConsecutiveRepeatedRecords() {
        if (this.head == null) {
            return false;
        }

        Node current = this.head;
        current.setNext(this.head.getNext());

        boolean copyFound = false;

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getB().toString().equals(current.getNext().getB().toString())) {
                current.setNext(current.getNext().getNext());

                copyFound = true;
            }

            current = current.getNext();

            if (current.getNext().getB().equals(this.head.getB())) {
                this.head = this.head.getNext();
                current.setNext(this.head);

                copyFound = true;
            }
        }

        if (copyFound) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method extracts the Book nodes matching a specific author, and creates a new BookList containing those books.
     * @param aut The specified author name to search for
     * @return An empty BookList if no books matched the author to be found, or a BookList containing Book objects that match the author to be found.
     */
    public BookList extractAuthList(String aut) {
        BookList author = new BookList();

        if (this.head == null) {
            return author;
        }

        Node current = this.head;
        current.setNext(this.head.getNext());

        boolean exists = false;

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getB().getAuthor().toLowerCase().equals(aut.toLowerCase().trim())) {
                exists = true;
                break;
            }

            current = current.getNext();
        }

        current = this.head;
        current.setNext(this.head.getNext());

        if (exists) {
            while (!current.getNext().getB().equals(this.head.getB())) {
                current = current.getNext();

                if (current.getB().getAuthor().toLowerCase().equals(aut.toLowerCase().trim())) {
                    author.addToStart(current.getB());
                }
            }
        }

        return author;
    }

    /**
     * This method swaps two Book nodes that match the two specified ISBNs
     * @param isbn1 The ISBN of the first node to be swapped
     * @param isbn2 The ISBN of the second node to be swapped
     * @return True if the swap was successful, False if the swap was not successful
     */
    public boolean swap(long isbn1, long isbn2) {
        if (this.head == null) {
            return false;
        }

        Node current = this.head;
        current.setNext(this.head.getNext());

        Node first = null;
        boolean firstExists = false;

        Node second = null;
        boolean secondExists = false;

        while (!current.getNext().getB().equals(this.head.getB())) {
            if (current.getB().getISBN() == isbn1) {
                first = current;
                first.setNext(current.getNext());
                firstExists = true;
            } else if (current.getB().getISBN() == isbn2) {
                second = current;
                second.setNext(current.getNext());
                secondExists = true;
            }

            current = current.getNext();

            if (current.getB().getISBN() == isbn1) {
                first = current;
                first.setNext(current.getNext());
                firstExists = true;
            } else if (current.getB().getISBN() == isbn2) {
                second = current;
                second.setNext(current.getNext());
                secondExists = true;
            }
        }

        current = this.head;
        current.setNext(this.head.getNext());

        if (firstExists && secondExists) {
            Node temp = null;
            temp = first.getNext();
            first.setNext(second.getNext());
            second.setNext(temp);

            while (!current.getNext().getB().equals(this.head.getB())) {
                if (current.getNext().getB().getISBN() == isbn1) {
                    current.setNext(second);
                } else if (current.getNext().getB().getISBN() == isbn2) {
                    current.setNext(first);
                }

                current = current.getNext();
            }

            return true;
        }

        return false;
    }

    /**
     * This method outputs the contents of the calling BookList object into a file.
     */
    public void commit() {
        if (this.head == null) {
            System.out.print("\nThis BookList is empty!");
            return;
        }

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileOutputStream("Update_Books.txt"));

            Node current = this.head;
            current.setNext(this.head.getNext());

            while (!current.getNext().getB().equals(this.head.getB())) {
                pw.println(current.getB());

                current = current.getNext();

                if (current.getNext().getB().equals(this.head.getB())) {
                    pw.println(current.getB());

                    break;
                }
            }

            System.out.print("\nSuccessfully committed the BookList!");

            pw.close();
        } catch (Exception e) {
            System.out.println("\nThere was an error committting!");
        }
    }
}