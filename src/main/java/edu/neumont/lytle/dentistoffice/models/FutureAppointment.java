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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Provider, List<Procedure>> proceduresByProvider = new HashMap<>();
	
	/**
	 * Default Constructor
	 */
	public FutureAppointment() {
		
	}

	/**
	 * Constructor with all parameters
	 * @param LocalDateTime appointmentDate
	 * @param Patient patient
	 */
	public FutureAppointment(LocalDateTime appointmentDate, Patient patient) {
		super(appointmentDate, patient);
		// TODO Auto-generated constructor stub
	}






	//	@SuppressWarnings("unchecked")
	/**
	 * 
	 * This method will return the list of providers set in the object
	 * @return List<Provider>
	 */
	public List<Provider> getProviders() {
		//List<Provider> providers = new ArrayList<>();
		
		return new ArrayList<>(proceduresByProvider.keySet());
	}
	
	
	/**
	 * This method will return the list of procedures by provider
	 * @param Provider provider
	 * @return List<Procedure>
	 */
	public List<Procedure> getProcedures(Provider provider) {
		return proceduresByProvider.get(provider);
	}
	
	/**
	 * This method will set a list of procedures with a specific provider
	 * @param Procedure procedures
	 * @param Provider provider
	 */
	public void setProcedures(List<Procedure> procedures, Provider provider) {
		if(procedures == null || procedures.isEmpty()) {
			throw new IllegalArgumentException("\"procedures\" cannot be null or empty");
		}
		this.proceduresByProvider.put(provider, procedures);
	}
	
	/**
	 * This method will return a string of all the information in the method
	 * return String
	 */
	@Override
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
