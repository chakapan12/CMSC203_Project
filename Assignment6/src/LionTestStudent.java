/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Lion object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Lion object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LionTestStudent {
	private Lion lion;

	@BeforeEach
	void setUp() throws Exception {
		lion = new Lion("King", 10, "Cape", "Brown");
	}

	@AfterEach
	void tearDown() throws Exception {
		lion = null;
	}

	@Test
	void testMove() {
		try {
			lion.move(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("move() should not throw an exception.");
		}
	}

	@Test
	void testMakeSound() {
		try {
			lion.makeSound(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("makeSound() should not throw an exception.");
		}
	}

	@Test
	void testGetName() {
		assertEquals("King", lion.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(10, lion.getAge());
	}

	@Test
	void testEqualsObject() {
		Lion sameLion = new Lion("King", 10, "Cape", "Brown");
		Lion otherLion = new Lion("Queen", 4, "Asiatic", "Yellow");

		assertTrue(lion.equals(sameLion));
		assertFalse(lion.equals(otherLion));
	}

	@Test
	void testToString() {
		String expectedString = "Lion [name: King, age: 10, species: Cape, color: Brown]";
		assertEquals(expectedString, lion.toString());
	}
}
