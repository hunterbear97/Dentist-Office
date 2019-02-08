package edu.neumont.lytle.dentistoffice.view;

import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.User;

public interface UserInteraction {
	
	String inputUsername();
	
	String inputPassword();
	
	int userMenuSelection(boolean isAdmin);
	
	PatientSearchCriteria searchPatients();
	
	ProviderSearchCriteria searchProviders();
	
	AppointmentSearchCriteria searchAppointments();

	Patient addPatient();
	
	Patient removePatient();
	
	void editPatient(Patient patient);
	
	Provider addProvider();
	
	void editProvider(Provider provider);

	Provider removeProvider();
	
	Appointment addAppointment();
	
	void editAppointment(Appointment appointment);
	
	Appointment removeAppointment();
	
	int adminMenu();
	
	User removeUser();
	
	User addUser();
	
	String changePassword();
	
	void noFoundUser();
	
	void invalidPassword();
	
	int printMent();
	
	void printList(String string);
	
}
