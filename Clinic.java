package edu.neumont.lytle.dentistoffice.models;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

	private List<User> users = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<Provider> providers = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	
	/**
	 * This method will retrieve the list of users in the clinic
	 * @return List<User>
	 */
	public List<User> getUsers() {
		return this.users;
	}
	
	/**
	 * This method will return the list of patients currently in the Clinic
	 * @return List<Patient>
	 */
	public List<Patient> getPatients() {
		return patients;
	}
	
	/**
	 * This method will return the list of payments in the system
	 * @return List<Payments>
	 */
	public List<Payment> getPayments() {
		return this.payments;
	}
	
	/**
	 * This method will return the list of providers in the system
	 * @return List<Provider>
	 */
	public List<Provider> getProviders() {
		return this.providers;
	}
	
	/**
	 * This will return the list of appointments, both past and future, in the system
	 * @return List<Appointment>
	 */
	public List<Appointment> getAppointments() {
		return this.appointments;
	}
	
	/**
	 * This method goes through all appointments and returns what is upcoming
	 * @return List<FutureAppointment>
	 */
	public List<FutureAppointment> getFutureAppointment(){
		List<FutureAppointment> futureAppointments = new ArrayList<>();
		for(Appointment a : appointments) {
			if(a instanceof FutureAppointment) {
				futureAppointments.add((FutureAppointment) a);
			}
		}
		return futureAppointments;
	}
	
	/**
	 * This Method goes through the list of appointments and returns what has already happened
	 * @return List<AppointmentRecord>
	 */
	public List<AppointmentRecord> getPastAppointment(){
		List<AppointmentRecord> pastAppointments = new ArrayList<>();
		for(Appointment a : appointments) {
			if(a instanceof AppointmentRecord) {
				pastAppointments.add((AppointmentRecord) a);
			}
		}
		
		return pastAppointments;
	}
	
	/**
	 * This method will take in search criteria for finding a provider and return a list of providers that meet that criteria
	 * @param ProviderSearchCriteria psc
	 * @return List<Provider>
	 */
	
	public List<Provider> searchProviders(ProviderSearchCriteria psc){
		List<Provider> providers = new ArrayList<>(this.providers);
		
		for(Provider p : new ArrayList<>(providers)) {
			boolean removeThis = false;
			if(psc.getFirstName() != null) {
				if(!psc.getFirstName().equals(p.getFirstName())) {
					removeThis = true;
				}
			}
			if(psc.getLastName() != null) {
				if(!psc.getLastName().equals(p.getLastName())) {
					removeThis = true;
				}
			}
			if(psc.getTitle() != null) {
				if(!psc.getTitle().equals(p.getTitle())) {
					removeThis = true;
				}
			}
			
			if(removeThis) {
				providers.remove(p);
			}
		}
		
		return providers;
	}
	
	/**
	 * This method will add a payment into the list of payments	
	 * @param Payment payment
	 */
	public void recievePayment(Payment payment) {
		payments.add(payment);
	}
	
	private Patient getPatient(int uniqueID) {
		
		Patient patient = null;
		
		for(Patient p : patients) {
			if(p.getUid() == uniqueID) {
				patient = p;
			}
		}
		
		return patient;
	}
	
	/**
	 * This method will take in the unique ID of a patient and return the total balance owed to the clinic;
	 * @param int uniqueId
	 * @return double
	 */
	public double getAccountBalance(int uniqueId) {
		
		Patient patient = getPatient(uniqueId);
		double total = 0;
		
		List<AppointmentRecord> list = this.getPastAppointment();
		
		for(AppointmentRecord ar: list) {
			if(ar.getPatient() == patient) {
				List<ProcedureRecord> procedures = ar.getProcedures();
				for(ProcedureRecord p : procedures) {
					total += p.getCost();
				}
			}
		}
		
		for(Payment p : payments) {
			if(p.getPatient() == patient) {
				total -= p.getAmount();
			}
		}
		
		return total;
	}
	
	/**
	 * This method will take in the criteria to find a patient and return a list of the patients that fit the criteria
	 * 
	 * @param PatientSearchCriteria criteria
	 * @return List<Patient>
	 */
	public List<Patient> searchPatients(PatientSearchCriteria criteria) {
		List<Patient> patients = new ArrayList<>(this.patients);
		for(Patient p : new ArrayList<>(patients)) {
			boolean removeThis = false;
			if(criteria.getFirstName() != null) {
				if(!criteria.getFirstName().equals(p.getFirstName())) {
					removeThis = true;
				}
			}
			if(criteria.getLastName() != null) {
				if(!criteria.getLastName().equals(p.getLastName())) {
					removeThis = true;
				}
			}
			if(criteria.getCompanyName() != null) {
				if(!criteria.getCompanyName().equals(p.getInsurance().getCompany())) {
					removeThis = true;
				}
			}
			
			if(removeThis) {
				patients.remove(p);
			}
		}
		return patients;
	}
	
	
	/**
	 * This method will take in criteria to find the appointments laid out by the criteria
	 * @param AppointmentSearchCriteria criteria
	 * @return List<Appointment>
	 */
	public List<Appointment> searchAppointments(AppointmentSearchCriteria criteria){
		// no start date or end date , defaults to everything
		
		//
		List<Appointment> appointments = new ArrayList<>();
		List<FutureAppointment> futureAppointments = this.searchFutureAppointments(criteria);
		List<AppointmentRecord> appointmentRecords = this.searchPastAppointments(criteria);
		appointments.addAll(appointmentRecords);
		appointments.addAll(futureAppointments);
		return appointments;
		}
	
	private List<FutureAppointment> searchFutureAppointments(AppointmentSearchCriteria asc){
		List<FutureAppointment> futureAppointments = this.getFutureAppointment();
		for(FutureAppointment a : new ArrayList<>(futureAppointments)) {
			boolean removeThis = false;
			
			if(!asc.getStartDate().isBefore(a.getAppointmentDate())) {
				removeThis = true;
			}
			else if(!asc.getEndDate().isAfter(a.getAppointmentDate())) {
				removeThis = true;
			}
			if(asc.getPatient() != null) {
				
				if(!asc.getPatient().equals(a.getPatient())) {
					removeThis = true;				
				}
			}
			if(asc.getProvider() != null) {
					
					
				List<Provider> appointmentProviders = a.getProviders();
				for(Provider p : appointmentProviders) {
					if(!asc.getProvider().equals(p)) {
						removeThis = true;
					}
						
					if(asc.getProcedureCode() != null) {
							
						List<Procedure> procedures = a.getProcedures(p);
							
						for(Procedure q : procedures) {
							if(!asc.getProcedureCode().equals(q.getCode())) {
								removeThis = true;
							}
						}
					}
				}
			}
				if(asc.getProvider() == null && asc.getProcedureCode() != null) {
					for(Provider p : this.providers) {
					List<Procedure> procedures = a.getProcedures(p);
					for(Procedure q : procedures) {
						if(!asc.getProcedureCode().equals(q.getCode())) {
							removeThis = true;
						}
					}
				}
			
			}
			if(removeThis) {
				futureAppointments.remove(a);
			}
		}
		return futureAppointments;
	}
	
	private List<AppointmentRecord> searchPastAppointments(AppointmentSearchCriteria asc){
		List<AppointmentRecord> pastAppointments = this.getPastAppointment();
		for(AppointmentRecord a : new ArrayList<>(pastAppointments)) {
			boolean removeThis = false;
			if(!asc.getStartDate().isBefore(a.getAppointmentDate())) {
				removeThis = true;
			}
			else if(!asc.getEndDate().isAfter(a.getAppointmentDate())) {
				removeThis = true;
			}
			if(asc.getPatient() != null) {
				
				if(!asc.getPatient().equals(a.getPatient())) {
					removeThis = true;				
				}
			}
			if(asc.getProvider() != null || asc.getProcedureCode() != null) {
				List<ProcedureRecord> procedures = a.getProcedures();
				for(ProcedureRecord p : procedures) {
					if(!p.getProvider().equals(asc.getProvider())) {
						removeThis = true;
					}
					
					if(!p.getProcedure().getCode().equals(asc.getProcedureCode())) {
						removeThis = true;
					}
				}
			}
			
			if(removeThis) {
				pastAppointments.remove(a);
			}
		}
		
		return pastAppointments;
	}

	/**
	 * This method will take in a list of any object and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<Object> list
	 * @return String
	 */
	public String listToString(List<Object> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}
}
