package edu.neumont.lytle.dentistoffice.models;

public class ProcedureSearchCriteria {

	private String procedureCode;

	public ProcedureSearchCriteria(){}
	
	public ProcedureSearchCriteria(String pc) {
		this.setProcedureCode(pc);
	}
	
	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
}
