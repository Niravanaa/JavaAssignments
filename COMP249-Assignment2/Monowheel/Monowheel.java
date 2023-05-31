// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Monowheel class represents a single-wheeled transportation device that extends WheeledTransportation.
 * It includes the maximum weight the Monowheel can carry.
 */
package Monowheel;

import WheeledTransportation.*;

/**
 * Represents a monowheel vehicle.
 */
public class Monowheel extends WheeledTransportation
{
	/**
	 * The maximum weight that this Monowheel can carry.
	 */
	public double maximumWeight;
	
	/**
	 * Constructs a Monowheel object with default values for all properties.
	 */
	public Monowheel()
	{
		super();
		this.maximumWeight = 0;
	}
	
	/**
	 * Constructs a Monowheel object with the specified values for numberOfWheels, maximumSpeed, and maximumWeight.
	 *
	 * @param numberOfWheels the number of wheels of the Monowheel
	 * @param maximumSpeed the maximum speed of the Monowheel in km/h
	 * @param maximumWeight the maximum weight the Monowheel can carry in kg
	 */
	public Monowheel(int numberOfWheels, double maximumSpeed, double maximumWeight)
	{
		super(numberOfWheels, maximumSpeed);
		this.maximumWeight = maximumWeight;
	}
	
	/**
	 * Constructs a new Monowheel object that is a copy of the specified Monowheel.
	 *
	 * @param other the Monowheel to copy
	 */
	public Monowheel(Monowheel other)
	{
		super(other);
		this.maximumWeight = other.maximumWeight;
	}
	
	/**
	 * Returns the maximum weight that this Monowheel can carry.
	 *
	 * @return the maximum weight the Monowheel can carry in kg
	 */
	public double getMaximumWeight()
	{
		return new Monowheel(this).maximumWeight;
	}
	
	/**
	 * Sets the maximum weight that this Monowheel can carry.
	 *
	 * @param maximumWeight the maximum weight the Monowheel can carry in kg
	 */
	public void setMaximumWeight(double maximumWeight)
	{
		this.maximumWeight = maximumWeight;
	}
	
	/**
	 * Returns a string representation of this Monowheel object.
	 *
	 * @return a string representation of the Monowheel object
	 */
	@Override
	public String toString()
	{
		return "This Monowheel has " + this.numberOfWheels + " wheels, a maximum speed of " + this.maximumSpeed + " km/h, and has a maximum weight of " + this.maximumWeight + " kg.";
	}
	
	/**
	 * Returns true if the specified object is equal to this Monowheel.
	 *
	 * @param o the object to compare
	 * @return true if the specified object is equal to this Monowheel
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Monowheel other = (Monowheel) o;
		
		if (other.numberOfWheels != this.numberOfWheels || other.maximumSpeed != this.maximumSpeed || other.maximumWeight != this.maximumWeight)
		{
			return false;
		}
		
		return true;
	}
}
