package edu.neumont.lytle.dentistoffice.models;

public class Provider extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProviderType title;
	
	/**
	 * default constructor
	 */
	public Provider() {
		
	}
	
	/**
	 * constructor with all parameters
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param uid
	 * @param title
	 */
	public Provider(String firstName, String lastName, String email, PhoneNumber phone, int uid, ProviderType title) {
		super(firstName, lastName, email, phone, uid);
		this.setTitle(title);
	}
	
	/**
	 * gets title of provider
	 * @return
	 */
	public ProviderType getTitle() {
		return title;
	}
	
	/**
	 * sets title of provider
	 * @param title
	 */
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
	
//	@Override
//	public boolean equals(Object obj) {
//		return super.equals(obj);
//	}

}
