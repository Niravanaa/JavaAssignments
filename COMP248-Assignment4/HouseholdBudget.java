// ---------------------------------------------------------
// Assignment 4
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// ---------------------------------------------------------

//The HouseholdBudget class contains methods from both the Fund and the Expense classes to function.
//We also use a Scanner to obtain the necessary information from the user.

import java.util.Scanner;

public class HouseholdBudget
{
	// We initialize the private instance variables that are specific to every HouseholdBudget object.
	private Fund funds;
	private Expense[] expenses;
	
	/**
	 *  We write the default constructor.
	 */
	public HouseholdBudget() {}
	
	/**
	 *  We write the main constructor, which builds a HouseholdBudget objects with its own Fund object and Expenses array.
	 * @param funds  A Fund object which will be contained in the HoudeholdBudget
	 * @param expenses  An Expense[] array which will contain expenses of the HouseholdBudget
	 */
	public HouseholdBudget(Fund funds, Expense[] expenses)
	{
		this.funds = funds;
		this.expenses = expenses;
	}
	
	/**
	 *  The compareFundValue method is an accessor method which compares whether two distinct HouseholdBudget objects have the same total fund value.
	 * @param household  A pre-existing HouseholdBudget object
	 * @return  true if the two distinct HouseholdBudget objects have the same total fund value and false otherwise
	 */
	public boolean compareFundValue(HouseholdBudget household)
	{
		return (this.funds.getTotal() == household.funds.getTotal());
	}
	
	/**
	 *  The compareFundTypes method is an accessor method which compares whether two distinct HouseholdBudget objects have the same Fund breakdown.
	 * @param household  A pre-existing HouseholdBudget object
	 * @return  true if the two distinct HouseholdBudget objects have the same fund breakdown and false otherwise
	 */
	public boolean compareFundTypes(HouseholdBudget household)
	{
		return (this.funds.equals(household.funds));
	}
	
	/**
	 * The getFundTotal method is an accessor method which returns the total fund value of a HouseholdBudget object.
	 * @return The total fund value of the HouseholdBudget object
	 */
	public double getFundTotal()
	{
		return this.funds.getTotal();
	}
	
	/**
	 * The getExpenseNumber method is an accessor method which returns the number of expenses of a HouseholdBudget object.
	 * @return The number of expenses of the HouseholdBudget object
	 */
	public int getExpenseNumber()
	{
		return this.expenses.length;
	}
	
	/**
	 *  The addExpense method is a mutator method which adds an Expense object to the Expense[] array of a HouseholdBudget object.
	 */
	public void addExpense()
	{
		// We initialize a Scanner object to obtain information from the user.
		Scanner key = new Scanner(System.in);
		
		// We obtain the type of purchase from the user.
		System.out.print(" --> Type of expense (Bill, Purchase, etc...): ");
		String type = key.next();

		double amount = -1;
		
		// This do-while loop obtains the amount of the expense and validates the input.
		do
		{
			System.out.print(" --> Amount of the expense: ");
			while(!key.hasNextDouble())
			{
				System.out.print("\nNot valid input! Amount of the expense: ");
				key.next();
			}
			amount = key.nextDouble();
		} while (amount <= 0);
		
		// We obtain the name of the business from which the expense was made from.
		System.out.print(" --> Name of the business: ");
		String businessName = key.next();
		
		// We obtain the day and month number on which the expense was performed.
		System.out.print(" --> Payment due day number and month (seperated by a space): ");
		int dueDay = key.nextInt();
		int dueMonth = key.nextInt();
		
		// We initialize an Expense[] array to store the pre-existing expenses of the HouseholdBudget object.
		Expense[] oldExpenses = new Expense[this.expenses.length];
		
		// We place the old expenses of the HouseholdBudget object into the Expense[] array.
		for (int i = 0; i < this.expenses.length; i++)
		{
			oldExpenses[i] = expenses[i];
		}
		
		// We re-initialize the main expenses array of the HouseholdBudget object with a larger size.
		expenses = new Expense[this.expenses.length + 1];
		
		// We transfer the original expenses into the newly initialized Expenses[] array of the HouseholdBudget object.
		for (int i = 0; i < oldExpenses.length; i++)
		{
			expenses[i] = oldExpenses[i];
		}
		
		// We place the new expense into the final slot of the newly initialized Expenses[] array of the HouseholdBudget object.
		expenses[this.expenses.length - 1] = new Expense(type, amount, businessName, dueDay, dueMonth);
		
		// We print a message containing the new number of expenses that the HouseholdBudget contains.
		if (expenses.length == 1)
		{
			System.out.println("You now have " + this.expenses.length + " expense");
		}
		
		else
		{
			System.out.println("You now have " + this.expenses.length + " expenses");
		}
	}
	
