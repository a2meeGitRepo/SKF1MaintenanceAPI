package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_lubrication_system_inspection")
public class SOP_LubricationSystemInspection {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="check_oilair")
	private String checkOilAir;
	
	@Column(name="check_oilmist")
	private String checkOilMist;
	
	@Column(name="air_pressure")
	private String airPressure;
	
	@Column(name="oil_type")
	private String oilType;
	
	@Column(name="other")
	private String other;
	
	@Column(name="check_cleanliness")
	private String checkCleanLiness;
	
	@Column(name="check_seals")
	private String checkSeals;
	
	@Column(name="check_condition")
	private String checkCondition;
	
	@Column(name="correct_seals")
	private String correctSeals;
	
	@Column(name="o_rings")
	private String oRings;
	
	@Column(name="nozzles")
	private String nozzles;
	
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

	public String getCheckOilAir() {
		return checkOilAir;
	}

	public void setCheckOilAir(String checkOilAir) {
		this.checkOilAir = checkOilAir;
	}

	public String getCheckOilMist() {
		return checkOilMist;
	}

	public void setCheckOilMist(String checkOilMist) {
		this.checkOilMist = checkOilMist;
	}

	public String getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public String getOilType() {
		return oilType;
	}

	public void setOilType(String oilType) {
		this.oilType = oilType;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getCheckCleanLiness() {
		return checkCleanLiness;
	}

	public void setCheckCleanLiness(String checkCleanLiness) {
		this.checkCleanLiness = checkCleanLiness;
	}

	public String getCheckSeals() {
		return checkSeals;
	}

	public void setCheckSeals(String checkSeals) {
		this.checkSeals = checkSeals;
	}

	public String getCheckCondition() {
		return checkCondition;
	}

	public void setCheckCondition(String checkCondition) {
		this.checkCondition = checkCondition;
	}

	public String getCorrectSeals() {
		return correctSeals;
	}

	public void setCorrectSeals(String correctSeals) {
		this.correctSeals = correctSeals;
	}

	public String getoRings() {
		return oRings;
	}

	public void setoRings(String oRings) {
		this.oRings = oRings;
	}

	public String getNozzles() {
		return nozzles;
	}

	public void setNozzles(String nozzles) {
		this.nozzles = nozzles;
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
