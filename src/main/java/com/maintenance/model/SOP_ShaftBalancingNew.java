/**
 * Dattatray Bodhale
	22-Jul-2021
 */
package com.maintenance.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author Dattatray Bodhale
 *
 */

@Entity
@Table(name="sop_shaft_balancing_new")
public class SOP_ShaftBalancingNew {
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
	
	@Column(name="action")
	private String action;
	
	@Column(name="weight_addition")
	private String weightAddition;
	
	@Column(name="weight_removal")
	private String weightRemoval;
	
	@Column(name="remark")
	private String remark;
	
	
	
	@Transient
	List<SOP_ShaftBalancingNewMapped> list;
	
	
	
	
	public List<SOP_ShaftBalancingNewMapped> getList() {
		return list;
	}

	public void setList(List<SOP_ShaftBalancingNewMapped> list) {
		this.list = list;
	}

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public String getWeightAddition() {
		return weightAddition;
	}

	public void setWeightAddition(String weightAddition) {
		this.weightAddition = weightAddition;
	}

	public String getWeightRemoval() {
		return weightRemoval;
	}

	public void setWeightRemoval(String weightRemoval) {
		this.weightRemoval = weightRemoval;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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



