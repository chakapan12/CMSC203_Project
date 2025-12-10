/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Bird object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Bird object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BirdTestStudent {

	private Bird bird;

	@BeforeEach
	void setUp() throws Exception {
		bird = new Bird("Polly", 2, "Parrot", "Green");
	}

	@AfterEach
	void tearDown() throws Exception {
		bird = null;
	}

	@Test
	void testMove() {
		try {
			bird.move(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("move() should not throw an exception.");
		}
	}

	@Test
	void testMakeSound() {
		try {
			bird.makeSound(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("makeSound() should not throw an exception.");
		}
	}

	@Test
	void testGetName() {
		assertEquals("Polly", bird.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(2, bird.getAge());
	}

	@Test
	void testEqualsObject() {
		Bird sameBird = new Bird("Polly", 2, "Parrot", "Green");
		Bird otherBird = new Bird("Kyle", 1, "Parrot", "Red");

		assertTrue(bird.equals(sameBird));
		assertFalse(bird.equals(otherBird));

	}

	@Test
	void testToString() {
		String expectedString = "Bird [name: Polly, age: 2, species: Parrot, color: Green]";
		assertEquals(expectedString, bird.toString());
	}

}
