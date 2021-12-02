/**
 * Dattatray Bodhale
	19-Jun-2021
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
@Table(name="sop_power_cabels")
public class SOP_PowerCables {
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="no_of_cables")
	private int noOfCables;
	
	@Column(name="cable_length")
	private String cableLength;
	
	@Column(name="cable_thickness")
	private String cableThickness;
	
	
	@Column(name="check_cabble")
	private boolean checkCabble;
	
	@Column(name="check_contact")
	private boolean checkContact;
	
	
	@Column(name="defect_cabble")
	private boolean defectCabble;
	
	@Column(name="defect_contact")
	private boolean defectContact;
	
	
	
	@Column(name="corrected_cabble")
	private boolean correctedCabble;
	
	@Column(name="corrected_contact")
	private boolean correctedContact;
	
	
	@Column(name="others")
	private String others;
	
	
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

	public int getNoOfCables() {
		return noOfCables;
	}

	public void setNoOfCables(int noOfCables) {
		this.noOfCables = noOfCables;
	}

	public String getCableLength() {
		return cableLength;
	}

	public void setCableLength(String cableLength) {
		this.cableLength = cableLength;
	}

	public String getCableThickness() {
		return cableThickness;
	}

	public void setCableThickness(String cableThickness) {
		this.cableThickness = cableThickness;
	}



	public boolean isCheckCabble() {
		return checkCabble;
	}

	public void setCheckCabble(boolean checkCabble) {
		this.checkCabble = checkCabble;
	}

	public boolean isCheckContact() {
		return checkContact;
	}

	public void setCheckContact(boolean checkContact) {
		this.checkContact = checkContact;
	}

	public boolean isDefectCabble() {
		return defectCabble;
	}

	public void setDefectCabble(boolean defectCabble) {
		this.defectCabble = defectCabble;
	}

	public boolean isDefectContact() {
		return defectContact;
	}

	public void setDefectContact(boolean defectContact) {
		this.defectContact = defectContact;
	}

	public boolean isCorrectedCabble() {
		return correctedCabble;
	}

	public void setCorrectedCabble(boolean correctedCabble) {
		this.correctedCabble = correctedCabble;
	}

	public boolean isCorrectedContact() {
		return correctedContact;
	}

	public void setCorrectedContact(boolean correctedContact) {
		this.correctedContact = correctedContact;
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



