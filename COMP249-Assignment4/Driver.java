// Nirav Patel #40248940
// COMP249
// Assignment # 4
// Due Date Monday, April 17, 2023

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This is the driver class of the program, in which
 * an ArrayList containing the bad books are contained,
 * a BookList containing the good books are contained,
 * the bad books are written into the YearErr.txt file,
 * the contents of the BookList are displayed,
 * the interactive program is executed.
 * @author Nirav
 */
public class Driver {

    /**
     * The main() method of the Driver class makes use of all the classes to create the interactive program.
     * @param args Command line arguments passed to the program when it is executed.
     */
    public static void main(String[] args) {
        ArrayList < Book > arrLst = new ArrayList < Book > ();
        BookList bkLst = new BookList();

        Scanner input = null;
        PrintWriter pw = null;

        try {
            input = new Scanner(new FileInputStream("Books.txt"));

            while (input.hasNextLine()) {
                String line = input.nextLine();

                String[] fields = line.split(",");

                if (Integer.parseInt(fields[5]) > 2024) {
                    arrLst.add(new Book(fields[0], fields[1], Double.parseDouble(fields[2]), Long.parseLong(fields[3]), fields[4], Integer.parseInt(fields[5])));
                } else {
                    bkLst.addToStart(new Book(fields[0], fields[1], Double.parseDouble(fields[2]), Long.parseLong(fields[3]), fields[4], Integer.parseInt(fields[5])));
                }
            }

            pw = new PrintWriter(new FileOutputStream("YearErr.txt"));

            for (int i = 0; i < arrLst.size(); i++) {
                pw.println(arrLst.get(i));
            }

            bkLst.displayContent();

            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner userInput = new Scanner(System.in);

        int currentOption = -1;

        while (currentOption != 8) {
            System.out.println("\nPOSSIBLE COMMANDS:");
            System.out.println("1) Give me a year # and I would extract all records of that year and store them in a file for that year");
            System.out.println("2) Ask me to delete all consecutive repeated records;");
            System.out.println("3) Give me an author name and I will create a new list with the records of this author and display them;");
            System.out.println("4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;");
            System.out.println("5) Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
            System.out.println("6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
            System.out.println("7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books;");
            System.out.println("8) Tell me to STOP TALKING. Remember, if you do not commit, I will not!\n");

            do {
                currentOption = userInput.nextInt();

            } while (currentOption > 8 || currentOption < 1);

            switch (currentOption) {
            case 1:
                int yearEntered = -1;

                do {
                    System.out.print("\nPlease provide a year: ");

                    while (!userInput.hasNextInt()) {
                        System.out.println("Please enter a valid year.");
                        userInput.next();
                    }
                    yearEntered = userInput.nextInt();
                } while (yearEntered >= 9999 || yearEntered <= 0);

                bkLst.storeRecordsByYear(yearEntered);

                break;

            case 2:
                if (bkLst.delConsecutiveRepeatedRecords()) {
                    System.out.println("Success!\n");
                    System.out.println("\nHere are the contents of the BookList after removing consecutive duplicates:\n============================================================================");

                    bkLst.displayContent();
                } else {
                    System.out.println("There are no consecutively identical records found!");
                }

                break;

            case 3:
                System.out.print("\nPlease provide the name of an author: ");

                userInput.nextLine();

                String authorName = userInput.nextLine();

                if (bkLst.extractAuthList(authorName).getHead() == null) {
                    System.out.println();
                    System.out.println("No BookList can be created with the author " + authorName + "!");
                } else {
                    System.out.print("\nHere are the contents of the author list for " + authorName + ":\n=============================================");
                    for (int i = 0; i < authorName.length() + 1; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                    bkLst.extractAuthList(authorName).displayContent();
                }

                break;

            case 4:
                long ISBNentered = -1;

                do {
                    System.out.print("\nPlease provide an ISBN number: ");

                    while (!userInput.hasNextLong()) {
                        System.out.print("Please enter a valid ISBN: ");
                        userInput.next();
                    }
                    ISBNentered = userInput.nextLong();
                } while (ISBNentered >= Long.MAX_VALUE || ISBNentered <= 0);

                String[] bookFields = new String[0];

                userInput.nextLine();

                boolean wrong = false;

                do {
                    wrong = false;

                    System.out.print("\nPlease provide a valid Book object that follows the following format:\n\"Title\", Author, Price, ISBN, Genre, Year\n");

                    String book = userInput.nextLine();

                    bookFields = book.split(", ");

                    if (bookFields.length == 6) {
                        try {
                            Double.parseDouble(bookFields[2]);

                            Long.parseLong(bookFields[3]);

                            Integer.parseInt(bookFields[5]);
                        } catch (Exception e) {
                            wrong = true;
                        }
                    }

                } while (wrong || bookFields.length != 6 || Double.parseDouble(bookFields[2]) < 0 || Long.parseLong(bookFields[3]) < 0 || Integer.parseInt(bookFields[5]) < 0 || Long.parseLong(bookFields[3]) > Long.MAX_VALUE || Integer.parseInt(bookFields[5]) > Integer.MAX_VALUE);

                if (bkLst.insertBefore(ISBNentered, new Book(bookFields[0], bookFields[1], Double.parseDouble(bookFields[2]), Long.parseLong(bookFields[3]), bookFields[4], Integer.parseInt(bookFields[5])))) {
                    bkLst.displayContent();

                    System.out.println("\nInsertion success!");
                } else {
                    System.out.println("\nThere was an error inserting!");
                }

                break;

            case 5:
                long ISBN1BetweenEntered = -1;
                long ISBN2BetweenEntered = -1;

                do {
                    System.out.print("\nPlease provide two ISBN numbers: ");

                    while (!userInput.hasNextLong()) {
                        System.out.print("Please enter two valid ISBN numbers: ");
                        userInput.next();
                    }
                    ISBN1BetweenEntered = userInput.nextLong();
                    ISBN2BetweenEntered = userInput.nextLong();
                } while (ISBN1BetweenEntered >= Long.MAX_VALUE || ISBN2BetweenEntered >= Long.MAX_VALUE || ISBN1BetweenEntered <= 0 || ISBN2BetweenEntered <= 0);

                String[] bookBetweenFields = new String[0];

                userInput.nextLine();

                wrong = false;

                do {
                    wrong = false;

                    System.out.print("\nPlease provide a valid Book object that follows the following format:\n\"Title\", Author, Price, ISBN, Genre, Year\n");

                    String book = userInput.nextLine();

                    bookBetweenFields = book.split(", ");

                    if (bookBetweenFields.length == 6) {
                        try {
                            Double.parseDouble(bookBetweenFields[2]);

                            Long.parseLong(bookBetweenFields[3]);

                            Integer.parseInt(bookBetweenFields[5]);
                        } catch (Exception e) {
                            wrong = true;
                        }
                    }
                } while (bookBetweenFields.length != 6 || Double.parseDouble(bookBetweenFields[2]) < 0 || Long.parseLong(bookBetweenFields[3]) < 0 || Integer.parseInt(bookBetweenFields[5]) < 0 || Long.parseLong(bookBetweenFields[3]) > Long.MAX_VALUE || Integer.parseInt(bookBetweenFields[5]) > Integer.MAX_VALUE);

                if (bkLst.insertBetween(ISBN1BetweenEntered, ISBN2BetweenEntered, new Book(bookBetweenFields[0], bookBetweenFields[1], Double.parseDouble(bookBetweenFields[2]), Long.parseLong(bookBetweenFields[3]), bookBetweenFields[4], Integer.parseInt(bookBetweenFields[5])))) {
                    System.out.println();

                    bkLst.displayContent();

                    System.out.println("\nIn between insertion success!");
                } else {
                    System.out.println("\nThere was an error inserting in between!");
                }

                break;

            case 6:
                long ISBN1SwapEntered = -1;
                long ISBN2SwapEntered = -1;

                do {
                    System.out.print("\nPlease provide two ISBN numbers: ");

                    while (!userInput.hasNextLong()) {
                        System.out.print("Please enter two valid ISBN numbers: ");
                        userInput.next();
                    }
                    ISBN1SwapEntered = userInput.nextLong();
                    ISBN2SwapEntered = userInput.nextLong();
                } while (ISBN1SwapEntered >= Long.MAX_VALUE || ISBN2SwapEntered >= Long.MAX_VALUE || ISBN1SwapEntered <= 0 || ISBN2SwapEntered <= 0);

                if (bkLst.swap(ISBN1SwapEntered, ISBN2SwapEntered)) {
                    System.out.println("\nRecords with ISBNs " + ISBN1SwapEntered + " and " + ISBN2SwapEntered + " were found and swapped.\nHere are the contents of the list after swapping:\n=================================================");
                    bkLst.displayContent();

                    System.out.println("\nSwap success!");
                } else {
                    System.out.println("\nThere was an error swapping!");
                }

                break;

            case 7:
                bkLst.commit();
                System.out.println();

                break;

            case 8:
                System.out.println("\nThank you for using the program.");

                break;
            }
        }

        userInput.close();

        System.exit(0);

    }

}