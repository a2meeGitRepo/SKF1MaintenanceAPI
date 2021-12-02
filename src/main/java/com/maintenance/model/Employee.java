/**
 * @Dattatray Bodhale
 */
package com.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author lenovo
 *
 */
@Entity
@Table(name="employee_mst")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="emoloyee_code")
	private String emoloyeeCode;
	
	@Column(name="fName")
	private String fName;
	
	@Column(name="lName")
	private String lName;
	
	
	@Column(name="email_id")
	private String emailId;
	
	
	@Column(name="contactNo")
	private String contactNo;
	
	
	@Column(name="gender")
	private String gender;
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name="designation_id")
	private Designation designation;
	
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="date_of_joining")
	private Date dateOfJoining;
		
	

	@Column(name="title")
	private String title;
	
	
	@Column(name="work_location")
	private String workLocation;
	

	@Column(name="manager_id")
	private int managerId;
	


	@Column(name="user_created")
	private int userCreated;
	
	@Column(name="active")
	private int active;
	
	@Column(name="del_bit")
	private int delBit;
	
	public int getDelBit() {
		return delBit;
	}

	public void setDelBit(int delBit) {
		this.delBit = delBit;
	}

	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="added_by")
	private String addedBy;

	@Column(name="profile_img_url")
	private String profileImgUrl;
	
	@Column(name="profile_img_name")
	private String profileImgName;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmoloyeeCode() {
		return emoloyeeCode;
	}

	public void setEmoloyeeCode(String emoloyeeCode) {
		this.emoloyeeCode = emoloyeeCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(int userCreated) {
		this.userCreated = userCreated;
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

	public String getProfileImgUrl() {
		return profileImgUrl;
	}

	public void setProfileImgUrl(String profileImgUrl) {
		this.profileImgUrl = profileImgUrl;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Column(name="updated_date")
	private Date updDate;

	
	

	
	
	
	
	
}
