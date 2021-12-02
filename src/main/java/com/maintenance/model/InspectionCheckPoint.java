/**
 * Dattatray Bodhale
	13-May-2021
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
@Table(name="mst_inspection_checkpoint")
public class InspectionCheckPoint {
	
	@Id
	@GeneratedValue
	@Column(name="inspection_checkpoint_id")
	private int inspectionCheckpointId;
	
	@Column(name="check_point_name")
	private String checkPointName;
	

	@Column(name="default_value")
	private String defaultValue;

	@Column(name="default_condistion")
	private String defaultCondistion;
	

	@Column(name="remark")
	private String remark;

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;

	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;

	@Column(name="del_bit")
	private int delBit;

	public int getInspectionCheckpointId() {
		return inspectionCheckpointId;
	}

	public void setInspectionCheckpointId(int inspectionCheckpointId) {
		this.inspectionCheckpointId = inspectionCheckpointId;
	}

	public String getCheckPointName() {
		return checkPointName;
	}

	public void setCheckPointName(String checkPointName) {
		this.checkPointName = checkPointName;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDefaultCondistion() {
		return defaultCondistion;
	}

	public void setDefaultCondistion(String defaultCondistion) {
		this.defaultCondistion = defaultCondistion;
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

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDelBit() {
		return delBit;
	}

	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}

	
	

}



