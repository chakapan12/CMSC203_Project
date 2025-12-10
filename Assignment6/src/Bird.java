/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Bird object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Bird object
 * 
 * @author Chakapan Kanchana
 */

public class Bird implements Animal {
	// instance variables
	private String name;
	private int age;
	private String species;
	private String color;

	/**
	 * Creates a Bird using given values.
	 * 
	 * @param name    the name of the bird
	 * @param age     the age of the bird
	 * @param species the species of the bird
	 * @param color   the color of the bird
	 */
	public Bird(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	/**
	 * Displays a message that the bird can move.
	 */
	@Override
	public void move() {
		System.out.println("Bird can move.");
	}

	/**
	 * Displays a message that the bird can make sound.
	 */
	@Override
	public void makeSound() {
		System.out.println("Bird can make sound.");
	}

	/**
	 * Get the name of the bird.
	 * 
	 * @return the bird's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the age of the bird.
	 * 
	 * @return the bird's age.
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Compares this bird to another object for equality.
	 * 
	 * @param obj the object to compare with this bird
	 * @return true if the given object is also a Bird with identical name, age,
	 *         species, and color; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return age == other.age && 
			   name.equalsIgnoreCase(other.name) && 
			   species.equalsIgnoreCase(other.species) && 
			   color.equalsIgnoreCase(other.color);
	}

	/**
	 * Returns a string representation of the Bird, including its name, age,
	 * species, and color.
	 * 
	 * @return the string representation of the bird.
	 */
	@Override
	public String toString() {
		return "Bird [name: " + name + ", age: " + age + ", species: " + species + ", color: " + color + "]";
	}

}
