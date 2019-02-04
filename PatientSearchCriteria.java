package edu.neumont.lytle.dentistoffice.models;

public class PatientSearchCriteria {

	private String firstName;
	private String lastName;
	private String companyName;
	
	public PatientSearchCriteria() {}
	
	public PatientSearchCriteria(String firstName, String lastName, String companyName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCompanyName(companyName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
