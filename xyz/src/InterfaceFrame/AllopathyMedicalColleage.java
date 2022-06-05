package InterfaceFrame;

import java.io.Serializable;

public class AllopathyMedicalColleage implements Doctor,Dentist,Serializable {

	@Override
	public void docure() {
		System.out.println("docure method called as per allopathy");
	}
@Override
public void toothCare() {
	System.out.println("Tooth care by allopathy........");	
}
}
