// -------------------------------------------------------
// Assignment 1 - Question 1
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------

// This program reads two integer values p and q and computes Cartesian coordinates x, y, and z of some astronomical object,
// The program then computes and outputs the Cartesian coordinates x, y, and z of the nearest astronomical object,
// The computation performed by this program is completed using empirical formulas containing constants
// such as E and PI.

import java.util.Scanner;

public class A1_Q1 {
   public static void main(String[] args) {

      // Initialize the constants that will be used for coordinate calculations
      final double PI = 22.0 / 7.0;
      final double E = 2.718281828;

      // Initialize the Scanner
      Scanner in = new Scanner(System.in);

      // Display the welcome message
      System.out.println("Welcome to the Simple 3D-Space Program:");
      System.out.println("+++++++++++++++++++++++++++++++++++++++");

      // Prompt the user to enter two values p and q
      System.out.print("Please enter the values for 'p' and 'q', simultaneously: ");

      // Take two inputs and store them in two variables p and q
      byte p = in.nextByte();
      byte q = in.nextByte();

      // Use the formulas provided to calculate the x, y, and z coordinates
      double xCoordinate = (double)(p * PI / E + 50);
      double yCoordinate = (double)(p * PI / E + 50 * 12);
      double zCoordinate = (double)(q + yCoordinate);

      // Print the calculate coordinate values
      System.out.println("The Cartesian coordinates of the first object is:");
      System.out.println("(" + xCoordinate + ", " + yCoordinate + ", " + zCoordinate + ")");

      // Use the calculated coordinate values and obtain the nearest object's coordinates
      double new_xCoordinate = xCoordinate;
      double new_yCoordinate = new_xCoordinate * 12;
      double new_zCoordinate = q + new_yCoordinate * 6;

      // Print the newly calculated coordinate values
      System.out.println("The Cartesian coordinates of the nearest object is:");
      System.out.println("(" + new_xCoordinate + ", " + new_yCoordinate + ", " + new_zCoordinate + ")");

      // Display the exit message
      System.out.println("");
      System.out.print("Thank you for your contribution to this Space Project.");

      // Close the Scanner
      in.close();
   }
}