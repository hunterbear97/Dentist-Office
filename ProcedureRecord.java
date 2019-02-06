package edu.neumont.lytle.dentistoffice.models;

public class ProcedureRecord {
//	private Patient patient;
	private Provider provider;
	private Appointment appointment;
	private Procedure procedure;
	private double cost;
	
	
	public ProcedureRecord() {
		
	}
	
	
	
	public ProcedureRecord(Provider provider, Appointment appointment, Procedure procedure, double cost) {
		super();
		this.setProvider(provider);;
		this.setAppointment(appointment);
		this.setProcedure(procedure);
		this.setCost(cost);;
	}



	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		if(provider == null) {
			throw new IllegalArgumentException("\"provider\" cannot be null");
		}
		this.provider = provider;
	}
	public Appointment getAppointment() {
		return appointment;
	}
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
