/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Arena object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Arena object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArenaTestStudent {
	private Arena arena;

	@BeforeEach
	void setUp() throws Exception {
		arena = new Arena("White", 200.0, 100.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		arena = null;
	}

	@Test
	void testConstructorAndInitialValues() {
		assertEquals("White", arena.getColor(), "Initial color is incorrect.");
		assertEquals(200.0, arena.getLength(), 0.001, "Initial length is incorrect.");
		assertEquals(100.0, arena.getWidth(), 0.001, "Initial width is incorrect.");
		assertEquals("Arena", arena.getBuildingType(), "Initial building type is incorrect.");
	}

	@Test
	void testSetSize() {
		arena.setSize(500.0, 200.0);
		assertEquals(500.0, arena.getLength(), 0.001);
		assertEquals(200.0, arena.getWidth(), 0.001);
	}

	@Test
	void testGetLength() {
		assertEquals(200.0, arena.getLength(), 0.001);
	}

	@Test
	void testGetWidth() {
		assertEquals(100.0, arena.getWidth(), 0.001);
	}

	@Test
	void testSetColor() {
		arena.setColor("Black");
		assertEquals("Black", arena.getColor());
	}

	@Test
	void testGetColor() {
		assertEquals("White", arena.getColor());
	}

	@Test
	void testSetBuildingType() {
		arena.setBuildingType("TicketingOffice");
		assertEquals("TicketingOffice", arena.getBuildingType());
	}

	@Test
	void testGetBuildingType() {
		assertEquals("Arena", arena.getBuildingType());
	}

	@Test
	void testToString() {
		String expectedString = "Arena [color=White, length=200.0, width=100.0, buildingType=Arena]";
		assertEquals(expectedString, arena.toString());
	}

}
