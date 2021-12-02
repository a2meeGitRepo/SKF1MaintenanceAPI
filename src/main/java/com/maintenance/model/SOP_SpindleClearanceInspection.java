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
@Table(name="sop_spindle_clearance_inspection")
public class SOP_SpindleClearanceInspection {

	
	
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
	
	
	@Column(name="axial_force")
	private String axialForce;
	
	
	@Column(name="radial_force")
	private String radialForce;
	
	
	@Column(name="axial_clerance")
	private String axialClerance;
	
	
	@Column(name="radial_clerance")
	private String radialClerance;
	
	
	
	@Column(name="ok_clearance")
	private String ok_clearance;
	
	
	
	@Column(name="stiffness")
	private String stiffness;
	
	
	

	@Column(name=" unclamp_force")
	private String unclampForce;
	
	
	
	@Column(name="clearance")
	private String clearance;
	
	
	@Column(name="standard_stiffness")
	private String standardStiffness;


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


	public String getAxialForce() {
		return axialForce;
	}


	public void setAxialForce(String axialForce) {
		this.axialForce = axialForce;
	}


	public String getRadialForce() {
		return radialForce;
	}


	public void setRadialForce(String radialForce) {
		this.radialForce = radialForce;
	}


	public String getAxialClerance() {
		return axialClerance;
	}


	public void setAxialClerance(String axialClerance) {
		this.axialClerance = axialClerance;
	}


	public String getRadialClerance() {
		return radialClerance;
	}


	public void setRadialClerance(String radialClerance) {
		this.radialClerance = radialClerance;
	}


	public String getOk_clearance() {
		return ok_clearance;
	}


	public void setOk_clearance(String ok_clearance) {
		this.ok_clearance = ok_clearance;
	}


	public String getStiffness() {
		return stiffness;
	}


	public void setStiffness(String stiffness) {
		this.stiffness = stiffness;
	}


	public String getUnclampForce() {
		return unclampForce;
	}


	public void setUnclampForce(String unclampForce) {
		this.unclampForce = unclampForce;
	}


	public String getClearance() {
		return clearance;
	}


	public void setClearance(String clearance) {
		this.clearance = clearance;
	}


	public String getStandardStiffness() {
		return standardStiffness;
	}


	public void setStandardStiffness(String standardStiffness) {
		this.standardStiffness = standardStiffness;
	}
	
	
	
	
	
	
	

	
	
	
	
	
}



