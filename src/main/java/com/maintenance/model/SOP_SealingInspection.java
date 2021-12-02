package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_sealing_inspection")
public class SOP_SealingInspection {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="check_labyrinth")
	private String checkLabyrinth;
	
	@Column(name="check_rubber_seal")
	private String checkRubberSeal;
	
	@Column(name="check_cleanliness")
	private String checkCleanLiness;
	
	@Column(name="check_seals")
	private String checkSeals;
	
	@Column(name="check_condition")
	private String checkCondition;
	
	@Column(name="correct_rubber_seal")
	private String correctRubberSeal;
	
	@Column(name="correct_air_seal")
	private String correctAirSeal;
	
	@Column(name="correct_gmn_seal")
	private String correctGMNSeal;
	
	@Column(name="other")
	private String other;

	@Column(name="check_gmn_seal")
	private String checkGMNSeal;
	
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

	public String getCheckLabyrinth() {
		return checkLabyrinth;
	}

	public void setCheckLabyrinth(String checkLabyrinth) {
		this.checkLabyrinth = checkLabyrinth;
	}

	public String getCheckRubberSeal() {
		return checkRubberSeal;
	}

	public void setCheckRubberSeal(String checkRubberSeal) {
		this.checkRubberSeal = checkRubberSeal;
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

	public String getCorrectRubberSeal() {
		return correctRubberSeal;
	}

	public void setCorrectRubberSeal(String correctRubberSeal) {
		this.correctRubberSeal = correctRubberSeal;
	}

	public String getCorrectAirSeal() {
		return correctAirSeal;
	}

	public void setCorrectAirSeal(String correctAirSeal) {
		this.correctAirSeal = correctAirSeal;
	}

	public String getCorrectGMNSeal() {
		return correctGMNSeal;
	}

	public void setCorrectGMNSeal(String correctGMNSeal) {
		this.correctGMNSeal = correctGMNSeal;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getCheckGMNSeal() {
		return checkGMNSeal;
	}

	public void setCheckGMNSeal(String checkGMNSeal) {
		this.checkGMNSeal = checkGMNSeal;
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
