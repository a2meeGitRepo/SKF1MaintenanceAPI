/**
 * Dattatray Bodhale
	28-Jun-2021
 */
package com.maintenance.dto;

import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public class SOP_TechnicalDetials {
	private Employee technician;
	
	private String sscNo;
	private String date;
	public Employee getTechnician() {
		return technician;
	}
	public void setTechnician(Employee technician) {
		this.technician = technician;
	}
	public String getSscNo() {
		return sscNo;
	}
	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}



