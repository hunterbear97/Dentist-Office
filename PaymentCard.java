package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDate;

public class PaymentCard {
	private long number;
	private LocalDate expirationDate;
	private String name;
	private int cvv;
	private int zip;
	
	public PaymentCard() {
		
	}
	
	public PaymentCard(long number, LocalDate expirationDate, String name, int cvv, int zip) {
		this.setNumber(number);
		this.setExpirationDate(expirationDate);
		this.setName(name);
		this.setCvv(cvv);
		this.setZip(zip);
		
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		if(number < 1000000000000000L || number > 9999999999999999L) {
			throw new IllegalArgumentException("\"number\" cannot be less than 1000000000000000 or greater than 9999999999999999");
		}
		this.number = number;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		if(expirationDate == null) {
			throw new IllegalArgumentException("\"expirationDate\" cannot be null");
		}
		this.expirationDate = expirationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("\"name\" cannot be null");
		}
		this.name = name;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		if(cvv < 0) { 
			throw new IllegalArgumentException("\"cvv\" cannot be less than 0");
		}
		this.cvv = cvv;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		if(zip < 0) {
			throw new IllegalArgumentException("\"zip\" cannot be less than 0");
		}
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return "Number: " + this.getNumber() + ", Expiration Date: " + this.getExpirationDate() + ", Name: " + this.getName() + ", CVV: " + this.getCvv() + ", Zip: " + this.getZip();
	}
	
	

}
