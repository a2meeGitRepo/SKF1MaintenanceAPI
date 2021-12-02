package com.maintenance.service;

import com.maintenance.dto.ResponceObject;

public interface EmailSmsService {
	ResponceObject sendMail(String recipient,String subject,String message);
	ResponceObject sendMailAttachement(String recipient,String fileName,String subject,String message);
	ResponceObject sendSMS(String phoneNo,String message);
}
