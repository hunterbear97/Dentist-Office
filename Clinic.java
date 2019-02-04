package edu.neumont.lytle.dentistoffice.models;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

	private List<User> users = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<PaymentCard> payments = new ArrayList<>();
	private List<Provider> providers = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	
	public Clinic() {}
	
	
	
	public List<Appointment> getFutureAppointment(){
		return appointments;
	}
	
	public List<Appointment> getPastAppointment(){
		return appointments;
	}
	
	public List<Provider> searchProviders(){
		return providers;
	}
	
	public void recievePayment(PaymentCard payment) {
		payments.add(payment);
	}
	
	public double getAccountBalance(int uniqueId) {
		return 0;
	}
	
	public List<Patient> searchPatients(PatientSearchCriteria criteria) {
		List<Patient> patients = new ArrayList<>();
		for(Patient p : this.patients) {
			if(criteria.getFirstName().equals(p.getFirstName()) ||
					criteria.getLastName().equals(p.getLastName()) ||
					criteria.getCompanyName().equals(p.getInsurance().getCompany())) {
				patients.add(p);
			}
		}
		return patients;
	}
	
	public List<Appointment> searchAppointments(AppointmentSearchCriteria criteria){
		// no start date or end date , defaults to everything
		
		//
		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : this.appointments) {
			if(criteria.getStartDate().isBefore(a.getAppointmentDate())) {
				appointments.add(a);
			}
			else if(criteria.getEndDate().isAfter(a.getAppointmentDate())) {
				appointments.add(a);
			}
			else if(criteria.getProvider().equals()) {
				appointments.add(a);
				//get provider from appointment, before or after
			}
			else if(criteria.getPatient().equals()) {
				//get patient from appointment
			}
			else if(criteria.getProcedureCode().equals()) {
				//get procedure code form appointment
			}
		}
		return appointments;
		
	}
}
