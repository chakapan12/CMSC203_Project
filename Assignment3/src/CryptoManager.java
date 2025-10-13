/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This is a utility class that encrypts and decrypts a phrase using three
 * different approaches.
 * Due: 09/29/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches.
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption is a
 * method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph)
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher.
 * 
 * @author Chakapan Kanchana
 * @version 10/11/2025
 */

import java.util.ArrayList;

public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	// Use 64-character matrix (8X8) for Playfair cipher
	private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

	/**
	 * This method checks if string in the given bounds
	 * 
	 * @param plainText the given text
	 * @return boolean return true if string in bounds, false if not
	 */
	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text based on the
	 * letters of a keyword. It works as below: Choose a keyword (e.g., KEY). Repeat
	 * the keyword to match the length of the plaintext. Each letter in the
	 * plaintext is shifted by the position of the corresponding letter in the
	 * keyword (A = 0, B = 1, ..., Z = 25).
	 */

	public static String vigenereEncryption(String plainText, String key) {
		// check if string is in bounds
		if (isStringInBounds(plainText) == false)
			return "The selected string is not in bounds, Try again.";

		// repeat the keyword to match the length of plainText
		String repeatKey = "";
		int indexKey = 0;
		while (repeatKey.length() < plainText.length()) {
			if (indexKey < key.length()) {
				repeatKey += key.charAt(indexKey++);
			} else {
				indexKey = 0;
			}
		}
		
		// performs encryption
		String encryptedText = "";
		for (int i = 0; i < plainText.length(); i++) {
			int a = plainText.charAt(i) - LOWER_RANGE; // plainText value
			int b = repeatKey.charAt(i) - LOWER_RANGE; // key value
			int c = (a + b) % RANGE + LOWER_RANGE; // encryption formula
			encryptedText += (char) c; // append encrypted character
		}
		return encryptedText;
	}

	// Vigenere Decryption
	public static String vigenereDecryption(String encryptedText, String key) {
		// repeat the keyword to match the length of plainText
		String repeatKey = "";
		int indexKey = 0;
		while (repeatKey.length() < encryptedText.length()) {
			if (indexKey < key.length()) {
				repeatKey += key.charAt(indexKey++);
			} else {
				indexKey = 0;
			}
		}

		// perform decryption
		String decryptedText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			int a = encryptedText.charAt(i) - LOWER_RANGE; // plainText value
			int b = repeatKey.charAt(i) - LOWER_RANGE; // key value
			int c = (a - b + RANGE) % RANGE + LOWER_RANGE; // decrypted formula
			decryptedText += (char) c;
		}
		return decryptedText;
	}

	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one. It works
	 * as follows: A matrix (8X8 in our case) is built using a keyword Plaintext is
	 * split into letter pairs (e.g., ME ET YO UR). Encryption rules depend on the
	 * positions of the letters in the matrix: Same row: replace each letter with
	 * the one to its right. Same column: replace each with the one below.
	 * Rectangle: replace each letter with the one in its own row but in the column
	 * of the other letter in the pair.
	 */

	public static String playfairEncryption(String plainText, String key) {
		// to be implemented by students

		// check if string is in bounds
		if (isStringInBounds(plainText) == false)
			return "The selected string is not in bounds, Try again.";
		// matrix size
		final int SIZE = 8;

		// create arrayList to store all character, and 2D char array to be a matrix
		// 8x8.
		ArrayList<Character> listChars = new ArrayList<>();
		char[][] matrix = new char[SIZE][SIZE];

		// Add key to array list
		for (int i = 0; i < key.length(); i++) {
			if (!listChars.contains(key.charAt(i)))
				listChars.add(key.charAt(i));
		}
		// Add the remaining character from ALPHABET64 that are not already in the list.
		for (int i = 0; i < ALPHABET64.length(); i++) {
			if (!listChars.contains(ALPHABET64.charAt(i)))
				listChars.add(ALPHABET64.charAt(i));
		}

		// Fill matrix(2D char array) with content from listChars.
		int index = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (index < listChars.size())
					matrix[i][j] = listChars.get(index++);
			}
		}

		// Remember all indexes of spaces before removing, and it will be used after
		// encryption
		int[] spacePostion = rememberSpacePostion(plainText);

		// Remove space from plainText if any
		plainText = plainText.replace(" ", "");
		String encriptText = "";

		// perform encryption
		for (int i = 0; i < plainText.length(); i += 2) {

			// split plainText into a pair first(a) and second(b)
			char a = plainText.charAt(i);
			char b = (i + 1 < plainText.length()) ? plainText.charAt(i + 1) : 'X'; // adding X if odd

			// find position a and b in the matrix
			int[] posA = findPosition(matrix, a); // [row, column]
			int[] posB = findPosition(matrix, b); // [row, column]

			// if same row replace each one to it right(column + 1)
			if (posA[0] == posB[0]) {
				a = matrix[posA[0]][(posA[1] + 1) % SIZE];
				b = matrix[posB[0]][(posB[1] + 1) % SIZE];
				// if same column replace each with one below(row + 1)
			} else if (posA[1] == posB[1]) {
				a = matrix[(posA[0] + 1) % SIZE][posA[1]];
				b = matrix[(posB[0] + 1) % SIZE][posB[1]];
				// if rectangle (same row, other column)
			} else {
				a = matrix[posA[0]][posB[1]];
				b = matrix[posB[0]][posA[1]];
			}
			encriptText += "" + a + b;
		}

		encriptText = insertSpaceBack(spacePostion, encriptText);

		return encriptText;

	}

	// Playfair Decryption
	public static String playfairDecryption(String encryptedText, String key) {
		// matrix size
		final int SIZE = 8;

		// create arrayList to store all character, and 2D char array to be a matrix
		// 8X8.
		ArrayList<Character> listChars = new ArrayList<>();
		char[][] matrix = new char[SIZE][SIZE];

		// Add key to array list
		for (int i = 0; i < key.length(); i++) {
			if (!listChars.contains(key.charAt(i)))
				listChars.add(key.charAt(i));
		}
		// Add the remaining character from ALPHABET64 that are not already in the list.
		for (int i = 0; i < ALPHABET64.length(); i++) {
			if (!listChars.contains(ALPHABET64.charAt(i)))
				listChars.add(ALPHABET64.charAt(i));
		}

		// Fill matrix(2D char array) with content from listChars.
		int index = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (index < listChars.size())
					matrix[i][j] = listChars.get(index++);
			}
		}

		// Remember all indexes of spaces before removing, and it will be used after
		// encryption
		int[] spacePostion = rememberSpacePostion(encryptedText);

		// Remove space from plainText if any
		encryptedText = encryptedText.replace(" ", "");
		String decryptedText = "";

		// perform encryption
		for (int i = 0; i < encryptedText.length(); i += 2) {
			// split plainText into a pair first(s) and second(b)
			char a = encryptedText.charAt(i);
			char b = encryptedText.charAt(i + 1);

			// find position a and b in the matrix
			int[] posA = findPosition(matrix, a); // [row, column]
			int[] posB = findPosition(matrix, b); // [row, column]

			// if same row replace each one to it right (column + 1)
			if (posA[0] == posB[0]) {
				a = matrix[posA[0]][(posA[1] - 1 + SIZE) % SIZE];
				b = matrix[posB[0]][(posB[1] - 1 + SIZE) % SIZE];
				// if same column replace each with one below (row + 1)
			} else if (posA[1] == posB[1]) {
				a = matrix[(posA[0] - 1 + SIZE) % SIZE][posA[1]];
				b = matrix[(posB[0] - 1 + SIZE) % SIZE][posB[1]];
				// if rectangle (same row and other column)
			} else {
				a = matrix[posA[0]][posB[1]];
				b = matrix[posB[0]][posA[1]];
			}
			decryptedText += "" + a + b;

		}

		decryptedText = insertSpaceBack(spacePostion, decryptedText);

		// check if decryptedText has 'X' at the end. If yes, remove it.
		if (decryptedText.charAt(decryptedText.length() - 1) == 'X') {
			return decryptedText.substring(0, decryptedText.length() - 1);
		} else {
			return decryptedText;
		}

	}

	/**
	 * Caesar Cipher is a simple substitution cipher that replaces each letter in a
	 * message with a letter some fixed number of positions down the alphabet. For
	 * example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and
	 * so on.
	 */
	public static String caesarEncryption(String plainText, int key) {
		// check if string is in bounds
		if (isStringInBounds(plainText) == false)
			return "The selected string is not in bounds, Try again.";

		
		String encryptedText = "";
		for (int i = 0; i < plainText.length(); i++) {
			encryptedText += "" + (char) ((plainText.charAt(i) - 32 + key) % 64 + 32); // shift each character by key
																						// value

		}
		return encryptedText;
	}

	// Caesar Decryption
	public static String caesarDecryption(String encryptedText, int key) {
		String decryptdText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			decryptdText += "" + (char) ((encryptedText.charAt(i) - 32 - key) % 64 + 32); // shift each character by key
																							// value

		}
		return decryptdText;

	}

	/**
	 * This method finds position of a character in the matrix(2D char array)
	 * 
	 * @param matrix    2D char array
	 * @param character the character that want to find position in the matrix
	 * 
	 * @return int[] array containing position of character in matrix [row, column],
	 *         and will return negative index if character not found.
	 */
	private static int[] findPosition(char[][] matrix, char character) {
		int row = -1, col = -1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (matrix[i][j] == character) {
					row = i;
					col = j;
				}
			}
		}
		return new int[] { row, col };
	}

	/**
	 * This method remember space(' ') position from plainText before encryption or
	 * encrypedText before decryption
	 * 
	 * @param text String text that want to remember space position
	 * @return int[] array that store index of all spaces in a given text
	 */
	private static int[] rememberSpacePostion(String text) {
		int spaceCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				spaceCount++;
			}
		}

		int[] positionOfspace = new int[spaceCount];
		int index = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				positionOfspace[index++] = i;
			}
		}
		return positionOfspace;
	}

	/**
	 * This method inserts space back to the given text at their orignal position
	 * after encryption or decryption.
	 * 
	 * @param positionOfSpace an int[] array containing the indexes of all spaces in
	 *                        original text.
	 * @param text            the text string where spaces should be reinserted
	 * @return String with spaces reinsert to their original
	 */
	private static String insertSpaceBack(int[] positionOfSpace, String text) {
		for (int n : positionOfSpace) {
			text = text.substring(0, n) + " " + text.substring(n);
		}
		return text;

	}

}
