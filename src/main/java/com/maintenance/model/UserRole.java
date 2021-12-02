/**
 * Dattatray Bodhale
	30-Apr-2021
 */
package com.maintenance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dattatray Bodhale
 *
 */
@Entity
@Table(name="access_user_role")
public class UserRole {
	
	
	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private int userRoleId;
	
	
	

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;


	



	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public int getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	
	
	
	
	
	
	

}



