/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Dog object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Dog object
 * 
 * @author Chakapan Kanchana
 */

public class Dog implements Animal, Cloneable {
	// Instance variables
	private String name;
	private int age;
	protected String species;
	protected String color;

	/**
	 * Creates a Dog using given values.
	 * 
	 * @param name    the name of the dog
	 * @param age     the age of the dog
	 * @param species the species of the dog
	 * @param color   the color of the dog
	 */
	public Dog(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	/**
	 * Displays a message that the dog can move.
	 */
	@Override
	public void move() {
		System.out.println("Dog can move.");

	}

	/**
	 * Displays a message that the dog can make sound.
	 */
	@Override
	public void makeSound() {
		System.out.println("Dog can make sound.");

	}

	/**
	 * Get the name of the dog.
	 * 
	 * @return the dog's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the age of the dog.
	 * 
	 * @return the dog's age.
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Compares this dog to another object for equality.
	 * 
	 * @param obj the object to compare with this dog
	 * @return true if the given object is also a Dog with identical name, age,
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
		Dog other = (Dog) obj;
		return age == other.age && 
			   name.equalsIgnoreCase(other.name) && 
			   species.equalsIgnoreCase(other.species) && 
			   color.equalsIgnoreCase(other.color);
	}

	/**
	 * Returns a string representation of the Dog, including its name, age, species,
	 * and color.
	 * 
	 * @return the string representation of the dog.
	 */
	@Override
	public String toString() {
		return "Dog [name: " + name + ", age: " + age + ", species: " + species + ", color: " + color + "]";
	}

}
