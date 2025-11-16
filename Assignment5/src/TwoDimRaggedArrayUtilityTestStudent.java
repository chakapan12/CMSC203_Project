/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents JUnit test cases for TwoDimRaggedArrayUtility object
 * different approaches.
 * Due: 11/17/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents JUnit test cases for TwoDimRaggedArrayUtility object
 * 
 * @author Chakapan Kanchana
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] dataSet1 = { { 1, 2, 3 }, 
									{ 4, 5 }, 
									{ 6, 7, 8, 9} };
	
	
	private double[][] dataSet2 = { { 7, 2, 9, 4 },  	
									{ 5 }, 				
									{ 8, 1, 3 },		
									{11, 6, 7, 2} };
	
	// invalid numbers of column (column > 10)
	private double[][] dataSet5 = { { 7, 2, 9, 4, 2, 3, 5, 6, 8, 8, 7 },  	
									{ 5 }, 				
									{ 8, 1, 3 } };	
	
	// invalid numbers of row (row > 10)
	private double[][] dataSet6 = { { 7, 2 },  	
									{ 5 }, 				
									{ 8, 1, },
									{ 5 }, 
									{ 5 }, 
									{ 5 },
									{ 5 }, 
									{ 5 }, 
									{ 5 }, 
									{ 5 },
									{ 5 } }; 
									
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test getAverage() method
	 * Return the average of the elements in the two dimension array
	 * 
	 */
	@Test
	void testGetAverage() {
		assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), 0.001);
		assertEquals(5.4167, TwoDimRaggedArrayUtility.getAverage(dataSet2), 0.001);
	}

	/**
	 * Test getColumnTotal() method
	 * Returns the total of all the elements of column 1.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	void testGetColumnTotal() {
		assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), 0.001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 1), 0.001);
	}

	/**
	 * Test getHighestInArray() method
	 * return the highest element in the two dimension array
	 * 
	 */
	@Test
	void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 0.001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), 0.001);
	}

	/**
	 * Test getHighestInColumn() method
	 * return the highest element in the column 2.
	 * 
	 */
	@Test
	void testGetHighestInColumn() {
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 0.01);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 2), 0.01);
	}
	
	/**
	 * Test getHighestInColumnIndex() method
	 * return index of the highest element in the column 2.
	 * 
	 */
	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 2));
	}

	/**
	 * Test getHighestInRow() method
	 * return the highest element in the Row 2.
	 * 
	 */
	@Test
	void testGetHighestInRow() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 0.01);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), 0.01);
	}

	/**
	 * Test getHighestInRowIndex() method
	 * return index of the highest element in the Row 2.
	 * 
	 */
	@Test
	void testGetHighestInRowIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2));
	}

	/**
	 * Test getLowestInArray() method
	 * return the Lowest element in the two dimension array
	 * 
	 */
	@Test
	void testGetLowestInArray() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1));
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2));
	}

	/**
	 * Test getLowestInColumn() method
	 * return the lowest element in the column 2.
	 * 
	 */
	@Test
	void testGetLowestInColumn() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), 0.001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), 0.001);
	}

	/**
	 * Test getLowestInColumnIndex() method
	 * return index of the lowest element in the column 2.
	 * 
	 */
	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2));
	}

	/**
	 * Test getLowestInRow() method
	 * return the lowest element in the Row 2.
	 * 
	 */
	@Test
	void testGetLowestInRow() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), 0.001);
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 2), 0.001);
	}

	/**
	 * Test getLowestInRowIndex() method
	 * return index of the lowest element in the Row 2.
	 * 
	 */
	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 2));
	}

	/**
	 * Test getRowTotal() method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	void testGetRowTotal() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
		assertEquals(5.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1), 0.001);
	}

	/**
	 * Test getTotal() method
	 * Returns the total of all the elements in the two dimension array
	 */
	@Test
	void testGetTotal() {
		assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
		assertEquals(65.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), 0.001);
	}

	/**
	 * Test readFile() method
	 * @throws IOException 
	 */
	@Test
	void testReadFile() throws IOException {
		
		// create empty file
		File testFile = new File("testFile.txt");
		testFile.createNewFile();
		
		// test read empty file - must return null
		assertNull(TwoDimRaggedArrayUtility.readFile(testFile));
		
		// test invalid file: a row contains more than 10 columns.
		// Write dataSet5 to testFile, then read the file back.
		TwoDimRaggedArrayUtility.writeToFile(dataSet5, testFile);
		
		// readFile should return null because column > 10 is not allowed.
		assertNull(TwoDimRaggedArrayUtility.readFile(testFile));
		
		// test invalid file: more than 10 rows
		// Write dataSet6 to testFile, then read the file back. 
		TwoDimRaggedArrayUtility.writeToFile(dataSet6, testFile);
		
		// readFile should return null because row count > 10 is not allowed.
		assertNull(TwoDimRaggedArrayUtility.readFile(testFile));
		
		// delete empty file
		testFile.delete();
		
		// read non-empty file - return double[][]
		double[][] studentDataSet = TwoDimRaggedArrayUtility.readFile(new File("dataSet2.txt"));
		
		// compare dimensions
		assertEquals(dataSet2.length, studentDataSet.length);
		
		// compare each row
		for(int i = 0; i < dataSet2.length; i++) {
			assertArrayEquals(dataSet2[i], studentDataSet[i], 0.001);
		}
		
	
	}

	/**
	 * Test writeFile() method
	 * 
	 * @throws FileNotFoundException 
	 */
	@Test
	void testWriteToFile() throws FileNotFoundException {
		// 1. create temporary file.
		File testFile = new File("testOutput.txt");
		
		// 2. write dataSet1 to the file.
		TwoDimRaggedArrayUtility.writeToFile(dataSet2, testFile);
		
		// 3. read the file back for comparing.
		double[][] studentDataSet = TwoDimRaggedArrayUtility.readFile(testFile);
		
		// 4. compare dimensions
		assertEquals(dataSet2.length, studentDataSet.length);
		
		// 5. compare each row
		for(int i = 0; i < dataSet2.length; i++) {
			assertArrayEquals(dataSet2[i], studentDataSet[i]);	
		}
		
		// 6. delete temporary file.
		testFile.delete();
		
	}

}
