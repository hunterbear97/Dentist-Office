package edu.neumont.lytle.dentistoffice.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double amount;
	private Patient patient;
	private PaymentMethod paymentMethod;
	private LocalDate dateOfPayment;
	
	/**
	 * default constructor
	 */
	public Payment() {}
	
	/**
	 * constructor with all parameters
	 * @param double amount
	 * @param Patient patient
	 * @param PaymentMethod paymentMethod
	 * @param LocalDate dateOfPayment
	 */
	public Payment(double amount, Patient patient, PaymentMethod paymentMethod, LocalDate dateOfPayment) {
		this.setAmount(amount);
		this.setPatient(patient);
		this.setPaymentMethod(paymentMethod);
		this.setDateOfPayment(dateOfPayment);

	}
	
	/**
	 * gets amount paid
	 * @return double
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * sets amount paid
	 * @param double amount
	 */
	public void setAmount(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("\"amount\" cannot be less than 0"); 
		}
		this.amount = amount;
	}
	
	/**
	 * gets patient
	 * @return Patient
	 */
	public Patient getPatient() {
		return this.patient;
	}
	
	/**
	 * sets patient
	 * @param Patient patient
	 */
	public void setPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("\"patient\" cannot be null");
		}
		
		this.patient = patient;
	}
	
	/**
	 * gets the payment method used
	 * @return PaymentMethod
	 */
	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}
	
	/**
	 * sets the payment method used
	 * @param PaymentMethod paymentMethod
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if(paymentMethod == null) {
			throw new IllegalArgumentException("\"paymentMethod\" cannot be null");
		}
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * gets the date of payment
	 * @return
	 */
	public LocalDate getDateOfPayment() {
		return this.dateOfPayment;
	}
	
	/**
	 * sets the date of payment
	 * @param dateOfPayment
	 */
	public void setDateOfPayment(LocalDate dateOfPayment) {
		if(dateOfPayment == null) {
			throw new IllegalArgumentException("\"dateOfPayment\" cannot equal null");
		}
		
		this.dateOfPayment = dateOfPayment;
	}
	/**
	 * returns a string of all parameters
	 * @returns String
	 */
	@Override
	public String toString() {
		return "Amount paid: " + this.getAmount() + ", Patient: " + this.getPatient() + ", Payment Method: " + this.getPaymentMethod() + ", Date of payment: " + this.getDateOfPayment();
	}
}
