package edu.neumont.lytle.dentistoffice.models;

public class AppointmentRecord extends Appointment{
	
	private ProcedureRecord procedures;
	
	public ProcedureRecord getProcedures() {
		return procedures;
	}
	
	public void setProcedures(ProcedureRecord procedures) {
		if(procedures == null) {
			throw new IllegalArgumentException("\"procedures\" cannot be null");
		}
		
		this.procedures = procedures;
	}

}
