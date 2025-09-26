/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This program reads and displays a list colors from a file based on the user's selection. Then it run a three-round color guessing game,
 * 				display the result, and  writes output to a file.
 * Due: 09/15/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class ESPGame {

	public static void main(String[] args) throws FileNotFoundException {

		final String INPUT_FILENAME = "colors.txt";
		final String OUTPUT_FILENAME = "EspGameResults.txt";
		final int MAXIMUN_ROUND = 3;
		boolean isContinue = true;

		String userName;
		String userDescription;
		String dueDate;
		String filename;
		String playAgain;
		String userGuess;
		String randomColor;

		int option;
		int maxColor;
		int numberOfCorrectGuess = 0;

		Scanner keyboard = new Scanner(System.in);

		// Display welcome message
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.println("Welcome to ESP - extrasensory preception!");

		// Continue display menu unless user select option 4 to exit program
		while (isContinue) {

			// Display selection menu
			System.out.println("Would you please choose one of the 4 options from the menu:\n");
			System.out.println(
					"\t1. read and display on the screen first 16 names of colors from a file colors.txt, so the player "
							+ "\n\t   can select one of the names of colors.");
			System.out.println(
					"\t2. read and display on the screen first 10 names of colors from a file colors.txt, so the player "
							+ "\n\t   can select one of the names of colors.");
			System.out.println(
					"\t3. read and display on the screen first 5 names of colors from a file colors.txt, so the player "
							+ "\n\t   can select one of the names of colors.");
			System.out.println("\t4. Exit from a program");

			System.out.print("\nEnter the option: ");
			option = keyboard.nextInt();

			// Validate input only accepting number from 1 to 4
			while (option < 1 || option > 4) {
				System.out.print("Please enter a number from 1 to 4 !!! \n\nEnter the option: ");
				option = keyboard.nextInt();

			}

			// option 4 exit program
			if (option == 4) {

				// Consume any key left in buffer
				keyboard.nextLine();
				System.out.print("Enter your name: ");
				userName = keyboard.nextLine();

				System.out.print("Describe yourself: ");
				userDescription = keyboard.nextLine();

				System.out.print("Due Date: ");
				dueDate = keyboard.nextLine();

				System.out.println("Username: " + userName);
				System.out.println("User Description: " + userDescription);
				System.out.println("Date: " + dueDate);

				PrintWriter outputFile = new PrintWriter(OUTPUT_FILENAME);
				outputFile.println("Game Over");
				outputFile.println(
						"You guessed " + numberOfCorrectGuess + " out of " + MAXIMUN_ROUND + " colors correctly");
				outputFile.println("Due Date: " + dueDate);
				outputFile.println("Username: " + userName);
				outputFile.println("User Description: " + userDescription);
				outputFile.println("Date: " + dueDate);
				outputFile.close();
				isContinue = false;

			// option 1 to 3
			} else {

				// Consume any key left in buffer and ask user to enter the filename
				keyboard.nextLine();
				System.out.print("Enter the filename: ");
				filename = keyboard.nextLine();

				// Validate the filename user enter
				while (!filename.equals(INPUT_FILENAME)) {
					System.out.print("Enter the filename: ");
					filename = keyboard.nextLine();
				}

				// Set maximum number of the name of color based on user selection
				maxColor = switch (option) {
				case 1 -> 16;
				case 2 -> 10;
				case 3 -> 5;
				default -> 0;
				};

				// Create scanner object to read a file
				Scanner inputFile = new Scanner(new File(filename));

				System.out.println("There are sixteen colors form a file:");

				// Display color names based on user selection
				for (int i = 1; i <= maxColor; i++) {
					System.out.println(i + " " + inputFile.nextLine());
				}

				// Create Random object
				Random random = new Random();

				// Set number of correct guesses to 0 in order to start counting correct
				// attempts
				numberOfCorrectGuess = 0;

				// Run color guessing game for MAXIMUN_ROUND round
				for (int i = 1; i <= MAXIMUN_ROUND; i++) {

					// Generate a random number between 1 to maxColor
					int randomInt = random.nextInt(maxColor) + 1;

					// Map the random number to a color name
					randomColor = switch (randomInt) {
					case 1 -> "Black";
					case 2 -> "White";
					case 3 -> "Gray";
					case 4 -> "Silver";
					case 5 -> "Maroon";
					case 6 -> "Red";
					case 7 -> "Purple";
					case 8 -> "Fuchsia";
					case 9 -> "Green";
					case 10 -> "Lime";
					case 11 -> "Olive";
					case 12 -> "Yellow";
					case 13 -> "Navy";
					case 14 -> "Blue";
					case 15 -> "Teal";
					case 16 -> "Aqua";
					default -> "Unknown";
					};

					// Display round information
					System.out.println("\nRound " + i);
					System.out.println("\nI am thinking of a color.");
					System.out.println("Is it one of list of colors above?");
					System.out.println("Enter your guess: ");

					// Read user's guess
					userGuess = keyboard.next();

					// Reveal the randomly selection color and update the correct guess if the use's
					// guess correct
					System.out.println("\nI was thinking of " + randomColor);
					if (userGuess.equalsIgnoreCase(randomColor))
						numberOfCorrectGuess++;

				}

				// Display the total number of correct guesses
				System.out.println("Game Over");
				System.out.println("You guessed " + numberOfCorrectGuess + " out of " + MAXIMUN_ROUND + " colors correctly.");

				System.out.println("\nWould you like to continue a Game? Type Yes/No");
				playAgain = keyboard.next();

				while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
					System.out.println("Please Type Yes/No");
					playAgain = keyboard.next();
				}

				inputFile.close();

			}

		}

		keyboard.close();
	}

}
