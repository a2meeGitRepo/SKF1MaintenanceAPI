package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_drawbar_spring_inspection")
public class SOP_DrawbarSpringInspection {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="no_of_springs")
	private String noOfSpring;
	
	@Column(name="front_side")
	private String frontSide;
	
	@Column(name="rear_side")
	private String rearSide;
	
	@Column(name="clamping_force")
	private String clampingForce;
	
	@Column(name="id_equal_to")
	private String idEqualTo;
	
	@Column(name="od_equal_to")
	private String odEqualTo;
	
	@Column(name="height")
	private String height;
	
	@Column(name="width")
	private String width;
	
	@Column(name="no_of_rev")
	private String noOfRev;
	
	@Column(name="wire_size")
	private String wireSize;
	
	@Column(name="forced")
	private String force;
	
	@Column(name="burned")
	private String burned;
	
	@Column(name="corrosion")
	private String corrosion;
	
	@Column(name="details")
	private String details;
	
	@Column(name="added_date")
	private Date addedDate;
		
	@Column(name="updated_date")
	private Date updatedDate;
		
	@Column(name="added_by")
	private int addedBy;
	
	@Column(name="updated_by")
	private int updatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSopId() {
		return sopId;
	}

	public void setSopId(int sopId) {
		this.sopId = sopId;
	}

	public String getStage_no() {
		return stage_no;
	}

	public void setStage_no(String stage_no) {
		this.stage_no = stage_no;
	}

	public String getNoOfSpring() {
		return noOfSpring;
	}

	public void setNoOfSpring(String noOfSpring) {
		this.noOfSpring = noOfSpring;
	}

	public String getFrontSide() {
		return frontSide;
	}

	public void setFrontSide(String frontSide) {
		this.frontSide = frontSide;
	}

	public String getRearSide() {
		return rearSide;
	}

	public void setRearSide(String rearSide) {
		this.rearSide = rearSide;
	}

	public String getClampingForce() {
		return clampingForce;
	}

	public void setClampingForce(String clampingForce) {
		this.clampingForce = clampingForce;
	}

	public String getIdEqualTo() {
		return idEqualTo;
	}

	public void setIdEqualTo(String idEqualTo) {
		this.idEqualTo = idEqualTo;
	}

	public String getOdEqualTo() {
		return odEqualTo;
	}

	public void setOdEqualTo(String odEqualTo) {
		this.odEqualTo = odEqualTo;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getNoOfRev() {
		return noOfRev;
	}

	public void setNoOfRev(String noOfRev) {
		this.noOfRev = noOfRev;
	}

	public String getWireSize() {
		return wireSize;
	}

	public void setWireSize(String wireSize) {
		this.wireSize = wireSize;
	}

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}

	public String getBurned() {
		return burned;
	}

	public void setBurned(String burned) {
		this.burned = burned;
	}

	public String getCorrosion() {
		return corrosion;
	}

	public void setCorrosion(String corrosion) {
		this.corrosion = corrosion;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
	
	
}
