package edu.neumont.lytle.dentistoffice.models;

import java.util.List;

import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Clinic;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.User;
import edu.neumont.lytle.dentistoffice.models.UserRole;
import edu.neumont.lytle.dentistoffice.view.UserInterface;

public class ClinicManager {
	Clinic clinic = new Clinic();
	
	UserInterface ui;
	
	User currentUser;
	
	public void run(UserInterface ui) {
		if(ui == null) {
			throw new IllegalArgumentException("\"ui\" cannot be null");
		}
		this.ui = ui;
		
		currentUser = login();
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
				//searchPatients();
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
				//searchProviders();
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
				//searchProcedures();
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
				//searchAppointments();
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
				//searchUsers();
			}
			else {
				wantsToExit = true;
			}
			
		}while(!wantsToExit);
	}
	
	private User login() {
		List<User> users = clinic.getUsers();
		if(users.isEmpty()) {
			Admin administrator = new Admin("Administrator", "1234Password", UserRole.Admin);
			clinic.addUser(administrator);
		}
		User userInQuestion = null;
		do {
			String userName = ui.inputUsername();
			
			for(User u : users) {
				if(u.getUserName().equals(userName)) {
					userInQuestion = u;
				}
			}
			
			if(userInQuestion == null) {
				ui.noFoundUser();
			}
		}while(userInQuestion == null);
		boolean correctPassword = false;
		do{
			String password = ui.inputPassword();
			if(password.equals(userInQuestion.getPassword())) {
				correctPassword = true;
			}
			else {
				ui.invalidPassword();
			}
			
		}while(!correctPassword);
		
		return userInQuestion;
	}
	
	private void searchPatients() {
		PatientSearchCriteria psc = ui.searchPatients();
		
		List<Patient> patients = clinic.searchPatients(psc);
		
		//TODO ToString and display;
	}
	
	private void searchProviders() {
		ProviderSearchCriteria psc  = ui.searchProviders();
		
		List<Provider> providers = clinic.searchProviders(psc);
		
		//TODO ToString and display;
	}
	
	private void searchAppointments() {
		Provider prov = getProvider();
		Patient pat = getPatient();
		AppointmentSearchCriteria asc = ui.searchAppointments(prov, pat);
		
		List<Appointment> appointments = clinic.searchAppointments(asc);
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
		Patient p = getPatient();
		List<Patient> patients = clinic.getPatients();
		patients.remove(p);
	}
	
	private void editPatient() {
		Patient p = getPatient();
		ui.editPatient(p);
	}
	
	private void addProvider() {
		Provider p = ui.addProvider();
		clinic.addProvider(p);
	}
	
	private Provider getProvider() {
		Provider p = null;
		int uid = ui.removeProvider();
		List<Provider> providers = clinic.getProviders();
		for(Provider prov : providers) {
			if(prov.getUid() == uid) {
				p = prov;
			}
			break;
		}
		return p;
	}
	
	private void removeProvider() {
		Provider p = getProvider();
		List<Provider> providers = clinic.getProviders();
		providers.remove(p);
	}
	
	private void editProvider() {
		Provider p = getProvider();
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
		//TODO create addAppointment class in clinic
	}
	
	private void removeAppointment() {
		Appointment a = ui.removeAppointment();
		List<Appointment> appointments = clinic.getAppointments();
		appointments.remove(a);
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
		User user = getUser();
		List<User> users = clinic.getUsers();
		users.remove(user);
	}
	
	private void changePassword() {
		User user = currentUser;
		if(user.getRole().equals(UserRole.Admin)) {
			user = getUser();			
		}
		ui.changePassword(user);
	}
	

}
