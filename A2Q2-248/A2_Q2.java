// --------------------------------------------------------------------
// Assignment 2 - Question 1
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------------------

// Description of the program:
// This program calculates the index of a particular month and market, both of which are inputted by the user.
// This program contains specific percentage of harvests for every month of the year for both the domestic and international markets.
// This program additionally outputs error messages if it fails to understand the user's inputs.
// This program is also case-insensitive, meaning that it will be able to read any variation of upper-case and lower-case input of a month and market name.


import java.util.Scanner;

public class A2_Q2
{
	public static void main(String[] args)
	{
		// Initialize the scanner to read user input.
		Scanner in = new Scanner(System.in);
		
		// Initialize the constant variable W, which will be used to calculate the index.
		final double W = 1.4672;
		
		// Initialize a variable which will later contain the percentage of the harvest.
		double P = 0;
		
		// Display the welcome message when running the program.
		System.out.println("Welcome to Farms Distribution Center Price Index Program:");
		System.out.println("=========================================================");
		
		// Prompt the user to enter then name of a Month and Market, respectively.
		System.out.print("\nPlease enter a Month and Market, respectively: ");
		
		// Initialize two variables containing the name of the month and market
		String month = in.next();
		String market = in.next();
		
		// Turn both the inputted month and market into strings containing only lowercase letters.
		month = month.toLowerCase();
		market = market.toLowerCase();
		
		// We use two switch statements, the first one to verify which market the user would like to obtain a percentage from.
		// The second switch statement, located inside the first switch statement, checks for the month.
		// Both switch statements contain error messages if the user fails to enter a correct market or month.
		switch(market)
		{
		case "domestic":
			switch(month)
			{
			case "january": P = 75.25; break;
			case "february": P = 62.86; break;
			case "march": P = 54.78; break;
			case "april": P = 68.46; break;
			case "may": P = 35.89; break;
			case "june": P = 28.94; break;
			case "july": P = 42.50; break;
			case "august": P = 86.10; break;
			case "september": P = 69.7; break;
			case "october": P = 85.4; break;
			case "november": P = 75.9; break;
			case "december": P = 76.8; break;
			default: System.out.println("Error: An invalid value has been entered for the 'Month' variable. Please retry again!");
			}
			break;
			
		case "international":
			switch(month)
			{
			case "january": P = 24.75; break;
			case "february": P = 37.14; break;
			case "march": P = 45.22; break;
			case "april": P = 31.54; break;
			case "may": P = 64.11; break;
			case "june": P = 71.06; break;
			case "july": P = 57.5; break;
			case "august": P = 13.9; break;
			case "september": P = 30.3; break;
			case "october": P = 14.6; break;
			case "november": P = 24.1; break;
			case "december": P = 23.2; break;
			default: System.out.println("Error: An invalid value has been entered for the 'Month' variable. Please retry again!");
			}
			break;
			
		default: System.out.println("Error: An invalid value has been entered for the 'Market' variable. Please retry again!");
		} 
		
		// Once user input for the month and market variables have been validated and the percentage has been set, we calculate the index and store it in a variable.
		double I = 1.0 / 20.0 * P * W;
		
		// Once calculated, we display the index value.
		System.out.printf("\nThe value of the Price Index, 'I', is: %.2f", I);
		
		// We display a 'thank you' message when the program has compeleted its work.
		System.out.println("\nThank you for using Farms Distribution Center Price Index Program!");
		
		// Close the scanner once all user input has been read.
		in.close();
	}
}
