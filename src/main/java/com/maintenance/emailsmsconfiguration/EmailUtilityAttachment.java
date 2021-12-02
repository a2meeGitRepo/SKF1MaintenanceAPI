package com.maintenance.emailsmsconfiguration;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.maintenance.dto.SendEmailData;




/**
 * A utility class for sending e-mail with attachment.
 * @author www.codejava.net
 *
 */
public class EmailUtilityAttachment {
	
	public static void sendEmail(SendEmailData data,String filename,String subject,String message)
					throws AddressException, MessagingException {
		
		/* 
		String host=data.getDetials().getHost();
		String port=data.getDetials().getPort();
		String userName=data.getDetials().getUserName();
		String fromMail=data.getDetials().getFromMail();
		String password=data.getDetials().getPassword();
		
	*/
		System.out.println("message : "+message);
		String host="smtp.ionos.com";
		String port="587";
		String userName="anurag.roy@a2mee.com";
		String fromMail="anurag.roy@a2mee.com";
		String password="Red@2020";
		String recipient="dattatray.bodhale@a2mee.com";
		//String message="Hiii   Datta <br/> Please Find Attcahment ";
		
		
		System.out.println("Email Starter at EmailUtility="+recipient);
		System.out.println("HOST NAME="+"smtp.ionos.com");
		System.out.println(" PORT ="+port);
		System.out.println("FROM ="+userName+"   EMAOL"+fromMail);
		System.out.println(" PASSWORD ="+password);
		System.out.println(" MSG ="+message);
		
		System.out.println(" MSG ="+message);
		
		message+=" hiii iam datta ";
		
		
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "false");
		
		/*properties.put("mail.user", userName);
		properties.put("mail.password", password);*/

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties,auth);
		// creates a new e-mail message
		Message msg = null;
		
		try {
			msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(fromMail));
			msg.setReplyTo(InternetAddress.parse(fromMail, false));
			InternetAddress[] toAddresses = { new InternetAddress(recipient) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			// msg.setContent(message, "text/html; charset=utf-8");
			msg.setSubject(subject);

			// creates message part
			
			
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("I am WHO", "text/html");
			
			
		

			// creates multi-part
			Multipart multipart = new MimeMultipart();
				
			String fileurl="C:\\Users\\datta\\Dropbox\\My PC (LAPTOP-DT90N56T)\\Downloads\\"+filename;
				messageBodyPart.attachFile(new File(fileurl));
			// creates multi-part
			multipart.addBodyPart(messageBodyPart);
			
	
			//    msg.setContent(message1, "text/html; charset=utf-8");
				msg.setContent(multipart);
				 String message1 = "<div style=\"color:red;\">BRIDGEYE</div>";
				    msg.setContent("adadasdadad", "text/html; charset=utf-8");
			System.out.println(msg);
			
		
			msg.setContent(multipart);

			// sends the e-mail
			try {
				Transport.send(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Email Sent Successfully to "+data.getRecipient());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Email Msg="+msg);
		
	}
}