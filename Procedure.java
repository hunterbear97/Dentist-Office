package edu.neumont.lytle.dentistoffice.models;

public class Procedure {
	private String code;
	private String description;
	private double cost;
	
	public Procedure() {}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		if(code == null || code.isEmpty()) {
			throw new IllegalArgumentException("\"code\" cannot be null");
		}
		
		this.code = code;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		if(description == null || description.isEmpty()) {
			throw new IllegalArgumentException("\"description\" cannot be null");
		}
		this.description = description;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) {
		if(cost < 0) {
			throw new IllegalArgumentException("\"cost\" cannot be less than 0");
		}
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Code: " + this.getCode() + ", Description: " + this.getDescription() + ", Cost: " + this.getCost();
	}
}
