package com.maintenance.dto;

import com.maintenance.emailsmsconfiguration.SmsSenderDetials;

public class SendSMSData {
private SmsSenderDetials smsSenderDetials;
private String phoneNo;
private String message;
public SmsSenderDetials getSmsSenderDetials() {
	return smsSenderDetials;
}
public void setSmsSenderDetials(SmsSenderDetials smsSenderDetials) {
	this.smsSenderDetials = smsSenderDetials;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}


}
