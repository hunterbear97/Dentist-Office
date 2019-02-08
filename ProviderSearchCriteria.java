package edu.neumont.lytle.dentistoffice.models;

public class ProviderSearchCriteria {

	private String firstName;
	private String lastName;
	private ProviderType title;
	
	public ProviderSearchCriteria() {}
	
	public ProviderSearchCriteria(String firstName, String lastName, ProviderType title) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setTitle(title);
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

	public ProviderType getTitle() {
		return title;
	}

	public void setTitle(ProviderType title) {
		this.title = title;
	}

}
