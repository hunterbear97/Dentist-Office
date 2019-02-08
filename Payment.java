package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDate;

public class Payment {
	private double amount;
	private Patient patient;
	private PaymentMethod paymentMethod;
	private LocalDate dateOfPayment;
	
	
	public Payment() {}
	
	public Payment(double amount, Patient patient, PaymentMethod paymentMethod) {
		this.setAmount(amount);
		this.setPatient(patient);
		this.setPaymentMethod(paymentMethod);

	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public void setAmount(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("\"amount\" cannot be less than 0"); 
		}
		this.amount = amount;
	}
	
	public Patient getPatient() {
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("\"patient\" cannot be null");
		}
		
		this.patient = patient;
	}
	
	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if(paymentMethod == null) {
			throw new IllegalArgumentException("\"paymentMethod\" cannot be null");
		}
		this.paymentMethod = paymentMethod;
	}
	
	public LocalDate getDateOfPayment() {
		return this.dateOfPayment;
	}
	
	public void setDateOfPayment(LocalDate dateOfPayment) {
		if(dateOfPayment == null) {
			throw new IllegalArgumentException("\"dateOfPayment\" cannot equal null");
		}
		
		this.dateOfPayment = dateOfPayment;
	}
	@Override
	public String toString() {
		return "Amount paid: " + this.getAmount() + ", Patient: " + this.getPatient() + ", Payment Method: " + this.getPaymentMethod() + ", Date of payment: " + this.getDateOfPayment();
	}
}
