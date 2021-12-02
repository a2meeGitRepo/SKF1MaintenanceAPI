/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="sop_tr")
public class SOP {
	@Id
	@GeneratedValue
	@Column(name="sop_id")
	private int sopId;
	

	@Column(name="sprindle_service_request_id")
	private int sprindleServiceRequestId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer  customer;
	
	@Transient 
	SpindleServiceRequest spindleServiceRequest; 
	
	
	
	public SpindleServiceRequest getSpindleServiceRequest() {
		return spindleServiceRequest;
	}


	public void setSpindleServiceRequest(SpindleServiceRequest spindleServiceRequest) {
		this.spindleServiceRequest = spindleServiceRequest;
	}


	@ManyToOne
	@JoinColumn(name="spindle_id")
	private Spindle spindle ;
	
	@ManyToOne
	@JoinColumn(name="technician_id")
	private Employee technician;
	
	@Column(name="issue")
	private String issue;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="primary_status")
	private String primaryStatus;
	
	
	@Column(name="secondary_status")
	private String secondaryStatus;
	
	
	@Column(name="offer_send_bit")
	private int offerSendBit;
	
	@Column(name="ins_report_bit")
	private int insReportBit;
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="no_of_stage")
	private int noOfstage;
	
	
	@Column(name="no_ofStage_complete")
	private int noOfStageComplete;


	public int getSopId() {
		return sopId;
	}


	public void setSopId(int sopId) {
		this.sopId = sopId;
	}


	
	public int getSprindleServiceRequestId() {
		return sprindleServiceRequestId;
	}


	public void setSprindleServiceRequestId(int sprindleServiceRequestId) {
		this.sprindleServiceRequestId = sprindleServiceRequestId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Spindle getSpindle() {
		return spindle;
	}


	public void setSpindle(Spindle spindle) {
		this.spindle = spindle;
	}


	public Employee getTechnician() {
		return technician;
	}


	public void setTechnician(Employee technician) {
		this.technician = technician;
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


	public String getPrimaryStatus() {
		return primaryStatus;
	}


	public void setPrimaryStatus(String primaryStatus) {
		this.primaryStatus = primaryStatus;
	}


	public String getSecondaryStatus() {
		return secondaryStatus;
	}


	public void setSecondaryStatus(String secondaryStatus) {
		this.secondaryStatus = secondaryStatus;
	}


	public int getOfferSendBit() {
		return offerSendBit;
	}


	public void setOfferSendBit(int offerSendBit) {
		this.offerSendBit = offerSendBit;
	}


	public int getInsReportBit() {
		return insReportBit;
	}


	public void setInsReportBit(int insReportBit) {
		this.insReportBit = insReportBit;
	}
@Transient
private String filename;



public String getFileName() {
	return filename;
}


public void setFileName(String filename) {
	this.filename = filename;
}
	

	

	
	
}



