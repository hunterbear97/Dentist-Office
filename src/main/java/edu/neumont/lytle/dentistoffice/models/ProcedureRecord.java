package edu.neumont.lytle.dentistoffice.models;

public class ProcedureRecord {
//	private Patient patient;
	private Provider provider;
	private Appointment appointment;
	private Procedure procedure;
	private double cost;
	
	/**
	 * Default constructor
	 */
	public ProcedureRecord() {
		
	}
	
	
	/**
	 * Constructor that takes in all parameters of the object
	 * @param Provider provider
	 * @param Appointment appointment
	 * @param Procedure procedure
	 * @param double cost
	 */
	public ProcedureRecord(Provider provider, Appointment appointment, Procedure procedure, double cost) {
		super();
		this.setProvider(provider);;
		this.setAppointment(appointment);
		this.setProcedure(procedure);
		this.setCost(cost);;
	}


	/**
	 * This method returns the provider of the procedure that took place
	 * @return Provider
	 */
	public Provider getProvider() {
		return provider;
	}
	
	/**
	 * This method sets the provider of the procedure
	 * @param Provider provider
	 */
	public void setProvider(Provider provider) {
		if(provider == null) {
			throw new IllegalArgumentException("\"provider\" cannot be null");
		}
		this.provider = provider;
	}
	
	/**
	 * This method will return the appointment of the procedure
	 * @return Appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	
	/**
	 * This method will set the appointment for the procedure
	 * @param Appointment appointment
	 */
	public void setAppointment(Appointment appointment) {
		if(appointment == null) {
			throw new IllegalArgumentException("\"appointment\" cannot be null");
		}
		this.appointment = appointment;
	}
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		if(procedure == null) {
			throw new IllegalArgumentException("\"procedure\" cannot be null");
		}
		this.procedure = procedure;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		if(cost < 0) {
			throw new IllegalArgumentException("\"cost\" cannot be less than 0");
		}
		this.cost = cost;
	}
	
	public String toString() {
		return "Provider: " + this.getProvider() + ", Appointment Time: " + this.getAppointment().toString() + ", Procedure: " + this.getProcedure() + ", Cost: " + this.getCost();
	}
	

}
