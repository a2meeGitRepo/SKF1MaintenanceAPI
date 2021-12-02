/**
 * Dattatray Bodhale
	15-Jun-2021
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
import javax.persistence.Transient;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="sop_stages_status")
public class SOPStageStatus {
	
	@Id
	@GeneratedValue
	@Column(name="sop_stage_id")
	private int sopStageId;
	
	@ManyToOne
	@JoinColumn(name="sop_id")
	private SOP  sop;
	
	@Transient
	private int sopId;

	@Column(name="stage_no")
	private int stageNo;
	
	
	
	
	public int getSopId() {
		return sopId;
	}

	public void setSopId(int sopId) {
		this.sopId = sopId;
	}

	@Column(name="stage_name")
	private String stageName;
	
	@Column(name="stage_type")
	private String stageType;
	
	public String getStageType() {
		return stageType;
	}

	public void setStageType(String stageType) {
		this.stageType = stageType;
	}

	@Column(name="status")
	private String status;
	
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="complete_date")
	private Date completeDate;

	@Column(name="added_date")
	private Date added_date;

	public int getSopStageId() {
		return sopStageId;
	}

	public void setSopStageId(int sopStageId) {
		this.sopStageId = sopStageId;
	}

	public SOP getSop() {
		return sop;
	}

	public void setSop(SOP sop) {
		this.sop = sop;
	}

	public int getStageNo() {
		return stageNo;
	}

	public void setStageNo(int stageNo) {
		this.stageNo = stageNo;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	
	
	
	
}



