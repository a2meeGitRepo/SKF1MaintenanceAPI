package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sop_spindle_run_out_inspection")
public class SOP_SpindleRunOutInspection {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="point1")
	private String point1;
	
	@Column(name="point2")
	private String point2;
	
	@Column(name="point3")
	private String point3;
	
	@Column(name="point4")
	private String point4;
	
	@Column(name="point5")
	private String point5;
	
	@Column(name="point6")
	private String point6;
	
	@Column(name="point7")
	private String point7;
	
	@Column(name="point8")
	private String point8;
	
	@Column(name="point9")
	private String point9;
	
	@Column(name="point10")
	private String point10;
	
	@Column(name="point11")
	private String point11;
	
	@Column(name="point12")
	private String point12;
	
	@Column(name="point13")
	private String point13;
	
	@Column(name="point14")
	private String point14;
	
	@Column(name="point15")
	private String point15;
	
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

	public String getPoint1() {
		return point1;
	}

	public void setPoint1(String point1) {
		this.point1 = point1;
	}

	public String getPoint2() {
		return point2;
	}

	public void setPoint2(String point2) {
		this.point2 = point2;
	}

	public String getPoint3() {
		return point3;
	}

	public void setPoint3(String point3) {
		this.point3 = point3;
	}

	public String getPoint4() {
		return point4;
	}

	public void setPoint4(String point4) {
		this.point4 = point4;
	}

	public String getPoint5() {
		return point5;
	}

	public void setPoint5(String point5) {
		this.point5 = point5;
	}

	public String getPoint6() {
		return point6;
	}

	public void setPoint6(String point6) {
		this.point6 = point6;
	}

	public String getPoint7() {
		return point7;
	}

	public void setPoint7(String point7) {
		this.point7 = point7;
	}

	public String getPoint8() {
		return point8;
	}

	public void setPoint8(String point8) {
		this.point8 = point8;
	}

	public String getPoint9() {
		return point9;
	}

	public void setPoint9(String point9) {
		this.point9 = point9;
	}

	public String getPoint10() {
		return point10;
	}

	public void setPoint10(String point10) {
		this.point10 = point10;
	}

	public String getPoint11() {
		return point11;
	}

	public void setPoint11(String point11) {
		this.point11 = point11;
	}

	public String getPoint12() {
		return point12;
	}

	public void setPoint12(String point12) {
		this.point12 = point12;
	}

	public String getPoint13() {
		return point13;
	}

	public void setPoint13(String point13) {
		this.point13 = point13;
	}

	public String getPoint14() {
		return point14;
	}

	public void setPoint14(String point14) {
		this.point14 = point14;
	}

	public String getPoint15() {
		return point15;
	}

	public void setPoint15(String point15) {
		this.point15 = point15;
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
