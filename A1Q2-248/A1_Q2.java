// -------------------------------------------------------
// Assignment 1 - Question 2
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------

// The goal of this program is to obtain two values of temperature, in Celsius and Farenheit units, inputted by the user,
// and uses an empirical formula to convert both values into the other temperature unit. First, the Celsius value is converted
// into Farenheit and the Farenheit value is converted into Celsius.


import java.util.Scanner;

public class A1_Q2 {
   public static void main(String[] args) {

      // Initialize the Scanner for user input
      Scanner in = new Scanner(System.in);

      // Display the welcome message to show the user what program he/she is running
      System.out.println("Welcome to the Simple Meteorological Program:");
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

      // Prompt the user to enter two temperature values, in both Farenheit and Celsius units, to be converted
      System.out.print("Please enter two values for the 'Farenheit' and 'Celsius' scale, simultaneously: ");

      // Read the next two inputs and store them in variables called farenheit and celsius for later calculation
      double farenheit = in.nextDouble();
      double celsius = in.nextDouble();

      // Use the empirical formula provided and convert both temperature values into the other unit.
      System.out.println(" ");
      double transformedFarenheit = 18.0 / 10.0 * celsius + 32;
      double transformedCelsius = 10.0 / 18.0 * (farenheit - 32);

      // Display the transformed values to show the user the results
      System.out.println("The corresponding temperature in Celsius unit is: " + transformedCelsius);
      System.out.printf("The corresponding temperature in Farenheit unit is: %.1f\n", transformedFarenheit);
      
      // Calculate the values of x and y as instructed
      double x = transformedFarenheit % Math.round(transformedCelsius);
      x = Math.round(x);
      double y = Math.pow(transformedFarenheit, transformedCelsius);

      // Display the x and y variabless
      System.out.printf("The corresponding value for x is: %.1f\n", x);
      System.out.println("The corresponding value for y is: " + y);

      // Display the exit message
      System.out.println(" ");
      System.out.println("Thank you for using my bespoke Meteorological program!");

      // Close the Scanner once its purposed has been fulfilled
      in.close();
   }
}