	/**
	 * The removeExpense method is a mutator method that removes an Expense object from the Expenses[] array of a HouseholdBudget object.
	 */
	public void removeExpense()
	{
		// We initialize a Scanner object to obtain information from the user.
		Scanner key = new Scanner(System.in);
		
		int expenseID = -1;
		
		// If the HouseholdBudget object contains no expenses, we return a message and terminate the method.
		if (this.expenses.length == 0)
		{
			System.out.println("Sorry! This HouseholdBudget has no expenses!");
			return;
		}
		
		// We obtain the ID of the expense that the user wishes to remove.
		// We make use of the getInput method, which is found in the BudgetDemo (the driver class) of the package.
		expenseID = BudgetDemo.getInput("(Enter number 0 to " + ( this.expenses.length - 1 ) + "): ", "No such expense number exists!", 0, this.expenses.length - 1);
		
		// We initialize an Expense[] array which will contain the original expenses of the HouseholdBudget.
		Expense[] oldExpenses = new Expense[this.expenses.length - 1];
		
		// We transfer the Expenses that the user wishes to keep into the old Expense[] array.
		for (int i = 0; i < expenseID; i++)
		{
			if (expenseID == 0) { break; }
			oldExpenses[i] = this.expenses[i];
		}
		
		// We continue transferring the Expenses that the user wishes to keep into the old Expense[] array.
		for (int i = expenseID + 1; i < this.expenses.length; i++)
		{	
			if (expenseID == this.expenses.length - 1) { break; }
			oldExpenses[i-1] = this.expenses[i];
		}
		
		// We reinitialize the main Expense[] array of the HouseholdBudget with a smaller size.
		this.expenses = new Expense[this.expenses.length - 1];
		
		// We transfer the remaining Expense objects back into the main Expense[] array of the HouseholdBudget object.
		for (int i = 0; i < oldExpenses.length; i++)
		{
			this.expenses[i] = oldExpenses[i];
		}
		
		// We display a success message.
		System.out.println("Expense was removed successfully!");
		
	}
	
	/**
	 *  The updateDueDate method is a mutator method which changes the day and month number of a pre-existing Expense object of a HouseholdBudget object.
	 */
	public void updateDueDate()
	{
		// We intiialize a Scanner object to obtain information from the user.
		Scanner key = new Scanner(System.in);
		
		// We display a fail message if the HouseholdBudget object contains no expense objects.
		if (this.expenses.length == 0)
		{
			System.out.println("Sorry! This HouseholdBudget does not have any expense to update.");
			return;
		}
		
		// We obtain the ID of the expense that the user wishes to update using the getInput method describe in the BudgetDemo class.
		int expenseID = BudgetDemo.getInput("Which expense do you want to update? (Enter number 0 to " + (this.expenses.length - 1) + "): ", "Sorry, there is no such expense number!", 0, this.expenses.length - 1);
		
		// We obtain the new day and month number.
		System.out.print(" --> Enter new payment due day number and month (seperated by a space): ");
		this.expenses[expenseID].dueDay = key.nextInt();
		this.expenses[expenseID].dueMonth = key.nextInt();
		
		// We validate the entered numbers and set the day and/or month number to 0 if the input is invalid.
		if (this.expenses[expenseID].dueDay < 1 || this.expenses[expenseID].dueDay > 31)
		{
			this.expenses[expenseID].dueDay = 0;
		}
		
		if (this.expenses[expenseID].dueMonth < 1 || this.expenses[expenseID].dueMonth > 12)
		{
			this.expenses[expenseID].dueMonth = 0;
		}
		
		// We display a success message.
		System.out.println("Due Date updated");
	}
	
	// The addBudgetFund method is a mutator method which adds funds to a pre-existing Fund object contained in the HouseholdBudget object.
	public void addBudgetFund()
	{
		// We initialize a Scanner object to obtain information from the user.
		Scanner key = new Scanner(System.in);
		
		// We obtain the number of each cash type that user wishes to add to a the pre-existing Fund object of the HouseholdBudget object.
		System.out.println("How many loonies, toonies, $5, $10, $20 bill do you want to add?");
		System.out.print("Enter 5 numbers (separated by a space): ");
		int loonies = key.nextInt();
		int toonies = key.nextInt();
		int fives = key.nextInt();
		int tens = key.nextInt();
		int twenties = key.nextInt();
		
		// We use the addFund method of the Fund class to add the values into the original values.
		this.funds.addFund(loonies, toonies, fives, tens, twenties);
		
		// We display a message containing the new total fund value of the HouseholdBudget object.
		System.out.println("You now have $" + this.funds.getTotal());
		
	}
	
	/**
	 *  The equals method is an accessor method that returns true if two distinct HouseholdBudget objects have the same total fund value and same number of expenses, and false otherwise.
	 * @param budget  A pre-existing HouseholdBudget object
	 * @return  true if the two distinct HouseholdBudget objects have the same total fund value and same number of expenses, false otherwise
	 */
	public boolean equals(HouseholdBudget budget)
	{
		if (this.funds.getTotal() != budget.funds.getTotal())
			return false;
		
		if (this.expenses.length != this.expenses.length)
			return false;
		
		return true;
	}
	
	/**
	 *  The toString method is an accessor method that makes use of the toString methods from the Fund and Expense classes to display the fund breakdown and the formatted list of expenses of a HouseholdBudget object.
	 * @return  A formatted description of the HouseholdBudget object, contaning the fund breakdown and a formatted list of its expenses
	 */
	public String toString()
	{
		// We make use of the toString method from the Fund class to display the fund breakdown of the HouseholdBudget object.
		System.out.println(this.funds.toString());
		
		// If the HouseholdBudget object contains no expenses, we display a fail message.
		if (this.expenses.length == 0)
		{
			System.out.println("No Expenses");
			return "";
		}
		
		// We iterate through the HouseholdBudget's Expense[] array and use the toString method from the Expense class to display a formatted list of the expenses.
		for (int i = 0; i < this.expenses.length; i++)
		{
			System.out.println(this.expenses[i].toString());
		}
		
		return "";
	}
	
	/**
	 *  The fundBreakdown method is an accessor method which displays the fund breakdown of the HouseholdBudget object using the toString method of the Fund class.
	 * @return The fund breakdown of the HouseholdBudget object
	 */
	public String fundBreakdown()
	{
		return this.funds.toString();
	}
}
