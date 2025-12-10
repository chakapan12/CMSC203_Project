/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Person object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Person object
 * 
 * @author Chakapan Kanchana
 */

public abstract class Person {
	private String name;
	private int age;
	private int yearsWorked;

	/**
	 * Creates a Person object using given values.
	 * 
	 * @param name        the name of the person
	 * @param age         the age of the person
	 * @param yearsWorked the number of years the person has worked
	 */
	public Person(String name, int age, int yearsWorked) {
		this.name = name;
		this.age = age;
		this.yearsWorked = yearsWorked;
	}

	/**
	 * Gets the name of the person.
	 * 
	 * @return the person's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the age of the person.
	 * 
	 * @return the person's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the number of years that the person has worked.
	 * 
	 * @return the number of years that the person has worked.
	 */
	public int getYearsWorked() {
		return yearsWorked;
	}

	/**
	 * Returns a string representation of the person, including their name, age, and
	 * years worked.
	 *
	 * @return a formatted string containing the person's details
	 */
	@Override
	public String toString() {
		return String.format("Name: %s%nAge: %d%nYears Worked: %d%n", name, age, yearsWorked);

	}

}