/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.dto;

import java.util.List;

import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;
import com.maintenance.model.InspectionStagesCheckpoint;

/**
 * @author Dattatray Bodhale
 *
 */
public class InspectionDTO {
	private InspectionStage inspectionStage;
	private List<InspectionCheckPoint> checkpoints;
	private String addedBy;
	public InspectionStage getInspectionStage() {
		return inspectionStage;
	}
	public void setInspectionStage(InspectionStage inspectionStage) {
		this.inspectionStage = inspectionStage;
	}
	public List<InspectionCheckPoint> getCheckpoints() {
		return checkpoints;
	}
	public void setCheckpoints(List<InspectionCheckPoint> checkpoints) {
		this.checkpoints = checkpoints;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	

}



