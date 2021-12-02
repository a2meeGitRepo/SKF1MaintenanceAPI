/**
 * Dattatray Bodhale
	12-Jul-2021
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

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="cus_spindle_reg")
public class CustomerSpindleRegistration {
	public String getAdditionDetials() {
		return additionDetials;
	}

	public void setAdditionDetials(String additionDetials) {
		this.additionDetials = additionDetials;
	}

	@Id
	@GeneratedValue
	@Column(name="cus_spindle_reg_id")
	private int cusSpindleRegId;
	
	
	@Column(name="spindle_brand")
	private String spindleBrand;
	
	
	@Column(name="machine_brand")
	private String machineBrand;
	
	@Column(name="serial_no")
	private String serialNo;
	
	@Column(name="spindle_model")
	private String spindleModel;
	
	@Column(name="machine_model")
	private String machineModel;
	
	@Column(name="power")
	private String power;
	
	@Column(name="max_speed")
	private String maxSpeed;
	
	@Column(name="operating_speed")
	private String operatingSpeed;
	
	@Column(name="poles")
	private String poles;
	
	@Column(name="tool_taper")
	private String toolTaper;
	
	@Column(name="current")
	private String current;
	
	
	@Column(name="voltage")
	private String voltage;
	
	@Column(name="lubrication")
	private String lubrication;
	
	@Column(name="assembly_drawing")
	private String assemblyDrawing;
	
	
	
	@ManyToOne
	@JoinColumn(name="service_reson_id")
	private ServiceReason reason;
	
	
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	
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
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	
	@Column(name="status")
	private String status;
	@Column(name="ssc_no")
	private String sscNo;
	
	
	
	public String getSscNo() {
		return sscNo;
	}

	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}

	@Column(name="addition_detials")
	private String additionDetials;
	@Transient
	private List<BearringAccessoryCustReq> frontBearings;
	@Transient
	private List<BearringAccessoryCustReq> rearBearings;
	
	
	
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BearringAccessoryCustReq> getFrontBearings() {
		return frontBearings;
	}

	public void setFrontBearings(List<BearringAccessoryCustReq> frontBearings) {
		this.frontBearings = frontBearings;
	}

	public List<BearringAccessoryCustReq> getRearBearings() {
		return rearBearings;
	}

	public void setRearBearings(List<BearringAccessoryCustReq> rearBearings) {
		this.rearBearings = rearBearings;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Transient
	private int specId;

	public int getSpecId() {
		return specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;

	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;

	public int getCusSpindleRegId() {
		return cusSpindleRegId;
	}

	public void setCusSpindleRegId(int cusSpindleRegId) {
		this.cusSpindleRegId = cusSpindleRegId;
	}

	public String getSpindleBrand() {
		return spindleBrand;
	}

	public void setSpindleBrand(String spindleBrand) {
		this.spindleBrand = spindleBrand;
	}

	public String getMachineBrand() {
		return machineBrand;
	}

	public void setMachineBrand(String machineBrand) {
		this.machineBrand = machineBrand;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSpindleModel() {
		return spindleModel;
	}

	public void setSpindleModel(String spindleModel) {
		this.spindleModel = spindleModel;
	}

	public String getMachineModel() {
		return machineModel;
	}

	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getOperatingSpeed() {
		return operatingSpeed;
	}

	public void setOperatingSpeed(String operatingSpeed) {
		this.operatingSpeed = operatingSpeed;
	}

	public String getPoles() {
		return poles;
	}

	public void setPoles(String poles) {
		this.poles = poles;
	}

	public String getToolTaper() {
		return toolTaper;
	}

	public void setToolTaper(String toolTaper) {
		this.toolTaper = toolTaper;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getLubrication() {
		return lubrication;
	}

	public void setLubrication(String lubrication) {
		this.lubrication = lubrication;
	}

	public String getAssemblyDrawing() {
		return assemblyDrawing;
	}

	public void setAssemblyDrawing(String assemblyDrawing) {
		this.assemblyDrawing = assemblyDrawing;
	}

	public ServiceReason getReason() {
		return reason;
	}

	public void setReason(ServiceReason reason) {
		this.reason = reason;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	
	
	
	
}



