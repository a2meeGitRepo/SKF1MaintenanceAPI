/**
 *  Dattatray Bodhale
 * 09-Mar-2021
 */
package com.maintenance.dto;

/**
 * @author datta
 *
 */
public class LoginResponceDto {
	private int code ;
	private String message;
	private String token;
	private Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
