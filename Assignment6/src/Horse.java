/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Horse object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Horse object
 * 
 * @author Chakapan Kanchana
 */

public class Horse implements Animal {

	// instance variables
	private String name;
	private int age;
	private String species;
	private String color;

	/**
	 * Creates a Horse using given values.
	 * 
	 * @param name    the name of the horse
	 * @param age     the age of the horse
	 * @param species the species of the horse
	 * @param color   the color of the horse
	 */
	public Horse(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	/**
	 * Displays a message that the horse can move.
	 */
	@Override
	public void move() {
		System.out.println("Horse can move.");
	}

	/**
	 * Displays a message that the horse can make sound.
	 */
	@Override
	public void makeSound() {
		System.out.println("Horse can make sound.");
	}

	/**
	 * Get the name of the horse.
	 * 
	 * @return the horse's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the age of the horse.
	 * 
	 * @return the horse's age.
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Compares this horse to another object for equality.
	 * 
	 * @param obj the object to compare with this dog
	 * @return true if the given object is also a Horse with identical name, age,
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
		Horse other = (Horse) obj;
		return age == other.age && 
			   name.equalsIgnoreCase(other.name) && 
			   species.equalsIgnoreCase(other.species) && 
			   color.equalsIgnoreCase(other.color);
	}

	/**
	 * Returns a string representation of the Horse, including its name, age,
	 * species, and color.
	 * 
	 * @return the string representation of the horse.
	 */
	@Override
	public String toString() {
		return "Horse [name: " + name + ", age: " + age + ", species: " + species + ", color: " + color + "]";
	}

}
