/**
 * Dattatray Bodhale
	01-Jul-2021
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
 @Table(name="sop_motor_check_disassembly")
public class SOP_MotorCheckDisassembly {
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
		
		@Column(name="asynchronus")
		private boolean asynchronus;
		
		@Column(name="synchronus")
		private boolean synchronus;
		
		
		@Column(name="phase_balance")
		private boolean phaseBalance;

		
		@Column(name="isolation")
		private boolean isolation;
		
		@Column(name="water_inside")
		private boolean waterInside;
		
		@Column(name="dirt_inside")
		private boolean dirtInside;
		
		

		@Column(name="phase_balance_dc")
		private boolean phaseBalance_dc;

		
		@Column(name="isolation_dc")
		private boolean isolation_dc;
		
		
		
		
		@Column(name="dirty")
		private boolean dirty;
	
		@Column(name="wet")
		private boolean wet;
		
		@Column(name="others")
		private String others;
		
		
		
		
		
		
		



		public String getOthers() {
			return others;
		}



		public void setOthers(String others) {
			this.others = others;
		}



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



		public boolean isAsynchronus() {
			return asynchronus;
		}



		public void setAsynchronus(boolean asynchronus) {
			this.asynchronus = asynchronus;
		}



		public boolean isSynchronus() {
			return synchronus;
		}



		public void setSynchronus(boolean synchronus) {
			this.synchronus = synchronus;
		}



		public boolean isIsolation() {
			return isolation;
		}



		public void setIsolation(boolean isolation) {
			this.isolation = isolation;
		}



		public boolean isDirtInside() {
			return dirtInside;
		}



		public void setDirtInside(boolean dirtInside) {
			this.dirtInside = dirtInside;
		}



		public boolean isDirty() {
			return dirty;
		}



		public void setDirty(boolean dirty) {
			this.dirty = dirty;
		}



		public boolean isWet() {
			return wet;
		}



		public void setWet(boolean wet) {
			this.wet = wet;
		}



		public boolean isWaterInside() {
			return waterInside;
		}



		public void setWaterInside(boolean waterInside) {
			this.waterInside = waterInside;
		}



		public boolean isPhaseBalance() {
			return phaseBalance;
		}



		public void setPhaseBalance(boolean phaseBalance) {
			this.phaseBalance = phaseBalance;
		}



		public boolean isPhaseBalance_dc() {
			return phaseBalance_dc;
		}



		public void setPhaseBalance_dc(boolean phaseBalance_dc) {
			this.phaseBalance_dc = phaseBalance_dc;
		}



		public boolean isIsolation_dc() {
			return isolation_dc;
		}



		public void setIsolation_dc(boolean isolation_dc) {
			this.isolation_dc = isolation_dc;
		}
		
		
		
		
		
}



