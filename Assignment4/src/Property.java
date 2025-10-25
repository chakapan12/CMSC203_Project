/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents property object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

import java.util.Objects;

/**
 * This class represents a Property object.
 */
public class Property {

	private String city;
	private String owner;
	private Plot plot;
	private String propertyName;
	private double rentAmount;

	/**
	 * Creates a new Property using empty strings. It also creates a default Plot.
	 */
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		plot = new Plot();
	}

	/**
	 * Creates a new Property object using given values. It also creates a default
	 * Plot.
	 * 
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}

	/**
	 * Creates a new Property object using given values. It also creates a Plot
	 * using given values of a plot.
	 * 
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 * @param x            the x coordinate of the plot
	 * @param y            the y coordinate of the plot
	 * @param width        the width coordinate of the plot
	 * @param depth        the depth coordinate of the plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this(propertyName, city, rentAmount, owner);
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * Creates a new copy of the given property object.
	 * 
	 * @param otherProperty the Property object to make a copy of
	 */
	public Property(Property otherProperty) {
		propertyName = otherProperty.propertyName;
		city = otherProperty.city;
		rentAmount = otherProperty.rentAmount;
		owner = otherProperty.owner;
		plot = new Plot(otherProperty.plot);
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Gets the plot.
	 * 
	 * @return the plot
	 */
	public Plot getPlot() {
		return new Plot(plot);
	}

	/**
	 * Gets the property name.
	 * 
	 * @return the property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Gets the rent amount.
	 * 
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Compares this property to another object for equality.
	 * 
	 * @param obj the object to compare with this property object
	 * @return true if all property details match; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(city, other.city) 
				&& Objects.equals(owner, other.owner) 
				&& this.plot.equals(other.plot)
				&& Objects.equals(propertyName, other.propertyName) 
				&& this.rentAmount == other.rentAmount;
	}
	
	/**
	 * Represents a Property object in the following String format:
	 * propertyName,city,owner,rentAmount
	 * 
	 * @return the string representation of a Property object
	 */
	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}

}
