/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Horse object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Horse object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorseTestStudent {
	private Horse horse;

	@BeforeEach
	void setUp() throws Exception {
		horse = new Horse("Star", 5, "Mustang", "White");
	}

	@AfterEach
	void tearDown() throws Exception {
		horse = null;
	}

	@Test
	void testMove() {
		try {
			horse.move(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("move() should not throw an exception.");
		}
	}

	@Test
	void testMakeSound() {
		try {
			horse.makeSound(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("makeSound() should not throw an exception.");
		}
	}

	@Test
	void testGetName() {
		assertEquals("Star", horse.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(5, horse.getAge());
	}

	@Test
	void testEqualsObject() {
		Horse sameHorse = new Horse("Star", 5, "Mustang", "White");
		Horse otherHorse = new Horse("King", 4, "Arabian", "Black");

		assertTrue(horse.equals(sameHorse));
		assertFalse(horse.equals(otherHorse));
	}

	@Test
	void testToString() {
		String expectedString = "Horse [name: Star, age: 5, species: Mustang, color: White]";
		assertEquals(expectedString, horse.toString());
	}

}
