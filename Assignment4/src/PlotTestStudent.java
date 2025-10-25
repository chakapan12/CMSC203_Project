/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test cases for plot object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test cases for plot object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	private Plot plot1, plot2, plot3, plot4, plot5;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(0, 0, 2, 2);
		plot2 = new Plot(1, 1, 3, 3);
		plot3 = new Plot(0, 0, 5, 5);
		plot4 = new Plot(3, 3, 4, 5);
		plot5 = new Plot(0, 0, 2, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = plot4 = null;
	}

	@Test
	void testOverlaps() {
		assertTrue(plot1.overlaps(plot2)); // plot1 overlaps plot2
		assertTrue(plot1.overlaps(plot3)); // plot1 is entirely inside plot3
		assertFalse(plot1.overlaps(plot4)); // plot1 does not overlap plot4
	}

	@Test
	void testEncompasses() {
		assertTrue(plot3.encompasses(plot1)); // plot1 is entirely inside plot3
		assertFalse(plot3.encompasses(plot4)); // plot4 is not entirely inside plot3
	}

	@Test
	void testEquals() {
		assertTrue(plot1.equals(plot5));
		assertFalse(plot1.equals(plot2));
	}

	@Test
	void testToString() {
		assertEquals("0,0,2,2", plot1.toString());
		assertEquals("3,3,4,5", plot4.toString());
	}

}
