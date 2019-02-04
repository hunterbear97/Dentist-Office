package edu.neumont.lytle.dentistoffice.view;

import edu.neumont.lytle.dentistoffice.model.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.User;

public interface UserInteraction {
	
	void inputUsernameAndPassword();
	
	int userMenuSelection();
	
	PatientSearchCriteria searchPatients();
	
	ProviderSearchCriteria searchProviders();
	
	AppointmentSearchCriteria searchAppointments();
	
	int adminMenu();
	
	User removeUser();
	
	User addUser();
	
	String changePassword();
}
