package edu.neumont.lytle.dentistoffice.view;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	int selectPatient(int patientAmount);
	
	void editPatient(Patient patient);
	
	Provider addProvider();
	
	void editProvider(Provider provider);

	int selectProvider(int providersAmount);
	
	Procedure addProcedure();
	
	String removeProcedure();
	
	Appointment addAppointment(Patient pat);
	
	void editAppointment(Appointment appointment);
	
	int selectAppointment(int ammountOfAppointments);
		
	int selectUser(int amountOfUsers);
	
	User addUser();
	
	void noFoundUser();
	
	void invalidPassword();
	
	void printList(String string);

	int getPatientUID();

	void editProcedure(Procedure procedure);

	void changePassword(User user);

	String getProcedureCode();

	boolean askForProviderSelection();

	boolean askForPatientSelection();
	
	LocalDateTime promptForStartDateTime();
	
	LocalDateTime promptForEndDateTime();
	
	LocalDate promptForStartDate();
	
	LocalDate promptForEndDate();
	
	boolean promptDayOrMonth();
//	int promptForYear();
//	
//	int promptForDay();
//	
//	int promptForMonth();
}