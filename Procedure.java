package edu.neumont.lytle.dentistoffice.models;

import java.io.Serializable;

public class Procedure implements Serializable{
	private String code;
	private String description;
	private double cost;
	/**
	 * default constructor
	 */
	public Procedure() {}
	
	/**
	 * constructor with all parameters
	 * @param code
	 * @param description
	 * @param cost
	 */
	public Procedure(String code, String description, double cost) {
		this.setCode(code);
		this.setCost(cost);
		this.setDescription(description);
		
	}
	
	/**
	 * gets code of procedure
	 * @return
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * sets code of procedure
	 * @param code
	 */
	public void setCode(String code) {
		if(code == null || code.isEmpty()) {
			throw new IllegalArgumentException("\"code\" cannot be null");
		}
		
		this.code = code;
	}
	
	/**
	 * gets description of procedure
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * sets description of procedure
	 * @param description
	 */
	public void setDescription(String description) {
		if(description == null || description.isEmpty()) {
			throw new IllegalArgumentException("\"description\" cannot be null");
		}
		this.description = description;
	}
	
	/**
	 * gets cost of procedure
	 * @return
	 */
	public double getCost() {
		return this.cost;
	}
	
	/**
	 * sets cost of procedure
	 * @param cost
	 */
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
