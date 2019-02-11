package edu.neumont.lytle.dentistoffice.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Clinic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DIRECTORY = "clinics";
	
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
	 * This method will take in an instance of Provider and add it into the system
	 * @param Provider provider
	 */
	public void addProvider(Provider provider) {
		if(provider == null) {
			throw new IllegalArgumentException("\"provider\" cannot be null");
		}
		providers.add(provider);
	}
	
	/**
	 * This method will take in an instance of Patient and add it into the system
	 * @param Patient patient
	 */
	public void addPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("\"patient\" cannot be null");
		}
		patients.add(patient);
	}
	
	/**
	 * This method will take in an instance of User and add it into the system
	 * @param User user
	 */
	public void addUser(User user) {
		if(user == null) {
			throw new IllegalArgumentException("\"user\" cannot be null");
		}
		users.add(user);
	}
	
	/**
	 * This method will take in an instance of Appointment and add it into the system
	 * @param Appointment appointment
	 */
	public void addAppointment(Appointment appointment) {
		if(appointment == null) {
			throw new IllegalArgumentException("\"appointment\" cannot be null");
		}
		appointments.add(appointment);
	}
	
	/**
	 * This method will add a payment into the list of payments	
	 * @param Payment payment
	 */
	public void recievePayment(Payment payment) {
		if(payment == null) {
			throw new IllegalArgumentException("\"payment\" cannot be null");
		}
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
					if(asc.getProvider() != null)
					{
						if(!p.getProvider().equals(asc.getProvider())) {
							removeThis = true;
						}
					}
					if(asc.getProcedureCode() != null) {
						if(!p.getProcedure().getCode().equals(asc.getProcedureCode())) {
							removeThis = true;
						}
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
	 * This method will take in a list of providers and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<Provider> list
	 * @return String
	 */
	public String providersToString(List<Provider> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will take in a list of patients and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<Patient> list
	 * @return String
	 */
	public String patientsToString(List<Patient> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will take in a list of appointments and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<Appointment> list
	 * @return String
	 */
	public String appointmentsToString(List<Appointment> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will take in a list of users and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<User> list
	 * @return String
	 */
	public String usersToString(List<User> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will take in a list of providers and print them out so that every object getsit's own line and has its index right next to it.
	 * @param List<Payment> list
	 * @return String
	 */
	public String paymentsToString(List<Payment> list) {
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(i).append(": ").append(list.get(i)).append("\n");
		}
		
		return sb.toString();
	}

	/**
	 * This method will take in a start date and end date, and then return how much revenue was generated during that time.
	 * Depending on the boolean, it can either be daily totals or monthly totals
	 * @param LocalDateTime startDate
	 * @param LocalDateTime endDate
	 * @param boolean dailyRevenue
	 * @return String
	 */
	public String getRevenueGenerated(LocalDateTime startDate, LocalDateTime endDate, boolean dailyRevenue) {
		StringBuilder sb = new StringBuilder();
		AppointmentSearchCriteria asc = new AppointmentSearchCriteria();
		asc.setStartDate(startDate);
		asc.setEndDate(endDate);
		
		List<Appointment> appointments = this.searchAppointments(asc);
		List<AppointmentRecord> records = new ArrayList<>();
		
		for(Appointment a : appointments) {
			if(a instanceof AppointmentRecord) {
				records.add((AppointmentRecord) a);
			}
		}
		
		int monthCompareInt = endDate.getMonthValue();
		
		if(endDate.getYear() - startDate.getYear() != 0) {
			monthCompareInt += (endDate.getYear() - startDate.getYear()) * 12;
		}
		
		if(!dailyRevenue) {
			
			for(int m = startDate.getMonthValue(); m <= monthCompareInt; m++) {
				sb.append("Month ").append(m%12).append(" revanue: $");
				double total = 0;
				
				
				for(AppointmentRecord ar : records) {
					if(ar.getAppointmentDate().getMonthValue() == m){
						List<ProcedureRecord> procedures = ar.getProcedures();
						for(ProcedureRecord p :procedures) {
							total += p.getCost();
						}
					}
				}
				
				sb.append(total).append("\n");
				
			}
			
		}
		
		
		else if(dailyRevenue) {
			LocalDateTime next = startDate.minusDays(1);
			while((next = next.plusDays(1)).isBefore(endDate.plusDays(1))){
				double total = 0;
				sb.append(next.toString()).append(" revanue: $");
				for(AppointmentRecord ar : records) {
					if(ar.getAppointmentDate().equals(next)){
						List<ProcedureRecord> procedures = ar.getProcedures();
						for(ProcedureRecord p :procedures) {
							total += p.getCost();
						}
					}
				}
				
				sb.append(total).append("\n");
				
			}
			
		}
		
		return sb.toString();
	}
	
	
	/**
	 * This method will take a start date and an end date and return how much money was collected during that time. Depending on the boolean, it can either be daily or monthly totals.
	 * @param LocalDate startDate
	 * @param LocalDate endDate
	 * @param boolan dailyRevenue
	 * @return String
	 */
	public String getCollections(LocalDate startDate, LocalDate endDate, boolean dailyRevenue) {
		StringBuilder sb = new StringBuilder();
		
		List<Payment> paymentsInQuestion = new ArrayList<>();
		
		for(Payment p : payments) {
			if(p.getDateOfPayment().isBefore(endDate) && p.getDateOfPayment().isAfter(startDate)) {
				paymentsInQuestion.add(p);
			}
		}
		
		int monthCompareInt = endDate.getMonthValue();
		
		if(endDate.getYear() - startDate.getYear() != 0) {
			monthCompareInt += (endDate.getYear() - startDate.getYear()) * 12;
		}
		
		if(!dailyRevenue) {
			
			for(int m = startDate.getMonthValue(); m <= monthCompareInt; m++) {
				sb.append("Month ").append(m%12).append(" collections: $");
				double total = 0;
				
				
				for(Payment p : paymentsInQuestion) {
					if(p.getDateOfPayment().getMonthValue() == m){
						total += p.getAmount();
					}
				}
				
				sb.append(total).append("\n");
				
			}
			
		}
		
		
		else if(dailyRevenue) {
			LocalDate next = startDate.minusDays(1);
			while((next = next.plusDays(1)).isBefore(endDate.plusDays(1))){
				double total = 0;
				sb.append(next.toString()).append(" collections: $");
				for(Payment p : paymentsInQuestion) {
					if(p.getDateOfPayment().equals(next)){
						total += p.getAmount();
					}
				}
				
				sb.append(total).append("\n");
				
			}
			
		}
		
		return sb.toString();
	}
	
	/**
	 * This method will save the Clinic to the file clinics/clinic.db
	 * @throws IOException
	 */
	public void saveClinic() throws IOException {
		makeDirIfNotExists();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DIRECTORY + "\\clinic.db"));
		out.writeObject(this);
		out.close();
	}

	private void makeDirIfNotExists() {
		// TODO Auto-generated method stub
		
		File dir = new File(DIRECTORY);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
	}
	
	/**
	 * This method will load a Clinic from clinics/clinic.db
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadClinic() throws IOException, ClassNotFoundException{
		Clinic newClinic = loadDb();
		this.appointments.clear();
		this.appointments.addAll(newClinic.appointments);
		this.patients.clear();
		this.patients.addAll(newClinic.patients);
		this.payments.clear();
		this.payments.addAll(newClinic.payments);
		this.providers.clear();
		this.providers.addAll(newClinic.providers);
		this.users.clear();
		this.users.addAll(newClinic.users);
		
		
	}
	
	private static Clinic loadDb() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(DIRECTORY + "\\clinic.db"));
		Clinic newClinic = (Clinic) in.readObject();
		in.close();
		return newClinic;
	}
	
}
