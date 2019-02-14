package edu.neumont.lytle.dentistoffice.models;

import java.util.List;

public class AppointmentRecord extends Appointment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProcedureRecord> procedures;
	
	
	/**
	 * This method will return the list of procedures in the method
	 * @return List<ProcedureRecord>
	 */
	public List<ProcedureRecord> getProcedures() {
		return procedures;
	}
	
	/**
	 * This method will take in a list of procedure records and add it to the object
	 * @param procedures
	 */
	
	public void setProcedures(List<ProcedureRecord> procedures) {
		if(procedures == null) {
			throw new IllegalArgumentException("\"procedures\" cannot be null");
		}
		
		this.procedures = procedures;
	}

}
