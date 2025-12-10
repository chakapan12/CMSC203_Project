/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Acrobatic object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Acrobatic object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcrobaticTestStudent {

	private Acrobatic acrobatic;

	@BeforeEach
	void setUp() throws Exception {
		acrobatic = new Acrobatic("Mike Bell", 30, 8, "Trapeze Artist");
	}

	@AfterEach
	void tearDown() throws Exception {
		acrobatic = null;
	}

	@Test
	void testToString() {
		String expectedString = "Name: Mike Bell\nAge: 30\nYears Worked: 8\nJob: Trapeze Artist";
		assertEquals(expectedString, acrobatic.toString());
	}

	@Test
	void testGetJob() {
		assertEquals("Trapeze Artist", acrobatic.getJob());
	}

	@Test
	void testGetName() {
		assertEquals("Mike Bell", acrobatic.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(30, acrobatic.getAge());
	}

	@Test
	void testGetYearsWorked() {
		assertEquals(8, acrobatic.getYearsWorked());
	}

}
