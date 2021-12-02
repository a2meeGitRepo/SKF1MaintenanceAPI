/**
 * @Auther Dattatray Bodhale
 */
package com.maintenance.dto;

/**
 * @author Dattatray Bodhale
 *
 * 
 */
public class AuthenticationResponse {
	private final String jwt;

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt
	 */
	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
	
	
	

}
