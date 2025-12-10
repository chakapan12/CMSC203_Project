/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents custom exception that extends InputMismatchException.
 * It is used when the user enters input that does not match the expected type.
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents CustomInputMismatchException object. 
 * It is used when the user enters input that does not match the expected type.
 * 
 * @author Chakapan Kanchana
 */
import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a CustomInputMismatchException with no message.
	 */
	public CustomInputMismatchException() {
		super();
	}

	/**
	 * Creates a CustomInputMismatchException with a specific error message.
	 *
	 * @param s the error message
	 */
	public CustomInputMismatchException(String s) {
		super(s);
	}

}
