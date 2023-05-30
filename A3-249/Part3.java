// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The Part3 class contains the third part of the program.
 * 
 * @author Nirav
 */
public class Part3 {
	/**
     * The do_part3() method of the program first reads the serialized binary files and organizes each file into arrays of valid Book objects.
     * The method then runs an interactive program that enables the user to select any of the genres and its corresponding records.
     */
    public static void do_part3() {
        // This String array will hold the names of the binary files that contain the serialized records.
        String[] binaryGenreFileNames = null;

        // This 2-D Book Array will hold as many genres in rows and as many Book objects as columns for each row as each genre possesses.
        Book[][] arrayOfArraysOfBooks = null;

        // This Integer will hold the number of files to read.
        int numberOfFiles = 0;

        // This Integer will hold the number of rows contained in the Book[][] 2-D array.
        int mainArraySize = 0;

        // This ObjectInputStream will read the serialized Book objects from the binary files.
        ObjectInputStream ois = null;

        // This Scanner object will read the number of files to read from the output text file.
        Scanner scan = null;

        try {
            scan = new Scanner(new FileInputStream("part1_output_file_names.txt"));

            numberOfFiles = scan.nextInt() - 1;

            scan.nextLine();

            arrayOfArraysOfBooks = new Book[numberOfFiles][0];

            binaryGenreFileNames = new String[numberOfFiles];

            for (int i = 0; i < numberOfFiles; i++) {
                binaryGenreFileNames[i] = scan.nextLine() + ".ser";
            }

            scan.close();
        } catch (Exception e) {
            System.out.println("There was an error reading the output file names!");
        }

        try {
            for (int i = 0; i < numberOfFiles; i++) {
                // This Integer will serve to increase the array of Books of a particular genre by one.
                int counter = 0;

                // This Book array will hold all the Book objects of a particular class.
                Book[] arrayOfBooks = new Book[0];

                ois = new ObjectInputStream(new FileInputStream(binaryGenreFileNames[i]));

                try {
                    while (true) {
                        // This Book object holds what the ObjectInputStream will read.
                        Book record = (Book) ois.readObject();

                        arrayOfBooks = Arrays.copyOf(arrayOfBooks, counter + 1);

                        arrayOfBooks[counter] = record;

                        counter++;
                    }
                } catch (Exception e) {
                    arrayOfArraysOfBooks = Arrays.copyOf(arrayOfArraysOfBooks, mainArraySize + 1);

                    arrayOfArraysOfBooks[mainArraySize] = arrayOfBooks;

                    mainArraySize++;

                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // For the interactive program, the default file displayed will be the file at the 0th index of the Main Array of Books.
        int currentFilePosition = 0;

        // This Scanner object will read the user's input and accordingly run commands.
        Scanner userInput = new Scanner(System.in);

        // The user's current option is default to an empty String.
        String currentOption = "";

        while (!currentOption.equals("x")) {
            System.out.println("-----------------------------");
            System.out.println("          Main Menu          ");
            System.out.println("-----------------------------");
            System.out.println("v View the selected file: " + binaryGenreFileNames[currentFilePosition] + " (" + arrayOfArraysOfBooks[currentFilePosition].length + " records)");
            System.out.println("s Select a file to view");
            System.out.println("x Exit");
            System.out.println("-----------------------------\n");
            System.out.print("Enter Your Choice: ");

            do {
                currentOption = userInput.next().toLowerCase();

            } while (!currentOption.equals("v") && !currentOption.equals("s") && !currentOption.equals("x"));

            switch (currentOption) {
            case "v": {
                // This Integer defaults the first record to display as the record located at the 0th index position of the genre's Book array.
                int currentPosition = 0;

                System.out.println("\nviewing " + binaryGenreFileNames[currentFilePosition] + " (" + arrayOfArraysOfBooks[currentFilePosition].length + " records)");

                // This Integer is used to manipulate how many Book objects to display depending on the user's input.
                int currentDisplay = 1;

                // This Integer is used to store what the user will input when asked to enter a viewing range.
                int integerEntered = 1;

                while (integerEntered != 0) {

                    do {
                        System.out.print("\nEnter a viewing integer: ");

                        while (!userInput.hasNextInt()) {
                            System.out.println("Please enter a valid integer.");
                            userInput.next();
                        }
                        integerEntered = userInput.nextInt();
                    } while (integerEntered >= Integer.MAX_VALUE || integerEntered <= Integer.MIN_VALUE);

                    System.out.println();

                    if (integerEntered == 1 || integerEntered == -1) {
                        System.out.println(arrayOfArraysOfBooks[currentFilePosition][currentPosition]);

                        continue;
                    }

                    if (integerEntered > 1) {
                        // This boolean stores whether the end of the array has been reached, and whether to display the EOF message.
                        boolean endReached = false;

                        if (integerEntered + currentPosition > arrayOfArraysOfBooks[currentFilePosition].length) {
                            endReached = true;
                            currentDisplay = arrayOfArraysOfBooks[currentFilePosition].length - 1;
                        } else {
                            currentDisplay = currentPosition + integerEntered - 1;
                        }

                        for (int i = currentPosition; i <= currentDisplay; i++) {
                            System.out.println(arrayOfArraysOfBooks[currentFilePosition][i]);
                        }

                        if (endReached) {
                            System.out.println("EOF has been reached");
                        }

                        currentPosition = currentDisplay;

                        continue;
                    }

                    if (integerEntered < -1) {

                        if (currentPosition - Math.abs(integerEntered) + 1 < 0) {
                            currentDisplay = 0;
                            System.out.println("EOF has been reached");
                        } else {
                            currentDisplay = currentPosition - Math.abs(integerEntered) + 1;
                        }

                        for (int i = currentDisplay; i <= currentPosition; i++) {
                            System.out.println(arrayOfArraysOfBooks[currentFilePosition][i]);
                        }

                        currentPosition = currentDisplay;

                    }
                }

                break;
            }
            case "s": {
                // This Integer will store the number of genres that are available to be viewed.
                int counter = arrayOfArraysOfBooks.length;

                System.out.println("\n------------------------------");
                System.out.println("          File Sub-Menu         ");
                System.out.println("------------------------------");

                for (int i = 0; i < counter; i++) {
                    if (binaryGenreFileNames[i].length() >= 28) {
                        System.out.println(" " + (i + 1) + "  " + binaryGenreFileNames[i] + "\t" + "(" + arrayOfArraysOfBooks[i].length + " records)");
                    } else {
                        System.out.println(" " + (i + 1) + "  " + binaryGenreFileNames[i] + "\t\t" + "(" + arrayOfArraysOfBooks[i].length + " records)");
                    }
                }

                System.out.println(" " + (counter + 1) + "  Exit");
                System.out.println("------------------------------\n");

                // This Integer will hold what the user inputs when asked which file to view.
                int integerEntered = 0;

                do {
                    System.out.print("Enter Your Choice: ");

                    while (!userInput.hasNextInt()) {
                        System.out.println("Please enter a valid integer.");
                        userInput.next();
                    }
                    integerEntered = userInput.nextInt();
                } while (integerEntered <= 0 || integerEntered > counter + 1);

                if (integerEntered == counter + 1) {
                    break;
                } else {
                    currentFilePosition = integerEntered - 1;
                }

                break;
            }

            case "x": {
                System.out.println("\nThank you for using the program.");
            }
            }
            
            
        }
        
        userInput.close();
        
        System.exit(0);

    }
}
