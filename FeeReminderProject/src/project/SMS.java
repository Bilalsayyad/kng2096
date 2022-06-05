package project;
import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.math.BigDecimal; 
 
	public class SMS {
		
//		public void sendTo(ArrayList<String> names,ArrayList<Integer> Num,ArrayList<String> FeeStatus) {
//			SMS sms=new SMS();
//			Iterator<String> iter=Num.iterator();
//			while(iter.hasNext()) {
//				System.out.println(iter.next());
//				System.out.println("SMS Sending..........");
//			}		 
//}
		public void sendSms(String num ) {
	     String ACCOUNT_SID = "AC2a16242182512a85e416f1d1de5797c1"; 
	     String AUTH_TOKEN = "be4f527136b2afb90d597201620ec952"; 
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
@SuppressWarnings("all")
        Message message = Message.creator(new PhoneNumber(num),new PhoneNumber("+19785818991"),   
                "Thankyou for paying your current month Fee \n"
                + "Regards \n Shoaib").create(); 
        System.out.println(message.getSid()); 
        System.out.println("Sms Sent.........");

    } 
}