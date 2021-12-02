/**
 * Dattatray Bodhale
	25-Jul-2021
 */
package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="quotation_tr")
public class Quotation {
	@Id
	@GeneratedValue
	@Column(name="quotation_id")
	private int quotationId;
	
	@ManyToOne
	@JoinColumn(name="sop_id")
	private SOP sop;
	
	@Column(name="ssc_no")
	private String sscNo;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@Column(name="scope_of_work")
	private String scopeOfWork;
	
	@ManyToOne
	@JoinColumn(name="service_request_id")
	private SpindleServiceRequest serviceRequest;
	
	@Column(name="quotation_no")
	private String quotationNo;

	public int getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}

	public SOP getSop() {
		return sop;
	}

	public void setSop(SOP sop) {
		this.sop = sop;
	}

	public String getSscNo() {
		return sscNo;
	}

	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getScopeOfWork() {
		return scopeOfWork;
	}

	public void setScopeOfWork(String scopeOfWork) {
		this.scopeOfWork = scopeOfWork;
	}

	public SpindleServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(SpindleServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}
	
	
	
	
	
}



