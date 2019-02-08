package edu.neumont.lytle.dentistoffice.view;

import java.time.LocalDateTime;
import java.time.YearMonth;

import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.InsuranceInfo;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.PaymentCard;
import edu.neumont.lytle.dentistoffice.models.Person;
import edu.neumont.lytle.dentistoffice.models.PhoneNumber;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.ProviderType;
import edu.neumont.lytle.dentistoffice.models.User;
import lib.ConsoleIO;

public class UserInteraction implements UserInterface{

	@Override
	public String inputUsername() {
		return ConsoleIO.promptForInput("Enter Username: ", false);
	}

	@Override
	public String inputPassword() {
		return ConsoleIO.promptForInput("Enter Password: ", false);
	}

	@Override
	public int userMenuSelection(boolean isAdmin) {
		if(isAdmin) {
			String[] options = {"Add Patient", "Remove Patient", "Edit Patient", "View Patients",
								"Add Provider", "Remove Provider", "Edit Provider", "View Providers",
								"Add Procedure", "Remove Procedure", "Edit Procedure", "View Procedures",
								"Add Appointment", "Remove Appointment", "Edit Appointment", "View Appointments",
								"Add User", "Remove User", "Change User Password"};
			return ConsoleIO.promptForInt("Enter your choice: ", 0, options.length);
		}
		else {
			String[] options = {"Add Patient", "Remove Patient", "Edit Patient", "View Patients",
								"Add Provider", "Remove Provider", "Edit Provider", "View Providers",
								"Add Procedure", "Remove Procedure", "Edit Procedure", "View Procedures",
								"Add Appointment", "Remove Appointment", "Edit Appointment", "View Appointments"};
			return ConsoleIO.promptForInt("Enter your choice: ", 0, options.length);
		}
	}

	@Override
	public PatientSearchCriteria searchPatients() {
		String firstName = ConsoleIO.promptForInput("Enter the first name or leave empty: ", true);
		String lastName = ConsoleIO.promptForInput("Enter the last name or leave empty: ", true);
		String company = ConsoleIO.promptForInput("Enter the Insurance company name or leave empty: ", true);
		PatientSearchCriteria psc = new PatientSearchCriteria(firstName, lastName, company);
		return psc;
	}

	@Override
	public ProviderSearchCriteria searchProviders() {
		String firstName = ConsoleIO.promptForInput("Enter the first name or leave empty: ", true);
		String lastName = ConsoleIO.promptForInput("Enter the last name or leave empty: ", true);
		String[] options = {ProviderType.Assistant.toString(), ProviderType.Dentist.toString(), ProviderType.Hygenist.toString()};
		int title = ConsoleIO.promptForMenuSelection(options, false);
		ProviderType pt = null;
		if(title == 1) {
			pt = ProviderType.Assistant;
		}
		else if(title == 2) {
			pt = ProviderType.Dentist;
		}
		else if(title == 3) {
			pt = ProviderType.Hygenist;
		}
		ProviderSearchCriteria psc = new ProviderSearchCriteria(firstName, lastName, pt);
		return psc;
	}

	@Override
	public AppointmentSearchCriteria searchAppointments() {
		int year = ConsoleIO.promptForInt("Enter the start year: ", 1950, 2050);
		int month = ConsoleIO.promptForInt("Enter the start month: ", 1, 12);
		int day = ConsoleIO.promptForInt("Enter the start day: ", 1, 31);
		int hour = ConsoleIO.promptForInt("Enter the start hour: ", 0, 23);
		int minute = ConsoleIO.promptForInt("Enter the start day: ", 0, 59);
		LocalDateTime start = LocalDateTime.of(year, month, day, hour, minute);
		year = ConsoleIO.promptForInt("Enter the end year: ", 1950, 2050);
		month = ConsoleIO.promptForInt("Enter the end month: ", 1, 12);
		day = ConsoleIO.promptForInt("Enter the end day: ", 1, 31);
		hour = ConsoleIO.promptForInt("Enter the end hour: ", 0, 23);
		minute = ConsoleIO.promptForInt("Enter the end day: ", 0, 59);
		LocalDateTime end = LocalDateTime.of(year, month, day, hour, minute);
		
		//provider, patient, procedure code
		AppointmentSearchCriteria apc = new AppointmentSearchCriteria();
		return apc;
	}
	
	@Override
	public Patient addPatient() {
		String firstName = ConsoleIO.promptForInput("Enter the first name: ", false);
		String lastName = ConsoleIO.promptForInput("Enter the last name: ", false);
		String email = ConsoleIO.promptForInput("Enter the email: ", false);
		int areaCode = ConsoleIO.promptForInt("Enter the phone area code: ", 0, 999);
		int prefix = ConsoleIO.promptForInt("Enter the phone's first 3 numbers: ", 0, 999);
		int line = ConsoleIO.promptForInt("Enter the phone's last 4 numbers: ", 0, 9999);
		PhoneNumber phone = new PhoneNumber(areaCode, prefix, line);
		int uid = ConsoleIO.promptForInt("Enter the patient's unique ID: ", 0, Integer.MAX_VALUE);
		boolean hasInsurance = ConsoleIO.promptForBool("Does the patient have insurance: ", "y", "n");
		InsuranceInfo insurance = null;
		if(hasInsurance) {
			String company = ConsoleIO.promptForInput("Enter the insurance company name: ", false);
			String groupID = ConsoleIO.promptForInput("Enter the patient's group ID: ", false);
			String memberID = ConsoleIO.promptForInput("Enter the patient's member ID: ", false);
			insurance = new InsuranceInfo(company, groupID, memberID);
		}
		long number = ConsoleIO.promptForLong("Enter the card number: ", 0, Long.MAX_VALUE);
		int year = ConsoleIO.promptForInt("Enter the year expiration date of the card: ", 1950, 2050);
		int month = ConsoleIO.promptForInt("Enter the month expiration date of the card: ", 1, 12);
		YearMonth expirationDate = YearMonth.of(year, month);
		String name = ConsoleIO.promptForInput("Enter the name on the card: ", false);
		int cvv = ConsoleIO.promptForInt("Enter the cvv: ", 100, 999);
		int zip = ConsoleIO.promptForInt("Enter the zip code of the card: ", 10000, 99999);
		PaymentCard paymentCard = new PaymentCard(number, expirationDate, name, cvv, zip);
		Patient patient = new Patient(firstName, lastName, email, phone, uid, insurance, paymentCard);
		return patient;
	}

	@Override
	public Patient removePatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Provider addProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editProvider(Provider provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Provider removeProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment addAppointment() {
		
		return null;
	}

	@Override
	public void editAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment removeAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User removeUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void noFoundUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int printMent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printList(String string) {
		// TODO Auto-generated method stub
		
	}

}
