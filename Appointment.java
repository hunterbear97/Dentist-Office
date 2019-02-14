package edu.neumont.lytle.dentistoffice.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDateTime appointmentDate;
	
	private Patient patient;

	/**
	 * Default Constructor
	 */
	public Appointment() {}
	
	/**
	 * Constructor with all parameters
	 * @param LocalDateTime appointmentDate
	 * @param Patient patient
	 */
	public Appointment(LocalDateTime appointmentDate, Patient patient) {
		this.setAppointmentDate(appointmentDate);
		this.setPatient(patient);
	}
	
	/**
	 * gets the date and time of appointment
	 * @return LocalDateTime
	 */
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * sets the date and time of appointment
	 * @param LocalDateTime appointmentDate
	 */
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		if(appointmentDate == null) {
			throw new IllegalArgumentException("\"appointmentDate\" cannot be null");
		}
		this.appointmentDate = appointmentDate;
	}
	
	/**
	 * gets the patient of the appointment
	 * @return Patient
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * sets the patient of the appointment
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("\"patient\" cannot be null");
		}
		this.patient = patient;
	}
	
	/**
	 * returns a string of all parameters
	 * @return String
	 */
	@Override
	public String toString() {
		return "Date: " + this.getAppointmentDate().toString() + ", Patient: " + this.getPatient();
	}
	
	
}
