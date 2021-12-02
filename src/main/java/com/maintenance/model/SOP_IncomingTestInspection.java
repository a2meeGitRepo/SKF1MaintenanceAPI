/**
 * Dattatray Bodhale
	28-Jun-2021
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
 */@Entity
 @Table(name="sop_incoming_test_inspection")
public class SOP_IncomingTestInspection {
	 @Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		
		@Column(name="sop_id")
		private int sopId;
		
		@Column(name="stage_no")
		private String stageNo;
		
		@Column(name="updated_by")
		private int updatedBy;
		
		@Column(name="updated_date")
		private Date updatedDate;
		
		@Column(name="added_by")
		private int addedBy;
		
		@Column(name="added_date")
		private Date addedDate;
		
		@Column(name="radial_on_nose")
		private String radialOnNose;
		
		
		
		@Column(name="tmm")
		private String tmm;  //@300mm
		
		@Column(name=" face_runout")
		private String  faceRunout;
		
		
		
		@Column(name="clamping_force")
		private String clampingForce;
		
		@Column(name="bt30")
		private boolean bt30;
		
		@Column(name="bt40")
		private boolean bt40;
		
		@Column(name="bt50")
		private boolean bt50;
	
		
		@Column(name="hsk40")
		private boolean hsk40;
		
		@Column(name="hsk50")
		private boolean hsk50;
		
		@Column(name="hsk63")
		private boolean hsk63;
		
		@Column(name="hsk80")
		private boolean hsk80;
		
		
		@Column(name="hsk100")
		private boolean hsk100;
		
		
		@Column(name="em_referance")
		private String emReferance;
		
		
		@Column(name="resistance_u")
		private String resistanceU;
		
		@Column(name="resistance_v")
		private String resistanceV;
		
		@Column(name="resistance_w")
		private String resistanceW;
		
		
		
		@Column(name="inductance_u")
		private String inductanceU;
		
		@Column(name="inductance_v")
		private String inductanceV;
		
		@Column(name="inductance_w")
		private String inductanceW;
		
		
		@Column(name="insulation_test_UE")
		private String insulationTestUE;
		
		@Column(name="insulation_test_VE")
		private String insulationTestVE;
		
		@Column(name="insulation_test_WE")
		private String insulationTestWE;
		
		
		@Column(name="bearing_housing")
		private String bearingHousing;
		
		@Column(name="motor_winding")
		private String motorWinding;
		
		@Column(name="sensor_s1")
		private String sensorS1;
		
		@Column(name="sensor_s2")
		private String sensorS2;

		
		@Column(name="sensor_s3")
		private String sensorS3;
		
		
		@Column(name="sensor_s4")
		private String sensorS4;

		
		@Column(name="sensor_s5")
		private String sensorS5;

		
		@Column(name="encoder_a2")
		private String encoderA2;
		
		@Column(name="jump")
		private String jump;
		
		
		@Column(name="gap")
		private String gap;
		
		public String getEncoderA2() {
			return encoderA2;
		}

		public void setEncoderA2(String encoderA2) {
			this.encoderA2 = encoderA2;
		}

		@Column(name="encoder_a")
		private String encoderA;
		
		
		@Column(name="encoder_b")
		private String encoderB;
		
		@Column(name="encoder_b2")
		private String encoderB2;

		
		@Column(name="encoder_z")
		private String encoderZ;
		
		@Column(name="encoder_z2")
		private String encoderZ2;

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

		public String getStageNo() {
			return stageNo;
		}

		public void setStageNo(String stageNo) {
			this.stageNo = stageNo;
		}

		public int getAddedBy() {
			return addedBy;
		}

		public void setAddedBy(int addedBy) {
			this.addedBy = addedBy;
		}

		
		public String getRadialOnNose() {
			return radialOnNose;
		}

		public void setRadialOnNose(String radialOnNose) {
			this.radialOnNose = radialOnNose;
		}

		public String getTmm() {
			return tmm;
		}

		public void setTmm(String tmm) {
			this.tmm = tmm;
		}

		public String getFaceRunout() {
			return faceRunout;
		}

		public void setFaceRunout(String faceRunout) {
			this.faceRunout = faceRunout;
		}

		public String getClampingForce() {
			return clampingForce;
		}

		public void setClampingForce(String clampingForce) {
			this.clampingForce = clampingForce;
		}

		

		public boolean isBt30() {
			return bt30;
		}

		public void setBt30(boolean bt30) {
			this.bt30 = bt30;
		}

		public boolean isBt40() {
			return bt40;
		}

		public void setBt40(boolean bt40) {
			this.bt40 = bt40;
		}

		public boolean isBt50() {
			return bt50;
		}

		public void setBt50(boolean bt50) {
			this.bt50 = bt50;
		}

