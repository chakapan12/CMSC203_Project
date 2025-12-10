/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents a Utility class used for reading and 
 * validating different types of user input.
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

import java.util.Scanner;

/**
 * This class represents Utility class used for reading and validating different
 * types of user input.
 * 
 * @author Chakapan Kanchana
 */

public class Utils {

	/**
	 * Reads a non-empty String from the user. The method repeatedly prompts the
	 * user until a non-empty value is entered.
	 *
	 * @param scanner the Scanner object used to read input
	 * @param prompt  the message displayed to the user
	 * @return a trimmed, non-empty String
	 */
	public static String readNonEmptyString(Scanner scanner, String prompt) {
		String input;
		while (true) {
			System.out.print(prompt);
			input = scanner.nextLine().trim();
			if (!input.isEmpty())
				return input;
			System.out.println("Error: Input cannot be empty.\n");
		}
	}

	/**
	 * Reads a positive integer from the user. This method continues to prompt the
	 * user until a valid integer greater than zero is entered.
	 *
	 * @param scanner the Scanner object used for input
	 * @param prompt  the message shown to the user
	 * @return a positive integer
	 */
	public static int readPositiveInt(Scanner scanner, String prompt) {
		int value;

		while (true) {
			System.out.print(prompt);

			try {
				value = Integer.parseInt(scanner.nextLine());
				if (value > 0) {
					return value;
				} else {
					System.out.println("Error: Please enter a positive number.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.\n");
			}
		}
	}

	/**
	 * Reads a positive double from the user. The method does not accept zero or
	 * negative values and continues prompting until valid input is entered.
	 *
	 * @param scanner the Scanner object used to read input
	 * @param prompt  the message displayed to the user
	 * @return a positive double value
	 */
	public static double readPositiveDouble(Scanner scanner, String prompt) {
		double value;

		while (true) {
			System.out.print(prompt);

			try {
				value = Double.parseDouble(scanner.nextLine());
				if (value > 0) {
					return value;
				} else {
					System.out.println("Error: Please enter a positive number.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.\n");
			}
		}
	}

	/**
	 * Reads a non-negative integer (zero or greater). The method continues
	 * prompting the user until a valid input is entered.
	 *
	 * @param scanner the Scanner object used to read user input
	 * @param prompt  the message displayed to the user
	 * @return an integer that is zero or positive
	 */
	public static int readNonNegativeInt(Scanner scanner, String prompt) {
		int value;

		while (true) {
			System.out.print(prompt);

			try {
				value = Integer.parseInt(scanner.nextLine());
				if (value >= 0) {
					return value;
				} else {
					System.out.println("Error: Please enter zero or a positive number.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.\n");
			}
		}
	}

	/**
	 * Reads a menu choice from the user. The method ensures that the user enters an
	 * integer between the specified minimum and maximum values.
	 *
	 * @param scanner the Scanner object used to read user input
	 * @param prompt  the message displayed to the user
	 * @param min     the minimum acceptable menu choice
	 * @param max     the maximum acceptable menu choice
	 * @return a valid integer representing a menu selection
	 */
	public static int readMenuChoice(Scanner scanner, String prompt, int min, int max) {
		while (true) {
			System.out.print(prompt);
			try {
				int value = Integer.parseInt(scanner.nextLine());
				if (value >= min && value <= max)
					return value;
				System.out.printf("Error: Enter a number between %d and %d.%n", min, max);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
			}
		}
	}
}
