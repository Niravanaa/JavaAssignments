// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Part2 class contains the second part of the program.
 * 
 * @author Nirav
 */
public class Part2 {
	/**
     * The do_part2() method makes use of the output files of part 1 and reads them to verify the semantics of each syntax-correct record.
     * Once the records have been semantic-checked, they are serialized into Book objects and written into binary files, with names similar to the files they were read from.
     */
    public static void do_part2() {
        // This String array holds the output genre file names.
        String[] genreFileNames = null;

        // This Scanner object reads the output files of the previous part and reads the records to semantic-check them.
        Scanner scan = null;

        // This ObjectOutputStream object will take the information of a semantic-correct record and produce a Book object to be written into the binary files.
        ObjectOutputStream oos = null;

        // This PrintWriter object will write the description of the semantic-related errors into the error text file.
        PrintWriter errorPW = null;

        try {
            scan = new Scanner(new FileInputStream("part1_output_file_names.txt"));

            // This Integer will hold the number of genre files to read.
            int genres = scan.nextInt() - 1;

            genreFileNames = new String[genres];

            scan.nextLine();

            for (int i = 0; i < genreFileNames.length; i++) {
                genreFileNames[i] = scan.nextLine();
            }

            scan.close();
        } catch (Exception e) {
            System.out.println("There was an error reading the input files!");
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < genreFileNames.length; i++) {
                oos = new ObjectOutputStream(new FileOutputStream(genreFileNames[i] + ".ser"));

                oos.close();
            }
        } catch (Exception e) {
            System.out.println("There was an error creating the binary files!");
            e.printStackTrace();
        }

        try {
            errorPW = new PrintWriter(new FileOutputStream("./semantic_error_file.txt"));

            for (int i = 0; i < genreFileNames.length; i++) {
                scan = new Scanner(new File(genreFileNames[i]));

                oos = new ObjectOutputStream(new FileOutputStream(genreFileNames[i] + ".ser"));

                // This boolean, similar to the one in part 1 of the program, will check whether to print the name of the file header in the error text file.
                boolean hasHeader = false;

                while (scan.hasNextLine()) {
                    // This String will contain the record in its entirety.
                    String line = null;

                    // This String array will contain the segmented portions of the record.
                    String[] fields = null;

                    try {
                        line = scan.nextLine();

                        // This String will contain the first piece of information of the record, which is the title.
                        String title = null;

                        fields = null;

                        if (line.charAt(0) == '"') {
                            title = line.substring(0, line.indexOf('"', 1) + 1);

                            // If the title of the record is enclosed in double quotation marks, the rest of the record is segmented
                            // in this String array.
                            String[] remaining = line.substring(title.length() + 2, line.length()).split(",(?=\\S)");

                            fields = new String[remaining.length + 1];

                            fields[0] = title;

                            for (int j = 0; j < remaining.length; j++) {
                                fields[j + 1] = remaining[j];
                            }

                        } else {
                            fields = line.split(",(?=\\S)");
                        }

                        for (int j = 1; j < fields.length; j++) {
                            fields[j] = fields[j].replaceAll(",", "");
                        }

                        if (fields[3].length() == 10) {
                            int sum = 0;

                            for (int j = 0; j < 10; j++) {
                                /* Bring back if the X is meant to be considered as a 10.
                                {
                                	sum += 10;
                                	continue;
                                }
                                */

                                sum += Character.getNumericValue(fields[3].charAt(j)) * (10 - j);
                            }

                            if (sum % 11 != 0) {
                                if (!hasHeader) {
                                    errorPW.println("syntax error in file: " + genreFileNames[i]);
                                    errorPW.println("====================");
                                    hasHeader = true;
                                }

                                throw new BadIsbn10Exception("Error: bad isbn10\nRecord: " + line + "\n\n\n");
                            }
                        } else if (fields[3].length() == 13) {
                            int sum = 0;

                            for (int j = 0; j < 13; j++) {
                                if (j % 2 == 0) {
                                    sum += Character.getNumericValue(fields[3].charAt(j));
                                } else {
                                    sum += 3 * Character.getNumericValue(fields[3].charAt(j));
                                }
                            }

                            if (sum % 10 != 0) {
                                if (!hasHeader) {
                                    errorPW.println("syntax error in file: " + genreFileNames[i]);
                                    errorPW.println("====================");
                                    hasHeader = true;
                                }

                                throw new BadIsbn13Exception("Error: bad isbn13\nRecord: " + line + "\n\n\n");
                            }
                        } else {
                            if (!hasHeader) {
                                errorPW.println("syntax error in file: " + genreFileNames[i]);
                                errorPW.println("====================");
                                hasHeader = true;
                            }

                            throw new BadIsbn10Exception("Error: unknown isbn type\nRecord: " + line + "\n\n\n");
                        }

                        if (Double.parseDouble(fields[2]) < 0) {
                            if (!hasHeader) {
                                errorPW.println("syntax error in file: " + genreFileNames[i]);
                                errorPW.println("====================");
                                hasHeader = true;
                            }

                            throw new BadPriceException("Error: bad price\nRecord: " + line + "\n\n\n");
                        }

                        if (Integer.parseInt(fields[5]) < 1995 || Integer.parseInt(fields[5]) > 2010) {
                            if (!hasHeader) {
                                errorPW.println("syntax error in file: " + genreFileNames[i]);
                                errorPW.println("====================");
                                hasHeader = true;
                            }

                            throw new BadYearException("Error: bad year\nRecord: " + line + "\n\n\n");
                        }

                        oos.writeObject(new Book(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5])));
                    } catch (BadIsbn10Exception e) {
                        if (!hasHeader) {
                            errorPW.println("syntax error in file: " + genreFileNames[i]);
                            errorPW.println("====================");
                            hasHeader = true;
                        }

                        errorPW.print(e.getMessage());
                    } catch (BadIsbn13Exception e) {
                        if (!hasHeader) {
                            errorPW.println("syntax error in file: " + genreFileNames[i]);
                            errorPW.println("====================");
                            hasHeader = true;
                        }

                        errorPW.print(e.getMessage());
                    } catch (BadPriceException e) {
                        if (!hasHeader) {
                            errorPW.println("syntax error in file: " + genreFileNames[i]);
                            errorPW.println("====================");
                            hasHeader = true;
                        }

                        errorPW.print(e.getMessage());
                    } catch (BadYearException e) {
                        if (!hasHeader) {
                            errorPW.println("syntax error in file: " + genreFileNames[i]);
                            errorPW.println("====================");
                            hasHeader = true;
                        }

                        errorPW.print(e.getMessage());
                    }
                }

                scan.close();
            }

            errorPW.close();
        } catch (Exception e) {
            System.out.println("There was an error syntax-checking the files!");
            e.printStackTrace();
        }
    }
}
