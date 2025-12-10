/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Circus object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Circus object
 * 
 * @author Chakapan Kanchana
 */
import java.util.ArrayList;
import java.util.List;

public class Circus {

	private List<Animal> animals;
	private List<Person> persons;
	private List<Building> buildings;
	private List<Ticket> tickets;

	/**
	 * No-arg constructor that creating empty lists for animals, persons, buildings,
	 * and tickets.
	 */
	public Circus() {
		animals = new ArrayList<>();
		persons = new ArrayList<>();
		buildings = new ArrayList<>();
		tickets = new ArrayList<>();
	}

	/**
	 * Gets the list of animals.
	 * 
	 * @return a list of animal objects
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * Gets the list of persons.
	 * 
	 * @return a list of person objects
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * Gets the list of buildings.
	 * 
	 * @return a list of building objects
	 */
	public List<Building> getBuildings() {
		return buildings;
	}

	/**
	 * Gets the list of tickets.
	 * 
	 * @return a list of ticket objects
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Adds a new building to the circus.
	 * 
	 * @param building the building object to add
	 */
	public void addBuilding(Building building) {
		buildings.add(building);
	}

	/**
	 * Displays all buildings by printing each building using toString().
	 */
	public void displayAllBuildings() {
		for (Building b : buildings) {
			System.out.println(b.toString());
		}
	}

	/**
	 * Adds a new person to the circus.
	 * 
	 * @param person the person object to add
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}

	/**
	 * Displays all persons by printing each person using toString().
	 */
	public void displayAllPersons() {
		for (Person p : persons) {
			System.out.println(p.toString() + "\n");
		}
	}

	/**
	 * Adds a new animal to the circus.
	 * 
	 * @param animal the animal object to add
	 */
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	/**
	 * Displays all animals by printing each person using toString().
	 */
	public void displayAllAnimals() {
		for (Animal a : animals) {
			System.out.println(a.toString());
		}
	}

	/**
	 * Sorts animals by age using the selection sort algorithm. The method prints
	 * the sorted list after completion.
	 */
	public void sortAnimalsByAge() {
		for (int i = 0; i < animals.size() - 1; i++) {
			int minIndex = i;

			// Find the index of the minimum age
			for (int j = i + 1; j < animals.size(); j++) {
				if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
					minIndex = j;
				}
			}

			// Swap the animal with the minimum age into its correct position.
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);

		}

		displayAllAnimals();

	}

	/**
	 * Sorts animals by name using the selection sort algorithm. The method prints
	 * the sorted list after completion.
	 */
	public void sortAnimalsByName() {
		for (int i = 0; i < animals.size() - 1; i++) {
			int minIndex = i;

			// Find the index of the animal whose name comes first alphabetically.
			for (int j = i + 1; j < animals.size(); j++) {
				if (animals.get(j).getName().compareTo(animals.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}

			// Swap the animal with the alphabetically smallest name into its correct
			// position.
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);

		}

		displayAllAnimals();

	}

	/**
	 * Searches an animal by name
	 * 
	 * @param name the name to search
	 * @return true if the animal is found; false otherwise
	 */
	public boolean searchAnimalByName(String name) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getName().equalsIgnoreCase(name)) {
				System.out.println("Animal with name " + name + " is found.");
				System.out.println(animals.get(i));
				return true;
			}
		}
		System.out.println("Animal with name " + name + " is not found.");
		return false;

	}

	/**
	 * Adds a ticket to the circus ticket list.
	 * 
	 * @param ticket the object to add
	 */
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	/**
	 * Generates a new ticket based on the provided information and adds it to the
	 * ticket list.
	 * 
	 * @param dayOfWeek    the day of the week
	 * @param customerType the type of customer
	 * @param basePrice    the base ticket price
	 * @return the generated object
	 */
	public Ticket generateTicket(String dayOfWeek, String customerType, double basePrice) {
		Ticket ticket = new Ticket(dayOfWeek, customerType, basePrice); // Pass dayOfWeek, customerType, basePrice to
																		// Ticket constructor
		addTicket(ticket);
		return ticket;
	}

	/**
	 * Generates a new ticket based on the provided information and adds it to the
	 * ticket list.
	 * 
	 * @param dayOfWeek    	   	the day of the week
	 * @param customerType 	   	the type of customer
	 * @param basePrice    	   	the base ticket price
	 * @param dayDiscount  	   	the discount for selected day
	 * @param customerDiscount 	the discount for customer type
	 * @param seatDiscount 		the discount for selected seat
	 * @param seatMultiplier 	the multiplier for T-level seat
	 * @param quantity 			the number of ticket
	 * @return 					the generated object
	 */
	public Ticket generateTicket(String dayOfWeek, 
								 String customerType, 
								 double basePrice, 
								 double dayDiscount,
								 double customerDiscount, 
								 double seatDiscount, 
								 double seatMultiplier, 
								 int quantity) {
		
		Ticket ticket = new Ticket(dayOfWeek, 
								   customerType, 
								   basePrice, 
								   dayDiscount, 
								   customerDiscount, 
								   seatDiscount,
								   seatMultiplier, 
								   quantity);
		addTicket(ticket);
		return ticket;
	}

}
