/**
 * Dattatray Bodhale
	04-Jul-2021
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
@Table(name="sop_cooling_system_inspection")
public class SOP_ColloingSystemInspection {

	
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
	
	
	
	
	
	@Column(name="cooling_front_bearing")
	private String coolingFrontBearing;
	
	
	
	@Column(name="cooling_rear_bearing")
	private String coolingRearBearing;
	
	
	@Column(name="colling_motor")
	private String collingMotor;
	
	@Column(name="seals")
	private String seals;
	
	
	@Column(name="o_ring")
	private String oRing;
	
	@Column(name="corrosion")
	private String corrosion;
	
	
	
	
	
	

	@Column(name="seal_d")
	private String seal_dc;
	
	@Column(name="o_ring_d")
	private String oRing_dc;
	
	
	@Column(name="corrosion_d")
	private String corrosion_dc;
	
	@Column(name="others")
	private String others;

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

	public String getCoolingFrontBearing() {
		return coolingFrontBearing;
	}

	public void setCoolingFrontBearing(String coolingFrontBearing) {
		this.coolingFrontBearing = coolingFrontBearing;
	}

	public String getCoolingRearBearing() {
		return coolingRearBearing;
	}

	public void setCoolingRearBearing(String coolingRearBearing) {
		this.coolingRearBearing = coolingRearBearing;
	}

	public String getCollingMotor() {
		return collingMotor;
	}

	public void setCollingMotor(String collingMotor) {
		this.collingMotor = collingMotor;
	}

	public String getSeals() {
		return seals;
	}

	public void setSeals(String seals) {
		this.seals = seals;
	}

	public String getoRing() {
		return oRing;
	}

	public void setoRing(String oRing) {
		this.oRing = oRing;
	}

	public String getCorrosion() {
		return corrosion;
	}

	public void setCorrosion(String corrosion) {
		this.corrosion = corrosion;
	}

	public String getSeal_dc() {
		return seal_dc;
	}

	public void setSeal_dc(String seal_dc) {
		this.seal_dc = seal_dc;
	}

	public String getoRing_dc() {
		return oRing_dc;
	}

	public void setoRing_dc(String oRing_dc) {
		this.oRing_dc = oRing_dc;
	}

	public String getCorrosion_dc() {
		return corrosion_dc;
	}

	public void setCorrosion_dc(String corrosion_dc) {
		this.corrosion_dc = corrosion_dc;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	
	
	
	
	
	
	
	
	
	
}



