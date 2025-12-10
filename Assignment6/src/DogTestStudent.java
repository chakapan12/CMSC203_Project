/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Dog object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Dog object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTestStudent {
	private Dog dog;

	@BeforeEach
	void setUp() throws Exception {
		dog = new Dog("Shabu", 3, "Bulldog", "White");
	}

	@AfterEach
	void tearDown() throws Exception {
		dog = null;
	}

	@Test
	void testMove() {
		try {
			dog.move(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("move() should not throw an exception.");
		}
	}

	@Test
	void testMakeSound() {
		try {
			dog.makeSound(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("makeSound() should not throw an exception.");
		}
	}

	@Test
	void testGetName() {
		assertEquals("Shabu", dog.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(3, dog.getAge());
	}

	@Test
	void testEqualsObject() {
		Dog sameDog = new Dog("Shabu", 3, "Bulldog", "White");
		Dog otherDog = new Dog("Rada", 4, "Beagle", "Black");

		assertTrue(dog.equals(sameDog));
		assertFalse(dog.equals(otherDog));
	}

	@Test
	void testToString() {
		String expectedString = "Dog [name: Shabu, age: 3, species: Bulldog, color: White]";
		assertEquals(expectedString, dog.toString());
	}

}
