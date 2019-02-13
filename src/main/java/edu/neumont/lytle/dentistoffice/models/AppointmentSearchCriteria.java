package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;

public class AppointmentSearchCriteria {
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Provider provider;
	
	private Patient patient;
	
	private String procedureCode;
	
	/**
	 * Default Constructor
	 */
	public AppointmentSearchCriteria() {
		this.setStartDate(null);
		this.setEndDate(null);
	}
	
	/**
	 * Constructor with parameters
	 * @param start
	 * @param end
	 * @param prov
	 * @param pat
	 * @param code
	 */
	public AppointmentSearchCriteria(LocalDateTime start, LocalDateTime end, Provider prov, Patient pat, String code) {
		// TODO Auto-generated constructor stub
		this.setStartDate(start);
		this.setEndDate(end);
		this.setPatient(pat);
		this.setProvider(prov);
		this.setProcedureCode(code);
	}

	/**
	 * This method will return the start date of the search criteria
	 * @return LocalDateTime
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	/**
	 * This method will set the start date of the search criteria. It defaults to LocalDateTime.MIN
	 * @param LocalDateTime startDate
	 */
	public void setStartDate(LocalDateTime startDate) {
		if(startDate == null) {
			startDate = LocalDateTime.MIN;
		}
		
		this.startDate = startDate;
	}
	
	/**
	 * This method will return the end date of the search criteria
	 * @return LocalDateTime
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * This method will set the end date of the search criteria. It defaults to LocalDateTime.MAX
	 * @param LocalDateTime endDate
	 */
	public void setEndDate(LocalDateTime endDate) {
		if(endDate == null) {
			endDate = LocalDateTime.MAX;
		}
		this.endDate = endDate;
	}
	
	/**
	 * This method will return the provider of the search criteria
	 * @return Provider
	 */

	public Provider getProvider() {
		return provider;
	}

	/**
	 * This method will set the provider to be searched by
	 * @param Provider provider
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	/**
	 * This method will return the patient to be searched by;
	 * @return Patient
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * This method will set the patient to be searched by
	 * @param Patient patient
	 */

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * This method will return the code of the procedure being searched by
	 * @return
	 */
	public String getProcedureCode() {
		return procedureCode;
	}
	
	/**
	 * This method will set the code of the procedure searched by
	 * @param String procedureCode
	 */

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
	

}
