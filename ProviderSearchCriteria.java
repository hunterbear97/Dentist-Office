package edu.neumont.lytle.dentistoffice.models;

public class ProviderSearchCriteria {

	private String firstName;
	private String lastName;
	private ProviderType title;
	
	/**
	 * default constructor
	 */
	public ProviderSearchCriteria() {}
	
	/**
	 * constructor with all parameters
	 * @param firstName
	 * @param lastName
	 * @param title
	 */
	public ProviderSearchCriteria(String firstName, String lastName, ProviderType title) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setTitle(title);
	}

	
	/**
	 * gets first name of searched provider
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets first name of searched provider
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * gets last name of provider searched
	 * @return
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * sets last name of provider searched
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * gets title of provider searched
	 * @return
	 */
	public ProviderType getTitle() {
		return title;
	}

	/**
	 * sets title of provider searched
	 * @param title
	 */
	public void setTitle(ProviderType title) {
		this.title = title;
	}

}

