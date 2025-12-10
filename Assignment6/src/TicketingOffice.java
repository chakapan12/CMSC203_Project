/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents TicketingOffice object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents TicketingOffice object
 * 
 * @author Chakapan Kanchana
 */
public class TicketingOffice implements Building {
	// instance variables
	private String color;
	private double length;
	private double width;
	private String buildingType;

	/**
	 * Creates an TicketingOffice using given values.
	 * 
	 * @param color  the color of Ticketing Office
	 * @param length the length of Ticketing Office
	 * @param width  the width of Ticketing Office
	 */
	public TicketingOffice(String color, double length, double width) {
		this.color = color;
		this.length = length;
		this.width = width;
		this.buildingType = "Ticketing Office";
	}

	/**
	 * Sets the size of the Ticketing Office by updating its length and width.
	 *
	 * @param length the new length of the Ticketing Office
	 * @param width  the new width of the Ticketing Office
	 */
	@Override
	public void setSize(double length, double width) {
		this.length = length;
		this.width = width;

	}

	/**
	 * Returns the length of the Ticketing Office.
	 *
	 * @return the current length
	 */
	@Override
	public double getLength() {
		return length;
	}

	/**
	 * Returns the width of Ticketing Office.
	 *
	 * @return the current width
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * Sets the color of the Ticketing Office.
	 *
	 * @param color the new color of the Arena
	 */
	@Override
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the color of the Ticketing Office.
	 *
	 * @return the current color
	 */
	@Override
	public String getColor() {
		return color;
	}

	/**
	 * Sets the building type of this structure.
	 *
	 * @param type the type to assign to this building
	 */
	@Override
	public void setBuildingType(String type) {
		buildingType = type;

	}

	/**
	 * Returns the building type of this structure.
	 *
	 * @return the building type
	 */
	@Override
	public String getBuildingType() {
		return buildingType;
	}

	/**
	 * Returns a string representation of the Ticketing Office, including its color,
	 * length, width, and building type.
	 *
	 * @return a formatted string describing the Ticketing Office
	 */
	@Override
	public String toString() {
		return "TicketingOffice [color=" + color + ", length=" + length + ", width=" + width + ", buildingType="
				+ buildingType + "]";
	}

}
