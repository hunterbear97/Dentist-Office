package edu.neumont.lytle.dentistoffice.models;

import java.io.Serializable;

abstract public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected PhoneNumber phone;
	protected int uid;
	
	/**
	 * default constructor
	 */
	public Person() {}
	
	/**
	 * constructor with all parameters
	 * @param String firstName
	 * @param String lastName
	 * @param String email
	 * @param PhoneNumber phone
	 * @param int uid
	 */
	public Person(String firstName, String lastName, String email, PhoneNumber phone, int uid) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setUid(uid);
	}
	
	/**
	 * returns first name of person
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * sets first name of person
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("\"firstName\" cannot be null or empty");
		}
		this.firstName = firstName;
	}
	
	/**
	 * gets last name of person
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * sets last name of person
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("\"lastName\" cannot be null or empty");
		}
		this.lastName = lastName;
	}
	/**
	 * gets email of person
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * sets email of person
	 * @param email
	 */
	public void setEmail(String email) {
		if(email == null || email.isEmpty()) {
			throw new IllegalArgumentException("\"email\" cannot be null");
		}
		
		this.email = email;
	}
	/**
	 * gets phone number of person
	 * @return
	 */
	public PhoneNumber getPhone() {
		return phone;
	}
	/**
	 * sets phone number of person
	 * @param phone
	 */
	public void setPhone(PhoneNumber phone) {
		if(phone == null) {
			throw new IllegalArgumentException("\"phone\" cannot be null");
		}
		this.phone = phone;
	}
	
	/**
	 * gets uid of person
	 * @return
	 */
	public int getUid() {
		return uid;
	}
	
	/**
	 * sets uid of person
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	/**
	 * returns string of person, last name first
	 * @return
	 */
	@Override
	public String toString() {
		return this.getUid() + " | " + this.getLastName() + ", " + this.getFirstName() +  ", Email: " + this.getEmail() + ", Phone: " + this.getPhone();
	}
	
	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		return this.getFirstName().equalsIgnoreCase(other.getFirstName()) && this.getLastName().equalsIgnoreCase(other.getLastName());
	}
	
}
