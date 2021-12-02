/**
 * @Auther Dattatray Bodhale
 */
package com.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maintenance.configuration.JwtUtil;
import com.maintenance.dto.AuthenticationReequest;
import com.maintenance.dto.ForgetPassword;
import com.maintenance.dto.LoginResponceDto;
import com.maintenance.model.Role;
import com.maintenance.model.Usermst;
import com.maintenance.service.AccessService;
import com.maintenance.service.AuthenticationService;

import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author Dattatray Bodhale
 *
 * 
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/authentication")
class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	AccessService accessService;
	
	
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
	public @ResponseBody List<Role> getRoleList() {
		List<Role> roleList = null;

		roleList= accessService.getRoleList();

		return roleList;
	}
	
	
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationService userDetailsService;
		/*  
		 *   Auther Datttaray Boddhae
		 *    
		 *   09-Mar-2021
		 *   
		 *   Login to application 
		 * 
		 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResponceDto> createAuthenticationToken(@RequestBody AuthenticationReequest authenticationRequest) throws Exception {
		LoginResponceDto responceDto= new LoginResponceDto();
		
		System.out.println("LOGUN API "+authenticationRequest.getUserId());
		System.out.println("LOGUN pass "+authenticationRequest.getPassword());
		
		try {
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUserId());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserId(), authenticationRequest.getPassword())
			);
			
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			Usermst usermst= userDetailsService.getUserByUserNamePassword(authenticationRequest.getUserId(),authenticationRequest.getPassword());
			responceDto.setToken(jwt);
			responceDto.setCode(200);
			responceDto.setMessage("Login Successfully");
			responceDto.setData(usermst);
		}
		catch (BadCredentialsException e) {
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUserId());
			if(userDetails==null){
				responceDto.setCode(500);
				responceDto.setMessage("Invalid Username");
			}else{
				if(userDetails.getPassword()!=authenticationRequest.getPassword()){
					responceDto.setCode(500);
					responceDto.setMessage("Invalid Password");
				}
				
				
			}
			
			
		}
		
		
		return ResponseEntity.ok(responceDto);
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ResponseEntity<LoginResponceDto> forgotPassword(@RequestBody ForgetPassword forgetPassword) throws Exception {
		LoginResponceDto responceDto= new LoginResponceDto();
		
		
		
		try {
			//Usermst usermst =userDetailsService.getUserdetialsByUserName(forgetPassword.getUsername());
			//usermst.setPassword(forgetPassword.getNewPassword());
			//userDetailsService.saveUserMst(usermst);
			responceDto.setCode(200);
			responceDto.setMessage("Pasword Updated Successfully");
		}
		catch (BadCredentialsException e) {
			
			responceDto.setCode(500);
			responceDto.setMessage("Something Wrong");
		}
		
		
		return ResponseEntity.ok(responceDto);
	}
	
	@RequestMapping(value = "/verifyUsernameEmial", method = RequestMethod.POST)
	public ResponseEntity<LoginResponceDto> verifyUsernameEmial(@RequestBody ForgetPassword forgetPassword) throws Exception {
		LoginResponceDto responceDto= new LoginResponceDto();
		
		System.out.println("Email "+forgetPassword.getEmailId());
		System.out.println("User Name  "+forgetPassword.getUsername());
		
		try {
			//Usermst usermst =userDetailsService.getUserdetialsByUserName(forgetPassword.getUsername());
			//Usermst usermst =userDetailsService.getUserdetialsByUserNameAndEmail(forgetPassword.getUsername(),forgetPassword.getEmailId());
		//	System.out.println("usermst "+usermst);
			
			/*if (usermst!=null) {
				responceDto.setCode(200);
				responceDto.setMessage("Detials Verified ");
			}else{
				responceDto.setCode(500);
				responceDto.setMessage("Detials not matched ");
			}*/
			
		}
		catch (BadCredentialsException e) {
			
			responceDto.setCode(500);
			responceDto.setMessage("Something Wrong");
		}
		
		
		return ResponseEntity.ok(responceDto);
	}
	
	
	
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ResponseEntity <LoginResponceDto>   check() throws Exception {
		LoginResponceDto responceDto= new LoginResponceDto();
		
		String rrtn="hiiiii Iam Datta";
		responceDto.setMessage(rrtn);
		return ResponseEntity.ok(responceDto);
	}
	
	
	
	
	
	
	
}
