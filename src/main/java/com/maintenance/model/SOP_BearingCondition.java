/**
 * Dattatray Bodhale
	30-Jun-2021
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
@Table(name="sop_bearing_condition")
public class SOP_BearingCondition {
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
	
	
	
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	
	@Column(name="added_by")
	private int addedBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	
	
	@Column(name="bearing_items")
	private String bearingItems;
	

	@Column(name="bearing_1")
	private String bearing1;

	@Column(name="bearing_2")
	private String bearing2;

	@Column(name="bearing_3")
	private String bearing3;

	@Column(name="bearing_4")
	private String bearing4;

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

	public String getBearingItems() {
		return bearingItems;
	}

	public void setBearingItems(String bearingItems) {
		this.bearingItems = bearingItems;
	}

	public String getBearing1() {
		return bearing1;
	}

	public void setBearing1(String bearing1) {
		this.bearing1 = bearing1;
	}

	public String getBearing2() {
		return bearing2;
	}

	public void setBearing2(String bearing2) {
		this.bearing2 = bearing2;
	}

	public String getBearing3() {
		return bearing3;
	}

	public void setBearing3(String bearing3) {
		this.bearing3 = bearing3;
	}

	public String getBearing4() {
		return bearing4;
	}

	public void setBearing4(String bearing4) {
		this.bearing4 = bearing4;
	}

	@Override
	public String toString() {
		return "SOP_BearingCondition [id=" + id + ", stage_no=" + stage_no + ", sopId=" + sopId + ", srNo=" + srNo
				+ ", updatedDate=" + updatedDate + ", addedBy=" + addedBy + ", updatedBy=" + updatedBy
				+ ", bearingItems=" + bearingItems + ", bearing1=" + bearing1 + ", bearing2=" + bearing2 + ", bearing3="
				+ bearing3 + ", bearing4=" + bearing4 + ", getId()=" + getId() + ", getStage_no()=" + getStage_no()
				+ ", getSopId()=" + getSopId() + ", getSrNo()=" + getSrNo() + ", getUpdatedDate()=" + getUpdatedDate()
				+ ", getAddedBy()=" + getAddedBy() + ", getUpdatedBy()=" + getUpdatedBy() + ", getBearingItems()="
				+ getBearingItems() + ", getBearing1()=" + getBearing1() + ", getBearing2()=" + getBearing2()
				+ ", getBearing3()=" + getBearing3() + ", getBearing4()=" + getBearing4() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

}



