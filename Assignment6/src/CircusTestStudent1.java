/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Circus object part 1/2
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Circus object part 1/2
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircusTestStudent1 {
	private Circus circus;
	private Bird bird;
	private Dog dog;
	private Horse horse;
	private Lion lion;

	@BeforeEach
	void setUp() throws Exception {
		circus = new Circus();
		bird = new Bird("Polly", 2, "Parrot", "Green");
		dog = new Dog("Shabu", 10, "Bulldog", "White");
		horse = new Horse("Star", 7, "Mustang", "White");
		lion = new Lion("King", 5, "Cape", "Brown");
	}

	@AfterEach
	void tearDown() throws Exception {
		circus = null;
		bird = null;
		dog = null;
		horse = null;
		lion = null;
	}

	@Test
	void testAddAndGetAnimals() {
		circus.addAnimal(bird);
		assertEquals(1, circus.getAnimals().size());
		circus.addAnimal(dog);
		assertEquals(2, circus.getAnimals().size());
		circus.addAnimal(null);
		assertEquals(3, circus.getAnimals().size());

	}

	@Test
	void testDisplayAllAnimals() {
		circus.addAnimal(bird);
		circus.addAnimal(dog);
		try {
			circus.displayAllAnimals(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("displayAllAnimals() should not throw an exception.");
		}
	}

	@Test
	void testSortAnimalsByAge() {
		circus.addAnimal(bird); // age = 2
		circus.addAnimal(dog); // age = 10
		circus.addAnimal(horse); // age = 7
		circus.addAnimal(lion); // age = 5

		circus.sortAnimalsByAge();

		assertEquals(2, circus.getAnimals().get(0).getAge());
		assertEquals(5, circus.getAnimals().get(1).getAge());
		assertEquals(10, circus.getAnimals().getLast().getAge());

	}

	@Test
	void testSortAnimalsByName() {
		circus.addAnimal(bird); // name = "Polly"
		circus.addAnimal(dog); // name = "Shabu"
		circus.addAnimal(horse); // name = "Star"
		circus.addAnimal(lion); // name = "King"

		circus.sortAnimalsByName();
		assertEquals("King", circus.getAnimals().get(0).getName());
		assertEquals("Polly", circus.getAnimals().get(1).getName());
		assertEquals("Star", circus.getAnimals().getLast().getName());

	}

	@Test
	void testSearchAnimalByName() {
		circus.addAnimal(bird); // name = "Polly"
		circus.addAnimal(dog); // name = "Shabu"

		assertTrue(circus.searchAnimalByName("Shabu"));
		assertFalse(circus.searchAnimalByName("Top"));

	}

}
