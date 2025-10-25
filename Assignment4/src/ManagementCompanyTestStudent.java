/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test cases for ManagementCompany object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test cases for ManagementCompany object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	private Property propertyOne, propertyTwo, propertyThree, propertyFour, propertyFive, propertySix, propertySeven;
	private ManagementCompany myCompany, testCompany;

	@BeforeEach
	void setUp() throws Exception {
		// create ManagementCompany object
		myCompany = new ManagementCompany("Google", "12345", 5);

		// Create property objects and make sure none of them overlap with each other
		propertyOne = new Property("Property AAA", "Rockville", 5000.0, "Kanchana", 0, 0, 1, 1);
		propertyTwo = new Property("Property BBB", "Rockville", 10000.0, "Kanchana", 1, 1, 1, 1);
		propertyThree = new Property("Property CCC", "Germantown", 15000.0, "Kanchana", 2, 2, 1, 1);
		propertyFour = new Property("Property DDD", "Silver Spring", 20000, "Kanchana", 3, 3, 1, 1);
		propertyFive = new Property("Property EEE", "Bethesda", 25000.0, "Kanchana", 4, 4, 1, 1);

		// Create a Property object that overlaps with another (overlap with propertyOne)
		propertySix = new Property("Property FFF", "Bethesda", 30000.0, "Kanchana", 0, 0, 5, 5);
		// not encompassed by the ManagementCompany
		propertySeven = new Property("Property GGG", "Bethesda", 30000.0, "Kanchana", 6, 6, 5, 5);

	}

	@AfterEach
	void tearDown() throws Exception {
		myCompany = null;
		propertyOne = propertyTwo = propertyThree = propertyFour = propertyFive = propertySix = propertySeven = null;
	}

	@Test
	void testAddProperty() {
		assertEquals(0, myCompany.addProperty(propertyOne)); // property 1 has been successfully added to index 0
		assertEquals(1, myCompany.addProperty(propertyTwo)); // property 2 has been successfully added to index 1
		assertEquals(-4, myCompany.addProperty(propertySix)); // property 6 was not added, should return -4
		assertEquals(-3, myCompany.addProperty(propertySeven)); // property 7 was not added, should return -3
		
		
	}

	@Test
	void testRemoveLastProperty() {
		// Add two properties
		myCompany.addProperty(propertyOne); // property 1 is added
		myCompany.addProperty(propertyTwo); // property 2 is added
		// Remove last property
		myCompany.removeLastProperty(); // property 2 is removed
		assertEquals(1, myCompany.getPropertiesCount());
	}

	@Test
	void testIsPropertiesFull() {
		myCompany.addProperty(propertyOne); // property 1 is added
		assertFalse(myCompany.isPropertiesFull()); // properties is not full

		myCompany.addProperty(propertyTwo); // property 2 is added
		myCompany.addProperty(propertyThree); // property 3 is added
		myCompany.addProperty(propertyFour); // property 4 is added
		myCompany.addProperty(propertyFive); // property 5 is added

		assertTrue(myCompany.isPropertiesFull()); // properties is full
	}

	@Test
	void testGetPropertiesCount() {
		myCompany.addProperty(propertyOne); // property 1 is added
		myCompany.addProperty(propertyTwo); // property 2 is added

		assertEquals(2, myCompany.getPropertiesCount()); // number of properties = 2
	}

	@Test
	void testGetTotalRent() {
		myCompany.addProperty(propertyOne); // property 1 is added (rent = 5000.0)
		myCompany.addProperty(propertyTwo); // property 2 is added (rent = 10000.0)

		assertEquals(15000.0, myCompany.getTotalRent());
	}

	@Test
	void testGetHighestRentProperty() {
		myCompany.addProperty(propertyOne); // property 1 is added (rent = 5000.0)
		myCompany.addProperty(propertyTwo); // property 2 is added (rent = 10000.0)

		assertEquals("Property BBB", myCompany.getHighestRentProperty().getPropertyName());
	}

	@Test
	void testGetHighestRentPropertyIndex() {
		myCompany.addProperty(propertyOne); // property 1 is added (rent = 5000.0) index = 0
		myCompany.addProperty(propertyTwo); // property 2 is added (rent = 10000.0) index = 1
		myCompany.addProperty(propertyThree); // property 3 is added (rent = 15000.0) index = 2

		assertEquals(2, myCompany.getHighestRentPropertyIndex());
	}

	@Test
	void testIsManangmentFeeValid() {
		assertTrue(myCompany.isManangmentFeeValid());
	}

	@Test
	void testGetName() {
		assertEquals("Google", myCompany.getName());
	}

	@Test
	void testGetTaxID() {
		assertEquals("12345", myCompany.getTaxID());
	}

	@Test
	void testGetProperties() {
		myCompany.addProperty(propertyOne); // property 1 is added to index 0
		Property testProperty = myCompany.getProperties()[0];

		// compare contents in propertyOne to test property
		// propertyOne = (Property AAA", "Rockville", 5000.0, "Kanchana")
		assertEquals("Property AAA", testProperty.getPropertyName());
		assertEquals("Rockville", testProperty.getCity());
		assertEquals(5000.0, testProperty.getRentAmount());
		assertEquals("Kanchana", testProperty.getOwner());
	}

	@Test
	void testGetMgmFeePer() {
		assertEquals(5, myCompany.getMgmFeePer());
	}

	@Test
	void testGetPlot() {
		assertEquals("0,0,10,10", myCompany.getPlot().toString()); // get default plot object for ManagementCompany
																	// object
	}

	@Test
	void testToString() {
		myCompany.addProperty(propertyOne);
		myCompany.addProperty(propertyTwo);
		String expectString = "List of the properties for Google, taxID: 12345\n"
				+ "_________________________________________\n" 
				+ "Property AAA,Rockville,Kanchana,5000.0\n"
				+ "Property BBB,Rockville,Kanchana,10000.0\n" 
				+ "_________________________________________\n"
				+ "\ntotal management Fee: 750.00";
		assertEquals(expectString, myCompany.toString());
	}

	@Test
	void testEquals() {
		testCompany = new ManagementCompany("Google", "12345", 5);
		assertTrue(myCompany.equals(testCompany));
	}

}
