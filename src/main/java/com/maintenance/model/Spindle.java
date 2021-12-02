/**
 * Dattatray Bodhale
	06-May-2021
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
@Table(name="mst_spindle")
public class Spindle {

	@Id
	@GeneratedValue
	@Column(name="spindle_id")
	private int spindleId;
	
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
	
		
	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	@Column(name="lubrication")
	private String lubrication;
	
	@Column(name="assembly_drawing")
	private String assemblyDrawing;

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;

	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;

	@Column(name="del_bit")
	private int delBit;

	public int getSpindleId() {
		return spindleId;
	}

	public void setSpindleId(int spindleId) {
		this.spindleId = spindleId;
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

	public int getDelBit() {
		return delBit;
	}

	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}


	
	
	
}



