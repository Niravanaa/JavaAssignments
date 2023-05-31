// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Aircraft class represents an aircraft object with a price and maximum elevation.
 */
package Aircrafts;

/**
 * Represents an aircraft vehicle.
 */
public class Aircraft
{
	/**
	* The price of the aircraft.
	*/
	public double price;
	
	/**
	 * The maximum elevation that the aircraft can reach.
	 */
	public double maximumElevation;
	
	/**
	 * Constructs a default Aircraft object.
	 * The price of a default Aircraft object is 0.
	 * The maximum elevation of a default Aircraft object is 0.
	 */
	public Aircraft()
	{
		this.price = 0;
		this.maximumElevation = 0;
	}
	
	/**
	 * Constructs an Aircraft object with the given price and maximum elevation.
	 *
	 * @param price The price of the aircraft.
	 * @param maximumElevation The maximum elevation that the aircraft can reach.
	 */
	public Aircraft(double price, double maximumElevation)
	{
		this.price = price;
		this.maximumElevation = maximumElevation;
	}
	
	/**
	 * Constructs an Aircraft object that is a copy of the given Aircraft object.
	 *
	 * @param other The Aircraft object to copy.
	 */
	public Aircraft(Aircraft other)
	{
		this.price = other.price;
		this.maximumElevation = other.maximumElevation;
	}
	
	/**
	 * Returns the price of the aircraft.
	 *
	 * @return The price of the aircraft.
	 */
	public double getPrice()
	{
		return new Aircraft(this).price;
	}
	
	/**
	 * Sets the price of the aircraft.
	 *
	 * @param price The price of the aircraft.
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**
	 * Returns the maximum elevation that the aircraft can reach.
	 *
	 * @return The maximum elevation that the aircraft can reach.
	 */
	public double getMaximumElevation()
	{
		return new Aircraft(this).maximumElevation;
	}
	
	/**
	 * Sets the maximum elevation that the aircraft can reach.
	 *
	 * @param maximumElevation The maximum elevation that the aircraft can reach.
	 */
	public void setMaximumElevation(double maximumElevation)
	{
		this.maximumElevation = maximumElevation;
	}
	
	/**
	 * Returns a string representation of the Aircraft object.
	 *
	 * @return A string representation of the Aircraft object.
	 */
	@Override
	public String toString()
	{
		return "This Aircraft has a price of " + this.price + "$, and a maximum elevation of " + this.maximumElevation + " feet.";
	}
	
	/**
	 * Determines whether the given object is equal to this Aircraft object.
	 *
	 * @param o The object to compare to this Aircraft object.
	 * @return true if the given object is equal to this Aircraft object; false otherwise.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Aircraft other = (Aircraft) o;
		
		if (other.price != this.price || other.maximumElevation != this.maximumElevation)
		{
			return false;
		}
		
		return true;
	}
}