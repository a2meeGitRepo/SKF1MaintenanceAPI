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
@Table(name="sop_running_test_result_2")
public class SOP_RunningTestResult2 {
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
	
	
	@Column(name="nose_run_out")
	private String noseRunOut;
	

	@Column(name="madrel_near_nose")
	private String madrelNearNose;
	

	@Column(name="madrel_300mm")
	private String madrel300mm;
	

	@Column(name="axial_clearance")
	private String axialClearance;
	

	@Column(name="radial_clearance")
	private String radialClearance;
	
	
	@Column(name="colling_motor")
	private String collingMotor;
	
	
	
	@Column(name="colloing_bearing")
	private String colloingBearing;
	
	
	@Column(name="other")
	private String other;


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


	public String getNoseRunOut() {
		return noseRunOut;
	}


	public void setNoseRunOut(String noseRunOut) {
		this.noseRunOut = noseRunOut;
	}


	public String getMadrelNearNose() {
		return madrelNearNose;
	}


	public void setMadrelNearNose(String madrelNearNose) {
		this.madrelNearNose = madrelNearNose;
	}


	public String getMadrel300mm() {
		return madrel300mm;
	}


	public void setMadrel300mm(String madrel300mm) {
		this.madrel300mm = madrel300mm;
	}


	public String getAxialClearance() {
		return axialClearance;
	}


	public void setAxialClearance(String axialClearance) {
		this.axialClearance = axialClearance;
	}


	public String getRadialClearance() {
		return radialClearance;
	}


	public void setRadialClearance(String radialClearance) {
		this.radialClearance = radialClearance;
	}


	public String getCollingMotor() {
		return collingMotor;
	}


	public void setCollingMotor(String collingMotor) {
		this.collingMotor = collingMotor;
	}


	public String getColloingBearing() {
		return colloingBearing;
	}


	public void setColloingBearing(String colloingBearing) {
		this.colloingBearing = colloingBearing;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}

	
}



