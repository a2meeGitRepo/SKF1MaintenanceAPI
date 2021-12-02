package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_clamping_system_sensors")
public class SOP_ClampingSystemSensors {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="with_tool_camp")
	private String withToolCamp;
	
	@Column(name="without_tool_camp")
	private String withoutToolCamp;
	
	@Column(name="un_camp")
	private String unCamp;
	
	@Column(name="other")
	private String other;
	
	@Column(name="s1")
	private String s1;
	
	@Column(name="s2")
	private String s2;
	
	@Column(name="s3")
	private String s3;
	
	@Column(name="check_sensor")
	private String checkSensor;
	
	@Column(name="check_cable")
	private String checkCable;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWithToolCamp() {
		return withToolCamp;
	}

	public void setWithToolCamp(String withToolCamp) {
		this.withToolCamp = withToolCamp;
	}

	public String getWithoutToolCamp() {
		return withoutToolCamp;
	}

	public void setWithoutToolCamp(String withoutToolCamp) {
		this.withoutToolCamp = withoutToolCamp;
	}

	public String getUnCamp() {
		return unCamp;
	}

	public void setUnCamp(String unCamp) {
		this.unCamp = unCamp;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	public String getCheckSensor() {
		return checkSensor;
	}

	public void setCheckSensor(String checkSensor) {
		this.checkSensor = checkSensor;
	}

	public String getCheckCable() {
		return checkCable;
	}

	public void setCheckCable(String checkCable) {
		this.checkCable = checkCable;
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
