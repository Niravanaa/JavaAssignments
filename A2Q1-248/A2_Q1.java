// --------------------------------------------------------------------
// Assignment 2 - Question 1
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// --------------------------------------------------------------------

// Description of the program:
// The program displays various recyclable products and their corresponding Recycling Codes.
// After displaying a list of the possible Recycling Codes, it reads the user's input.
// If the user's input is not validated, it displays an error message.
// If the user's input is validated, it displays the name of the Recycling Code.
// It continues with a recommended Action/Instruction to dispose of the recyclable item.
// The program ends with a 'Thank You' to the user.

import java.util.Scanner;

public class A2_Q1
{
	
	public static void main(String[] args)
	{
	// Initialize the scanner to read user input.
	Scanner in = new Scanner(System.in);
	
	// Greet the user once the program has been opened.
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println("Welcome to My City Recycling Program:");
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	
	// Display all the Recycling codes and their corresponding Item samples
	System.out.println("Item Recycling Code. |--> Item samples");
	System.out.println("------------------------------------");
	
	System.out.println("1.  |-->[Soft drink bottles/Trash cans]");
	System.out.println("2.  |-->[Shampoo bottles/Yogurt containers");
	System.out.println("3.  |-->[Plastic bags]");
	System.out.println("4.  |-->[Storage bins/Brooms/Brushes]");
	System.out.println("5.  |-->[Garden hoses/Piping]");
	
	System.out.println("6.  |-->[Carry-out food containers]");
	System.out.println("7.  |-->[Plastic straws/Chip bags/Coffee pods]");
	
	System.out.println("8.  |-->[Cell phone/Computer/Camera/Batteries]");
	System.out.println("9.  |-->[TV Remote/Flashlight batteries]");
	System.out.println("10. |-->[Car batteries]");
	
	System.out.println("11. |-->[Cereal/Snack Carboard boxes]");
	System.out.println("12. |-->[Newspaper/Books/Wallpaper]");
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	
	// Display a prompt message for the user to enter a Recycling Code.
	System.out.print("\nPlease enter the Recycling Code, from the above, that corresponds to the item you want to recycle: ");
	
	// Initialize a variable that stores the user's input.
	int code = in.nextInt();
	
	// Verify the user input and display an error message if the input is out of range.
	if (code < -128 || code > 127)
	{
		System.out.println("Error: Your Recycling Code is not a valid integer between -128 to 127. Kindly retry again!");
	}
	
	// If user input is validated, match the input with the correct Recycling Type and Action Instruction.
	else
	{
		// We use a switch case for the main Recycling Codes.
		switch(code)
		{
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("This is a Recycled Plastics/Paper item.");
			System.out.println("Item required to be put in the blue household recycling bin.");	
			break;
			
		case 6:
		case 7:
			System.out.println("This is a Non-Recycled Plastics item.");
			System.out.println("Item required to be put in the gray household garbage bin.");
			break;
			
		case 8:
		case 9:
		case 10:
			System.out.println("This is a Batteries item.");
			System.out.println("Item required to be taken to your local recycling depot or nearby store for disposal.");
			break;
			
		case 11:
		case 12:
			System.out.println("This is a Paper item.");
			System.out.println("Item required to be put in the blue household recycling bin.");
			break;
		}
		
		// We use if-statements for the last two recycling codes that are ranges. This if-statement checks for N/A Codes.
		if (13 <= code && code <= 127)
		{
			System.out.println("This item is N/A");
			System.out.println("Item code not handled by the city recycling system.\nKindly check the nearby city(ies) for possible recycling availability.");
		}
		
		// This if-statement checks for Hazardous Codes.
		if (-128 <= code && code <= 0)
		{
			System.out.println("This item is Hazardous material.");
			System.out.println("Material required to be put in a hazardous dumpster diving.\nKindly check your area for the nearby one.");
		}
		
		// Once the correct display statements have executed, we thank the user to have run the program.
		System.out.println("\nThank you for saving the planet!");
	}
	
	// Close the scanner when done reading user input.
	in.close();
	}
}
