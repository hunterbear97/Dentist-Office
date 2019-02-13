package edu.neumont.lytle.dentistoffice.models;

import java.time.YearMonth;

public class PaymentCard {
	private long number;
	private YearMonth expirationDate;
	private String name;
	private int cvv;
	private int zip;
	
	/**
	 * Default Constructor
	 * @param zip2 
	 * @param cvv2 
	 * @param name2 
	 * @param expirationDate2 
	 * @param number2 
	 */
	public PaymentCard() {
		
	}
	
	/**
	 * Constructor with all parameters
	 * @param long number
	 * @param LocalDate expirationDate
	 * @param String name
	 * @param int cvv
	 * @param int zip
	 */
	
	public PaymentCard(long number, YearMonth expirationDate, String name, int cvv, int zip) {
		this.setNumber(number);
		this.setExpirationDate(expirationDate);
		this.setName(name);
		this.setCvv(cvv);
		this.setZip(zip);
		
	}
	
	/**
	 * returns the number of the card
	 * @return long
	 */
	public long getNumber() {
		return number;
	}
	
	/**
	 * sets the card number
	 * @param long number
	 */
	public void setNumber(long number) {
		if(number < 0 || number > 9999999999999999L) {
			throw new IllegalArgumentException("\"number\" cannot be less than 1000000000000000 or greater than 9999999999999999");
		}
		this.number = number;
	}
	
	/**
	 * gets the expiration date of the card
	 * @return LocalDate
	 */
	public YearMonth getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * sets the expiration date of the card
	 * @param LocalDate expirationDate
	 */
	public void setExpirationDate(YearMonth expirationDate) {
		if(expirationDate == null) {
			throw new IllegalArgumentException("\"expirationDate\" cannot be null");
		}
		this.expirationDate = expirationDate;
	}
	/**
	 * gets the name on card
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name on card
	 * @param String name
	 */
	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("\"name\" cannot be null");
		}
		this.name = name;
	}
	
	/**
	 * gets the cvv of the card
	 * @return int
	 */
	public int getCvv() {
		return cvv;
	}
	
	/**
	 * sets the cvv of card
	 * @param int cvv
	 */
	public void setCvv(int cvv) {
		if(cvv < 0) { 
			throw new IllegalArgumentException("\"cvv\" cannot be less than 0");
		}
		this.cvv = cvv;
	}
	
	/**
	 * gets the zip code of card
	 * @return int
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * sets the zip code of card
	 * @param int zip
	 */
	public void setZip(int zip) {
		if(zip < 0) {
			throw new IllegalArgumentException("\"zip\" cannot be less than 0");
		}
		this.zip = zip;
	}
	
	/**
	 * returns the string of parameters
	 * @return String
	 */
	@Override
	public String toString() {
		return "Number: " + this.getNumber() + ", Expiration Date: " + this.getExpirationDate() + ", Name: " + this.getName() + ", CVV: " + this.getCvv() + ", Zip: " + this.getZip();
	}
	
	

}
