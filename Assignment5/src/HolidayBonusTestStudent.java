/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test cases for HolidayBonus object
 * different approaches.
 * Due: 11/17/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test cases for HolidayBonus object
 * 
 * @author Chakapan Kanchana
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	
	private double[][] dataSet2 = { { 7, 2, 9, 4 },  	// 2000	2000 5000 5000 -> 14000
									{ 5 }, 				// 1000 	           -> 1000
									{ 8, 1, 3 },		// 2000 1000 1000      -> 4000
									{11, 6, 7, 2} }; 	// 5000 5000 2000 1000 -> 13000
																		  //total 32000
	
	private double[][] dataSet4 = { { -2.5, -5.3,  6.1 },  	    // 0	0    5000      -> 5000
									{ -4.4,  8.2 }, 		    // 0 	5000           -> 5000
									{  2.3, -7.5 },		        // 5000 0              -> 5000
									{ -4.2,  7.3, -5.9, 2.6} }; // 0    2000 0    5000 -> 7000
																				  //total 22000
	


	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test calculateHolidayBonus
	 */
	@Test
	void testCalculateHolidayBonus() {
		// dataSet2
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
			assertEquals(14000.0, result[0], .001);
			assertEquals(1000.0, result[1], .001);
			assertEquals(4000.0, result[2], .001);
			assertEquals(13000.0, result[3], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		
		// dataSet4
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet4);
			assertEquals(5000.0, result[0], .001);
			assertEquals(5000.0, result[1], .001);
			assertEquals(5000.0, result[2], .001);
			assertEquals(7000.0, result[3], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		
		
	}

	/**
	 * Test calculateTotalHolidayBonus
	 */
	@Test
	void testCalculateTotalHolidayBonus() {
		// dataSet2
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
		
		// dataSet4
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet4), .001);
	}

}
