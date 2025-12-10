/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Clerk object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Clerk object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClerkTestStudent {

	private Clerk clerk;

	@BeforeEach
	void setUp() throws Exception {
		clerk = new Clerk("John Brown", 35, 10, "Office Manager");
	}

	@AfterEach
	void tearDown() throws Exception {
		clerk = null;
	}

	@Test
	void testToString() {
		String expectedString = "Name: John Brown\nAge: 35\nYears Worked: 10\nJob: Office Manager";
		assertEquals(expectedString, clerk.toString());
	}

	@Test
	void testGetJob() {
		assertEquals("Office Manager", clerk.getJob());
	}

	@Test
	void testGetName() {
		assertEquals("John Brown", clerk.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(35, clerk.getAge());
	}

	@Test
	void testGetYearsWorked() {
		assertEquals(10, clerk.getYearsWorked());
	}

}
