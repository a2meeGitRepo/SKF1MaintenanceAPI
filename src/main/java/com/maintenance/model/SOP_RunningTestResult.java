/**
 * Dattatray Bodhale
	15-Jul-2021
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
@Table(name="sop_running_test_result")
public class SOP_RunningTestResult {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="sr_no")
	private int srNo;
	
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	
	@Column(name="added_by")
	private int addedBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	
	@Column(name="rpm")
	private String rpm;
	

	@Column(name="time")
	private String time;
	

	@Column(name="vibration_front_horizontal")
	private String vibrationFrontHorizontal;
	

	@Column(name="vibration_front_verticle")
	private String vibrationFrontVerticle;
	

	@Column(name="vibration_rear_horizontal")
	private String vibrationRearHorizontal;
	
	
	@Column(name="vibration_rear_verticle")
	private String vibrationRearVerticle;
	
	
	
	@Column(name="temp_front")
	private String temp_front;
	
	
	@Column(name="temp_rear")
	private String tempRear;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStage_no() {
		return stage_no;
	}


	public void setStage_no(String stage_no) {
		this.stage_no = stage_no;
	}


	public int getSopId() {
		return sopId;
	}


	public void setSopId(int sopId) {
		this.sopId = sopId;
	}


	public int getSrNo() {
		return srNo;
	}


	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public int getAddedBy() {
		return addedBy;
	}


	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}


	public int getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getRpm() {
		return rpm;
	}


	public void setRpm(String rpm) {
		this.rpm = rpm;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getVibrationFrontHorizontal() {
		return vibrationFrontHorizontal;
	}


	public void setVibrationFrontHorizontal(String vibrationFrontHorizontal) {
		this.vibrationFrontHorizontal = vibrationFrontHorizontal;
	}


	public String getVibrationFrontVerticle() {
		return vibrationFrontVerticle;
	}


	public void setVibrationFrontVerticle(String vibrationFrontVerticle) {
		this.vibrationFrontVerticle = vibrationFrontVerticle;
	}


	public String getVibrationRearHorizontal() {
		return vibrationRearHorizontal;
	}


	public void setVibrationRearHorizontal(String vibrationRearHorizontal) {
		this.vibrationRearHorizontal = vibrationRearHorizontal;
	}


	public String getVibrationRearVerticle() {
		return vibrationRearVerticle;
	}


	public void setVibrationRearVerticle(String vibrationRearVerticle) {
		this.vibrationRearVerticle = vibrationRearVerticle;
	}


	public String getTemp_front() {
		return temp_front;
	}


	public void setTemp_front(String temp_front) {
		this.temp_front = temp_front;
	}


	public String getTempRear() {
		return tempRear;
	}


	public void setTempRear(String tempRear) {
		this.tempRear = tempRear;
	}
	
	
	
}



