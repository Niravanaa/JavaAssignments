// ---------------------------------------------------------
// Assignment 4
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// ---------------------------------------------------------

// The BudgetDemo class is the driver class of the package. It contains the bulk of the program and makes use of the methods developed in the other three class files.

import java.util.Scanner;

public class BudgetDemo
{
	// The getInput method is a static method that obtains a valid Integer in a specific range that can be used to either obtain a valid HouseholdBudget ID or Expense ID.
	public static int getInput(String message, String errorMessage, int low, int high)
	{
		// We initialize a Scanner object to obtain information from the user.
		Scanner key = new Scanner(System.in);
		
		int number = -1;
		
		boolean validated = false;
		
		// The initial request for information is displayed to the user.
		System.out.print(message);
		
		// This while loop validates the information entered by the user.
		while (!validated)
		{
			if (key.hasNextInt())
			{
				number = key.nextInt();
				
				// This if-else statement verifies whether the integer entered is valid.
				if (number >= low && number <= high)
				{
					validated = true;
				}
				
				else
				{
					System.out.println(errorMessage);
					System.out.print("--> Try again: (Enter number " + low + " to " + high + "): ");
				}
			}
			
			else
			{
				System.out.println(errorMessage);
				System.out.print("--> Try again: (Enter number " + low + " to " + high + "): ");
				key.next();
			}
		}
		
		return number;
	}
	
