/**
 * Dattatray Bodhale
	17-May-2021
 */
package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="service_request_mapped_enginner")
public class ServiceRequestMappedEnginner {
	
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sprindle_service_request_id")
	private int sprindleServiceRequestId;
	
	@Column(name="engineer_id")
	private int engineerId;
	

	@Column(name="requested_by")
	private String requestedBy;
	
	

	@Column(name="approval_by")
	private String approvalBy;
	

	@Column(name="requested_date")
	private Date requestedDate;
	
	
	@Column(name="approval_date")
	private Date approvalDate;
	
	
	
	@Column(name="status")
	private String status;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSprindleServiceRequestId() {
		return sprindleServiceRequestId;
	}



	public void setSprindleServiceRequestId(int sprindleServiceRequestId) {
		this.sprindleServiceRequestId = sprindleServiceRequestId;
	}



	public int getEngineerId() {
		return engineerId;
	}



	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}



	public String getRequestedBy() {
		return requestedBy;
	}



	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}



	public String getApprovalBy() {
		return approvalBy;
	}



	public void setApprovalBy(String approvalBy) {
		this.approvalBy = approvalBy;
	}



	public Date getRequestedDate() {
		return requestedDate;
	}



	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}



	public Date getApprovalDate() {
		return approvalDate;
	}



	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}



