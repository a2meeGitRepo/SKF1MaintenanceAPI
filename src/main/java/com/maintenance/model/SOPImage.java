/**
 * Dattatray Bodhale
	22-Jun-2021
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
@Table(name="sop_image")
public class SOPImage {
	
	@Id
	@GeneratedValue
	@Column(name="sop_image_id")
	private int sopImageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="base_code")
	private String base64Code;
	
	@Column(name="image_selected")
	private boolean imageSelected;
	
	
	public boolean isImageSelected() {
		return imageSelected;
	}


	public void setImageSelected(boolean imageSelected) {
		this.imageSelected = imageSelected;
	}


	public String getBase64Code() {
		return base64Code;
	}


	public void setBase64Code(String base64Code) {
		this.base64Code = base64Code;
	}


	@Column(name="location")
	private String location;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stageNo")
	private int stageNo;
	
	@Column(name="technician_id")
	private int technicianId;
	
	@Column(name="report_send")
	private int reportSend;
	
	
	@Column(name="added_date")
	private Date addedDate;


	public int getSopImageId() {
		return sopImageId;
	}


	public void setSopImageId(int sopImageId) {
		this.sopImageId = sopImageId;
	}


	


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}




	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getSopId() {
		return sopId;
	}


	public void setSopId(int sopId) {
		this.sopId = sopId;
	}


	public int getStageNo() {
		return stageNo;
	}


	public void setStageNo(int stageNo) {
		this.stageNo = stageNo;
	}


	public int getTechnicianId() {
		return technicianId;
	}


	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}


	public int getReportSend() {
		return reportSend;
	}


	public void setReportSend(int reportSend) {
		this.reportSend = reportSend;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	
	
	
	
	

}