	public static void main(String[] args)
	{
		// We initialize a HouseholdBudget[] array containing five HouseholdBudget objects, as instructed.
		HouseholdBudget[] budgets = new HouseholdBudget[5];
		
		// HouseholdBudget #0 and HouseholdBudget #1 have the same fund breakdown and same number of expenses.
		budgets[0] = new HouseholdBudget(
				new Fund(0, 1, 0, 2, 1),
				new Expense[] {
						new Expense("Purchase", 85.5, "IGA", 25, 11),
						new Expense("Bill", 122.75, "Videotron", 2, 12)
				}
		);
		
		budgets[1] = new HouseholdBudget(
				new Fund(0, 1, 0, 2, 1),
				new Expense[] {
						new Expense("Purchase", 85.5, "IGA", 25, 11),
						new Expense("Bill", 16.2, "Costco", 23, 11)
				}
		);
		
		// HouseholdBudget #2 is the only HouseholdBudget object that has a fund breakdown that is different from all the others and contain three Expense objects.
		budgets[2] = new HouseholdBudget(
				new Fund(2, 0, 2, 1, 1),
				new Expense[] {
						new Expense("Purchase", 50.75, "Pharmaprix", 1, 12),
						new Expense("Purchase", 16.2, "TheBay", 16, 12),
						new Expense("Bill", 65.85, "Fido", 5, 1)
				}
		);
		
		// HouseholdBudget #3 and #4 have the same fund breakdown and no Expense objects.
		budgets[3] = new HouseholdBudget(
				new Fund(2, 1, 2, 1, 5),
				new Expense[] { }
		);
		
		budgets[4] = new HouseholdBudget(
				new Fund(2, 1, 2, 1, 5),
				new Expense[] { }
		);
		
		// We initialize a Scanner object to obtain information from the user.
		Scanner in = new Scanner(System.in);
		
		// We display the welcome header of the program.
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Welcome to COMP248 Geek's HouseholdBudget_2022 Application");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// We initialize integer variables that will be used to operate the program.
		int codeEntered = -1;
		int number;
		
		// This while loop is the main loop of the program, which exits if the code entered by the user is 0.
		while(codeEntered != 0)
		{
			// We display the possible codes that can be entered by the user to operate the program.
			System.out.println("\nWhat would you like to do?");
			System.out.println("  1. See the possessions of all HouseholdBudgets");
			System.out.println("  2. See the possessions of one HouseholdBudget");
			System.out.println("  3. List HouseholdBudgets with same total amount of fund");
			System.out.println("  4. List HouseholdBudgets with same fund denomination(s)");
			System.out.println("  5. List HouseholdBudgets with same total amount of fund and same number of expenses");
			System.out.println("  6. Add an expense to an existing HouseholdBudget");
			System.out.println("  7. Remove an existing expense from a HouseholdBudget");
			System.out.println("  8. Update the payment due date of an existing expense");
			System.out.println("  9. Add fund to a HouseholdBudget");
			System.out.println("  0. To quit");
			
			// We obtain the code that the user wishes to execute using the getInput method, which is explained above.
			codeEntered = getInput("\nPlease enter your choice and press <Enter>: ", "Sorry that is not a valid choice. Try again.", 0, 9);
			
			// This switch statement executes the code depending on the command that the user entered.
			switch (codeEntered)
			{
			
			// The first case displays the fund breakdown and the formatted list of expenses of all five HouseholdBudget objects created initially.
			case 1:
				System.out.println("\nContent of each HouseholdBudget:");
				System.out.println("---------------------");
				
				for (int i = 0; i < budgets.length; i++)
				{
					System.out.println("HouseholdBudget #" + i);
					System.out.println(budgets[i].toString());
				}
				
				break;
				
			// The second case asks the user which HouseholdBudget they wish to view and displays the fund breakdown and a formatted list of expenses of the HouseholdBudget object.
			case 2:
				int budgetID = getInput("\nWhich HouseholdBudget would you like to see the possessions of? (Enter number 0 to 4): ", "Sorry, but there is no such HouseholdBudget number!", 0, 4);
				
				System.out.println("");
				
				System.out.println(budgets[budgetID].toString());
				
				break;
				
			// The third case compares all of the HouseholdBudget objects in the pre-made HouseholdBudget[] array and displays the pairs of HouseholdBudget objects that have the same total fund value along with the total fund value amount.
			case 3:
				System.out.println("\nList of HouseholdBudgets with same total fund:");
				System.out.println("");
				
				for (int i = 0; i < budgets.length - 1; i++)
				{
					for (int j = i + 1; j < budgets.length; j++)
					{
						if (budgets[i].compareFundValue(budgets[j]))
						{
							System.out.println("	HouseholdBudgets " + i + " and " + j + " both have " + budgets[i].getFundTotal());
						}
					}
				}
				
				break;
				
			// The fourth case compares all of the HouseholdBudgets objects in the pre-made HouseholdBudget[] array and displays the pair of HouseholdBudget objects that have the same fund distribution.
			case 4:
				System.out.println("\nList of HouseholdBudgets with same Fund:");
				System.out.println("");
				
				for (int i = 0; i < budgets.length - 1; i++)
				{
					for (int j = i + 1; j < budgets.length; j++)
					{
						if (budgets[i].compareFundTypes(budgets[j]))
						{
							System.out.println("	HouseholdBudgets " + i + " and " + j + " both have " + budgets[i].fundBreakdown());
						}
					}
				}
				
				break;
				
			// The fifth case lists all of the HouseholdBudget objects that are equal in terms of total fund value and number of expenses.
			case 5:
				System.out.println("\nList of HouseholdBudgets with same amount of money and same number of expenses:");
				System.out.println("");
				
				for (int i = 0; i < budgets.length - 1; i++)
				{
					for (int j = i + 1; j < budgets.length; j++)
					{
						if (budgets[i].compareFundValue(budgets[j]) && budgets[i].getExpenseNumber() == budgets[j].getExpenseNumber())
						{
							System.out.println("	HouseholdBudgets " + i + " and " + j);
						}
					}
				}
				
				break;
			
			// The sixth case asks the user which HouseholdBudget they would like to add an expense to, as well as enter the expense information.
			case 6:
				budgetID = getInput("\nWhich HouseholdBudget would you like to add an expense to? (Enter number 0 to 4): ", "Sorry, but there is no such HouseholdBudget number!", 0, 4);
				
				System.out.println("Please enter the following information so that we may complete the expense-");
				
				budgets[budgetID].addExpense();
				
				break;
				
			// The seventh case asks the user which HouseholdBudget they would like to remove an expense from, as well as the index they want removed.
			case 7:
				budgetID = getInput("\nWhich HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): ", "Sorry, but there is no such HouseholdBudget number!", 0, 4);
			
				budgets[budgetID].removeExpense();

				break;
			
			// The eighth case asks the user which HouseholdBudget they would like to update. It then asks the user to enter the expense index they would like to update. The day and month of the expense are then updated.
			case 8:
				budgetID = getInput("\nWhich HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): ", "Sorry, but there is no such HouseholdBudget number!", 0, 4);
				
				budgets[budgetID].updateDueDate();
				
				break;
			
			// The ninth and final case asks the user which HouseholdBudget they would like to add funds to and how many of each cash type they would like to add. Each value is then added into the original amount in the HouseholdBudget object.
			case 9:
				budgetID = getInput("\nWhich HouseholdBudget do you want to add Funds to? (Enter number 0 to 4): ", "Sorry, but there is no such HouseholdBudget number!", 0, 4);
				
				budgets[budgetID].addBudgetFund();
				
				break;
			}
			
		}
		
		// The exit message is displayed.
		System.out.print("Thank you for using COMP248 Geek's HouseholdBudget application!");
	}
}
