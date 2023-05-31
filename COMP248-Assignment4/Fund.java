// ---------------------------------------------------------
// Assignment 4
// Written by: Nirav Patel #40248940
// For COMP 248 Section R – Fall 2022
// ---------------------------------------------------------

// This public class contains the methods required to modify and obtain information regarding the funds of a HouseholdBudget.

public class Fund
{
	// We initailize the required instance variables that represent the different types of money that a Fund can contain.
	private int loonies;
	private int toonies;
	private int fives;
	private int tens;
	private int twenties;
	
	/**
	 *  We write the default constructor for a Fund object.
	 */
	public Fund() {}
	
	/** 
	 * We write the main constructor which creates a Fund object containing a certain fund breakdown.
	 * @param loonies  The number of loonies ($1)
	 * @param toonies  The number of toonies ($2)
	 * @param fives    The number of five-dollar bills ($5)
	 * @param tens     The number of ten dollar bills ($10)
	 * @param twenties  The number of twenty dollar bills ($20)
	 */
	public Fund(int loonies, int toonies, int fives, int tens, int twenties)
	{
		this.loonies = loonies;
		this.toonies = toonies;
		this.fives = fives;
		this.tens = tens;
		this.twenties = twenties;
	}
	
	/**
	 * We write a copy constructor to give the user the ability to create new Fund objects containing information from a pre-existing Fund object.
	 * @param fund  A pre-existing Fund object.
	 */
	public Fund(Fund fund)
	{
		this.loonies = fund.loonies;
		this.toonies = fund.toonies;
		this.fives = fund.fives;
		this.tens = fund.tens;
		this.twenties = fund.twenties;
	}
	
	/** 
	 * The addFund method is a mutator method that essentially adds a certain amount of funds to a pre-existing Fund object.
	 * @param loonies  The number of loonies ($1)
	 * @param toonies  The number of toonies ($2)
	 * @param fives  The number of fives ($5)
	 * @param tens  The number of tens ($10)
	 * @param twenties  The number of twenties ($20)
	 */
	public void addFund(int loonies, int toonies, int fives, int tens, int twenties)
	{
		this.loonies += loonies;
		this.toonies += toonies;
		this.fives += fives;
		this.tens += tens;
		this.twenties += twenties;
	}
	
	
	/**
	 * The getTotal method is an accessor method that returns the total value of the fund that a budget contains.
	 * @return sum  The sum of all loonies, toonies, five-dollar bills, ten-dollar bills, twenty-dollar bills.
	 */
	public double getTotal()
	{
		double sum = this.loonies + this.toonies * 2 + this.fives * 5 + this.tens * 10 + this.twenties * 20;
		
		return sum;
	}
	
	/**
	 * The toString method is an accessor method that presents the fund breakdown of a Fund object.
	 * @return result  The formatted fund breakdown of the Fund object.
	 */
	public String toString()
	{
		String result = "(" + this.loonies + " x $1) + (" + this.toonies + " x $2) + (" + this.fives + " x $5) + (" + this.tens + " x $10) + (" + this.twenties + " x $20)";
				
		return result;
	}
	
	/**
	 * The equals method is an accessor method that returns true if the information contained in two distinct Fund objects are the same or not, and false otherwise.
	 * @param fund  A pre-existing Fund Object
	 * @return true if both objects are equal and false otherwise
	 */
	public boolean equals(Fund fund)
	{
		int[] originalBreakdown = new int[5];
		
		originalBreakdown[0] = this.loonies;
		originalBreakdown[1] = this.toonies;
		originalBreakdown[2] = this.fives;
		originalBreakdown[3] = this.tens;
		originalBreakdown[4] = this.twenties;
		
		int[] newBreakdown = new int[5];
		
		newBreakdown[0] = fund.loonies;
		newBreakdown[1] = fund.toonies;
		newBreakdown[2] = fund.fives;
		newBreakdown[3] = fund.tens;
		newBreakdown[4] = fund.twenties;
		
		for (int i = 0; i < 5; i++)
		{
			if (originalBreakdown[i] != newBreakdown[i])
				return false;
		}
		
		return true;
	}
}
