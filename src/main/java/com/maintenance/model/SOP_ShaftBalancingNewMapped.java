/**
 * Dattatray Bodhale
	22-Jul-2021
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
@Table(name="sop_shaft_balancing_new_mapped")
public class SOP_ShaftBalancingNewMapped {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="shaft_weight")
	private String shaftWeight;
	
	@Column(name="defects")
	private String defects;
	
	@Column(name="unbalance_value")
	private String unbalanceValue;
	
	@Column(name="unbalance_value_operation")
	private String unbalanceValueOperation;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="done_corrected")
	private String doneCorrected;
	
	
	
	
		
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

	public String getShaftWeight() {
		return shaftWeight;
	}

	public void setShaftWeight(String shaftWeight) {
		this.shaftWeight = shaftWeight;
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

	public String getUnbalanceValueOperation() {
		return unbalanceValueOperation;
	}

	public void setUnbalanceValueOperation(String unbalanceValueOperation) {
		this.unbalanceValueOperation = unbalanceValueOperation;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getDoneCorrected() {
		return doneCorrected;
	}

	public void setDoneCorrected(String doneCorrected) {
		this.doneCorrected = doneCorrected;
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



