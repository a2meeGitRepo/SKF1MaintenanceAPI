package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_encoder")
public class SOP_Encoder {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="wheel_256")
	private String wheel_256;
	
	@Column(name="wheel_512")
	private String wheel_512;
	
	@Column(name="wheel_1024")
	private String wheel_1024;
	
	@Column(name="other")
	private String other;
	
	@Column(name="a1")
	private String a1;
	
	@Column(name="a2")
	private String a2;
	
	@Column(name="b1")
	private String b1;
	
	@Column(name="b2")
	private String b2;
	
	@Column(name="u1_u2")
	private String u1u2;
	
	
	
	@Column(name="sensor_head")
	private String sensorHead;
	
	@Column(name="cable")
	private String cable;
	
	@Column(name="connector")
	private String connector;
	
	@Column(name="sensor_wheel")
	private String sensorWheel;
	
	
	
	@Column(name="ab_r")
	private String ab_r;
	
	
	
	@Column(name="phase_ab_deg")
	private String phaseABDeg;
	
	@Column(name="r1")
	private String r1;
	
	@Column(name="r2")
	private String r2;
	
	@Column(name="gear_wheel_run_out")
	private String gearWheelRunOut;
	
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

	public String getWheel_256() {
		return wheel_256;
	}

	public void setWheel_256(String wheel_256) {
		this.wheel_256 = wheel_256;
	}

	public String getWheel_512() {
		return wheel_512;
	}

	public void setWheel_512(String wheel_512) {
		this.wheel_512 = wheel_512;
	}

	public String getWheel_1024() {
		return wheel_1024;
	}

	public void setWheel_1024(String wheel_1024) {
		this.wheel_1024 = wheel_1024;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getB1() {
		return b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}

	public String getU1u2() {
		return u1u2;
	}

	public void setU1u2(String u1u2) {
		this.u1u2 = u1u2;
	}

	public String getPhaseABDeg() {
		return phaseABDeg;
	}

	public void setPhaseABDeg(String phaseABDeg) {
		this.phaseABDeg = phaseABDeg;
	}

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getGearWheelRunOut() {
		return gearWheelRunOut;
	}

	public void setGearWheelRunOut(String gearWheelRunOut) {
		this.gearWheelRunOut = gearWheelRunOut;
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

	public String getSensorHead() {
		return sensorHead;
	}

	public void setSensorHead(String sensorHead) {
		this.sensorHead = sensorHead;
	}

	public String getCable() {
		return cable;
	}

	public void setCable(String cable) {
		this.cable = cable;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getSensorWheel() {
		return sensorWheel;
	}

	public void setSensorWheel(String sensorWheel) {
		this.sensorWheel = sensorWheel;
	}

	public String getAb_r() {
		return ab_r;
	}

	public void setAb_r(String ab_r) {
		this.ab_r = ab_r;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	
	
	
}
