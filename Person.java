package edu.neumont.lytle.dentistoffice.models;

abstract public class Person {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected PhoneNumber phone;
	protected int uid;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String email, PhoneNumber phone, int uid) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setUid(uid);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("\"firstName\" cannot be null or empty");
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("\"lastName\" cannot be null or empty");
		}
		this.lastName = lastName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		if(email == null || email.isEmpty()) {
			throw new IllegalArgumentException("\"email\" cannot be null");
		}
		
		this.email = email;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		if(phone == null) {
			throw new IllegalArgumentException("\"phone\" cannot be null");
		}
		this.phone = phone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Override
	public String toString() {
		return this.getUid() + " | " + this.getLastName() + ", " + this.getFirstName() +  ", Email: " + this.getEmail() + ", Phone: " + this.getPhone();
	}
	
}
