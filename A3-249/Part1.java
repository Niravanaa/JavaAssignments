// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Part1 class contains the first part of the program.
 * 
 * @author Nirav
 */
public class Part1 {
	/**
     * This method performs Part 1 of the program by creating and storing output file names,
     * storing input file names, and syntax-checking the input files. It reads in file names 
     * from external files, and creates the output files if they do not already exist. It then
     * syntax-checks each input file for errors and writes any errors to an error file. If an
     * input file has no errors, it writes the contents of the file to the appropriate output file.
     */
    public static void do_part1() {
        // Array of Strings that will hold the file names for each genre.
        String[] genreFileNames = null;

        // Array of Strings to store the abbreviations of the genres.
        // The purpose of storing genres if to check for invalid genres in the input files during the syntax-checking process.
        String[] genreAbbreviations = null;

        // Array of Strings that will be used to store the names of the input files that will be used to read the data for the program.
        String[] inputFileNames = null;

        // Array of Strings that defines the template for the input records that will be read and processed by the program.
        String[] recordTemplate = {
            "title",
            "author",
            "price",
            "isbn",
            "genre",
            "year"
        };

        // A declaration for a file output stream object that will be used to write error messages to a file.
        FileOutputStream error = null;

        // The Scanner object that will read the input files and store the input file names, the output file names, and the genre abbreviations.
        Scanner scan = null;

        // The PrintWriter object that will write syntax-correct records to the appropriate output files.
        PrintWriter pw = null;

        // The PrintWriter object that will write the error and their corresponding description to the error output file.
        PrintWriter errorPW = null;

        try {
            scan = new Scanner(new FileInputStream("part1_output_file_names.txt"));

            // This variable effectively holds the number of genres, and consequently the number of output files to produce.
            int genres = scan.nextInt() - 1;

            genreFileNames = new String[genres];
            genreAbbreviations = new String[genres];

            scan.nextLine();

            for (int i = 0; i < genres; i++) {
                genreFileNames[i] = scan.nextLine();

                FileOutputStream file = new FileOutputStream(genreFileNames[i]);

                file.close();
            }

            error = new FileOutputStream(scan.nextLine());

            for (int i = 0; i < genreAbbreviations.length; i++) {
                genreAbbreviations[i] = scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println("There was an error creating the files!");
        }

        // Part 1.2: Store the input file names.
        try {
            scan = new Scanner(new FileInputStream("part1_input_file_names.txt"));

            inputFileNames = new String[scan.nextInt()];

            scan.nextLine();

            for (int i = 0; i < inputFileNames.length; i++) {
                inputFileNames[i] = scan.nextLine();
            }

            scan.close();
        } catch (Exception e) {
            System.out.println("There was an error reading the input files!");
        }

        // Part 1.3: Begin syntax-checking the input files.
        try {
            errorPW = new PrintWriter(error);

            for (int i = 0; i < genreFileNames.length; i++) {
                pw = new PrintWriter(new FileOutputStream(genreFileNames[i]));

                for (int j = 0; j < inputFileNames.length; j++) {
                    scan = new Scanner(new FileInputStream(inputFileNames[j]));

                    // This boolean variable will store whether to print the header containing the name of the file in the error output file.
                    boolean hasHeader = false;

                    while (scan.hasNextLine()) {
                        // This String holds a single record at a time.
                        String line = scan.nextLine();

                        // This String variable will occupy the first position in the fields[] array, and the title of the record.
                        String title = null;

                        // This String array will hold the separated contents of the record string.
                        String[] fields = null;

                        if (line.charAt(0) == '"') {
                            title = line.substring(0, line.indexOf('"', 1) + 1);

                            // If the title in the record is enclosed in double quotation marks, then it is removed from the record and the rest
                            // retained in this String array.
                            String[] remaining = line.substring(title.length() + 2, line.length()).split(",(?=\\S)");

                            fields = new String[remaining.length + 1];

                            fields[0] = title;

                            for (int k = 0; k < remaining.length; k++) {
                                fields[k + 1] = remaining[k];
                            }
                        } else {
                            fields = line.split(",(?=\\S)");
                        }

                        for (int k = 1; k < fields.length; k++) {
                            fields[k] = fields[k].replaceAll(",", "");
                        }

                        try {
                            if (fields.length < 6) {
                                if (!hasHeader) {
                                    errorPW.println("syntax error in file: " + inputFileNames[j]);
                                    errorPW.println("====================");
                                    hasHeader = true;
                                }

                                throw new TooFewFieldsException("Error: too few fields\n" + "Record: " + line + "\n\n\n");
                            }

                            if (fields.length > 6) {
                                if (!hasHeader) {
                                    errorPW.println("syntax error in file: " + inputFileNames[j]);
                                    errorPW.println("====================");
                                    hasHeader = true;
                                }

                                throw new TooManyFieldsException("Error: too many fields\n" + "Record: " + line + "\n\n\n");
                            }

                            for (int k = 0; k < fields.length; k++) {
                                if (fields[k].equals("")) {
                                    if (!hasHeader) {
                                        errorPW.println("syntax error in file: " + inputFileNames[j]);
                                        errorPW.println("====================");
                                        hasHeader = true;
                                    }

                                    throw new MissingFieldException("Error: missing " + recordTemplate[k] + "\nRecord: " + line + "\n\n\n");
                                }
                            }

                            // This boolean serves to indicate whether the genre of the record exists or is non identifiable.
                            boolean exists = false;

                            for (int k = 0; k < genreAbbreviations.length; k++) {
                                if (fields[4].equals(genreAbbreviations[k])) {
                                    exists = true;
                                    break;
                                }
                            }

                            if (!exists) {
                                throw new UnknownGenreException("Error: invalid genre\nRecord: " + line + "\n\n\n");
                            }

                            if (fields[4].equals(genreAbbreviations[i])) {
                                pw.println(line);
                            }
                        } catch (Exception e) {
                            errorPW.print(e.getMessage());
                        }
                    }
                    scan.close();
                }
                pw.close();
            }
            error.close();
            errorPW.close();
        } catch (Exception e) {
            System.out.println("An error occured in syntax-checking the files!");
            e.printStackTrace();
        }
    }
}
