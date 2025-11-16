/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents ManagementCompany object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

public class HolidayBonus {

	private static final double BONUS_FOR_HIGHEST = 5000;
	private static final double BONUS_FOR_LOWEST = 1000;
	private static final double BONUS_FOR_OTHERS = 2000;

	/**
	 * No-arg constructor
	 */
	public HolidayBonus() {

	}

	/**
	 * Calculate bonus for each store
	 * 
	 * @param data - the two dimensional array of store sales
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonusArr = new double[data.length];

		// find the max number of column
		int maxCol = 0;
		for (double[] row : data) {
			if (row != null && row.length > maxCol) {
				maxCol = row.length;
			}
		}

		// Calculate bonus bases on sales for each category
		for (int col = 0; col < maxCol; col++) {

			// Get highest and lowest in column
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

			for (int row = 0; row < data.length; row++) {

				// Check if current row has sales in the category
				if (data[row] != null && col < data[row].length) {

					double sales = data[row][col];
					// No bonus for negative sales
					if (sales < 0)
						continue;

					// Only store has sales in this category
					// Assume no store has the same sales
					if (highIndex == lowIndex) {
						if (row == highIndex) {
							bonusArr[row] += BONUS_FOR_HIGHEST;
						}
						continue;
					}

					// Apply bonus based on sales
					if (row == highIndex) {
						bonusArr[row] += BONUS_FOR_HIGHEST;
					} else if (row == lowIndex) {
						bonusArr[row] += BONUS_FOR_LOWEST;
					} else {
						bonusArr[row] += BONUS_FOR_OTHERS;
					}
				}
			}

		}

		return bonusArr;
	}

	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data - the two dimensional array of store sales
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bunusArr = calculateHolidayBonus(data);
		double total = 0;
		for (double eachStore : bunusArr) {
			total += eachStore;
		}
		return total;

	}

}
