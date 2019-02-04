package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;

public class AppointmentSearchCriteria {
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Provider provider;
	
	private Patient patient;
	
	private String procedureCode;
	

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		if(startDate == null) {
			startDate = LocalDateTime.now();
		}
		
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		if(endDate == null) {
			endDate = LocalDateTime.now();
		}
		this.endDate = endDate;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
	

}
