/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Circus object part 2/2
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Circus object part 2/2
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircusTestStudent2 {
	private Circus circus;
	private Person person1;
	private Person person2;
	private Building building1;
	private Building building2;
	private Ticket ticket1;
	private Ticket ticket2;
	

	@BeforeEach
	void setUp() throws Exception {
		circus = new Circus();
		person1 = new Acrobatic("Mike Bell", 30, 8, "Trapeze Artist");
		person2 = new Clerk("John Brown", 35, 10, "Office Manager");
		building1 = new Arena("White", 200.0, 100.0);
		building2 = new TicketingOffice("Blue", 300.0, 100.0);
		ticket1 = new Ticket("monday", "child", 20.00);
		ticket2 = new Ticket("monday", "adult", 20.00);
	}

	@AfterEach
	void tearDown() throws Exception {
		circus = null;
		person1 = null;
		person2 = null;
		building1 = null;
		building2 = null;
	}

	@Test
	void testGetAndAddPersons() {
		circus.addPerson(person1);
		assertEquals(1, circus.getPersons().size());
		circus.addPerson(person2);
		assertEquals(2, circus.getPersons().size());
	}

	@Test
	void testGetAndAddBuildings() {
		circus.addBuilding(building1);
		assertEquals(1, circus.getBuildings().size());
		circus.addBuilding(building2);
		assertEquals(2, circus.getBuildings().size());
	}

	@Test
	void testGetAndAddTickets() {
		circus.addTicket(ticket1);
		assertEquals(1, circus.getTickets().size());
		circus.addTicket(ticket2);
		assertEquals(2, circus.getTickets().size());
	}

	@Test
	void testDisplayAllBuildings() {
		circus.addBuilding(building1);
		circus.addBuilding(building2);
		try {
			circus.displayAllBuildings(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("displayAllBuildings() should not throw an exception.");
		}
	}

	@Test
	void testDisplayAllPersons() {
		circus.addPerson(person1);
		circus.addPerson(person2);
		try {
			circus.displayAllPersons(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("displayAllPersons() should not throw an exception.");
		}
	}

	@Test
	void testGenerateTicket() {
		circus.generateTicket("Monday", "child", 30.00);
		assertEquals(1, circus.getTickets().size());
	}

}
