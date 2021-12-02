/**
 * Dattatray Bodhale
	13-Jul-2021
 */
package com.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maintenance.dto.SendEmailData;
import com.maintenance.emailsmsconfiguration.EmailUtilityAttachment;
import com.maintenance.emailsmsconfiguration.EmailUtilityNew;
import com.maintenance.model.MailManager;
import com.maintenance.model.SOP;
import com.maintenance.service.CommomService;
import com.maintenance.service.EmailSmsService;

/**
 * @author Dattatray Bodhale
 *
 */

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	EmailSmsService emailSmsService;
	@Autowired
	CommomService commomService;
	
	EmailUtilityNew   emial= new EmailUtilityNew ();
	
	@RequestMapping(value = "/sendOffermail", method = RequestMethod.POST)
	public @ResponseBody int  sendmail(@RequestBody SOP sop) {
		int  count= 0;
		try { 
			String filename="Offer_"+sop.getSopId()+".pdf";

			System.out.println("    fileName   "+filename);
			SendEmailData  sendEmailData = new SendEmailData();
			//String subject="Inspection Report";
			String message="Dear Sir <br/> Find attachement for Spindle Service Offer ";
			//emial.sendEmail(sendEmailData,filename,subject,message);
			List<MailManager> mailManagers = commomService.getAllMailManagerForNewOffer();
			if(mailManagers.size()!=0){
				for(MailManager mailManager: mailManagers){
					
					//String message="<h5> Hello "+mailManager.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+spindleServiceRequest.getCustomer().getCustomerCode()+"-"+spindleServiceRequest.getCustomer().getCompanyName() +"</br> SSC No : "+spindleServiceRequest.getSscNo()+"</br> Spindle Model :"+spindleServiceRequest.getSpindle().getSpindleModel()+"<br> Spindle : "+spindleServiceRequest.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
					emailSmsService.sendMailAttachement(mailManager.getMailTo(),filename,"Spindle Service Offer", message);

					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@RequestMapping(value = "/sendInspectionmail", method = RequestMethod.POST)
	public @ResponseBody int  sendInspectionmail(@RequestBody SOP sop) {
		int  count= 0;
		try { 
			String filename="Inspection.pdf";

			System.out.println("    fileName   "+filename);
			SendEmailData  sendEmailData = new SendEmailData();
			//String subject="Inspection Report";
			String message="Dear Sir <br/> Find attachement for Spindle Service Offer ";
			//emial.sendEmail(sendEmailData,filename,subject,message);
			List<MailManager> mailManagers = commomService.getAllMailManagerForNewOffer();
			if(mailManagers.size()!=0){
				for(MailManager mailManager: mailManagers){
					
					//String message="<h5> Hello "+mailManager.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+spindleServiceRequest.getCustomer().getCustomerCode()+"-"+spindleServiceRequest.getCustomer().getCompanyName() +"</br> SSC No : "+spindleServiceRequest.getSscNo()+"</br> Spindle Model :"+spindleServiceRequest.getSpindle().getSpindleModel()+"<br> Spindle : "+spindleServiceRequest.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
					emailSmsService.sendMailAttachement(mailManager.getMailTo(),filename,"Spindle Service Inspection Report", message);

					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}



