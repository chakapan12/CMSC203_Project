/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Arena object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Arena object
 * 
 * @author Chakapan Kanchana
 */
public class Arena implements Building {
	// instance variables
	private String color;
	private double length;
	private double width;
	private String buildingType;

	/**
	 * Creates an Arena using given values.
	 * 
	 * @param color  the color of Arena
	 * @param length the length of Arena
	 * @param width  the width of Arena
	 */
	public Arena(String color, double length, double width) {
		this.color = color;
		this.length = length;
		this.width = width;
		this.buildingType = "Arena";
	}

	/**
	 * Sets the size of the Arena by updating its length and width.
	 *
	 * @param length the new length of the Arena
	 * @param width  the new width of the Arena
	 */
	@Override
	public void setSize(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * Returns the length of the Arena.
	 *
	 * @return the current length
	 */
	@Override
	public double getLength() {
		return length;
	}

	/**
	 * Returns the width of the Arena.
	 *
	 * @return the current width
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * Sets the color of the Arena.
	 *
	 * @param color the new color of the Arena
	 */
	@Override
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the color of the Arena.
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
	 * Returns a string representation of the Arena, including its color, length,
	 * width, and building type.
	 *
	 * @return a formatted string describing the Arena
	 */
	@Override
	public String toString() {
		return "Arena [color=" + color + ", length=" + length + ", width=" + width + ", buildingType=" + buildingType
				+ "]";
	}

}
