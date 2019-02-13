package edu.neumont.lytle.dentistoffice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import edu.neumont.lytle.dentistoffice.models.Admin;
import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Clinic;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Procedure;
import edu.neumont.lytle.dentistoffice.models.ProcedureSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.User;
import edu.neumont.lytle.dentistoffice.models.UserRole;
import edu.neumont.lytle.dentistoffice.view.UserInterface;

public class ClinicManager {
	Clinic clinic = new Clinic();
	
	UserInterface ui;
	
	User currentUser;
	
	public void run(UserInterface ui) throws ClassNotFoundException, IOException {
		if(ui == null) {
			throw new IllegalArgumentException("\"ui\" cannot be null");
		}
		this.ui = ui;
		
		//File f = new File("clinic\\clinic.db");
		//if(f.exists()) {
			clinic.loadClinic();
		//}
		login();
		boolean wantsToExit = false;
		do {
			int userChoice = ui.userMenuSelection(currentUser.getRole() == UserRole.Admin);
			if(userChoice == 1) {
				addPatient();
			}
			else if(userChoice == 2) {
				removePatient();
			}
			else if(userChoice == 3) {
				editPatient();
			}
			else if(userChoice == 4) {
				ui.printList(clinic.patientsToString(searchPatients()));
			}
			else if(userChoice == 5) {
				addProvider();
			}
			else if(userChoice == 6) {
				removeProvider();
			}
			else if(userChoice == 7) {
				editProvider();
			}
			else if(userChoice == 8) {
				ui.printList(clinic.providersToString(searchProviders()));
			}
			else if(userChoice == 9) {
				addProcedure();
			}
			else if(userChoice == 10) {
				removeProcedure();
			}
			else if(userChoice == 11) {
				editProcedure();
			}
			else if(userChoice == 12) {
				ui.printList(clinic.proceduresToString(searchProcedures()));
			}
			else if(userChoice == 13) {
				addAppointment();
			}
			else if(userChoice == 14) {
				removeAppointment();
			}
			else if(userChoice == 15) {
				editAppointment();
			}
			else if(userChoice == 16) {
				ui.printList(clinic.appointmentsToString(searchAppointments()));
			}
			else if(userChoice == 17) {
				changePassword();
			}
			else if(userChoice == 18) {
				addUser();
			}
			else if(userChoice == 19) {
				removeUser();
			}
			else if(userChoice == 20) {
				ui.printList(clinic.usersToString(clinic.getUsers()));
			}
			else {
				wantsToExit = true;
			}
			
		}while(!wantsToExit);
		
		clinic.saveClinic();
	}
	
	private void login() {
		List<User> users = clinic.getUsers();
		if(users.isEmpty()) {
			Admin administrator = new Admin("Administrator", "1234Password", UserRole.Admin);
			clinic.addUser(administrator);
		}
		do {
			String userName = ui.inputUsername();
			
			for(User u : users) {
				if(u.getUserName().equals(userName)) {
					currentUser = u;
				}
			}
			
			if(currentUser == null) {
				ui.noFoundUser();
			}
		}while(currentUser == null);
		boolean correctPassword = false;
		do{
			String password = ui.inputPassword();
			if(password.equals(currentUser.getPassword())) {
				correctPassword = true;
			}
			else {
				ui.invalidPassword();
			}
			
		}while(!correctPassword);
		if(currentUser.getPassword().equals("1234Password")) {
			changePassword();
		}
	}
	
	private List<Patient> searchPatients() {
		PatientSearchCriteria psc = ui.searchPatients();
		
		List<Patient> patients = clinic.searchPatients(psc);
		return patients;
	}
	
	private List<Provider> searchProviders() {
		ProviderSearchCriteria psc  = ui.searchProviders();
		
		List<Provider> providers = clinic.searchProviders(psc);
		return providers;
		
	}
	
	private List<Appointment> searchAppointments() {
		boolean wantsProvider = ui.askForProviderSelection();
		Provider prov = null;
		Patient pat = null;
		if(wantsProvider) {
			int providerIndex = ui.selectProvider(clinic.getProviders().size());
			prov = clinic.getProvider(providerIndex);
		}
		boolean wantsPatient = ui.askForPatientSelection();
		if(wantsPatient) {
			int patientIndex = ui.selectPatient(clinic.getPatients().size());
			pat  = clinic.getPatient(patientIndex);
		}
		
		
		AppointmentSearchCriteria asc = ui.searchAppointments(prov, pat);
		
		List<Appointment> appointments = clinic.searchAppointments(asc);
		return appointments;
	}
	

