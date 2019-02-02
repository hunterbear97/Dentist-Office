package edu.neumont.lytle.dentistoffice.models;

public class Provider extends Person{
	
	ProviderType title;
	
	public Provider() {
		
	}
	
	public Provider(String firstName, String lastName, String email, PhoneNumber phone, int uid, ProviderType title) {
		super(firstName, lastName, email, phone, uid);
		
	}
	
	public ProviderType getTitle() {
		return title;
	}
	
	public void setTitle(ProviderType title) {
		if(title == null) {
			throw new IllegalArgumentException("\"title\" cannot be null");
		}
		
		this.title = title;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Title: " + this.getTitle().toString();
	}

}
