/**
 * Dattatray Bodhale
	30-Apr-2021
 */
package com.maintenance.dto;

import javax.persistence.Column;

/**
 * @author Dattatray Bodhale
 *
 */
public class PermissionDto {
	
	
	private String  name;
	private String  value;
	private String accessType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
	
	
}



