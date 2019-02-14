package edu.neumont.lytle.dentistoffice.models;

public class Admin extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin(String string, String string2, UserRole admin) {
		super(string, string2, admin);
	}

	public void changeUserPassword(User user, String password) {
		user.setPassword(password);
	}
	
	public void removeUser(User user) {
		//TODO make method
	}
	
	public void addUser(User user) {
		//TODO make method
	}
	
	public void changeUserRole(User user, UserRole role) {
		//TODO make method
	}
	
	
}
