/**
 * Dattatray Bodhale
	14-May-2021
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
@Table(name="mst_inspection_stage")
public class InspectionStage {
	
	
	@Id
	@GeneratedValue
	@Column(name="inspection_stage_id")
	private int inspectionStageId;
	
	@Column(name="stage_no")
	private String stageNo;
	
	@Column(name="stage_name")
	private String stageName;
	
	
	@Column(name="spindle_model")
	private String spindleModel;
	
	
	@Column(name="del_bit")
	private int delBit;
	
	@Column(name="active")
	private int active;
	
	
	@Column(name="added_by")
	private String addedBy;
	

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="no_of_checkpoint")
	private int noOfCheckpoint;

	public int getInspectionStageId() {
		return inspectionStageId;
	}

	public void setInspectionStageId(int inspectionStageId) {
		this.inspectionStageId = inspectionStageId;
	}

	public String getStageNo() {
		return stageNo;
	}

	public void setStageNo(String stageNo) {
		this.stageNo = stageNo;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getSpindleModel() {
		return spindleModel;
	}

	public void setSpindleModel(String spindleModel) {
		this.spindleModel = spindleModel;
	}

	public int getDelBit() {
		return delBit;
	}

	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public int getNoOfCheckpoint() {
		return noOfCheckpoint;
	}

	public void setNoOfCheckpoint(int noOfCheckpoint) {
		this.noOfCheckpoint = noOfCheckpoint;
	}
	
	
	
	

}



