// -------------------------------------------------------
// Assignment 3 - Question 1
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------

// Description of the program:
// The goal of this program is to encrypt or decrypt an inputted message.
// Depending on whether the message inputted is of an even or odd length, every pair of letters will be flipped.
// A normal message can be inputted to obtain an encrypted message.
// A message encrypted with this program can be re-inputted to obtain the original message.
// If the inputted message is of an odd length, the resulting message's first letter will be the same as the
// original message's first letter.

import java.util.Scanner;

public class A3_Q1
{
	public static void main(String[] args)
	{
		// We initialize the scanner and employ the keyword "in."
		Scanner in = new Scanner(System.in);
		
		// We print the Welcome Message and the instruction for the user to perform.
		System.out.println("Welcome to the 3D-Space Encryption-Decryption Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("Please enter your plain text below:");
		
		// We save the user's input in a String variable.
		String text = in.nextLine();
		
		// We remove whitespaces at the beginning and the end of the input using the trim() method.
		text = text.trim();
		
		// We create a result string that will store the encrypted/decrypted message.
		String result = "";
		
		// In this if-else statment, we verify whether the input has an even or an odd length.
		if (text.length() % 2 == 0)
		{
			// In this for-loop, we iterate through every pair of characters and flip their positions.
			for (int i = 1; i <= text.length() - 1; i += 2)
			{
				result = result + text.charAt(i);
				
				result = result + text.charAt(i - 1);
			}
		}
		
		else
		{
			// For an input with odd length, the result string will begin with the first character of the original input.
			result = result + text.charAt(0);
			
			// In this for-loop, we start with the second character and iterate through every pair of characters and flip their positions.
			for (int i = 2; i <= text.length() - 1; i += 2)
			{
				result = result + text.charAt(i);
				
				result = result + text.charAt(i - 1);
			}
		}
		
		// We display the resulting string.
		System.out.println("\nKindly find below your encrypted text output:");
		System.out.println(result + "\n");
		
		// We display the Thank You message.
		System.out.print("Thank you for your contribution to this Space Project.");
		
		// We close the scanner variable.
		in.close();
	}
}