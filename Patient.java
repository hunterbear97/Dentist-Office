package edu.neumont.lytle.dentistoffice.models;

public class Patient extends Person{
	private InsuranceInfo insurance;
	private PaymentCard paymentCard;
	
	
	public Patient(String firstName, String lastName, String email, PhoneNumber phone, int uid, InsuranceInfo insurance,
			PaymentCard paymentCard) {
		super(firstName, lastName, email, phone, uid);
		this.setInsurane(insurance);
		this.setPaymentCard(paymentCard);
	}
	
	public InsuranceInfo getInsurance() {
		return insurance;
	}
	public void setInsurane(InsuranceInfo insurance) {
		this.insurance = insurance;
	}
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}
	
}
