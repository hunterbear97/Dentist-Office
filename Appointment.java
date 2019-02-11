package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;

public class Appointment {
	private LocalDateTime appointmentDate;
	
	private Patient patient;

	public Appointment() {}
	
	public Appointment(LocalDateTime appointmentDate, Patient patient) {
		this.setAppointmentDate(appointmentDate);
		this.setPatient(patient);
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		if(appointmentDate == null) {
			throw new IllegalArgumentException("\"appointmentDate\" cannot be null");
		}
		this.appointmentDate = appointmentDate;
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
	
	@Override
	public String toString() {
		return "Date: " + this.getAppointmentDate().toString() + ", Patient: " + this.getPatient();
	}
	
	
}
