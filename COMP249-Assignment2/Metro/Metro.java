// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Metro class represents a train that operates within a metropolitan area, with a certain number of stops.
 * It inherits from the Train class and adds a numberOfStops attribute.
 */
package Metro;

import TrainTram.*;

/**
 * Represents a metro train vehicle.
 */
public class Metro extends Train
{
	/** The number of stops the metro has */
	public int numberOfStops;
	
	/** 
	 * Constructs a new Metro object with default values for attributes.
	 * Calls the parent constructor and sets numberOfStops to 0.
	 */
	public Metro()
	{
		super();
		this.numberOfStops = 0;
	}
	
	/** 
	 * Constructs a new Metro object with the given attribute values.
	 * Calls the parent constructor with the given values for attributes of the Train class 
	 * and sets the numberOfStops attribute to the given value.
	 * 
	 * @param numberOfWheels The number of wheels of the metro.
	 * @param maximumSpeed The maximum speed of the metro.
	 * @param numberOfVehicles The number of vehicles the metro has.
	 * @param startingStationName The name of the starting station of the metro.
	 * @param destinationStationName The name of the destination station of the metro.
	 * @param numberOfStops The number of stops the metro has.
	 */
	public Metro(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String startingStationName, String destinationStationName, int numberOfStops)
	{
		super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStationName, destinationStationName);
		this.numberOfStops = numberOfStops;
	}
	
	/** 
	 * Constructs a new Metro object that is a copy of the given Metro object.
	 * Calls the parent constructor with the attributes of the given Metro object 
	 * and sets the numberOfStops attribute to the same value as the given Metro object.
	 * 
	 * @param other The Metro object to copy.
	 */
	public Metro(Metro other)
	{
		super(other);
		this.numberOfStops = other.numberOfStops;
	}
	
	/** 
	 * Returns the number of stops the metro has.
	 * 
	 * @return The number of stops the metro has.
	 */
	public int getNumberOfStops()
	{
		return new Metro(this).numberOfStops;
	}
	
	/** 
	 * Sets the number of stops the metro has to the given value.
	 * 
	 * @param numberOfStops The new number of stops for the metro.
	 */
	public void setNumberOfStops(int numberOfStops)
	{
		this.numberOfStops = numberOfStops;
	}
	
	/**
	 * Returns a string representation of the metro object.
	 * 
	 * @return A string representation of the metro object.
	 */
	@Override
	public String toString()
	{
		return "This metro has " + this.numberOfWheels + " wheels, a maximum speed of " + this.maximumSpeed + " km/h, " + this.numberOfVehicles + " vehicles, and its starting station is " + this.startingStationName + " and its ending station is " + this.destinationStationName + ", and has " + this.numberOfStops + " stops.";
	}
	
	/** 
	 * Compares this Metro object to the given object for equality.
	 * 
	 * @param o The object to compare to.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Metro other = (Metro) o;
		
		if (other.numberOfWheels != numberOfWheels || other.maximumSpeed != maximumSpeed || other.numberOfVehicles != numberOfVehicles || !other.startingStationName.equals(startingStationName) || !other.destinationStationName.equals(destinationStationName) || other.numberOfStops != numberOfStops)
		{
			return false;
		}
		
		return true;
	}
}