		public boolean isHsk40() {
			return hsk40;
		}

		public void setHsk40(boolean hsk40) {
			this.hsk40 = hsk40;
		}

		public boolean isHsk50() {
			return hsk50;
		}

		public void setHsk50(boolean hsk50) {
			this.hsk50 = hsk50;
		}

		public boolean isHsk63() {
			return hsk63;
		}

		public void setHsk63(boolean hsk63) {
			this.hsk63 = hsk63;
		}

		public boolean isHsk80() {
			return hsk80;
		}

		public void setHsk80(boolean hsk80) {
			this.hsk80 = hsk80;
		}

		public boolean isHsk100() {
			return hsk100;
		}

		public void setHsk100(boolean hsk100) {
			this.hsk100 = hsk100;
		}

		public String getEmReferance() {
			return emReferance;
		}

		public void setEmReferance(String emReferance) {
			this.emReferance = emReferance;
		}

		public String getResistanceU() {
			return resistanceU;
		}

		public void setResistanceU(String resistanceU) {
			this.resistanceU = resistanceU;
		}

		public String getResistanceV() {
			return resistanceV;
		}

		public void setResistanceV(String resistanceV) {
			this.resistanceV = resistanceV;
		}

		public String getResistanceW() {
			return resistanceW;
		}

		public void setResistanceW(String resistanceW) {
			this.resistanceW = resistanceW;
		}

		public String getInductanceU() {
			return inductanceU;
		}

		public void setInductanceU(String inductanceU) {
			this.inductanceU = inductanceU;
		}

		public String getInductanceV() {
			return inductanceV;
		}

		public void setInductanceV(String inductanceV) {
			this.inductanceV = inductanceV;
		}

		public String getInductanceW() {
			return inductanceW;
		}

		public void setInductanceW(String inductanceW) {
			this.inductanceW = inductanceW;
		}

		public String getInsulationTestUE() {
			return insulationTestUE;
		}

		public void setInsulationTestUE(String insulationTestUE) {
			this.insulationTestUE = insulationTestUE;
		}

		public String getInsulationTestVE() {
			return insulationTestVE;
		}

		public void setInsulationTestVE(String insulationTestVE) {
			this.insulationTestVE = insulationTestVE;
		}

		public String getInsulationTestWE() {
			return insulationTestWE;
		}

		public void setInsulationTestWE(String insulationTestWE) {
			this.insulationTestWE = insulationTestWE;
		}

		public String getBearingHousing() {
			return bearingHousing;
		}

		public void setBearingHousing(String bearingHousing) {
			this.bearingHousing = bearingHousing;
		}

		public String getMotorWinding() {
			return motorWinding;
		}

		public void setMotorWinding(String motorWinding) {
			this.motorWinding = motorWinding;
		}

		public String getSensorS1() {
			return sensorS1;
		}

		public void setSensorS1(String sensorS1) {
			this.sensorS1 = sensorS1;
		}

		public String getSensorS2() {
			return sensorS2;
		}

		public void setSensorS2(String sensorS2) {
			this.sensorS2 = sensorS2;
		}

		public String getSensorS3() {
			return sensorS3;
		}

		public void setSensorS3(String sensorS3) {
			this.sensorS3 = sensorS3;
		}

		public String getSensorS4() {
			return sensorS4;
		}

		public void setSensorS4(String sensorS4) {
			this.sensorS4 = sensorS4;
		}

		public String getSensorS5() {
			return sensorS5;
		}

		public void setSensorS5(String sensorS5) {
			this.sensorS5 = sensorS5;
		}

		public String getEncoderA() {
			return encoderA;
		}

		public void setEncoderA(String encoderA) {
			this.encoderA = encoderA;
		}

		public String getEncoderB() {
			return encoderB;
		}

		public void setEncoderB(String encoderB) {
			this.encoderB = encoderB;
		}

		public String getEncoderB2() {
			return encoderB2;
		}

		public void setEncoderB2(String encoderB2) {
			this.encoderB2 = encoderB2;
		}

		public String getEncoderZ() {
			return encoderZ;
		}

		public void setEncoderZ(String encoderZ) {
			this.encoderZ = encoderZ;
		}

		public String getEncoderZ2() {
			return encoderZ2;
		}

		public void setEncoderZ2(String encoderZ2) {
			this.encoderZ2 = encoderZ2;
		}

		public int getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(int updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}

		public Date getAddedDate() {
			return addedDate;
		}

		public void setAddedDate(Date addedDate) {
			this.addedDate = addedDate;
		}

		public String getJump() {
			return jump;
		}

		public void setJump(String jump) {
			this.jump = jump;
		}

		public String getGap() {
			return gap;
		}

		public void setGap(String gap) {
			this.gap = gap;
		}
		
		
}



