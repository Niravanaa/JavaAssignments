// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The Train class represents a type of wheeled transportation that has a specific number of vehicles and operates on a track between two stations.
 * It inherits from the WheeledTransportation class.
 */
package TrainTram;

import WheeledTransportation.*;

/**
 * Represents a train vehicle.
 */
public class Train extends WheeledTransportation
{
	/** The number of vehicles on the train. */
	public int numberOfVehicles;

	/** The name of the station where the train starts its journey. */
	public String startingStationName;

	/** The name of the station where the train ends its journey. */
	public String destinationStationName;

	/**
	 * Constructs a new Train object with default values for all fields.
	 */
	public Train() {
		super();
		this.numberOfVehicles = 0;
		this.startingStationName = "";
		this.destinationStationName = "";
	}

	/**
	 * Constructs a new Train object with the specified values for all fields.
	 * @param numberOfWheels The number of wheels on the train.
	 * @param maximumSpeed The maximum speed of the train in km/h.
	 * @param numberOfVehicles The number of vehicles on the train.
	 * @param startingStationName The name of the station where the train starts its journey.
	 * @param destinationStationName The name of the station where the train ends its journey.
	 */
	public Train(int numberOfWheels, double maximumSpeed, int numberOfVehicles, String startingStationName, String destinationStationName) {
		super(numberOfWheels, maximumSpeed);
		this.numberOfVehicles = numberOfVehicles;
		this.startingStationName = startingStationName;
		this.destinationStationName = destinationStationName;
	}

	/**
	 * Constructs a new Train object that is a copy of the specified Train object.
	 * @param other The Train object to copy.
	 */
	public Train(Train other) {
		super(other);
		this.numberOfVehicles = other.numberOfVehicles;
		this.startingStationName = other.startingStationName;
		this.destinationStationName = other.destinationStationName;
	}

	/**
	 * Returns the number of vehicles on the train.
	 * @return The number of vehicles on the train.
	 */
	public int getNumberOfVehicles() {
		return new Train(this).numberOfVehicles;
	}

	/**
	 * Sets the number of vehicles on the train.
	 * @param numberOfVehicles The number of vehicles on the train.
	 */
	public void setNumberOfVehicles(int numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	/**
	 * Returns the name of the station where the train starts its journey.
	 * @return The name of the station where the train starts its journey.
	 */
	public String getStartingStationName() {
		return new Train(this).startingStationName;
	}

	/**
	 * Sets the name of the station where the train starts its journey.
	 * @param startingStationName The name of the station where the train starts its journey.
	 */
	public void setStartingStationName(String startingStationName) {
		this.startingStationName = startingStationName;
	}

	/**
	 * Returns the name of the station where the train ends its journey.
	 * @return The name of the station where the train ends its journey.
	 */
	public String getDestinationStationName() {
		return new Train(this).destinationStationName;
	}
	
	/**
	 * 
	 * Sets the destination station name for this Train.
	 * @param destinationStationName the name of the destination station for this Train
	 */
	public void setDestinationStationName(String destinationStationName)
	{
		this.destinationStationName = destinationStationName;
	}
	
	/**
	 * Returns a String representation of this Train, including its number of wheels, maximum speed,
	 * number of vehicles, starting station name, and destination station name.
	 * @return a String representation of this Train
	 */
	@Override
	public String toString()
	{
		return "This Train has " + this.numberOfWheels + " wheels, a maximum speed of " + this.maximumSpeed + " km/h, " + this.numberOfVehicles + " vehicles, and its starting station is " + this.startingStationName + " and its ending station is " + this.destinationStationName + ".";
	}
	
	/**
	 * Compares this Train to the specified Object for equality. The result is true if and only if
	 * the argument is not null and is a Train object that has the same number of wheels, maximum speed,
	 * number of vehicles, starting station name, and destination station name as this Train.
	 * @param o the Object to compare this Train against
	 * @return true if the given Object is equal to this Train, false otherwise
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Train other = (Train) o;
		
		if (other.numberOfWheels != numberOfWheels ||
				other.maximumSpeed != maximumSpeed ||
				other.numberOfVehicles != numberOfVehicles ||
				!other.startingStationName.equals(startingStationName) ||
				!other.destinationStationName.equals(destinationStationName))
		{
			return false;
		}
		
		return true;
	}
}

