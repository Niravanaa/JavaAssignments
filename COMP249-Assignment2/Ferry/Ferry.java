// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Ferry class represents a ferry vehicle that can carry passengers and vehicles across bodies of water.
 */
package Ferry;

/**
 * Represents a ferry transportation vehicle.
 */
public class Ferry
{
	/**
	* The maximum speed of the ferry in km/h.
	*/
	public double maximumSpeed;
	
	/**
	 * The maximum load capacity of the ferry in kg.
	 */
	public double maximumLoad;
	
	/**
	 * Constructs a new Ferry object with default values for maximumSpeed and maximumLoad.
	 */
	public Ferry()
	{
		this.maximumSpeed = 0;
		this.maximumLoad = 0;
	}
	
	/**
	 * Constructs a new Ferry object with the specified maximumSpeed and maximumLoad values.
	 * @param maximumSpeed the maximum speed of the ferry in km/h.
	 * @param maximumLoad the maximum load capacity of the ferry in kg.
	 */
	public Ferry(double maximumSpeed, double maximumLoad)
	{
		this.maximumSpeed = maximumSpeed;
		this.maximumLoad = maximumLoad;
	}
	
	/**
	 * Constructs a new Ferry object with the same maximumSpeed and maximumLoad values as another Ferry object.
	 * @param other the Ferry object to copy.
	 */
	public Ferry(Ferry other)
	{
		this.maximumSpeed = other.maximumSpeed;
		this.maximumLoad = other.maximumLoad;
	}
	
	/**
	 * Returns the maximum speed of the ferry in km/h.
	 * @return the maximum speed of the ferry.
	 */
	public double getMaximumSpeed()
	{
		return new Ferry(this).maximumSpeed;
	}
	
	/**
	 * Sets the maximum speed of the ferry in km/h.
	 * @param maximumSpeed the new maximum speed of the ferry.
	 */
	public void setMaximumSpeed(double maximumSpeed)
	{
		this.maximumSpeed = maximumSpeed;
	}
	
	/**
	 * Returns the maximum load capacity of the ferry in kg.
	 * @return the maximum load capacity of the ferry.
	 */
	public double getMaximumLoad()
	{
		return new Ferry(this).maximumLoad;
	}
	
	/**
	 * Sets the maximum load capacity of the ferry in kg.
	 * @param maximumLoad the new maximum load capacity of the ferry.
	 */
	public void setMaximumLoad(double maximumLoad)
	{
		this.maximumLoad = maximumLoad;
	}
	
	/**
	 * Returns a String representation of the Ferry object.
	 * @return a String representation of the Ferry object.
	 */
	@Override
	public String toString()
	{
		return "This Ferry has a maximum speed of " + this.maximumSpeed + " km/h, and a maximum load of " + this.maximumLoad + " kg.";
	}
	
	/**
	 * Determines whether another object is equal to this Ferry object.
	 * @param o the object to compare.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Ferry other = (Ferry) o;
		
		if (other.maximumSpeed != this.maximumSpeed || other.maximumLoad != this.maximumLoad)
		{
			return false;
		}
		
		return true;
	}
}
