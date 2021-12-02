/**
 * Dattatray Bodhale
	07-Jul-2021
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
@Table(name="sop_component_inspection_1")
public class SOP_ComponentInspection_1 {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="sr_no")
	private int srNo;
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	
	@Column(name="added_by")
	private int addedBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	
	

	@Column(name="type")
	private String type;
	
	@Column(name="size")
	private String size;
	
	
	@Column(name="taper")
	private String taper;
	
	
	@Column(name="ovality")
	private String ovality;
	
	
	@Column(name="total_runout")
	private String total_runout;


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


	public int getSrNo() {
		return srNo;
	}


	public void setSrNo(int srNo) {
		this.srNo = srNo;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getTaper() {
		return taper;
	}


	public void setTaper(String taper) {
		this.taper = taper;
	}


	public String getOvality() {
		return ovality;
	}


	public void setOvality(String ovality) {
		this.ovality = ovality;
	}


	public String getTotal_runout() {
		return total_runout;
	}


	public void setTotal_runout(String total_runout) {
		this.total_runout = total_runout;
	}
	


}



