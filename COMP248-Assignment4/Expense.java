// ---------------------------------------------------------
// Assignment 4
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// ---------------------------------------------------------

// This public class contains the methods required to modify and obtain information regarding the expenses of a budget.

public class Expense
{
	// We initialize the instance variables that are specific to every Expense object.
	private String type;
	private double amount;
	private String businessName;
	
	// We initialize the public instance variables that are accessed by the equals method, which will shortly be explained.
	public int dueMonth;
	public int dueDay;
	
	/**
	 *  We write the default constructor.
	 */
	public Expense() {}
	
	/**
	 *  We write the main constructor, which builds an Expense object containing the type of purchase, the amount, the name of the business from which the purchase was made, the day and month number when the expense was performed.
	 * @param type  The kind of expense made (i.e. Purchase, Bill, etc)
	 * @param amount  The amount of the expense made
	 * @param businessName  The name of the business in which the expense was made
	 * @param dueDay  The day on which the expense was made (must be between 1 and 31, or else it defaults to 0)
	 * @param dueMonth  The month on which the expense was made (must be between 1 and 12, or else it defaults to 0)
	 */
	public Expense(String type, double amount, String businessName, int dueDay, int dueMonth)
	{
		this.type = type;
		this.amount = amount;
		this.businessName = businessName;
		this.dueMonth = dueMonth;
		
		// This if-else statement validates the entered day number, if it is not a valid day number, we set it to 0.
		if (dueDay < 1 || dueDay > 31)
		{
			this.dueDay = 0;
		}
		
		else
		{
			this.dueDay = dueDay;
		}
		
		// This if-else statement validates the entered month number, if it is not a valid month number, we set it to 0.
		if (dueMonth < 1 || dueMonth > 12)
		{
			this.dueMonth = 0;
		}
		
		else
		{
			this.dueMonth = dueMonth;
		}
	}
	
	/**
	 * We write the copy constructor to give the user the ability to build Expense objects contaning information from pre-existing Expense objects. 
	 * @param expense  A pre-existing Expense object
	 */
	public Expense(Expense expense)
	{
		this.type = expense.type;
		this.amount = expense.amount;
		this.businessName = expense.businessName;
		this.dueMonth = expense.dueMonth;
		this.dueDay = expense.dueDay;
	}
	
	/**
	 *  The toString method is an accessor method which displays all the relevant information pertaining to the object.
	 *  return result  A string containing the formatted information of the Expense
	 */
	public String toString()
	{
		String dueDayFormatted = "";
		String dueMonthFormatted = "";
		
		// This if-else statement correctly formats the day number belonging to the expense.
		if (this.dueDay < 10)
		{
			dueDayFormatted = "0" + this.dueDay;
		}
		
		else
		{
			dueDayFormatted = "" + this.dueDay + "";
			dueDayFormatted.trim();
		}
		
		// This if-else statement correctly formats the month number belonging to the expense.
		if (this.dueMonth < 10)
		{
			dueMonthFormatted = "0" + this.dueMonth;
		}
		
		else
		{
			dueMonthFormatted = "" + this.dueMonth + "";
			dueMonthFormatted.trim();
			
		}
		
		String result = this.type.trim() + " - $" + this.amount + " - " + this.businessName.trim() + " - " + dueDayFormatted + "/" + dueMonthFormatted + ".";
		
		return result;
	}
	
	/**
	 *  The equals method is an accessor method that returns true if two distinct Expense objects contain the same information, and false otherwise.
	 * @param expense  A pre-existing Expense object
	 * @return true if the distinct Expense objects are equal and false otherwise
	 */
	public boolean equals(Expense expense)
	{
		// We initialize a String array containing the String instance variables.
		String[] originalWords = new String[2];
		
		originalWords[0] = this.type;
		originalWords[1] = this.businessName;
		
		// We initialize an Int array containing the Integer instance variables.
		int[] originalNumbers = new int[2];
		
		originalNumbers[0] = this.dueMonth;
		originalNumbers[1] = this.dueDay;
		
		// We initialize a second String array containing the String instance variables of the other Expense object.
		String[] newWords = new String[2];
		
		newWords[0] = expense.type;
		newWords[1] = expense.businessName;
		
		// We initialize a second Integer array containing the Integer instance variables of the other Expense object. 
		int[] newNumbers = new int[2];
		
		newNumbers[0] = expense.dueMonth;
		newNumbers[1] = expense.dueDay;
		
		// We verify whether the two distinct Expense objects contain the same String instance variables.
		for (int i = 0; i < 2; i++)
		{
			if (!originalWords[i].equals(newWords[i]))
				return false;
		}
		
		// We verify whether the two distinct Expense objects contain the same Integer instance variables.
		for (int i = 0; i < 2; i++)
		{
			if (originalNumbers[i] != newNumbers[i])
				return false;
		}
		
		// We verify whether the single Double instance variable is equal.
		if (this.amount != expense.amount)
			return false;
		
		return true;
	}
}
