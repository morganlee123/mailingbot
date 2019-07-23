package tests;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	
	private String email;
	
	public SendEmail(String email) {
		this.email = email;
	}
	

	public void sendAsHotmail() {
		// change accordingly 
		String to = email;  

		// change accordingly 
		String from = "noreply@novipsych.com";  

		// or IP address 
		String host = "smtp.bizmail.yahoo.com";  

		// mail id 
		final String username = "noreply@novipsych.com";

		// correct password for email id 
		final String password = "oilhyqadwgnqfkpe";  

		
		System.out.println("TLSEmail Start"); 
		// Get the session object 

		// Get system properties 
		Properties properties = System.getProperties();  

		// Setup mail server 
		properties.setProperty("mail.smtp.host", host); 

		// SSL Port 
		properties.put("mail.smtp.port", "465");  

		// enable authentication 
		properties.put("mail.smtp.auth", "true");  

		// SSL Factory 
		properties.put("mail.smtp.socketFactory.class", 
				"javax.net.ssl.SSLSocketFactory");   

		// creating Session instance referenced to  
		// Authenticator object to pass in  
		// Session.getInstance argument 
		Session session = Session.getDefaultInstance(properties, 
				new javax.mail.Authenticator() { 

			// override the getPasswordAuthentication  
			// method 
			protected PasswordAuthentication  
			getPasswordAuthentication() { 
				return new PasswordAuthentication(username, password); 
			} 
		}); 


		//compose the message 
		try { 
			// javax.mail.internet.MimeMessage class is mostly  
			// used for abstraction. 
			MimeMessage message = new MimeMessage(session);  

			// header field of the header. 
			message.setFrom(new InternetAddress(from)); 

			message.addRecipient(Message.RecipientType.TO,  
					new InternetAddress(to)); 
			message.setSubject("NO REPLY - Welcome to The Psychiatry and Psychology Center in Northville"); 
			message.setText("here ill send their unique ID and other stuff"); 

			// Send message 
			Transport.send(message); 
			System.out.println("Yo it has been sent.."); 
		} 
		catch (MessagingException mex) { 
			mex.printStackTrace(); 
		} 
	}
	
	public static void main(String args[]) {
		SendEmail email = new SendEmail("contact@novipsych.com");
		email.sendAsHotmail();
	}
}
