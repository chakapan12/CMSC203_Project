/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This program prompts the user to enter information from the keyboard, including the 
 * patient’s information and details for three procedures. After all the data is entered, the program 
 * displays the patient information, the three procedures, and the total charges of all
 * three procedures on the screen. 
 * 
 * Due: 09/29/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

import java.util.Scanner;

public class PatientDriverApp {

	public static void main(String[] args) {

		final String STUDENT_NAME = "Chakapan Kanchana";
		final String MC_NUMBER = "M21140729";
		final String DUE_DATE = "09/29/2025";

		String nameOfProcedure2;
		String dateOfProcedure2;

		String nameOfProcedure3;
		String dateOfProcedure3;
		String nameOfPractitioner3;
		double chargesForProcedure3;

		// Create Scanner object to read user input
		Scanner scanner = new Scanner(System.in);

		// Create Patient object and initialize all attributes based on a user input
		Patient patient = new Patient();
		setPatientInfo(patient, scanner);

		// Create Procedure1 object using no-arg constructor and initialize all
		// attributes based on a user input
		Procedure procedure1 = new Procedure();
		System.out.println("\nPlease enter procedure 1 information");
		setProcdureInfo(procedure1, scanner);

		// Prompt user to enter name of procedure2 and date of procedure2
		System.out.println("\nPlease enter procedure 2 information");
		System.out.print("Enter name of the procedure: ");
		nameOfProcedure2 = scanner.next();

		System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");
		dateOfProcedure2 = scanner.next();

		while (!isDateFormatCorrect(dateOfProcedure2)) {
			System.out.println("incorrect format. Please Enter again!");
			System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");
			dateOfProcedure2 = scanner.next();
		}
		scanner.nextLine(); // consume newLine

		// Create Procedure2 object using parameterize constructor and initialize two
		// attributes with given values
		Procedure procedure2 = new Procedure(nameOfProcedure2, dateOfProcedure2);
		// Initialize the remaining attributes
		setProcdureInfo(procedure2, scanner);

		// Prompt user to enter procedure3 information
		System.out.println("\nPlease enter procedure 3 information");

		System.out.print("Enter name of the procedure: ");
		nameOfProcedure3 = scanner.nextLine();

		System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");

		dateOfProcedure3 = scanner.next();
		while (!isDateFormatCorrect(dateOfProcedure3)) {
			System.out.println("incorrect format. Please Enter again!");
			System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");
			dateOfProcedure3 = scanner.next();
		}
		scanner.nextLine();

		System.out.print("Enter name of the practitioner: ");
		nameOfPractitioner3 = scanner.nextLine();

		System.out.print("Enter charges for the procedure: ");
		chargesForProcedure3 = readPositiveDouble(scanner);

		// Create Procedure3 object and initialize all attributes with given values.
		Procedure procedure3 = new Procedure(nameOfProcedure3, dateOfProcedure3, nameOfPractitioner3,
				chargesForProcedure3);

		// display patient info
		displayPatient(patient);

		// display all three procedures
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);

		// calculate total procedure charges and display
		System.out.printf("\nTotal Charges: $%,.2f" + "\n", calculateTotalCharges(procedure1, procedure2, procedure3));

		// display student info
		System.out.println("\nStudent Name: " + STUDENT_NAME);
		System.out.println("MC#: " + MC_NUMBER);
		System.out.println("Due Date: " + DUE_DATE);

