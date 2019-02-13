//package edu.neumont.lytle.dentistoffice;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import edu.neumont.lytle.dentistoffice.models.Appointment;
//import edu.neumont.lytle.dentistoffice.models.AppointmentRecord;
//import edu.neumont.lytle.dentistoffice.models.AppointmentSearchCriteria;
//import edu.neumont.lytle.dentistoffice.models.Clinic;
//import edu.neumont.lytle.dentistoffice.models.FutureAppointment;
//import edu.neumont.lytle.dentistoffice.models.InsuranceInfo;
//import edu.neumont.lytle.dentistoffice.models.Patient;
//import edu.neumont.lytle.dentistoffice.models.PaymentCard;
//import edu.neumont.lytle.dentistoffice.models.PhoneNumber;
//import edu.neumont.lytle.dentistoffice.models.Procedure;
//import edu.neumont.lytle.dentistoffice.models.ProcedureRecord;
//import edu.neumont.lytle.dentistoffice.models.Provider;
//import edu.neumont.lytle.dentistoffice.models.ProviderType;
//
//public class TestDriver {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Clinic clinic = new Clinic();
//		LocalDate ld = LocalDate.now();
//		FutureAppointment fa1 = new FutureAppointment();
//		PhoneNumber phone1 = new PhoneNumber(801, 652, 5426);
//		InsuranceInfo i1 = new InsuranceInfo("Aetna", "D13224", "55");
//		PaymentCard p1 = new PaymentCard(1234123412341234L, ld, "Steve Smith", 324, 84118);
//		PaymentCard p2 = new PaymentCard(5678567856785678L, ld, "Gary Larson", 324, 84118);
//		Patient pat1 = new Patient("Steve", "Smith", "me@fakemail.com", phone1, 01, i1, p1);
//		Patient pat2 = new Patient("Gary", "Larson", "me@fakemail.com", phone1, 02, i1, p1);
//		Provider pro2 = new Provider("Gary", "Larson", "you@fakemail.com", phone1, 02, ProviderType.Assistant);
//		Provider pro3 = new Provider("Gary", "Larson", "you@fakemail.com", phone1, 03, ProviderType.Hygenist);
//		Procedure p3 = new Procedure("S1234", "Root Canal", 3.14);
//		Procedure p4 = new Procedure("S5678", "Tooth Cleaning", 7.89);
//		AppointmentRecord ar1 = new AppointmentRecord();
//		ProcedureRecord r = new ProcedureRecord();
//		r.setCost(3.14);
//		r.setProcedure(p3);
//		r.setProvider(pro3);
//		r.setAppointment(ar1);
//		List<ProcedureRecord> rl = new ArrayList<>();
//		rl.add(r);
//		ar1.setAppointmentDate(LocalDateTime.now());
//		ar1.setPatient(pat2);
//		ar1.setProcedures(rl);
//		List<Procedure> procedures = new ArrayList<>();
//		procedures.add(p3);
//		procedures.add(p4);
//		
//		fa1.setAppointmentDate(LocalDateTime.now());
//		fa1.setPatient(pat1);
//		fa1.setProcedures(procedures, pro3);
//		clinic.addAppointment(fa1);
//		clinic.addAppointment(ar1);
//		
//		AppointmentSearchCriteria asc = new AppointmentSearchCriteria();
//		
//		asc.setProcedureCode("S1234");
//		
//		List<Appointment> list = clinic.searchAppointments(asc);
//		
//		System.out.println(clinic.appointmentsToString(list));
//		
////		clinic.addProvider(pro1);
////		clinic.addProvider(pro2);
////		clinic.addProvider(pro3);
////		clinic.addPatient(pat1);
////		clinic.addPatient(pat2);
////		
//////		ProviderSearchCriteria psc = new ProviderSearchCriteria();
//////		psc.setFirstName("Gary");
//////		
//////		List<Provider> list = clinic.searchProviders(psc);
////		
////		PatientSearchCriteria psc = new PatientSearchCriteria(null, "Larson", null);
////		List<Patient> list = clinic.searchPatients(psc);
////		
////		System.out.println(clinic.patientsToString(list));
//		
//	}
//
//}
