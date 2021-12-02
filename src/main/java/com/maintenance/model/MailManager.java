/**
 * Dattatray Bodhale
	29-Jul-2021
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
@Table(name="mail_manager")
public class MailManager {
	
	@Id
	@GeneratedValue
	@Column(name="mail_manager_id")
	private int mailManageId;
	
	@Column(name="mail_for")
	private String mailFor;
	
	
	@Column(name="mail_to")
	private String mailTo;
	
	
	@Column(name="name")
	private String name;

	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="active")
	private int active;


	public int getMailManageId() {
		return mailManageId;
	}

	public void setMailManageId(int mailManageId) {
		this.mailManageId = mailManageId;
	}

	public String getMailFor() {
		return mailFor;
	}

	public void setMailFor(String mailFor) {
		this.mailFor = mailFor;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	

}



