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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="inspection_stages_checkpoint")
public class InspectionStagesCheckpoint {
	
	
	@Id
	@GeneratedValue
	@Column(name="inspection_stages_checkpoint_id")
	private int inspectionStagesCheckpointId;
	

	@ManyToOne
	@JoinColumn(name="inspection_stage_id")
	private InspectionStage inspectionStage;
	
	@ManyToOne
	@JoinColumn(name="inspection_checkpoint_id")
	private InspectionCheckPoint inspectionCheckPoint;
	
	
	@Column(name="active")
	private int active;
	
	@Column(name="sequence_no")
	private int sequence_no;
	
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="del_bit")
	private int delBit;
	
	
	public int getDelBit() {
		return delBit;
	}


	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}


	@Column(name="added_date")
	private Date addedDate;


	public int getInspectionStagesCheckpointId() {
		return inspectionStagesCheckpointId;
	}


	public void setInspectionStagesCheckpointId(int inspectionStagesCheckpointId) {
		this.inspectionStagesCheckpointId = inspectionStagesCheckpointId;
	}


	public InspectionStage getInspectionStage() {
		return inspectionStage;
	}


	public void setInspectionStage(InspectionStage inspectionStage) {
		this.inspectionStage = inspectionStage;
	}


	public InspectionCheckPoint getInspectionCheckPoint() {
		return inspectionCheckPoint;
	}


	public void setInspectionCheckPoint(InspectionCheckPoint inspectionCheckPoint) {
		this.inspectionCheckPoint = inspectionCheckPoint;
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


	public int getSequence_no() {
		return sequence_no;
	}


	public void setSequence_no(int sequence_no) {
		this.sequence_no = sequence_no;
	}
	
	
	
	
	

}



