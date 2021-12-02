package com.maintenance.service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.dto.ResponceObject;
import com.maintenance.dto.SendEmailData;
import com.maintenance.emailsmsconfiguration.EmailSenderDetials;
import com.maintenance.emailsmsconfiguration.EmailUtility;
import com.maintenance.emailsmsconfiguration.EmailUtilityNew;
import com.maintenance.emailsmsconfiguration.SmsSenderDetials;
import com.maintenance.repo.EmailSenderDetialsRepo;
import com.maintenance.repo.SmsSenderDetialsRepo;


@Service
public class EmailSmsServiceImpl implements EmailSmsService{
	@Autowired
	SmsSenderDetialsRepo smsSenderDetialsRepo;
	
	@Autowired
	EmailSenderDetialsRepo emailSenderDetialsRepo;

	@Override
	public ResponceObject sendMail(String recipient, String subject, String message) {
		// TODO Auto-generated method stub
		ResponceObject object = new ResponceObject();
		Optional<EmailSenderDetials> senders=emailSenderDetialsRepo.getActiveSender();
		if(senders.isPresent()){
			EmailUtility emailUtility = new EmailUtility();
			SendEmailData sendEmailData= new SendEmailData();
			sendEmailData.setDetials(senders.get());
			sendEmailData.setMessage(message+senders.get().getSigniture());
			sendEmailData.setRecipient(recipient);
			sendEmailData.setSubject(subject);
			try {
				emailUtility.sendEmail(sendEmailData);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				object.setCode(500);
				object.setMsg("Email Not Send :"+recipient);
			}
		}else{
			object.setCode(500);
			object.setMsg("Email Not Send :"+recipient);
		}
		return null;
	}

	@Override
	public ResponceObject sendSMS(String phoneNo, String message) {
		// TODO Auto-generated method stub
		ResponceObject object = new ResponceObject();
		Optional<SmsSenderDetials> senders=smsSenderDetialsRepo.setAcriveSender();
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmailSmsService#sendMailAttachement(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ResponceObject sendMailAttachement(String recipient, String fileName, String subject, String message) {
		// TODO Auto-generated method stub
		ResponceObject object = new ResponceObject();
		Optional<EmailSenderDetials> senders=emailSenderDetialsRepo.getActiveSender();
		if(senders.isPresent()){
			EmailUtility emailUtility = new EmailUtility();
			SendEmailData sendEmailData= new SendEmailData();
			sendEmailData.setDetials(senders.get());
			sendEmailData.setMessage(message+senders.get().getSigniture());
			sendEmailData.setRecipient(recipient);
			sendEmailData.setSubject(subject);
			sendEmailData.setFileName(fileName);
			try {
				EmailUtilityNew.sendEmail(sendEmailData);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				object.setCode(500);
				object.setMsg("Email Not Send :"+recipient);
			}
		}else{
			object.setCode(500);
			object.setMsg("Email Not Send :"+recipient);
		}
		return null;
	}

}
