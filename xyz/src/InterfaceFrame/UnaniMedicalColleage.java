package InterfaceFrame;

import java.io.Serializable;

public class UnaniMedicalColleage implements Doctor,Serializable{

	@Override
	public void docure() {
		System.out.println("docure method called as per unani");
		
	}

}
