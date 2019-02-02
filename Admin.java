package edu.neumont.lytle.dentistoffice.models;

public class Admin extends User{
	
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
