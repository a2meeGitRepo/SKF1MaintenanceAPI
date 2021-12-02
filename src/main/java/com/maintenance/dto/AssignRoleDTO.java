/**
 * Dattatray Bodhale
	10-Jun-2021
 */
package com.maintenance.dto;

import java.util.List;

import com.maintenance.model.AccessPermission;

/**
 * @author Dattatray Bodhale
 *
 */
public class AssignRoleDTO {
	private int id;
	private String roleName;
	private List<AccessPermission> permission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<AccessPermission> getPermission() {
		return permission;
	}
	public void setPermission(List<AccessPermission> permission) {
		this.permission = permission;
	}
	

}



