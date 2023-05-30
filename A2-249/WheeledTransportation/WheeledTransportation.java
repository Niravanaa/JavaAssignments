// -----------------------------------------------------
// Assignment 2
// Part: 1 & 2
// Written by: Nirav Patel #40248940
// -----------------------------------------------------

/**
 * The `WheeledTransportation` class represents any vehicle that moves on wheels.
 * It has two properties: the number of wheels and the maximum speed of the vehicle.
 */
package WheeledTransportation;

/**
 * Represents a wheeled transportation vehicle.
 */
public class WheeledTransportation {

	/**
	 * The number of wheels in the vehicle.
	 */
	public int numberOfWheels;
	
	/**
	 * The maximum speed that the vehicle can achieve.
	 */
	public double maximumSpeed;
	
	/**
	 * Constructs a new `WheeledTransportation` object with no wheels and zero maximum speed.
	 */
	public WheeledTransportation() {
		this.numberOfWheels = 0;
		this.maximumSpeed = 0;
	}
	
	/**
	 * Constructs a new `WheeledTransportation` object with the specified number of wheels and maximum speed.
	 *
	 * @param numberOfWheels the number of wheels in the vehicle
	 * @param maximumSpeed the maximum speed that the vehicle can achieve
	 */
	public WheeledTransportation(int numberOfWheels, double maximumSpeed) {
		this.numberOfWheels = numberOfWheels;
		this.maximumSpeed = maximumSpeed;
	}
	
	/**
	 * Constructs a new `WheeledTransportation` object that is a copy of the specified `WheeledTransportation` object.
	 *
	 * @param other the `WheeledTransportation` object to copy
	 */
	public WheeledTransportation(WheeledTransportation other) {
		this.numberOfWheels = other.numberOfWheels;
		this.maximumSpeed = other.maximumSpeed;
	}
	
	/**
	 * Returns the number of wheels in the vehicle.
	 *
	 * @return the number of wheels in the vehicle
	 */
	public int getNumberOfWheels() {
		return new WheeledTransportation(this).numberOfWheels;
	}
	
	/**
	 * Sets the number of wheels in the vehicle.
	 *
	 * @param numberOfWheels the number of wheels to set
	 */
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	/**
	 * Returns the maximum speed that the vehicle can achieve.
	 *
	 * @return the maximum speed that the vehicle can achieve
	 */
	public double getMaximumSpeed() {
		return new WheeledTransportation(this).maximumSpeed;
	}
	
	/**
	 * Returns a string representation of the `WheeledTransportation` object, showing the number of wheels and maximum speed.
	 *
	 * @return a string representation of the `WheeledTransportation` object
	 */
	@Override
	public String toString() {
		return "This WheeledTransportation has " + this.numberOfWheels + " wheels and has a maximum speed of " + this.maximumSpeed + " km/h.";
	}
	
	/**
	 * Compares the `WheeledTransportation` object to another object to see if they are equal.
	 *
	 * @param o the object to compare to
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		WheeledTransportation other = (WheeledTransportation) o;
		
		if (numberOfWheels != other.numberOfWheels || maximumSpeed != other.maximumSpeed) {
			return false;
		}
		
		return true;
	}
}
