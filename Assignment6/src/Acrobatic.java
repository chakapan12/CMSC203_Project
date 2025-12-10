/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents a|Acrobatic object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Acrobatic object
 * 
 * @author Chakapan Kanchana
 */
public class Acrobatic extends Person {
	private String job;

	/**
	 * Creates a Clerk object using the given values.
	 *
	 * @param name        the name of the acrobatic
	 * @param age         the age of the acrobatic
	 * @param yearsWorked the number of years the acrobatic has worked
	 * @param job         the job title or position of the acrobatic
	 */
	public Acrobatic(String name, int age, int yearsWorked, String job) {
		super(name, age, yearsWorked);
		this.job = job;
	}

	/**
	 * Gets the job title of the acrobatic.
	 * 
	 * @return the acrobatic job title
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Returns a string representation of the acrobatic, including their name, age,
	 * years worked, and job title.
	 *
	 * @return a formatted string containing the acrobatic details
	 */
	@Override
	public String toString() {
		return super.toString() + "Job: " + job;
	}

}
