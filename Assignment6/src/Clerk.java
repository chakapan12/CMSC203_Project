/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Clerk object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Clerk object
 * 
 * @author Chakapan Kanchana
 */
public class Clerk extends Person {
	private String job;

	/**
	 * Creates a Clerk object using the given values.
	 *
	 * @param name        the name of the clerk
	 * @param age         the age of the clerk
	 * @param yearsWorked the number of years the clerk has worked
	 * @param job         the job title or position of the clerk
	 */
	public Clerk(String name, int age, int yearsWorked, String job) {
		super(name, age, yearsWorked);
		this.job = job;
	}

	/**
	 * Gets the job title of the clerk.
	 * 
	 * @return the clerk's job title
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Returns a string representation of the clerk, including their name, age,
	 * years worked, and job title.
	 *
	 * @return a formatted string containing the clerk details
	 */
	@Override
	public String toString() {
		return super.toString() + "Job: " + job;
	}

}
