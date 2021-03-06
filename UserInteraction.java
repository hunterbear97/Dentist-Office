package edu.neumont.lytle.dentistoffice.view;

import java.time.LocalDate;
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
import edu.neumont.lytle.lib.ConsoleIO;


public class UserInteraction implements UserInterface{


	public String inputUsername() {
		return ConsoleIO.promptForInput("Enter Username: ", false);
	}


	public String inputPassword() {
		return ConsoleIO.promptForInput("Enter Password: ", false);
	}


	public int userMenuSelection(boolean isAdmin) {
		if(isAdmin) {
			String[] options = {"Add Patient", "Remove Patient", "Edit Patient", "View Patients",
								"Add Provider", "Remove Provider", "Edit Provider", "View Providers",
								"Add Procedure", "Remove Procedure", "Edit Procedure", "View Procedures",
								"Add Appointment", "Remove Appointment", "Edit Appointment", "View Appointments", "get Patient Balance", "Get Generated Revanue", "Get Collections", "Logout",
								"Change User Password", "Add User", "Remove User", "View Users"};
			return ConsoleIO.promptForMenuSelection(options, true);
		}
		else {
			String[] options = {"Add Patient", "Remove Patient", "Edit Patient", "View Patients",
								"Add Provider", "Remove Provider", "Edit Provider", "View Providers",
								"Add Procedure", "Remove Procedure", "Edit Procedure", "View Procedures",
								"Add Appointment", "Remove Appointment", "Edit Appointment", "View Appointments", "Get Patient Balance", "Get Generated Revanue", "Get Collections","Logout",
								"Change Password"};
			return ConsoleIO.promptForMenuSelection(options, true);
		}
	}

	
	
	
	public PatientSearchCriteria searchPatients() {
		String firstName = ConsoleIO.promptForInput("Enter the first name or leave empty: ", true);
		String lastName = ConsoleIO.promptForInput("Enter the last name or leave empty: ", true);
		String company = ConsoleIO.promptForInput("Enter the Insurance company name or leave empty: ", true);
		PatientSearchCriteria psc = new PatientSearchCriteria(firstName, lastName, company);
		return psc;
	}

	
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

	
	public AppointmentSearchCriteria searchAppointments(Provider prov, Patient pat) {
		boolean wantsProcedureCode = ConsoleIO.promptForBool("Do you want to enter a procedure code? Y/N ", "Y", "N");
		String code = null;
		if(wantsProcedureCode) {
			code = getProcedureCode();			
		}
		
		LocalDateTime start = null;
		
		boolean wantsStartDate = ConsoleIO.promptForBool("Do you want to enter a start date? Y/N ", "Y", "N");
		if(wantsStartDate) {
			start = this.promptForStartDateTime();
		}
		LocalDateTime end = null;
		boolean wantsEndDate = ConsoleIO.promptForBool("Do you want to enter an end date? Y/N ", "Y", "N");
		if(wantsEndDate) {			
			end = this.promptForEndDateTime();
		}
		AppointmentSearchCriteria apc = new AppointmentSearchCriteria(start, end, prov, pat, code);
		return apc;
	}
	
	
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
	
	
	public int selectPatient(int patientAmount) {
		
		if(patientAmount == 0) {
			ConsoleIO.displayMessage("There are no patients in the list");
			return -1;
		}
		
		return ConsoleIO.promptForInt("Enter the index of the patient: ", 0, patientAmount - 1);
		
	}

	
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

	
	public int selectProvider(int providersAmount) {
		return ConsoleIO.promptForInt("Please select the index of the provider you want: ", 0, providersAmount - 1);
	}

	
	public Procedure addProcedure() {
		String code = ConsoleIO.promptForInput("Enter the procedure code: ", false);
		String description = ConsoleIO.promptForInput("Enter the procedure description: ", false);
		double cost = ConsoleIO.promptForDouble("Enter the cost of the procedure: ", 0, 10000);
		Procedure procedure = new Procedure(code, description, cost);
		return procedure;
	}

	
	public String getProcedureCode() {
		return ConsoleIO.promptForInput("Enter the procedure code: ", false);
	}
	
	
	public String removeProcedure() {
		return getProcedureCode();
	}

	
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

	
	//pass in a patient and from a list/menu remove one of their appointments?
	public int selectAppointment(int appointmentAmount) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public int selectUser(int amountOfUsers) {
		return ConsoleIO.promptForInt("Enter the index of the user: ", 0, amountOfUsers - 1);
		
	}

	
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

	
	public void changePassword(User user) {
		String newPassword = ConsoleIO.promptForInput("Enter the new password: ", false);
		user.setPassword(newPassword);
	}

	
	public void noFoundUser() {
		ConsoleIO.displayMessage("The object that you searched for does not exist.");
	}

	
	public void invalidPassword() {
		ConsoleIO.displayMessage("The password you entered was invalid.");
	}

	
	public void printList(String list) {
		System.out.println(list);
		
	}
	
	public boolean askForProviderSelection() {
		return ConsoleIO.promptForBool("Would you like to select a provider? Y/N ", "Y", "N");
	}


	public boolean askForPatientSelection() {
		return ConsoleIO.promptForBool("Would you like to select a provider? Y/N ", "Y", "N");
	}


	private int promptForYear() {
		return ConsoleIO.promptForInt("Enter the year: ", 1950, 2050);
		
	}


	private int promptForMonth() {
		
		int month = ConsoleIO.promptForInt("Enter the month: ", 1, 12);
		return month;
	}


	private int promptForDay() {
		int day = ConsoleIO.promptForInt("Enter the day: ", 1, 31);
		return day;
	}


	public LocalDateTime promptForStartDateTime() {
		ConsoleIO.displayMessage("Please enter the start date");
		int year = this.promptForYear();
		int month = this.promptForMonth();
		int day = this.promptForDay();
		LocalDateTime date = LocalDateTime.of(year, month, day, 0, 0);
		return date;
	}


	public LocalDateTime promptForEndDateTime() {
		ConsoleIO.displayMessage("Please enter the end date");
		int year = this.promptForYear();
		int month = this.promptForMonth();
		int day = this.promptForDay();
		LocalDateTime date = LocalDateTime.of(year, month, day, 23, 59);
		return date;
	}


	public LocalDate promptForStartDate() {
		ConsoleIO.displayMessage("Please enter the start date");
		int year = this.promptForYear();
		int month = this.promptForMonth();
		int day = this.promptForDay();
		LocalDate date = LocalDate.of(year, month, day);
		return date;
//		return null;
	}


	public LocalDate promptForEndDate() {
		ConsoleIO.displayMessage("Please enter the end date");
		int year = this.promptForYear();
		int month = this.promptForMonth();
		int day = this.promptForDay();
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}


	public boolean promptDayOrMonth() {
		return ConsoleIO.promptForBool("Would yu like to group by day or month? D/M ", "D", "M");
	}


}