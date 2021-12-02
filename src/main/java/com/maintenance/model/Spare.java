/**
 * Dattatray Bodhale
	18-May-2021
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
@Table(name="mst_spare")
public class Spare {
	
	
	@Id
	@GeneratedValue
	@Column(name = "spare_id")
	private Integer spareId;
	
	@Column(name = "spare_name")
	private String  spareName;
	
	@Column(name = "description")
	private String  description;
	
	@Column(name = "spindle_model")
	private String  spindleModel;
	
	@Column(name = "uom")
	private String  uom;
	
	@Column(name="price")
	private Double price;
	
	
	
	@Column(name="active")
	private int active;

	
	@Column(name="del_bit")
	private int delBit;
	
	
	
	@Column(name="added_date")
	private Date addedDate;

	
	@Column(name="added_by")
	private String addedBy;


	public Integer getSpareId() {
		return spareId;
	}


	public void setSpareId(Integer spareId) {
		this.spareId = spareId;
	}


	public String getSpareName() {
		return spareName;
	}


	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSpindleModel() {
		return spindleModel;
	}


	public void setSpindleModel(String spindleModel) {
		this.spindleModel = spindleModel;
	}


	public String getUom() {
		return uom;
	}


	public void setUom(String uom) {
		this.uom = uom;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
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


	public int getDelBit() {
		return delBit;
	}


	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}
	
	
	
	
	
	
	

}



