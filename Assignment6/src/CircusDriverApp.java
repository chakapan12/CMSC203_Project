/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents CircusDriverApp object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents CircusDriverApp object
 * 
 * @author Chakapan Kanchana
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
	public static void main(String[] args) {
		Circus circus = new Circus();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		System.out.println("Welcome to Bob's Circus Management System!");

		while (!exit) {
			try {
				// Display menu
				System.out.println("\nMenu:");
				System.out.println("1. Add Animal");
				System.out.println("2. Add Person");
				System.out.println("3. Add Building");
				System.out.println("4. Generate Ticket");
				System.out.println("5. Display All Animals");
				System.out.println("6. Display All Persons");
				System.out.println("7. Display All Buildings");
				System.out.println("8. Sort Animals by Age");
				System.out.println("9. Sort Animals by Name");
				System.out.println("10. Search Animal by Name");
				System.out.println("11. Exit\n");

				System.out.print("Choose an option: ");

				// Use validateInput method
				int choice = 0;
				boolean validInput = false;

				// Retry until valid input is received
				while (!validInput) {
					try {
						choice = validateInput(scanner);
						validInput = true;
					} catch (CustomInputMismatchException e) {
						System.out.println("Invalid input. Please enter a number between 1 and 11.\n");
						System.out.print("Choose an option: ");
						scanner.nextLine(); // Clear invalid input.
					}
				}

				switch (choice) {
				case 1:
					handleAddAnimal(circus, scanner);
					break;
				case 2:
					handleAddPerson(circus, scanner);
					break;
				case 3:
					handleAddBuilding(circus, scanner);
					break;
				case 4:
					handleGenerateTicket(circus, scanner);
					break;
				case 5:
					System.out.println("Displaying all animals:");
					System.out.println("----------------------");
					circus.displayAllAnimals();
					break;
				case 6:
					System.out.println("Displaying all persons:");
					System.out.println("----------------------");
					circus.displayAllPersons();
					break;
				case 7:
					System.out.println("Displaying all buildings:");
					System.out.println("------------------------");
					circus.displayAllBuildings();
					break;
				case 8:
					System.out.println("Sorting animals by age...");
					circus.sortAnimalsByAge();
					System.out.println("Animals sorted by age.");
					break;
				case 9:
					System.out.println("Sorting animals by name...");
					circus.sortAnimalsByName();
					System.out.println("Animals sorted by name.");
					break;
				case 10:
					System.out.print("Enter the name of the animal to search: ");
					// scanner.nextLine(); // Consume the leftover newline
					String searchName = scanner.nextLine();
					circus.searchAnimalByName(searchName);
					break;
				case 11:
					exit = true;
					System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
					break;
				default:
					System.out.println("Invalid option. Please choose again.");
				}

			} catch (Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
				e.printStackTrace();
			}

		}

		scanner.close();
	}

	private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
		int input = 0;
		try {
			input = scanner.nextInt();
			scanner.nextLine(); // Consume the leftover
		} catch (InputMismatchException e) {
			throw new CustomInputMismatchException();
		}
		return input;
	}

	// handleAddAnimal()
	private static void handleAddAnimal(Circus circus, Scanner scanner) {
		Animal animal = null;
		System.out.println("\nChoose an animal to add");
		System.out.println("1. Bird");
		System.out.println("2. Dog");
		System.out.println("3. Horse");
		System.out.println("4. Lion");

		// Validate choice
		int choice = Utils.readMenuChoice(scanner, "\nChoose an option: ", 1, 4);

		// Prompt users to enter the animal details.
		String name = Utils.readNonEmptyString(scanner, "Enter animal name: ");
		int age = Utils.readPositiveInt(scanner, "Enter animal age: ");
		String species = Utils.readNonEmptyString(scanner, "Enter animal species: ");
		String color = Utils.readNonEmptyString(scanner, "Enter animal color: ");

		// Create animal base on selection.
		switch (choice) {
		case 1:
			animal = new Bird(name, age, species, color);
			break;
		case 2:
			animal = new Dog(name, age, species, color);
			break;
		case 3:
			animal = new Horse(name, age, species, color);
			break;
		case 4:
			animal = new Lion(name, age, species, color);
			break;
		}

		// Add to circus
		circus.addAnimal(animal);

	}

	// handleAddPerson()
	private static void handleAddPerson(Circus circus, Scanner scanner) {
		Person person = null;
		System.out.println("\nEnter job title:");
		System.out.println("1. Clerk");
		System.out.println("2. Acrobatic");

		// Validate choice
		int choice = Utils.readMenuChoice(scanner, "\nChoose an option: ", 1, 2);

		// Prompt users to enter the person information.
		String name = Utils.readNonEmptyString(scanner, "Enter a person name: ");
		int age = Utils.readPositiveInt(scanner, "Enter a person age: ");
		int yearsWorked = Utils.readNonNegativeInt(scanner, "Enter years worked: ");
		String job = Utils.readNonEmptyString(scanner, "Enter job: ");

		// Create person object based on the selection.
		if (choice == 1) {
			person = new Clerk(name, age, yearsWorked, job);
		} else {
			person = new Acrobatic(name, age, yearsWorked, job);
		}

		circus.addPerson(person);

	}

	// handleAddBuilding()
	private static void handleAddBuilding(Circus circus, Scanner scanner) {
		Building building = null;
		System.out.println("\nEnter Building Type:");
		System.out.println("1. Arena");
		System.out.println("2. TicketingOffice");

		// Validate choice
		int choice = Utils.readMenuChoice(scanner, "\nChoose an option: ", 1, 2);

		// Prompt user to enter building information
		String color = Utils.readNonEmptyString(scanner, "Enter color of building: ");
		double length = Utils.readPositiveDouble(scanner, "Enter length of building: ");
		double width = Utils.readPositiveDouble(scanner, "Enter width of building: ");

		// Create building based on the selection.
		if (choice == 1) {
			building = new Arena(color, length, width);
		} else {
			building = new TicketingOffice(color, length, width);
		}

		// Add to circus
		circus.addBuilding(building);

	}

	private static void handleGenerateTicket(Circus circus, Scanner scanner) {
		double totalAmount = 0;
		double basePrice;
		StringBuilder ticketDetails = new StringBuilder();
		boolean addMoreTickets = true;

		// Prompt users to enter base price.
		basePrice = Utils.readPositiveDouble(scanner, "\nEnter ticket base price: ");

		ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

		while (addMoreTickets) {
			// Select day of the week
			System.out.println("\nSelect day of the week:");
			for (int i = 0; i < DayOfWeek.values().length; i++) {
				DayOfWeek day = DayOfWeek.values()[i];
				if (day.getDiscount() > 0) {
					System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
				} else {
					System.out.printf("%d. %s%n", i + 1, day);
				}
			}
			// Reads dayChoice from users.
			int dayChoice = Utils.readMenuChoice(scanner, "\nEnter your choice: ", 1, 7);

			if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
				System.out.println("Invalid choice. Please select a valid day.");
				continue;
			}

			DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
			double dayDiscount = selectedDay.getDiscount();

			// Select customer type
			System.out.println("\nEnter customer type:");
			System.out.println("1. Child (10% discount)");
			System.out.println("2. Student (10% discount)");
			System.out.println("3. Adult");
			System.out.println("4. Senior (5% discount)");

			// Reads customerType from users
			int customerType = Utils.readMenuChoice(scanner, "\nEnter your choice: ", 1, 4);

			double customerDiscount = 0.0;
			String customerTypeName = "";
			switch (customerType) {
			case 1:
				customerDiscount = 0.10;
				customerTypeName = "child";
				break;
			case 2:
				customerDiscount = 0.10;
				customerTypeName = "student";
				break;
			case 3:
				customerTypeName = "adult";
				break;
			case 4:
				customerDiscount = 0.05;
				customerTypeName = "senior";
				break;
			default:
				System.out.println("Invalid customer type. Please try again.");
				continue;
			}

			// Select seat location
			System.out.println("\nSeat Location in the Arena:");
			System.out.println("1. Lower level");
			System.out.println("2. T-level (double ticket price)");
			System.out.println("3. Upper level (5% discount)");

			// Reads seatLocation from users.
			int seatLocation = Utils.readMenuChoice(scanner, "\nEnter your choice: ", 1, 3);

			double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
			double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

			// Prompt users to enter number of ticket
			int numberOfTickets = Utils.readPositiveInt(scanner, "Enter number of tickets: ");

			DayOfWeek day = DayOfWeek.values()[dayChoice - 1];

			// Call generateTicket() to create ticket object.
			Ticket ticket = circus.generateTicket(day.toString(), customerTypeName, basePrice, dayDiscount,
					customerDiscount, seatDiscount, seatMultiplier, numberOfTickets);

			// Calculate total discounts
			double ticketPrice = ticket.calculatePrice();

			// Add to total amount
			totalAmount += ticketPrice;

			// Append details of this batch to the ticket details
			ticketDetails.append(ticket.getTicketDetails());

			// Ask user to add more tickets and validate user response.
			while (true) {
				System.out.print("\nDo you want to add more tickets? (y/n): ");
				String response = scanner.nextLine().trim().toLowerCase();
				if (response.equals("y")) {
					addMoreTickets = true;
					break;
				} else if (response.equals("n")) {
					addMoreTickets = false;
					break;
				} else {
					System.out.println("Invalid choice. Please enter 'y' or 'n'");
				}

			}
		}

		// Display ticket calculation details
		System.out.println("\nTicket Calculation Details:");
		System.out.println("---------------------------");
		System.out.println(ticketDetails);

		// Display final total amount
		System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
		System.out.println("Enjoy the show!");
	}

}
