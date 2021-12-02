package com.maintenance.dto;

import java.util.List;

import javax.persistence.Transient;


public class ComplaintVisitImage {
	
	
	private int stageNo;
	private int sopId;
	private List<ImageCode> images;
	public int getStageNo() {
		return stageNo;
	}
	public void setStageNo(int stageNo) {
		this.stageNo = stageNo;
	}
	public int getSopId() {
		return sopId;
	}
	public void setSopId(int sopId) {
		this.sopId = sopId;
	}
	public List<ImageCode> getImages() {
		return images;
	}
	public void setImages(List<ImageCode> images) {
		this.images = images;
	}
	public int getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}
	
	private int technicianId;




    
  

    
    
}
