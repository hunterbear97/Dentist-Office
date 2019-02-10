package edu.neumont.lytle.dentistoffice.view;

import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.Procedure;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.User;

public interface UserInterface {
	
	String inputUsername();
	
	String inputPassword();
	
	int userMenuSelection(boolean isAdmin);
	
	PatientSearchCriteria searchPatients();
	
	ProviderSearchCriteria searchProviders();
	
	AppointmentSearchCriteria searchAppointments(Provider prov, Patient pat);
	
	Patient addPatient();
	
	int removePatient();
	
	void editPatient(Patient patient);
	
	Provider addProvider();
	
	void editProvider(Provider provider);

	int removeProvider();
	
	Procedure addProcedure();
	
	String removeProcedure();
	
	Appointment addAppointment(Patient pat);
	
	void editAppointment(Appointment appointment);
	
	Appointment removeAppointment();
	
	int adminMenu();
	
	String removeUser();
	
	User addUser();
	
	void noFoundUser();
	
	void invalidPassword();
	
	int printMent();
	
	void printList(String string);

	int getPatientUID();

	void editProcedure(Procedure procedure);

	void changePassword(User user);
	
}