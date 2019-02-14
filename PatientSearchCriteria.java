
package edu.neumont.lytle.dentistoffice.models;

public class PatientSearchCriteria {

	private String firstName;
	private String lastName;
	private String companyName;
	
	/**
	 * Default Constructor
	 */
	public PatientSearchCriteria() {}
	
	/**
	 * Constructor that takes in all parameters
	 * @param String firstName
	 * @param String lastName
	 * @param String companyName
	 */
	public PatientSearchCriteria(String firstName, String lastName, String companyName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCompanyName(companyName);
	}

	/**
	 * This method returns the first name of the searched patient
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets the first name to be searched
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method will get the last name to be searched
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method will set the last name to be searched
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method will get the name of the insurance company to be searched
	 * @return String
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * This method will set the name of the company to be searched
	 * @param String companyName
	 */

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}