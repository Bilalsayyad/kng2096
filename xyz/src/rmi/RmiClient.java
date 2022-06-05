package rmi;

import java.rmi.Naming;

import InterfaceFrame.Dentist;
import InterfaceFrame.Doctor;
import emailcomponant.Email;

public class RmiClient {
public static void main(String[] args) throws Exception {
	
	Bussiness bussiness=(Bussiness)Naming.lookup("rmi://localhost:1099/bilalstores");

	Doctor doctor=(Doctor)bussiness.getBilalStoreObjects();
	doctor.docure();
	
	Dentist dentist=(Dentist)bussiness.getBilalStoreObjects();
	dentist.toothCare();
	
	Email email=(Email)bussiness.getBilalStoreObjects();
	email.sendEmail();
}
}
