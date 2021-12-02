/**
 * Dattatray Bodhale
	10-May-2021
 */
package com.maintenance.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.maintenance.dto.Email;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="sprindle_service_request")
public class SpindleServiceRequest {
	

	@Override
	public String toString() {
		return "SpindleServiceRequest [sprindleServiceRequestId=" + sprindleServiceRequestId + ", customer=" + customer
				+ ", spindle=" + spindle + ", reason=" + reason + ", engineer=" + engineer + ", branch=" + branch
				+ ", sscNo=" + sscNo + ", employeeId=" + employeeId + ", qrCode=" + qrCode + ", spindleDesign="
				+ spindleDesign + ", application=" + application + ", drive=" + drive + ", moutingType=" + moutingType
				+ ", orientation=" + orientation + ", replacementSpindle=" + replacementSpindle + ", serviceRequested="
				+ serviceRequested + ", additionDetials=" + additionDetials + ", addedBy=" + addedBy + ", addedDate="
				+ addedDate + ", status=" + status + ", active=" + active + ", inspectionDate=" + inspectionDate
				+ ", servicedDate=" + servicedDate + ", delBit=" + delBit + ", updDatetime=" + updDatetime + ", emails="
				+ emails + ", frontBearings=" + frontBearings + ", rearBearings=" + rearBearings + ", getEmployeeId()="
				+ getEmployeeId() + ", getQrCode()=" + getQrCode() + ", getSprindleServiceRequestId()="
				+ getSprindleServiceRequestId() + ", getCustomer()=" + getCustomer() + ", getSpindle()=" + getSpindle()
				+ ", getReason()=" + getReason() + ", getEngineer()=" + getEngineer() + ", getBranch()=" + getBranch()
				+ ", getSscNo()=" + getSscNo() + ", getSpindleDesign()=" + getSpindleDesign() + ", getApplication()="
				+ getApplication() + ", getDrive()=" + getDrive() + ", getMoutingType()=" + getMoutingType()
				+ ", getOrientation()=" + getOrientation() + ", getReplacementSpindle()=" + getReplacementSpindle()
				+ ", getServiceRequested()=" + getServiceRequested() + ", getAdditionDetials()=" + getAdditionDetials()
				+ ", getAddedBy()=" + getAddedBy() + ", getAddedDate()=" + getAddedDate() + ", getStatus()="
				+ getStatus() + ", getInspectionDate()=" + getInspectionDate() + ", getServicedDate()="
				+ getServicedDate() + ", getActive()=" + getActive() + ", getUpdDatetime()=" + getUpdDatetime()
				+ ", getDelBit()=" + getDelBit() + ", getEmails()=" + getEmails() + ", getFrontBearings()="
				+ getFrontBearings() + ", getRearBearings()=" + getRearBearings() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Id
	@GeneratedValue
	@Column(name="sprindle_service_request_id")
	private int sprindleServiceRequestId;
	
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="spindle_id")
	private Spindle spindle;
	
	@ManyToOne
	@JoinColumn(name="service_reson_id")
	private ServiceReason reason;
	
	@ManyToOne
	@JoinColumn(name="engineer_assigned")
	private Employee engineer;
	
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	@Column(name="ssc_no")
	private String sscNo;
	
	@Transient
	private int employeeId;


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Column(name="qr_code")
	private String qrCode;
	
	@Column(name="spindle_design")
	private String spindleDesign;
	
	@Column(name="application")
	private String application;
	
	@Column(name="drive")
	private String drive;
	
	
	@Column(name="mouting_type")
	private String moutingType;
	
	@Column(name="orientation")
	private String orientation;
	
	@Column(name="replacement_spindle")
	private String replacementSpindle;

	@Column(name="service_requested")
	private String serviceRequested;
	
	@Column(name="addition_detials")
	private String additionDetials;
	
	@Column(name="added_by")
	private String addedBy;
	
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="status")
	private String status;
	

	@Column(name="active")
	private int active;
	
	
	@Column(name="inspection_date")
	private Date inspectionDate;
	
	@Column(name="serviced_date")
	private Date servicedDate;
	
	
	@Column(name="del_bit")
	private int delBit;
	
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	
	
	
	
	@Transient
	private List<Email> emails;
	@Transient
	private List<BearringAccessory> frontBearings;
	@Transient
	private List<BearringAccessory> rearBearings;

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

	public ServiceReason getReason() {
		return reason;
	}

	public void setReason(ServiceReason reason) {
		this.reason = reason;
	}

	public Employee getEngineer() {
		return engineer;
	}

	public void setEngineer(Employee engineer) {
		this.engineer = engineer;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getSscNo() {
		return sscNo;
	}

	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}

	public String getSpindleDesign() {
		return spindleDesign;
	}

	public void setSpindleDesign(String spindleDesign) {
		this.spindleDesign = spindleDesign;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getMoutingType() {
		return moutingType;
	}

	public void setMoutingType(String moutingType) {
		this.moutingType = moutingType;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getReplacementSpindle() {
		return replacementSpindle;
	}

	public void setReplacementSpindle(String replacementSpindle) {
		this.replacementSpindle = replacementSpindle;
	}

	public String getServiceRequested() {
		return serviceRequested;
	}

	public void setServiceRequested(String serviceRequested) {
		this.serviceRequested = serviceRequested;
	}

	public String getAdditionDetials() {
		return additionDetials;
	}

	public void setAdditionDetials(String additionDetials) {
		this.additionDetials = additionDetials;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public Date getServicedDate() {
		return servicedDate;
	}

	public void setServicedDate(Date servicedDate) {
		this.servicedDate = servicedDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public int getDelBit() {
		return delBit;
	}

	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<BearringAccessory> getFrontBearings() {
		return frontBearings;
	}

	public void setFrontBearings(List<BearringAccessory> frontBearings) {
		this.frontBearings = frontBearings;
	}

	public List<BearringAccessory> getRearBearings() {
		return rearBearings;
	}

	public void setRearBearings(List<BearringAccessory> rearBearings) {
		this.rearBearings = rearBearings;
	}

	
	
	
	
	
	
}



