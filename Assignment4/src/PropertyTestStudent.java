/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test cases for property object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test cases for property object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	private Property myProperty;
	private Property mySecondProperty;
	private Property yourProperty;

	@BeforeEach
	void setUp() throws Exception {
		myProperty = new Property("Property XYZ", "Germantown", 5000.0, "Chakapan");
		yourProperty = new Property("Property ABC", "Rockville", 10000.0, "Kanchana", 2, 2, 4, 4);
		mySecondProperty = new Property("Property XYZ", "Germantown", 5000.0, "Chakapan");
	}

	@AfterEach
	void tearDown() throws Exception {
		myProperty = yourProperty = mySecondProperty = null;
	}

	@Test
	void testGetCity() {
		assertEquals("Germantown", myProperty.getCity());
		assertEquals("Rockville", yourProperty.getCity());
	}

	@Test
	void testGetOwner() {
		assertEquals("Chakapan", myProperty.getOwner());
		assertEquals("Kanchana", yourProperty.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, myProperty.getPlot().getX());
		assertEquals(0, myProperty.getPlot().getY());
		assertEquals(1, myProperty.getPlot().getWidth());
		assertEquals(1, myProperty.getPlot().getDepth());
		assertEquals(new Plot(2, 2, 4, 4), yourProperty.getPlot());
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property XYZ", myProperty.getPropertyName());
		assertEquals("Property ABC", yourProperty.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(5000, myProperty.getRentAmount());
		assertEquals(10000, yourProperty.getRentAmount());

	}

	@Test
	void testToString() {
		assertEquals("Property XYZ,Germantown,Chakapan,5000.0", myProperty.toString());
		assertEquals("Property ABC,Rockville,Kanchana,10000.0", yourProperty.toString());
	}

	@Test
	void testEquals() {
		assertTrue(myProperty.equals(mySecondProperty));
		assertFalse(myProperty.equals(yourProperty));
	}

}
