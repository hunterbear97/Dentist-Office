package edu.neumont.lytle.dentistoffice;

import java.io.IOException;

import edu.neumont.lytle.dentistoffice.controller.ClinicManager;
import edu.neumont.lytle.dentistoffice.view.UserInteraction;

public class DentistOffice {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ClinicManager cm = new ClinicManager();
		cm.run(new UserInteraction());
	}

}
