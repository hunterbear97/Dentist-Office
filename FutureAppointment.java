package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FutureAppointment extends Appointment{
	private Patient patient;
	private List<Provider> providers = new ArrayList<>();
	private List<Procedure> procedures = new ArrayList<>();
	
	public FutureAppointment() {}
	
	
	
	
	public FutureAppointment(LocalDateTime appointmentDate, Patient patient, List<Provider> providers,
			List<Procedure> procedures) {
		super(appointmentDate);
		this.setPatient(patient);
		this.setProviders(providers);
		this.setProviders(providers);
	}




	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("\"patient\" cannot be null");
		}
		this.patient = patient;
	}
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		if(providers == null || providers.isEmpty()) {
			throw new IllegalArgumentException("\"providers\" cannot be null or empty");
		}
		this.providers = providers;
	}
	public List<Procedure> getProcedures() {
		return procedures;
	}
	public void setProcedures(List<Procedure> procedures) {
		if(procedures == null || procedures.isEmpty()) {
			throw new IllegalArgumentException("\"procedures\" cannot be null or empty");
		}
		this.procedures = procedures;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Patient: " + this.getPatient() + ", " + this.getProviders().toString() + ", Providers: " + this.getProcedures().toString();
	}
	
	
}
