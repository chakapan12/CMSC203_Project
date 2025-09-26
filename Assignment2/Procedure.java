/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents procedure object
 * Due: 09/29/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/
public class Procedure {

	private String nameOfProcedure;
	private String dateOfProcedure;
	private String nameOfPractitioner;
	private double chargesForProcedure;

	public Procedure() {
	}

	public Procedure(String nameOfProcedure, String dateOfProcedure) {
		this.nameOfProcedure = nameOfProcedure;
		this.dateOfProcedure = dateOfProcedure;
	}

	public Procedure(String nameOfProcedure, String dateOfProcedure, String nameOfPractitioner,
			double chargesForProcedure) {
		this.nameOfProcedure = nameOfProcedure;
		this.dateOfProcedure = dateOfProcedure;
		this.nameOfPractitioner = nameOfPractitioner;
		this.chargesForProcedure = chargesForProcedure;
	}

	public String getNameOfProcedure() {
		return nameOfProcedure;
	}

	public String getDateOfProcedure() {
		return dateOfProcedure;
	}

	public String getNameOfPractitioner() {
		return nameOfPractitioner;
	}

	public double getChargesForProcedure() {
		return chargesForProcedure;
	}

	public void setNameOfProcedure(String nameOfProcedure) {
		this.nameOfProcedure = nameOfProcedure;
	}

	public void setDateOfProcedure(String dateOfProcedure) {
		this.dateOfProcedure = dateOfProcedure;
	}

	public void setNameOfPractitioner(String nameOfPractitioner) {
		this.nameOfPractitioner = nameOfPractitioner;
	}

	public void setChargesForProcedure(double chargesForProcedure) {
		this.chargesForProcedure = chargesForProcedure;
	}

	@Override
	public String toString() {
		return "\tProcedure: " + nameOfProcedure + "\n\tProcedureDate=" + dateOfProcedure + "\n\tPractitioner="
				+ nameOfPractitioner + "\n\tCharge=" + chargesForProcedure;
	}

}
