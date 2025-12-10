/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test case for Ticket object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test case for Ticket object
 * 
 * @author Chakapan Kanchana
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTestStudent {
	private Ticket ticket1;
	private Ticket ticket2;
	private Ticket ticket3;

	@BeforeEach
	void setUp() throws Exception {

		// with discount, quantity = 2, multiplier = 1.0
		ticket1 = new Ticket("monday", "student", 20.0, 0.10, 0.10, 0.05, 1.0, 2);

		// no discount, quantity = 1, multiplier = 1.0
		ticket2 = new Ticket("monday", "adult", 20.0, 0.0, 0.0, 0.0, 1.0, 1);

		// no discount, quantity = 1, multiplier = 2.0
		ticket3 = new Ticket("monday", "adult", 20.0, 0.10, 0.10, 0.00, 2.0, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		ticket1 = ticket2 = null;
	}

	@Test
	void testCalculatePriceWithNoDiscount() {

		assertEquals(20.0, ticket2.calculatePrice(), 0.001);
	}

	@Test
	void testCalculatePriceWithDiscount() {
		/*
		 * basePrice = 20, DayDiscout = 0.10, customerDiscount = 0.1
		 * 		 * seatDiscount = 0.05 
		 * totalDiscount = 20 * (0.10 + 0.10 + 0.05) = 20 * 0.25 = 5 
		 * price after discount = 20 - 5 = 15 
		 * apply multiplier 1 → 15 
		 * total for 2 tickets → 15 * 2 = 30.0
		 */
		assertEquals(30.0, ticket1.calculatePrice(), 0.001);

		/*
		 * basePrice = 20, DayDiscout = 0.10, customerDiscount = 0.1, 
		 * totalDiscount = 20 * (0.10 + 0.10) = 20 * 0.20 = 4 
		 * price after discount = 20 - 4 = 16 
		 * apply multiplier 2 → 16 * 2 = 32
		 * total for 2 tickets → 32 * 2 = 64.0
		 */
		assertEquals(64.0, ticket3.calculatePrice(), 0.001);
	}

	@Test
	void testGetTicketDetails() {

		String ticketDetails = ticket1.getTicketDetails();

		assertTrue(ticketDetails.contains("student"));
		assertTrue(ticketDetails.contains("MONDAY"));
		assertTrue(ticketDetails.contains("Day Discount: 10%"));

	}

	@Test
	void testDisplayTicketDetails() {
		try {
			ticket1.displayTicketDetails(); // call method
			assertTrue(true); // if no exception, test pass
		} catch (Exception e) {
			fail("displayTicketDetails(); should not throw an exception.");
		}
	}

	@Test
	void testToString() {

		String expected = "Ticket [Day: Monday, Customer Type: student, Quantity: 2, Price: $30.00]";
		assertEquals(expected, ticket1.toString());

	}

}
