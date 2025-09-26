/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This Class represents patient object
 * Due: 09/29/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/
public class Patient {

	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactPhoneNumber;

	public Patient() {}

	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Patient(String firstName, String middleName, String lastName, String streetAddress, String city,
			String state, String zipcode, String phoneNumber, String emergencyContactName,
			String emergencyContactPhoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}

	public String buildFullName() {
		if (middleName.equals("-") || middleName.isEmpty())
			return firstName + " " + lastName;
		else
			return firstName + " " + middleName + " " + lastName;
	}

	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipcode;
	}

	public String buildEmergencyContact() {
		return emergencyContactName + " " + emergencyContactPhoneNumber;
	}

	@Override
	public String toString() {
		return "Patient info:" + "\n  Name: " + buildFullName() + "\n  Address: " + buildAddress()
				+ "\n  EmergencyContact: " + buildEmergencyContact();
	}

}
