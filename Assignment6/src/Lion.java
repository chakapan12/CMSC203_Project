/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Lion object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Lion object
 * 
 * @author Chakapan Kanchana
 */

public class Lion implements Animal {
	// instance variables
	private String name;
	private int age;
	private String species;
	private String color;

	/**
	 * Creates a Lion using given values.
	 * 
	 * @param name    the name of the lion
	 * @param age     the age of the lion
	 * @param species the species of the lion
	 * @param color   the color of the lion
	 */
	public Lion(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	/**
	 * Displays a message that the lion can move.
	 */
	@Override
	public void move() {
		System.out.println("Lion can move.");
	}

	/**
	 * Displays a message that the lion can make sound.
	 */
	@Override
	public void makeSound() {
		System.out.println("Lion can make sound.");
	}

	/**
	 * Get the name of the lion.
	 * 
	 * @return the lion's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the age of the lion.
	 * 
	 * @return the lion's age.
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Compares this lion to another object for equality.
	 * 
	 * @param obj the object to compare with this lion
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
		Lion other = (Lion) obj;
		return age == other.age && 
			   name.equalsIgnoreCase(other.name) && 
			   species.equalsIgnoreCase(other.species) && 
			   color.equalsIgnoreCase(other.color);
	}

	/**
	 * Returns a string representation of the Lion, including its name, age,
	 * species, and color.
	 * 
	 * @return the string representation of the lion.
	 */
	@Override
	public String toString() {
		return "Lion [name: " + name + ", age: " + age + ", species: " + species + ", color: " + color + "]";
	}

}
