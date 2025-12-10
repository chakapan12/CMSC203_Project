/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for TicketingOffice object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for TicketingOffice object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketingOfficeTestStudent {

	private TicketingOffice ticketingOffice;

	@BeforeEach
	void setUp() throws Exception {
		ticketingOffice = new TicketingOffice("Blue", 300.0, 100.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		ticketingOffice = null;
	}

	@Test
	void testConstructorAndInitialValues() {
		assertEquals("Blue", ticketingOffice.getColor(), "Initial color is incorrect.");
		assertEquals(300.0, ticketingOffice.getLength(), 0.001, "Initial length is incorrect.");
		assertEquals(100.0, ticketingOffice.getWidth(), 0.001, "Initial width is incorrect.");
		assertEquals("Ticketing Office", ticketingOffice.getBuildingType(), "Initial building type is incorrect.");
	}

	@Test
	void testSetSize() {
		ticketingOffice.setSize(500.0, 200.0);
		assertEquals(500.0, ticketingOffice.getLength(), 0.001);
		assertEquals(200.0, ticketingOffice.getWidth(), 0.001);
	}

	@Test
	void testGetLength() {
		assertEquals(300.0, ticketingOffice.getLength(), 0.001);
	}

	@Test
	void testGetWidth() {
		assertEquals(100.0, ticketingOffice.getWidth(), 0.001);
	}

	@Test
	void testSetColor() {
		ticketingOffice.setColor("Black");
		assertEquals("Black", ticketingOffice.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("Blue", ticketingOffice.getColor());
	}

	@Test
	void testSetBuildingType() {
		ticketingOffice.setBuildingType("Arena");
		assertEquals("Arena", ticketingOffice.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Ticketing Office", ticketingOffice.getBuildingType());
	}

	@Test
	void testToString() {
		String expectedString = "TicketingOffice [color=Blue, length=300.0, width=100.0, buildingType=Ticketing Office]";
		assertEquals(expectedString, ticketingOffice.toString());
	}

}
