package com.maintenance.dto;

import java.util.List;

import com.maintenance.model.UserDetails;

public class UsersWithRolesDto {
	
	List<UserDetails> userwithrole;
	List<UserDetails> userwithoutrole;
	public List<UserDetails> getUserwithrole() {
		return userwithrole;
	}
	public void setUserwithrole(List<UserDetails> userwithrole) {
		this.userwithrole = userwithrole;
	}
	public List<UserDetails> getUserwithoutrole() {
		return userwithoutrole;
	}
	public void setUserwithoutrole(List<UserDetails> userwithoutrole) {
		this.userwithoutrole = userwithoutrole;
	}
	
	
	
	

}
