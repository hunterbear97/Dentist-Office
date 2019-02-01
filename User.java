package edu.neumont.lytle.dentistoffice.models;

public class User {
	protected String userName;
	protected String password;
	protected UserRole role;
	
	
	public User(UserRole role) {
		
	}
	
	public User(String userName, String password, UserRole role) {
		this.setUserName(userName);
		this.setPassword(password);
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if(userName == null || userName.isEmpty()) {
			throw new IllegalArgumentException("\"userName\" cannot be null or empty");
		}

		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null || password.isEmpty()) {
			throw new IllegalArgumentException("\"password\" cannot be null or empty");
		}
		this.password = password;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		if(role == null) {
			throw new IllegalArgumentException("\"role\" cannot be null");
		}
		
		this.role = role;
	}
	
	@Override
	public boolean equals(Object obj) {
		User other = (User) obj; 
		return this.getUserName().equals(other.getUserName());
	}
	
	@Override
	public String toString() {
		return this.getUserName() + ".........." + this.getRole();
	}

}
