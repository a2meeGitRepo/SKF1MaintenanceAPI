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
@Table(name="quotation_work_point")
public class QuotationWorkPoint {
	
	@Id
	@GeneratedValue
	@Column(name="quotation_work_id")
	private int quotationWorkId;
	
	@ManyToOne
	@JoinColumn(name="quotation_id")
	private Quotation quotation;
	
	@Column(name="point_no")
	private String pointNo;
	
	@Column(name="scope_of_work")
	private String scopeOfWork;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_date")
	private Date createdDate;

	public int getQuotationWorkId() {
		return quotationWorkId;
	}

	public void setQuotationWorkId(int quotationWorkId) {
		this.quotationWorkId = quotationWorkId;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public String getPointNo() {
		return pointNo;
	}

	public void setPointNo(String pointNo) {
		this.pointNo = pointNo;
	}

	public String getScopeOfWork() {
		return scopeOfWork;
	}

	public void setScopeOfWork(String scopeOfWork) {
		this.scopeOfWork = scopeOfWork;
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
	
	
	
	
	

}



