package edu.neumont.lytle.dentistoffice.view;

import java.time.LocalDateTime;
import java.time.YearMonth;

import edu.neumont.lytle.dentistoffice.models.Admin;
import edu.neumont.lytle.dentistoffice.models.Appointment;
import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.FutureAppointment;
import edu.neumont.lytle.dentistoffice.models.InsuranceInfo;
import edu.neumont.lytle.dentistoffice.models.Patient;
import edu.neumont.lytle.dentistoffice.models.PatientSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.PaymentCard;
import edu.neumont.lytle.dentistoffice.models.PhoneNumber;
import edu.neumont.lytle.dentistoffice.models.Procedure;
import edu.neumont.lytle.dentistoffice.models.Provider;
import edu.neumont.lytle.dentistoffice.models.ProviderSearchCriteria;
import edu.neumont.lytle.dentistoffice.models.ProviderType;
import edu.neumont.lytle.dentistoffice.models.StandardUser;
import edu.neumont.lytle.dentistoffice.models.User;
import edu.neumont.lytle.dentistoffice.models.UserRole;
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
								"Change User Password", "Add User", "Remove User", "View Users"};
			return ConsoleIO.promptForMenuSelection(options, true);
		}
		else {
			String[] options = {"Add Patient", "Remove Patient", "Edit Patient", "View Patients",
								"Add Provider", "Remove Provider", "Edit Provider", "View Providers",
								"Add Procedure", "Remove Procedure", "Edit Procedure", "View Procedures",
								"Add Appointment", "Remove Appointment", "Edit Appointment", "View Appointments",
								"Change Password"};
			return ConsoleIO.promptForMenuSelection(options, true);
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
	public AppointmentSearchCriteria searchAppointments(Provider prov, Patient pat) {
		String code = getProcedureCode();
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
		AppointmentSearchCriteria apc = new AppointmentSearchCriteria(start, end, prov, pat, code);
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
		long number = ConsoleIO.promptForLong("Enter the card number: ", 1000000000000000L, 9999999999999999L);
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

	public int getPatientUID() {
		return ConsoleIO.promptForInt("Enter the patient's unique ID: ", 0, Integer.MAX_VALUE);
	}
	
	@Override
	public int removePatient() {
		return getPatientUID();
	}

	@Override
	public void editPatient(Patient patient) {
		boolean editMore = true;
		do {
			String[] options = {"First Name", "Last Name", "Email", "Phone Number", "Unique ID", "Insurance Info", "Payment Card"};
			int choice = ConsoleIO.promptForMenuSelection(options, true);
			switch(choice) {
			case 1:
				String firstName = ConsoleIO.promptForInput("Enter the first name: ", false);
				patient.setFirstName(firstName);
				break;
			case 2:
				String lastName = ConsoleIO.promptForInput("Enter the last name: ", false);
				patient.setLastName(lastName);
				break;
			case 3: 
				String email = ConsoleIO.promptForInput("Enter the email: ", false);
				patient.setEmail(email);
				break;
			case 4: 
				int areaCode = ConsoleIO.promptForInt("Enter the phone area code: ", 0, 999);
				int prefix = ConsoleIO.promptForInt("Enter the phone's first 3 numbers: ", 0, 999);
				int line = ConsoleIO.promptForInt("Enter the phone's last 4 numbers: ", 0, 9999);
				PhoneNumber phone = new PhoneNumber(areaCode, prefix, line);
				patient.setPhone(phone);
				break;
			case 5:
				int uid = ConsoleIO.promptForInt("Enter the patient's unique ID: ", 0, Integer.MAX_VALUE);
				patient.setUid(uid);
				break;
			case 6:
				boolean hasInsurance = ConsoleIO.promptForBool("Does the patient have insurance: ", "y", "n");
				InsuranceInfo insurance = null;
				if(hasInsurance) {
					String company = ConsoleIO.promptForInput("Enter the insurance company name: ", false);
					String groupID = ConsoleIO.promptForInput("Enter the patient's group ID: ", false);
					String memberID = ConsoleIO.promptForInput("Enter the patient's member ID: ", false);
					insurance = new InsuranceInfo(company, groupID, memberID);
				}
				patient.setInsurance(insurance);
				break;
			case 7:
				long number = ConsoleIO.promptForLong("Enter the card number: ", 0, Long.MAX_VALUE);
				int year = ConsoleIO.promptForInt("Enter the year expiration date of the card: ", 1950, 2050);
				int month = ConsoleIO.promptForInt("Enter the month expiration date of the card: ", 1, 12);
				YearMonth expirationDate = YearMonth.of(year, month);
				String name = ConsoleIO.promptForInput("Enter the name on the card: ", false);
				int cvv = ConsoleIO.promptForInt("Enter the cvv: ", 100, 999);
				int zip = ConsoleIO.promptForInt("Enter the zip code of the card: ", 10000, 99999);
				PaymentCard paymentCard = new PaymentCard(number, expirationDate, name, cvv, zip);
				patient.setPaymentCard(paymentCard);
				break;
			case 0:
				editMore = false;
			}
		} while(editMore);
	}

	@Override
	public Provider addProvider() {
		String firstName = ConsoleIO.promptForInput("Enter the first name: ", false);
		String lastName = ConsoleIO.promptForInput("Enter the last name: ", false);
		String email = ConsoleIO.promptForInput("Enter the email: ", false);
		int areaCode = ConsoleIO.promptForInt("Enter the phone area code: ", 0, 999);
		int prefix = ConsoleIO.promptForInt("Enter the phone's first 3 numbers: ", 0, 999);
		int line = ConsoleIO.promptForInt("Enter the phone's last 4 numbers: ", 0, 9999);
		PhoneNumber phone = new PhoneNumber(areaCode, prefix, line);
		int uid = ConsoleIO.promptForInt("Enter the patient's unique ID: ", 0, Integer.MAX_VALUE);
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
		Provider provider = new Provider(firstName, lastName, email, phone, uid, pt);
		return provider;
	}

	public int getProviderUID() {
		return ConsoleIO.promptForInt("Enter the provider's unique ID: ", 0, Integer.MAX_VALUE);
	}
	
	@Override
	public void editProvider(Provider provider) {
		boolean editMore = true;
		do {
			String[] options = {"First Name", "Last Name", "Email", "Phone Number", "Unique ID", "Title"};
			int choice = ConsoleIO.promptForMenuSelection(options, true);
			switch(choice) {
			case 1:
				String firstName = ConsoleIO.promptForInput("Enter the first name: ", false);
				provider.setFirstName(firstName);
				break;
			case 2:
				String lastName = ConsoleIO.promptForInput("Enter the last name: ", false);
				provider.setLastName(lastName);
				break;
			case 3: 
				String email = ConsoleIO.promptForInput("Enter the email: ", false);
				provider.setEmail(email);
				break;
			case 4: 
				int areaCode = ConsoleIO.promptForInt("Enter the phone area code: ", 0, 999);
				int prefix = ConsoleIO.promptForInt("Enter the phone's first 3 numbers: ", 0, 999);
				int line = ConsoleIO.promptForInt("Enter the phone's last 4 numbers: ", 0, 9999);
				PhoneNumber phone = new PhoneNumber(areaCode, prefix, line);
				provider.setPhone(phone);
				break;
			case 5:
				int uid = ConsoleIO.promptForInt("Enter the provider's unique ID: ", 0, Integer.MAX_VALUE);
				provider.setUid(uid);
				break;
			case 6:
				String[] options2 = {ProviderType.Assistant.toString(), ProviderType.Dentist.toString(), ProviderType.Hygenist.toString()};
				int title = ConsoleIO.promptForMenuSelection(options2, false);
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
				provider.setTitle(pt);
				break;
			case 0:
				editMore = false;
			}
		} while(editMore);
	}

	@Override
	public int removeProvider() {
		return getProviderUID();
	}

	@Override
	public Procedure addProcedure() {
		String code = ConsoleIO.promptForInput("Enter the procedure code: ", false);
		String description = ConsoleIO.promptForInput("Enter the procedure description: ", false);
		double cost = ConsoleIO.promptForDouble("Enter the cost of the procedure: ", 0, 10000);
		Procedure procedure = new Procedure(code, description, cost);
		return procedure;
	}

	@Override
	public String getProcedureCode() {
		return ConsoleIO.promptForInput("Enter the procedure code: ", false);
	}
	
	@Override
	public String removeProcedure() {
		return getProcedureCode();
	}

	@Override
	public void editProcedure(Procedure procedure) {
		boolean editMore = true;
		do {
			String[] options = {"Code", "Description", "Cost"};
			int choice = ConsoleIO.promptForMenuSelection(options, true);
			switch(choice) {
			case 1:
				String code = ConsoleIO.promptForInput("Enter the Code: ", false);
				procedure.setCode(code);
				break;
			case 2:
				String description = ConsoleIO.promptForInput("Enter the description: ", false);
				procedure.setDescription(description);
				break;
			case 3: 
				double cost = ConsoleIO.promptForDouble("Enter the cost: ", 0, 10000);
				procedure.setCost(cost);
				break;
			case 0:
				editMore = false;
			}
		} while(editMore);
	}
	
	@Override
	//when we add an appointment, we assume it will be in the future
	//adding an appointment to the past is not useful for now
	public Appointment addAppointment(Patient pat) {
		int year = ConsoleIO.promptForInt("Enter the start year: ", 1950, 2050);
		int month = ConsoleIO.promptForInt("Enter the start month: ", 1, 12);
		int day = ConsoleIO.promptForInt("Enter the start day: ", 1, 31);
		int hour = ConsoleIO.promptForInt("Enter the start hour: ", 0, 23);
		int minute = ConsoleIO.promptForInt("Enter the start day: ", 0, 59);
		LocalDateTime appointmentDate = LocalDateTime.of(year, month, day, hour, minute);
		FutureAppointment fa = new FutureAppointment(appointmentDate, pat);
		return fa;
	}

	@Override
	public void editAppointment(Appointment appointment) {
		boolean editMore = true;
		do {
			String[] options = {"Appointment Date", "Patient"};
			int choice = ConsoleIO.promptForMenuSelection(options, true);
			switch(choice) {
			case 1:
				int year = ConsoleIO.promptForInt("Enter the start year: ", 1950, 2050);
				int month = ConsoleIO.promptForInt("Enter the start month: ", 1, 12);
				int day = ConsoleIO.promptForInt("Enter the start day: ", 1, 31);
				int hour = ConsoleIO.promptForInt("Enter the start hour: ", 0, 23);
				int minute = ConsoleIO.promptForInt("Enter the start day: ", 0, 59);
				LocalDateTime appointmentDate = LocalDateTime.of(year, month, day, hour, minute);
				appointment.setAppointmentDate(appointmentDate);
				break;
			case 0:
				editMore = false;
			}
		} while(editMore);
		
	}

	@Override
	//pass in a patient and from a list/menu remove one of their appointments?
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
	public String removeUser() {
		return ConsoleIO.promptForInput("Enter the username: ", false);
		
	}

	@Override
	public User addUser() {
		
		String username = ConsoleIO.promptForInput("Enter the username: ", false);
		String password = ConsoleIO.promptForInput("Enter the password: ", false);
		String[] options = {"Admin", "Standard"}; 
		int role = ConsoleIO.promptForMenuSelection(options, false);
		UserRole uRole = null;
		if(role == 1) {
			uRole = UserRole.Admin;
			Admin admin = new Admin(username, password, uRole);
			return admin;
		}
		else if(role == 2) {
			uRole = UserRole.Standard;
			StandardUser su = new StandardUser(username, password, uRole);
			return su;
		}
		return null;
	}

	@Override
	public void changePassword(User user) {
		String newPassword = ConsoleIO.promptForInput("Enter the new password: ", false);
		user.setPassword(newPassword);
	}

	@Override
	public void noFoundUser() {
		// TODO Auto-generated method stub
		System.out.println("The object that you searched for does not exist.");
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
	public void printList(String list) {
		System.out.println(list);
		
	}


}
