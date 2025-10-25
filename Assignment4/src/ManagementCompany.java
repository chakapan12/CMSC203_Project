/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents ManagementCompany object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

import java.util.Arrays;
import java.util.Objects;

public class ManagementCompany {

	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	private double mgmFeePer;
	private String name;
	private int numberOfProperties;
	private Plot plot;
	private Property[] properties;
	private String taxID;

	/**
	 * Creates a ManagementCompany object using empty strings, creates a default
	 * Plot with maximum width and depth and it initializes the properties array.
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];

	}

	/**
	 * Creates a ManagementCompany object using the given values, creates a default
	 * Plot with maximum width and depth and it initializes the properties array.
	 * 
	 * @param name   management Company name
	 * @param taxID  tax Id
	 * @param mgmFee management Fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Creates a ManagementCompany object using the given values creates a Plot
	 * using the given values and it initializes the properties array. This
	 * constructor should call an appropriate existing constructor.
	 * 
	 * @param name      management Company name
	 * @param taxID     tax Id
	 * @param mgmFeePer management Fee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this(name, taxID, mgmFeePer);
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Creates a new ManagementCompany copy of the given ManagementCompany. This
	 * constructor should call an appropriate existing constructor.
	 * 
	 * @param otherCompany otherCompany object to make a copy of
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = new Plot(otherCompany.plot);
	}

	/**
	 * Adds a new property to the properties array, this method should call an
	 * appropriate existing overloaded method.
	 * 
	 * @param name  property name
	 * @param city  city where the property is located
	 * @param rent  rent amount
	 * @param owner the owner's name
	 * @return -1 if the array is full, -2 if the Property object is null, -3 if
	 *         management company does not encompass the property plot, -4 if
	 *         property plot overlaps ANY of properties in array, otherwise return
	 *         the index of the array where the property was added.
	 */

	public int addProperty(String name, String city, double rent, String owner) {
		// create property object
		Property property = new Property(name, city, rent, owner);
		return addProperty(property);

	}

	/**
	 * Adds a new property to the properties array, this method should call an
	 * appropriate existing overloaded method.
	 * 
	 * @param name  property name
	 * @param city  city where the property is located
	 * @param rent  rent amount
	 * @param owner the owner's name
	 * @param x     The x coordinate of the plot
	 * @param y     The y coordinate of the plot
	 * @param width The width coordinate of the plot
	 * @param depth The depth coordinate of the plot
	 * @return -1 if the array is full, -2 if the Property object is null, -3 if
	 *         management company does not encompass the property plot, -4 if
	 *         property plot overlaps ANY of properties in array, otherwise return
	 *         the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		// create property object
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);

	}

	/**
	 * Creates a property object by copying from another property and adds it to the
	 * properties array.
	 * 
	 * @param property property object
	 * @return -1 if the array is full, -2 if the Property object is null, -3 if
	 *         management company does not encompass the property plot, -4 if
	 *         property plot overlaps ANY of properties in array, otherwise return
	 *         the index of the array where the property was added.
	 */
	public int addProperty(Property property) {

		if (isPropertiesFull())
			return -1;
		if (property == null)
			return -2;
		if (!plot.encompasses(property.getPlot()))
			return -3;
		if (numberOfProperties >= 1) {
			for (int i = 0; i < numberOfProperties; i++) {
				if (properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
		}

		properties[numberOfProperties] = new Property(property);
		return numberOfProperties++;

	}

	/**
	 * Removes(nullifies) the LAST property in the properties array
	 */
	public void removeLastProperty() {
		properties[numberOfProperties - 1] = null;
		numberOfProperties--;
	}

	/**
	 * Checks if the properties array has reached the maximum capacity
	 * 
	 * @return true if properties array is full, false otherwise
	 */
	public boolean isPropertiesFull() {
		if (numberOfProperties == MAX_PROPERTY)
			return true;
		return false;
	}

	/**
	 * Gets the number of existing properties in the array
	 * 
	 * @return the number of existing properties in the array
	 */
	public int getPropertiesCount() {
		return numberOfProperties;
	}

	/**
	 * Returns the total rent of the properties in the properties array
	 * 
	 * @return total rent
	 */
	public double getTotalRent() {
		double totalRent = 0;
		for (int i = 0; i < numberOfProperties; i++) {
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}

	/**
	 * Gets the property in the array with the maximum amount of rent
	 * 
	 * @return the property in the array which has the highest amount of rent
	 */
	public Property getHighestRentProperty() {
		if (numberOfProperties == 0)
			return null;

		double highestRent = properties[0].getRentAmount();
		int highestIndex = 0;
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getRentAmount() > highestRent) {
				highestRent = properties[i].getRentAmount();
				highestIndex = i;
			}
		}
		return properties[highestIndex];
	}

	/**
	 * Returns the index of the property with the maximum rent amount. * NOTE: For
	 * simplicity assume that each "Property" object's rent amount is different.
	 * 
	 * @return the index of the property with the maximum rent amount
	 */
	public int getHighestRentPropertyIndex() {
		if (numberOfProperties == 0)
			return -1;
		if (numberOfProperties == 1)
			return 0;

		double highestRent = properties[0].getRentAmount();
		int highestIndex = -1;
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getRentAmount() > highestRent) {
				highestRent = properties[i].getRentAmount();
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	/**
	 * Checks if the management company has a valid (between 0-100) fee
	 * 
	 * @return true of the management fee is valid (between 0-100), false otherwise
	 */
	public boolean isManangmentFeeValid() {
		if (mgmFeePer < 0 || mgmFeePer > 100)
			return false;
		return true;
	}

	/**
	 * Get the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the tax ID
	 * 
	 * @return the tax ID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * Get the property
	 * 
	 * @return the property
	 */
	public Property[] getProperties() {

		// create a copy property array and copy values from original property
		Property[] copy = new Property[numberOfProperties];
		for (int i = 0; i < numberOfProperties; i++) {
			copy[i] = new Property(properties[i]);
		}
		return copy;
	}

	/**
	 * Gets the management fee per.
	 * 
	 * @return the mgmFeePer
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
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
	 * Compares this ManagementCompany to another object for equality.
	 * 
	 * @param obj the object to compare with this ManagementCompany object
	 * @return true if all ManagementCompany details match; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagementCompany other = (ManagementCompany) obj;
		return this.mgmFeePer == other.mgmFeePer 
				&& Objects.equals(name, other.name)
				&& numberOfProperties == other.numberOfProperties 
				&& this.plot.equals(other.plot)
				&& Arrays.equals(properties, other.properties) 
				&& Objects.equals(taxID, other.taxID);
	}
	
	/**
	 * Represents the information of all the properties in the properties array.
	 * 
	 * @return information of ALL the properties within this management company by
	 *         accessing the properties array. This value should include each
	 *         management company's name, taxID as well each property's
	 *         name,city,owner,rent Amount
	 */
	@Override
	public String toString() {

		String str = "";
		double totalFee = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			totalFee += properties[i].getRentAmount() * getMgmFeePer() / 100;
			str += properties[i].getPropertyName() + "," + properties[i].getCity() + "," + properties[i].getOwner()
					+ "," + properties[i].getRentAmount() + "\n";
		}

		String feeFormat = String.format("%.2f", totalFee);

		return "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n"
				+ "_________________________________________\n" + str + "_________________________________________\n"
				+ "\n" + "total management Fee: " + feeFormat;
	}

}
