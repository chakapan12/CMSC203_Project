import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data - the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of
	 *         elements/number of elements)
	 */
	public static double getAverage(double[][] data) {
		int count = 0;
		double total = 0.0;
		for (double[] row : data) {
			for (double col : row) {
				total += col;
				count++;
			}
		}
		return total / count;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to take the total of (0 refers to the first
	 *             column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length)
				total += data[row][col];
		}
		return total;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double maxValue = Double.NEGATIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > maxValue) {
					maxValue = data[row][col];
				}
			}
		}

		return maxValue;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the largest element of (0 refers to
	 *             the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double colMax = Double.NEGATIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > colMax) {
					colMax = data[row][col];
				}
			}
		}

		return colMax;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the largest element of (0 refers to
	 *             the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double colMax = getHighestInColumn(data, col);
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] == colMax) {
					index = row;
				}
			}
		}
		return index;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double rowMax = Double.NEGATIVE_INFINITY;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > rowMax) {
				rowMax = data[row][col];
			}
		}
		return rowMax;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return the index of the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double rowMax = getHighestInRow(data, row);
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] == rowMax) {
				index = col;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data - the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double minValue = Double.POSITIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < minValue) {
					minValue = data[row][col];
				}
			}
		}

		return minValue;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col  - the column index to find the smallest element of (0 refers to
	 *             the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {

		double colMin = Double.POSITIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < colMin) {
					colMin = data[row][col];
				}
			}
		}

		return colMin;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data - the two dimensional array
	 * @param col- the column index to find the smallest element of (0 refers to the
	 *             first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double colMin = getLowestInColumn(data, col);
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] == colMin) {
					index = row;
				}
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {

		double rowMin = Double.POSITIVE_INFINITY;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < rowMin) {
				rowMin = data[row][col];
			}
		}
		return rowMin;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double colMin = getLowestInRow(data, row);
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] == colMin) {
				index = col;
			}
		}
		return index;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @param data - the two dimensional array
	 * @param row  - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data - the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;
		for (double[] row : data) {
			for (double col : row) {
				total += col;
			}
		}
		return total;
	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * 
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the
	 *         file is not empty, returns a null if file is empty
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		// Check if file is exist.
		if (!file.exists()) {
			System.out.println("No such file.");
			return null;
		}

		final int MAX_ROW = 10;
		final int MAX_COL = 10;
		double[][] dummy = new double[MAX_ROW][];

		int rowCount = 0;
		double[][] data;

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] tokens = line.split(" ");

				// Check if column is less than or equal 10
				if (tokens.length > MAX_COL) {
					System.out.println("Unable to read data! Column must less than or equal 10.");
					return null; // if column > 10
				}

				// Check if row is less than or equal 10
				if (rowCount >= MAX_ROW) {
					System.out.println("Unable to read data! Row must less than or equal 10.");
					return null; // if row > 10
				}

				dummy[rowCount] = new double[tokens.length];
				for (int i = 0; i < tokens.length; i++) {
					dummy[rowCount][i] = Double.parseDouble(tokens[i]);
				}
				rowCount++;
			}

			// Check if file is empty.
			if (rowCount == 0) {
				System.out.println("File is empty.");
				return null;
			}

			// copy filled row to final data array
			data = new double[rowCount][];
			for (int i = 0; i < rowCount; i++) {
				data[i] = new double[dummy[i].length];
				for (int j = 0; j < dummy[i].length; j++) {
					data[i][j] = dummy[i][j];
				}
			}
		}

		return data;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * 
	 * @param data       - two dimensional ragged array of doubles
	 * @param outputFile - the file to write to
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter(outputFile)) {
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[row].length; col++) {
					out.print(data[row][col] + " ");
				}
				out.println();
			}
		}
	}

}
