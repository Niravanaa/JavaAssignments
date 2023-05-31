// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * A class representing a World War 2 Aircraft, which is a subclass of Aircraft.
 * It adds a boolean field to indicate whether the aircraft has a twin engine or not.
 */
package Aircrafts;

/**
 * Represents a World War II aircraft vehicle.
 */
public class WW2Aircraft extends Aircraft
{
	/**
	* Boolean value indicating whether the WW2Aircraft has a twin engine or not.
	*/
	public boolean isTwinEngine;
	
	/**
	 * Default constructor. Initializes the isTwinEngine field to false, and calls the default constructor of the superclass.
	 */
	public WW2Aircraft()
	{
		super();
		this.isTwinEngine = false;
	}
	
	/**
	 * Constructor that initializes the fields with the specified values, and calls the corresponding constructor of the superclass.
	 * @param price the price of the aircraft
	 * @param maximumElevation the maximum elevation of the aircraft
	 * @param isTwinEngine whether the aircraft has a twin engine or not
	 */
	public WW2Aircraft(double price, double maximumElevation, boolean isTwinEngine)
	{
		super(price, maximumElevation);
		this.isTwinEngine = isTwinEngine;
	}
	
	/**
	 * Copy constructor. Creates a new WW2Aircraft object that is a copy of the given object, by calling the copy constructor of the superclass and copying the isTwinEngine field.
	 * @param other the object to be copied
	 */
	public WW2Aircraft(WW2Aircraft other)
	{
		super(other);
		this.isTwinEngine = other.isTwinEngine;
	}
	
	/**
	 * Returns the value of the isTwinEngine field of this WW2Aircraft object.
	 * @return the value of the isTwinEngine field
	 */
	public boolean getIsTwinEngine()
	{
		return new WW2Aircraft(this).isTwinEngine;
	}
	
	/**
	 * Sets the value of the isTwinEngine field of this WW2Aircraft object to the specified value.
	 * @param isTwinEngine the new value of the isTwinEngine field
	 */
	public void setIsTwinEngine(boolean isTwinEngine)
	{
		this.isTwinEngine = isTwinEngine;
	}
	

	/**
	 * Returns a string representation of this WW2Aircraft object, which includes the values of the price, maximumElevation, and isTwinEngine fields.
	 * @return a string representation of this WW2Aircraft object
	 */
	@Override
	public String toString()
	{
		return "This World War 2 Aircraft has a price of " + this.price + "$, a maximum elevation of " + this.maximumElevation + " feet, and it is " + this.isTwinEngine + " that this WW2 Aircraft has a twin engine.";
	}
	
	/**
	 * Determines whether this WW2Aircraft object is equal to the specified object.
	 * Two WW2Aircraft objects are considered equal if they have the same values for the price, maximumElevation, and isTwinEngine fields.
	 * @param o the object to be compared with this WW2Aircraft object
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		WW2Aircraft other = (WW2Aircraft) o;
		
		if (other.isTwinEngine != this.isTwinEngine || other.price != this.price || other.maximumElevation != this.maximumElevation)
		{
			return false;
		}
		
		return true;
	}
}
