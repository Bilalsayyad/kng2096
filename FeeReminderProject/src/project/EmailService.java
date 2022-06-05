package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EmailService {
public void Sendmail(ArrayList<String> names,ArrayList<String> emails,ArrayList<String> FeeStatus) throws Exception {
	int i=0;
	   for (String email : emails) {
		    if (FeeStatus.get(i).equals("N")) {
		    	sendto(names.get(i),email);
		    	 
			}
			i++;
		
}}
public void sendto(String name,String email) throws Exception {
	
	  final String username="developerb517@gmail.com";
			final String password="Bilal@7117";
			String Frommail="developerb517@gmail.com";
			String Tomail=email;
			
	
	Properties props=new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	
	
	
	Session session=Session.getInstance(props,new javax.mail.Authenticator() {
		protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
			return new javax.mail.PasswordAuthentication(username, password);
			
		}
	});
		MimeMessage msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress(Frommail));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(Tomail));
		msg.setSubject("FEES REMINDER FOR HIT GOLDEN TOUCH");
		
		Multipart content =new MimeMultipart();
		
		MimeBodyPart text=new MimeBodyPart();
		
		text.setText("Dear "+name+",\n  \n Please Pay you fees for the "
				+ "pending months as soon as possible ....\nRegards,\nHIT Golden Touch.");
		content.addBodyPart(text);
		
//		text.attachFile(new File(name));
		
		msg.setContent(content);
		
        javax.mail.Transport.send(msg);
		
		System.out.println("Email sent successfully.....");
		
}
}
