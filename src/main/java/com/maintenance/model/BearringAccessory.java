/**
 * Dattatray Bodhale
	13-May-2021
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
@Table(name="bearing_accessory")
public class BearringAccessory {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSscNo() {
		return sscNo;
	}
	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="ssc_no")
	private String sscNo;
	
	
	@Column(name="detials")
	private String detials;
	
	@Column(name="qty")
	private String qty;
	
	@Column(name="side")
	private String side;
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	@Column(name="added_by")
	private String addedBy;
	
	public String getDetials() {
		return detials;
	}
	public void setDetials(String detials) {
		this.detials = detials;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	
	
	
	
	

}



