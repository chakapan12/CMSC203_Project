/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents Ticket object
 * Due: 12/08/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents Ticket object
 * 
 * @author Chakapan Kanchana
 */
public class Ticket {
	private String dayOfWeek;
	private String customerType;
	private double basePrice;
	private double dayDiscount;
	private double customerDiscount;
	private double seatDiscount;
	private double seatMultiplier;
	private int quantity;

	/**
	 * Constructs a Ticket with only essential information.
	 * 
	 * @param dayOfWeek    the day of the week
	 * @param customerType the type of customer
	 * @param basePrice    the base ticket price
	 */
	public Ticket(String dayOfWeek, String customerType, double basePrice) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.customerType = customerType;
		this.basePrice = basePrice;
	}

	/**
	 * Constructs a Ticket with all details including discounts, seat multipliers,
	 * and quantity.
	 *
	 * @param dayOfWeek        the day of the week
	 * @param customerType     the type of customer
	 * @param basePrice        the base ticket price
	 * @param dayDiscount      discount based on the day
	 * @param customerDiscount discount based on customer type
	 * @param seatDiscount     discount based on seat type
	 * @param seatMultiplier   multiplier applied for premium seats
	 * @param quantity         total quantity of tickets purchased
	 */
	public Ticket(String dayOfWeek, String customerType, double basePrice, double dayDiscount, double customerDiscount,
			double seatDiscount, double seatMultiplier, int quantity) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.customerType = customerType;
		this.basePrice = basePrice;
		this.dayDiscount = dayDiscount;
		this.customerDiscount = customerDiscount;
		this.seatDiscount = seatDiscount;
		this.seatMultiplier = seatMultiplier;
		this.quantity = quantity;
	}

	/**
	 * Calculates the final ticket price after applying: all discount, seat
	 * multiplier, and quantity.
	 * 
	 * 
	 * 
	 * @return the total calculated price for all purchased tickets.
	 */
	public double calculatePrice() {

		// total discount based on base price
		double totalDiscount = basePrice * (dayDiscount + customerDiscount + seatDiscount);

		double discountPrice = basePrice - totalDiscount;

		// apply T-level multiplier
		discountPrice *= seatMultiplier;

		// batch total
		return discountPrice * quantity;
	}

	/**
	 * Builds a readable string containing all ticket details, including discounts
	 * and seat modifiers if applicable.
	 *
	 * @return a formatted string representing ticket details
	 */
	public String getTicketDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%d %s $%.2f (Day: %S", quantity, customerType, calculatePrice(), dayOfWeek));

		if (dayDiscount > 0) {
			sb.append(String.format(", Day Discount: %d%%", (int) (dayDiscount * 100)));
		}

		if (customerDiscount > 0) {
			sb.append(String.format(", Customer Type Discount: %d%%", (int) (customerDiscount * 100)));
		}

		if (seatDiscount > 0) {
			sb.append(String.format(", Seat Type Discount: %d%%", (int) (seatDiscount * 100)));
		}

		if (seatMultiplier > 1) {
			sb.append(", T-Level Seat (x2)");
		}
		sb.append(")\n");

		return sb.toString();
	}

	/**
	 * Prints the ticket details to the console.
	 */
	public void displayTicketDetails() {
		System.out.println(getTicketDetails());
	}

	/**
	 * Returns a string representation of the ticket containing day, customer type,
	 * quantity, and the calculated total price.
	 *
	 * @return a formatted string representation of this ticket
	 */
	@Override
	public String toString() {
		return String.format("Ticket [Day: %s, Customer Type: %s, Quantity: %d, Price: $%.2f]",
				dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), customerType, quantity,
				calculatePrice());
	}
}
