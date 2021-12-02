/**
 * Dattatray Bodhale
	15-Jun-2021
 */
package com.maintenance.dto;

import java.util.Date;

/**
 * @author Dattatray Bodhale
 *
 */
public class SpindleServiceRequestDTO {
	@Override
	public String toString() {
		return "SpindleServiceRequestDTO [spindleServicceRequestId=" + spindleServicceRequestId + ", employeeId="
				+ employeeId + ", sscNo=" + sscNo + ", spindleBrand=" + spindleBrand + ", machineBrand=" + machineBrand
				+ ", serialNo=" + serialNo + ", spindleModel=" + spindleModel + ", machineModel=" + machineModel
				+ ", spindleRequestedDate=" + spindleRequestedDate + ", getSpindleServicceRequestId()="
				+ getSpindleServicceRequestId() + ", getSscNo()=" + getSscNo() + ", getSpindleBrand()="
				+ getSpindleBrand() + ", getMachineBrand()=" + getMachineBrand() + ", getSerialNo()=" + getSerialNo()
				+ ", getSpindleModel()=" + getSpindleModel() + ", getMachineModel()=" + getMachineModel()
				+ ", getSpindleRequestedDate()=" + getSpindleRequestedDate() + ", getEmployeeId()=" + getEmployeeId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	private int spindleServicceRequestId;
	
	private int employeeId;
	private String sscNo;
	private String spindleBrand;
	private String machineBrand;
	private String serialNo;
	private String spindleModel;
	private String machineModel;
	private Date spindleRequestedDate;
	public int getSpindleServicceRequestId() {
		return spindleServicceRequestId;
	}
	public void setSpindleServicceRequestId(int spindleServicceRequestId) {
		this.spindleServicceRequestId = spindleServicceRequestId;
	}
	public String getSscNo() {
		return sscNo;
	}
	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
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
	public Date getSpindleRequestedDate() {
		return spindleRequestedDate;
	}
	public void setSpindleRequestedDate(Date spindleRequestedDate) {
		this.spindleRequestedDate = spindleRequestedDate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	
}