		scanner.close();

	}

	/**
	 * The displayPatient method displays patient information to the console
	 * 
	 * @param patient the patient object to display
	 */

	private static void displayPatient(Patient patient) {
		System.out.println("\n" + patient);

	}

	/**
	 * The displayProcedure method displays procedure information to the console.
	 * 
	 * @param procedure the procedure object to display
	 */
	private static void displayProcedure(Procedure procedure) {
		System.out.println("\n" + procedure);
	}

	/**
	 * The calculateTotalCharges method calculates the total charges for three
	 * procedures.
	 * 
	 * @param procedure1 the first Procedure object
	 * @param procedure2 the second Procedure object
	 * @param procedure3 the third Procedure object
	 * @return the total charges of all three procedures as a double
	 */
	private static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		return procedure1.getChargesForProcedure() + procedure2.getChargesForProcedure()
				+ procedure3.getChargesForProcedure();
	}

	/**
	 * The setPatientInfo method sets the information of a patient object based on
	 * user input. This method prompts the user to enter values for any missing
	 * attributes of the patient.
	 * 
	 * @param patient the Patient Object whose information will be set
	 * @param scanner the scanner object to read input from user
	 */
	private static void setPatientInfo(Patient patient, Scanner scanner) {

		System.out.print("Enter first name: ");
		patient.setFirstName(scanner.next());

		System.out.print("Enter middle name (type '-' if none): ");
		patient.setMiddleName(scanner.next());

		System.out.print("Enter last name: ");
		patient.setLastName(scanner.next());

		System.out.print("Enter street address: ");
		patient.setStreetAddress(scanner.nextLine());
		scanner.nextLine();

		System.out.print("Enter city: ");
		patient.setCity(scanner.next());

		System.out.print("Enter state: ");
		patient.setState(scanner.next());

		System.out.print("Enter zipcode: ");
		String zipcode = scanner.next();
		while (!zipcode.matches("\\d{5}")) {
			System.out.println("Invalid zip code! Please Enter only number.");
			System.out.print("Enter zipcode: ");
			zipcode = scanner.next();
		}
		patient.setZipcode(zipcode);

		System.out.print("Enter phone number (e.g., 123-456-7890): ");
		String phoneNumber = scanner.next();
		// check if phone number format is correct
		while (!isPhoneNumberFormatCorrect(phoneNumber)) {
			System.out.println("Incorrect format!");
			System.out.print("Enter phone number (e.g., 123-456-7890): ");
			phoneNumber = scanner.next();
		}
		patient.setPhoneNumber(phoneNumber);
		scanner.nextLine(); // consume newLine

		System.out.print("Enter emergency contact full name: ");
		patient.setEmergencyContactName(scanner.nextLine());

		System.out.print("Enter emergency contact phone number (e.g., 123-456-7890): ");
		String EmegencyPhoneNumber = scanner.next();
		while (!isPhoneNumberFormatCorrect(EmegencyPhoneNumber)) {
			System.out.println("Incorrect format!");
			System.out.print("Enter phone number (e.g., 123-456-7890): ");
			EmegencyPhoneNumber = scanner.next();
		}
		patient.setEmergencyContactPhoneNumber(EmegencyPhoneNumber);
		scanner.nextLine(); // consume newLine

	}

	/**
	 * The setProcdureInfo method sets the information of a procedure object based
	 * on user input. This method prompts the user to enter values for any missing
	 * attributes of the procedure.
	 * 
	 * @param procedure the Procedure Object whose information will be set
	 * @param scanner   the scanner object to read input from user
	 */
	private static void setProcdureInfo(Procedure procedure, Scanner scanner) {

		if (procedure.getNameOfProcedure() == null) {
			System.out.print("Enter name of the procedure: ");
			procedure.setNameOfProcedure(scanner.nextLine());
		}

		if (procedure.getDateOfProcedure() == null) {
			System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");

			String date = scanner.next();
			while (!isDateFormatCorrect(date)) {
				System.out.println("incorrect format. Please Enter again!");
				System.out.print("Enter date of the procedure (e.g., 06/02/2025): ");
				date = scanner.next();
			}
			procedure.setDateOfProcedure(date);
			scanner.nextLine(); // consume newLine
		}

		if (procedure.getNameOfPractitioner() == null) {
			System.out.print("Enter name of the practitioner: ");
			procedure.setNameOfPractitioner(scanner.nextLine());
		}

		if (procedure.getChargesForProcedure() == 0.0) {
			System.out.print("Enter charges for the procedure: ");
			procedure.setChargesForProcedure(readPositiveDouble(scanner));

		}

	}

	/**
	 * This method check if input match with the given format (e.g., 123-456-7890).
	 * 
	 * @param phoneNumber given phone number
	 * @return boolean true if correct format, false if incorrect format
	 */
	private static boolean isPhoneNumberFormatCorrect(String phoneNumber) {
		return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
	}

	/**
	 * This method checks if input match with the given format (e.g., 02/03/2025).
	 * This only check format, not the date is valid.
	 * 
	 * @param date given date
	 * @return boolean true if correct format, false if incorrect format
	 */
	private static boolean isDateFormatCorrect(String date) {
		return date.matches("\\d{1,2}/\\d{1,2}/\\d{4}");
	}

	/**
	 * This method prompts user until they enter positive double.
	 * 
	 * @param scanner Scanner to read input
	 * @return the positive double entered by the user
	 */
	private static double readPositiveDouble(Scanner scanner) {
		while (true) {
			// check whether input is double
			if (scanner.hasNextDouble()) {
				double value = scanner.nextDouble();
				// check if positive number
				if (value >= 0) {
					scanner.nextLine(); // consume newLine
					return value;
				} else {
					System.out.println("Invalid input! Please Enter only positive number.");
					System.out.print("Enter charges for the procedure: ");
				}
			} else {
				System.out.println("Invalid input! Please Enter only positive number.");
				System.out.print("Enter charges for the procedure: ");
				scanner.nextLine(); // consume invalid input
			}
		}

	}

}
