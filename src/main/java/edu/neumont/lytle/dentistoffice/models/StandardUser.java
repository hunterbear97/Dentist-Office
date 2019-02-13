package edu.neumont.lytle.dentistoffice.models;

public class StandardUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StandardUser(String username, String password, UserRole uRole) {
		super(username, password, uRole);
	}

}
