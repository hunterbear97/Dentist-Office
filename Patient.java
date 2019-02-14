package edu.neumont.lytle.dentistoffice.models;

public class Patient extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InsuranceInfo insurance;
	private PaymentCard paymentCard;
	/**
	 * Default constructor
	 */
	public Patient() {}
	
	/**
	 * Constructor that takes in all parameters
	 * @param String firstName
	 * @param String lastName
	 * @param String email
	 * @param PhoneNumber phone
	 * @param int uid
	 * @param InsuranceInfo insurance
	 * @param PaymentCard paymentCard
	 */
	public Patient(String firstName, String lastName, String email, PhoneNumber phone, int uid, InsuranceInfo insurance,
			PaymentCard paymentCard) {
		super(firstName, lastName, email, phone, uid);
		this.setInsurance(insurance);
		this.setPaymentCard(paymentCard);
	}
	/**
	 * This method returns the insurance info of the class
	 * @return InsuranceInfo
	 */
	public InsuranceInfo getInsurance() {
		return insurance;
	}
	/**
	 * This method sets the insurance info of the patient
	 * @param InsuranceInfo insurance
	 */
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}
	
	/**
	 * This method returns the payment card of the patient
	 * @return PaymentCard
	 */
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}
	
	/**
	 * This method sets the payment card of the patient
	 * @param PaymentCard paymentCard
	 */
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}

	@Override
	public String toString() {
		String insuranceString;
		if(this.getInsurance() == null) {
			insuranceString = "";
		}
		else {
			insuranceString = this.getInsurance().toString();
		}
		return super.toString() + insuranceString + this.getPaymentCard().toString();
	}
	
	
}
