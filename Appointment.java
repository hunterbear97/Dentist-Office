package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;

public class Appointment {
	private LocalDateTime appointmentDate;

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		if(appointmentDate == null) {
			throw new IllegalArgumentException("\"appointmentDate\" cannot be null");
		}
		this.appointmentDate = appointmentDate;
	}
	
	@Override
	public String toString() {
		return "Date: " + this.getAppointmentDate().toString();
	}
	
	
}
