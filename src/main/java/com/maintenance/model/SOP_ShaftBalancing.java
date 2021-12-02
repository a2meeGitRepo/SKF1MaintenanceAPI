package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_shaft_balancing")
public class SOP_ShaftBalancing {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="balanced_rpm")
	private String balanceRPM;
	
	@Column(name="shaft_weight")
	private String shiftWeight;
	
	@Column(name="unbalance")
	private String unbalance;
	
	@Column(name="plane1")
	private String plane1;
	
	@Column(name="plane2")
	private String plane2;
	
	@Column(name="g_level_rpm")
	private String gLevelRPM;
	
	@Column(name="method_of_balancing")
	private String methodOfBalancing;
	
	@Column(name="check_weight_addition")
	private String checkWeightAddition;
	
	@Column(name="check_weight_removal")
	private String checkWeightRemoval;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="defects")
	private String defects;
	
	@Column(name="unbalance_value")
	private String unbalanceValue;
	
	@Column(name="unbalance_value_after_operation")
	private String unbalanceValueAfterOperation;
	
	@Column(name="done_or_corrected")
	private String doneORCorrected;
	
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

	public String getBalanceRPM() {
		return balanceRPM;
	}

	public void setBalanceRPM(String balanceRPM) {
		this.balanceRPM = balanceRPM;
	}

	public String getShiftWeight() {
		return shiftWeight;
	}

	public void setShiftWeight(String shiftWeight) {
		this.shiftWeight = shiftWeight;
	}

	public String getUnbalance() {
		return unbalance;
	}

	public void setUnbalance(String unbalance) {
		this.unbalance = unbalance;
	}

	public String getPlane1() {
		return plane1;
	}

	public void setPlane1(String plane1) {
		this.plane1 = plane1;
	}

	public String getPlane2() {
		return plane2;
	}

	public void setPlane2(String plane2) {
		this.plane2 = plane2;
	}

	public String getgLevelRPM() {
		return gLevelRPM;
	}

	public void setgLevelRPM(String gLevelRPM) {
		this.gLevelRPM = gLevelRPM;
	}

	public String getMethodOfBalancing() {
		return methodOfBalancing;
	}

	public void setMethodOfBalancing(String methodOfBalancing) {
		this.methodOfBalancing = methodOfBalancing;
	}

	public String getCheckWeightAddition() {
		return checkWeightAddition;
	}

	public void setCheckWeightAddition(String checkWeightAddition) {
		this.checkWeightAddition = checkWeightAddition;
	}

	public String getCheckWeightRemoval() {
		return checkWeightRemoval;
	}

	public void setCheckWeightRemoval(String checkWeightRemoval) {
		this.checkWeightRemoval = checkWeightRemoval;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDefects() {
		return defects;
	}

	public void setDefects(String defects) {
		this.defects = defects;
	}

	public String getUnbalanceValue() {
		return unbalanceValue;
	}

	public void setUnbalanceValue(String unbalanceValue) {
		this.unbalanceValue = unbalanceValue;
	}

	public String getUnbalanceValueAfterOperation() {
		return unbalanceValueAfterOperation;
	}

	public void setUnbalanceValueAfterOperation(String unbalanceValueAfterOperation) {
		this.unbalanceValueAfterOperation = unbalanceValueAfterOperation;
	}

	public String getDoneORCorrected() {
		return doneORCorrected;
	}

	public void setDoneORCorrected(String doneORCorrected) {
		this.doneORCorrected = doneORCorrected;
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
