/**
 * Dattatray Bodhale
	15-Jun-2021
 */
package com.maintenance.dto;

import javax.persistence.Column;

/**
 * @author Dattatray Bodhale
 *
 */
public class SOPDTO {
	
	private int sprindleServiceRequestId;
	private int sopId;

	private String customerCode;
	private String customerName;
	private String spindleBrand;
	private String spindleModel;
	
	private String issue;
	
	private int noOfstage;
	
	
	
	private int noOfStageComplete;



	public int getSprindleServiceRequestId() {
		return sprindleServiceRequestId;
	}



	public String getSpindleBrand() {
		return spindleBrand;
	}



	public void setSpindleBrand(String spindleBrand) {
		this.spindleBrand = spindleBrand;
	}



	public String getSpindleModel() {
		return spindleModel;
	}



	public void setSpindleModel(String spindleModel) {
		this.spindleModel = spindleModel;
	}



	public void setSprindleServiceRequestId(int sprindleServiceRequestId) {
		this.sprindleServiceRequestId = sprindleServiceRequestId;
	}



	public String getCustomerCode() {
		return customerCode;
	}



	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public int getNoOfstage() {
		return noOfstage;
	}



	public void setNoOfstage(int noOfstage) {
		this.noOfstage = noOfstage;
	}



	public int getNoOfStageComplete() {
		return noOfStageComplete;
	}



	public void setNoOfStageComplete(int noOfStageComplete) {
		this.noOfStageComplete = noOfStageComplete;
	}



	public int getSopId() {
		return sopId;
	}



	public void setSopId(int sopId) {
		this.sopId = sopId;
	}
	
	
	
	
}



