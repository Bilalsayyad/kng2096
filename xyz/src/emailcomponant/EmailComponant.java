package emailcomponant;

import java.io.Serializable;

public class EmailComponant implements Email,Serializable{

	@Override
	public void sendEmail() {
		System.out.println("Send email...........");
		
	}

}
