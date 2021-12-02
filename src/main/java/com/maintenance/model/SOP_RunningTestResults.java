package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_running_test_results")
public class SOP_RunningTestResults {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="rpm_500")
	private String rpm500;
	
	@Column(name="rpm_1000")
	private String rpm1000;
	
	@Column(name="rpm_2000")
	private String rpm2000;
	
	@Column(name="rpm_3000")
	private String rpm3000;
	
	@Column(name="rpm_4000")
	private String rpm4000;
	
	@Column(name="rpm_5000")
	private String rpm5000;
	
	@Column(name="rpm_6000")
	private String rpm6000;
	
	@Column(name="rpm_7000")
	private String rpm7000;
	
	@Column(name="rpm_8000")
	private String rpm8000;
	
	@Column(name="rpm_9000")
	private String rpm9000;
	
	@Column(name="rpm_10000")
	private String rpm10000;
	
	@Column(name="rpm_11000")
	private String rpm11000;
	
	@Column(name="rpm_12000")
	private String rpm12000;
	
	@Column(name="rpm_13000")
	private String rpm13000;
	
	@Column(name="rpm_14000")
	private String rpm14000;
	
	@Column(name="rpm_15000")
	private String rpm15000;
	
	@Column(name="colling_motor")
	private String collingMotor;
	
	@Column(name="cooling_bearing")
	private String coolingBearing;
	
	@Column(name="other")
	private String other;
	
	@Column(name="vertical_front")
	private String verticalFront;
	
	@Column(name="horizontal_front")
	private String horizontalFront;
	
	@Column(name="vertical_rear")
	private String verticalRear;
	
	@Column(name="horizontal_rear")
	private String horizontalRear;
	
	@Column(name="front")
	private String front;
	
	@Column(name="rear")
	private String rear;
	
	@Column(name="run_out_nose")
	private String runOutNose;
	
	@Column(name="on_mandrel_near_nose")
	private String onMandrelNearNose;
	
	@Column(name="on_mandrel_300mm_nose")
	private String onMandrel300mmNose;
	
	@Column(name="axial_clearance")
	private String axialClearance;
	
	@Column(name="radial_clearance")
	private String radialClearance;
	
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

	public int getSopId() {
		return sopId;
	}

	public void setSopId(int sopId) {
		this.sopId = sopId;
	}

	public String getStage_no() {
		return stage_no;
	}

	public void setStage_no(String stage_no) {
		this.stage_no = stage_no;
	}

	public String getRpm500() {
		return rpm500;
	}

	public void setRpm500(String rpm500) {
		this.rpm500 = rpm500;
	}

	public String getRpm1000() {
		return rpm1000;
	}

	public void setRpm1000(String rpm1000) {
		this.rpm1000 = rpm1000;
	}

	public String getRpm2000() {
		return rpm2000;
	}

	public void setRpm2000(String rpm2000) {
		this.rpm2000 = rpm2000;
	}

	public String getRpm3000() {
		return rpm3000;
	}

	public void setRpm3000(String rpm3000) {
		this.rpm3000 = rpm3000;
	}

	public String getRpm4000() {
		return rpm4000;
	}

	public void setRpm4000(String rpm4000) {
		this.rpm4000 = rpm4000;
	}

	public String getRpm5000() {
		return rpm5000;
	}

	public void setRpm5000(String rpm5000) {
		this.rpm5000 = rpm5000;
	}

	public String getRpm6000() {
		return rpm6000;
	}

	public void setRpm6000(String rpm6000) {
		this.rpm6000 = rpm6000;
	}

	public String getRpm7000() {
		return rpm7000;
	}

	public void setRpm7000(String rpm7000) {
		this.rpm7000 = rpm7000;
	}

	public String getRpm8000() {
		return rpm8000;
	}

	public void setRpm8000(String rpm8000) {
		this.rpm8000 = rpm8000;
	}

	public String getRpm9000() {
		return rpm9000;
	}

	public void setRpm9000(String rpm9000) {
		this.rpm9000 = rpm9000;
	}

	public String getRpm10000() {
		return rpm10000;
	}

	public void setRpm10000(String rpm10000) {
		this.rpm10000 = rpm10000;
	}

	public String getRpm11000() {
		return rpm11000;
	}

	public void setRpm11000(String rpm11000) {
		this.rpm11000 = rpm11000;
	}

	public String getRpm12000() {
		return rpm12000;
	}

	public void setRpm12000(String rpm12000) {
		this.rpm12000 = rpm12000;
	}

	public String getRpm13000() {
		return rpm13000;
	}

	public void setRpm13000(String rpm13000) {
		this.rpm13000 = rpm13000;
	}

	public String getRpm14000() {
		return rpm14000;
	}

	public void setRpm14000(String rpm14000) {
		this.rpm14000 = rpm14000;
	}

	public String getRpm15000() {
		return rpm15000;
	}

	public void setRpm15000(String rpm15000) {
		this.rpm15000 = rpm15000;
	}

	public String getCollingMotor() {
		return collingMotor;
	}

	public void setCollingMotor(String collingMotor) {
		this.collingMotor = collingMotor;
	}

	public String getCoolingBearing() {
		return coolingBearing;
	}

	public void setCoolingBearing(String coolingBearing) {
		this.coolingBearing = coolingBearing;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getVerticalFront() {
		return verticalFront;
	}

	public void setVerticalFront(String verticalFront) {
		this.verticalFront = verticalFront;
	}

	public String getHorizontalFront() {
		return horizontalFront;
	}

	public void setHorizontalFront(String horizontalFront) {
		this.horizontalFront = horizontalFront;
	}

	public String getVerticalRear() {
		return verticalRear;
	}

	public void setVerticalRear(String verticalRear) {
		this.verticalRear = verticalRear;
	}

	public String getHorizontalRear() {
		return horizontalRear;
	}

	public void setHorizontalRear(String horizontalRear) {
		this.horizontalRear = horizontalRear;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getRear() {
		return rear;
	}

	public void setRear(String rear) {
		this.rear = rear;
	}

	public String getRunOutNose() {
		return runOutNose;
	}

	public void setRunOutNose(String runOutNose) {
		this.runOutNose = runOutNose;
	}

	public String getOnMandrelNearNose() {
		return onMandrelNearNose;
	}

	public void setOnMandrelNearNose(String onMandrelNearNose) {
		this.onMandrelNearNose = onMandrelNearNose;
	}

	public String getOnMandrel300mmNose() {
		return onMandrel300mmNose;
	}

	public void setOnMandrel300mmNose(String onMandrel300mmNose) {
		this.onMandrel300mmNose = onMandrel300mmNose;
	}

	public String getAxialClearance() {
		return axialClearance;
	}

	public void setAxialClearance(String axialClearance) {
		this.axialClearance = axialClearance;
	}

	public String getRadialClearance() {
		return radialClearance;
	}

	public void setRadialClearance(String radialClearance) {
		this.radialClearance = radialClearance;
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
