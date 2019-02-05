package edu.neumont.lytle.dentistoffice.controller;

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
import edu.neumont.lytle.dentistoffice.view.UserInteraction;

public class ClinicManager {
	Clinic clinic = new Clinic();
	
	UserInteraction ui;
	
	public void run(UserInteraction ui) {
		if(ui == null) {
			throw new IllegalArgumentException("\"ui\" cannot be null");
		}
		this.ui = ui;
		
		User user = login();
		boolean wantsToExit = false;
		do {
			int userChoice = ui.userMenuSelection(user.getRole() == UserRole.Admin);
			if(userChoice == 1) {
				//TODO decide order of menu choices
			}
			else if(userChoice == 2) {
				
			}
			else {
				wantsToExit = true;
			}
			
		}while(!wantsToExit);
	}
	
	private User login() {
		List<User> users = clinic.getUsers();
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
		PatientSearchCriteria psc  = ui.searchPatients();
		
		List<Patient> patients = clinic.searchPatients(psc);
		
		//TODO ToString and display;
	}
	
	private void searchProviders() {
		ProviderSearchCriteria psc  = ui.searchProviders();
		
		List<Provider> providers = clinic.searchProviders();
		
		//TODO ToString and display;
	}
	
	private void searchAppointments() {
		AppointmentSearchCriteria asc = ui.searchAppointments();
		
		List<Appointment> appointments = clinic.searchAppointments(asc);
	}
	
	private void addPatient() {
		Patient p = ui.addPatient();
		
		//TODO create addPatient() in clinic
	}
	
	private void addProvider() {
		Provider p = ui.addProvider();
		
		//TODO create addProvider class in clinic
	}
	
	private void addAppointment() {
		Appointment a = ui.addAppointment();
		
		//TODO create addAppointment class in clinic
	}
	
	

}
