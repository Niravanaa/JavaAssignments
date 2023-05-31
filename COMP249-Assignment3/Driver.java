// -----------------------------------------------------
// Assignment 3
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Driver class of the program contains all three methods and their functionality.
 * First, the Driver class contains the do_part1() method, which runs the first part of the method that consists of creating the files, and syntax-checking the input files.
 * Second, the Driver class contains the do_part2() method, which reads the outputted csv files from the first part and semantic-checks the files, and then serializes the records into binary files.
 * Third, the Driver class opens each of the serialized binary files and runs an interactive program that enables the user to view each file and its syntax and semantic correct records.
 */
public class Driver {
    /**
     * The main() method of the program runs all three parts of the program together, and consequently represents the main program.
     * 
     * @param args the array of command-line arguments
     */
    public static void main(String[] args) {
        Part1.do_part1(); //validating syntax, partition book records based on genre.

        Part2.do_part2(); // validating semantics, read the genre files each into arrays of Book objects,
        // then serialize the arrays of Book objects each into binary files.

        Part3.do_part3(); // reading the binary files, de-serialize the array objects in each file, and
        // then provide an interactive program to allow the user to navigate the arrays.
    }
}