	private List<Procedure> searchProcedures() {
		ProcedureSearchCriteria psc  = new ProcedureSearchCriteria(ui.getProcedureCode());
		
		List<Procedure> procedures = clinic.searchProcedures(psc);
		return procedures;
	}

	
	private void addPatient() {
		Patient p = ui.addPatient();
		clinic.addPatient(p);
	}
	
	private Patient getPatient() {
		Patient p = null;
		int uid = ui.getPatientUID();
		List<Patient> patients = clinic.getPatients();
		for(Patient pat : patients) {
			if(pat.getUid() == uid) {
				p = pat;
			}
			break;
		}
		if(p == null) {
			ui.noFoundUser();
		}
		return p;
	}
	
	private void removePatient() {
		List<Patient> patients = clinic.getPatients();
		ui.printList(clinic.patientsToString(patients));
		int patientIndex = ui.selectPatient(patients.size());
		patients.remove(patientIndex);
	}
	
	private void editPatient() {
		Patient p = getPatient();
		ui.editPatient(p);
	}
	
	private void addProvider() {
		Provider p = ui.addProvider();
		clinic.addProvider(p);
	}
	
//	private Provider getProvider() {
//		Provider p = null;
//		int uid = ui.removeProvider();
//		List<Provider> providers = clinic.getProviders();
//		for(Provider prov : providers) {
//			if(prov.getUid() == uid) {
//				p = prov;
//			}
//			break;
//		}
//		return p;
//	}
	
	private void removeProvider() {
		ui.printList(clinic.providersToString(clinic.getProviders()));
		int providerIndex = ui.selectProvider(clinic.getProviders().size());
		clinic.removeProvider(providerIndex);
	}
	
	private void editProvider() {
		int selectedProvider = ui.selectProvider(clinic.getProviders().size());
		Provider p = clinic.getProvider(selectedProvider);
		ui.editProvider(p);
	}
	
	private void addProcedure() {
		Procedure p = ui.addProcedure();
		clinic.addProcedure(p);
	}
	
	private Procedure getProcedure() {
		Procedure p = null;
		String code = ui.removeProcedure();
		List<Procedure> procedures = clinic.getProcedures();
		for(Procedure proc : procedures) {
			if(proc.getCode().equals(code)) {
				p = proc;
			}
			break;
		}
		return p;
	}
	
	private void removeProcedure() {
		Procedure p = getProcedure();
		List<Procedure> procedures = clinic.getProcedures();
		procedures.remove(p);
	}
	
	private void editProcedure() {
		Procedure p = getProcedure();
		ui.editProcedure(p);
	}
	
	private void addAppointment() {
		Patient pat = getPatient();
		Appointment a = ui.addAppointment(pat);
		clinic.addAppointment(a);
	}
	
	private void removeAppointment() {
		ui.printList(clinic.appointmentsToString(clinic.getAppointments()));
		int appointmentSelected = ui.selectAppointment(clinic.getAppointments().size());
		List<Appointment> appointments = clinic.getAppointments();
		appointments.remove(appointmentSelected);
	}
	
	private void editAppointment() {
		
	}
	
	private void addUser() {
		User user = ui.addUser();
		clinic.addUser(user);
	}
	
	private User getUser() {
		User user = null;
		String username = ui.inputUsername();
		List<User> users = clinic.getUsers();
		for(User u : users) {
			if(u.getUserName().equals(username)) {
				user = u;
			}
			break;
		}
		return user;
	}
	
	private void removeUser() {
		ui.printList(clinic.usersToString(clinic.getUsers()));
		int userIndex = ui.selectUser(clinic.getUsers().size());
		clinic.removeUser(userIndex);
	}
	
	private void changePassword() {
		User user = currentUser;
		if(user.getRole() == UserRole.Admin && !user.getPassword().equals("1234Password")) {
			user = getUser();			
		}
		ui.changePassword(user);
	}
	

}
