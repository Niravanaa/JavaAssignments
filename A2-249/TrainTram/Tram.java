// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Tram class represents a type of train that operates on a tramway system.
 * It extends the Metro class and adds a year of creation attribute.
 */
package TrainTram;

import Metro.*;

/**
 * Represents a tram vehicle.
 */
public class Tram extends Metro
{
	/**
	 * The yearOfCreation attribute represents the year when the tram was built.
	 */
	public int yearOfCreation;

	/**
	 * Constructs a Tram object with default values for the attributes.
	 * Calls the Metro default constructor and sets the year of creation to 0.
	 */
	public Tram()
	{
		super();
		this.yearOfCreation = 0;
	}
	
	/**
	 * Constructs a Tram object with the specified attributes.
	 * Calls the Metro constructor with the same arguments and sets the year of creation.
	 * @param numberOfWheels The number of wheels the tram has.
	 * @param maximumSpeed The maximum speed of the tram in km/h.
	 * @param numberOfVehicles The number of vehicles the tram has.
	 * @param startingStationName The name of the station where the tram starts.
	 * @param destinationStationName The name of the station where the tram ends.
	 * @param numberOfStops The number of stops the tram has.
	 * @param yearOfCreation The year when the tram was built.
	 */
	public Tram(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String startingStationName, String destinationStationName, int numberOfStops, int yearOfCreation)
	{
		super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStationName, destinationStationName, numberOfStops);
		this.yearOfCreation = yearOfCreation;
	}
	
	/**
	 * Constructs a Tram object that is a copy of another Tram object.
	 * Calls the Metro copy constructor with the same argument and sets the year of creation.
	 * @param other The Tram object to be copied.
	 */
	public Tram(Tram other)
	{
		super(other);
		this.yearOfCreation = other.yearOfCreation;
	}
	
	/**
	 * Returns the year when the tram was built.
	 * @return The year when the tram was built.
	 */
	public int getYearOfCreation()
	{
		return new Tram(this).yearOfCreation;
	}
	
	/**
	 * Sets the year when the tram was built.
	 * @param yearOfCreation The year when the tram was built.
	 */
	public void setYearOfCreation(int yearOfCreation)
	{
		this.yearOfCreation = yearOfCreation;
	}
	
	/**
	 * Returns a string representation of the Tram object.
	 * Overrides the Metro toString() method and adds the year of creation.
	 * @return A string representation of the Tram object.
	 */
	@Override
	public String toString()
	{
		return "This Tram has " + this.numberOfWheels + " wheels, a maximum speed of " + this.maximumSpeed + " km/h, " + this.numberOfVehicles + " vehicles, and its starting station is " + this.startingStationName + " and its ending station is " + this.destinationStationName + ", and has " + this.numberOfStops + " stops, and was created in " + this.yearOfCreation + ".";
	}
	
	/**
	 * Compares the Tram object to another object to see if they are equal.
	 * Overrides the Metro equals() method and adds the year of creation to the comparison.
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
		
		Tram other = (Tram) o;
		
		if (other.numberOfWheels != numberOfWheels || other.maximumSpeed != maximumSpeed || other.numberOfVehicles != numberOfVehicles || !other.startingStationName.equals(startingStationName) || !other.destinationStationName.equals(destinationStationName) || other.numberOfStops != numberOfStops || other.yearOfCreation != this.yearOfCreation)
		{
			return false;
		}
		
		return true;
	}
}
