package com.maintenance.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserPermissionDto {

	String id;
	String Name;
//	 HashMap<String, String> permissions = new HashMap<String, String>();
	List<PermissionTypeDto> permissions = new ArrayList<PermissionTypeDto>();;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public List<PermissionTypeDto> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionTypeDto> permissions) {
		this.permissions = permissions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
