package edu.neumont.lytle.dentistoffice.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutureAppointment extends Appointment{
	//private Patient patient;
//	private List<Provider> providers = new ArrayList<>();
//	private List<Procedure> procedures = new ArrayList<>();
	
	private Map<Provider, List<Procedure>> proceduresByProvider = new HashMap<>();
	
	public FutureAppointment() {
		
	}

	
	public FutureAppointment(LocalDateTime appointmentDate, Patient patient) {
		super(appointmentDate, patient);
		// TODO Auto-generated constructor stub
	}






	//	@SuppressWarnings("unchecked")
	public List<Provider> getProviders() {
		//List<Provider> providers = new ArrayList<>();
		
		return new ArrayList<>(proceduresByProvider.keySet());
	}
	
	public List<Procedure> getProcedures(Provider provider) {
		return proceduresByProvider.get(provider);
	}
	public void setProcedures(List<Procedure> procedures, Provider provider) {
		if(procedures == null || procedures.isEmpty()) {
			throw new IllegalArgumentException("\"procedures\" cannot be null or empty");
		}
		this.proceduresByProvider.put(provider, procedures);
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Provider> p = this.getProviders();
		for(int i = 0; i < proceduresByProvider.size(); i++) {
			sb.append("\n, Provider: ").append(p.get(i)).append(", Procedures: ").append(proceduresByProvider.get(p.get(i)).toString()).append("\n");
		}
		
		return super.toString() + sb.toString();
		
	}
//	@Override
//	public String toString() {
//		return super.toString() + " , " + this.getProviders().toString() + ", Providers: " + this.getProcedures().toString();
//	}
	
	
}
