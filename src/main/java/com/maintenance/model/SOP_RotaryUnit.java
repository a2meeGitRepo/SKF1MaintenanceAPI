/**
 * Dattatray Bodhale
	04-Jul-2021
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
@Table(name="sop_rotary_unit")
public class SOP_RotaryUnit {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	
	@Column(name="stage_no")
	private String stage_no;
	
	@Column(name="sop_id")
	private int sopId;
	
	@Column(name="sr_no")
	private int srNo;
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	
	@Column(name="added_by")
	private int addedBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="connection")
	private String connection;
	
	@Column(name="bearing")
	private String bearing;
	
	
	@Column(name="connector")
	private String connector;
	
	
	@Column(name="seals")
	private String seals;
	
	
	@Column(name="connection_dc")
	private String connection_dc;
	
	
	@Column(name="bearing_dc")
	private String bearing_dc;
	
	
	@Column(name="connector_dc")
	private String connector_dc;
	
	
	@Column(name="seals_dc")
	private String seals_dc;
	
	@Column(name="other")
	private String other;

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


	public int getSrNo() {
		return srNo;
	}


	public void setSrNo(int srNo) {
		this.srNo = srNo;
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


	public String getConnection() {
		return connection;
	}


	public void setConnection(String connection) {
		this.connection = connection;
	}


	public String getBearing() {
		return bearing;
	}


	public void setBearing(String bearing) {
		this.bearing = bearing;
	}


	public String getConnector() {
		return connector;
	}


	public void setConnector(String connector) {
		this.connector = connector;
	}


	public String getSeals() {
		return seals;
	}


	public void setSeals(String seals) {
		this.seals = seals;
	}


	public String getConnection_dc() {
		return connection_dc;
	}


	public void setConnection_dc(String connection_dc) {
		this.connection_dc = connection_dc;
	}


	public String getBearing_dc() {
		return bearing_dc;
	}


	public void setBearing_dc(String bearing_dc) {
		this.bearing_dc = bearing_dc;
	}


	public String getConnector_dc() {
		return connector_dc;
	}


	public void setConnector_dc(String connector_dc) {
		this.connector_dc = connector_dc;
	}


	public String getSeals_dc() {
		return seals_dc;
	}


	public void setSeals_dc(String seals_dc) {
		this.seals_dc = seals_dc;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}
	
	
	
	
	
	
	
	
	
}



