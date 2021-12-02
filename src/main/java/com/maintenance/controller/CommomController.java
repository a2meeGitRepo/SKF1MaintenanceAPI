/**
 * @Dattatray Bodhale
 */
package com.maintenance.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maintenance.dto.ResponceObj;
import com.maintenance.model.City;
import com.maintenance.model.Customer;
import com.maintenance.model.MailManager;
import com.maintenance.model.State;
import com.maintenance.service.CommomService;



/**
 * @author lenovo
 *
 */
@Controller
@RequestMapping("/common")
public class CommomController {
	@Autowired
	CommomService commomService;
	
	
		
	
	// Comment in Branch 
	
	// Get All City List
	@RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCity() {
		List<City> cities = null;
		try {
			cities = commomService.getAllCity();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	
	
	// Get City List By State
	@RequestMapping(value = "/getCitiesByState", method = RequestMethod.GET)
	public @ResponseBody List<City> getCitiesByState(@RequestParam("stateId") int StateId) {
		List<City> cities= null;
		try {
			cities = commomService.getCitiesByState(StateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	
	@RequestMapping(value = "/getAllState", method = RequestMethod.GET)
	public @ResponseBody List<State> getAllState() {
		List<State> states = null;
		try {
			states = commomService.getAllState();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	
	
	@RequestMapping(value = "/getAllMailManager", method = RequestMethod.GET)
	public @ResponseBody List<MailManager> getAllMailManager() {
		List<MailManager> states = null;
		try {
			states = commomService.getAllMailManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	


	@RequestMapping(value = "/addNewMailManager", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewMailManager(@RequestBody MailManager  mailManager) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<MailManager> optional= commomService.getMailManagerById(mailManager.getMailManageId());
			if(optional.isPresent()){
				responceDTO.setCode(200);
				responceDTO.setMessage("Mail Manager  updated .....Successfully");
			}else{
				mailManager.setActive(1);
				mailManager.setAddedDate(new Date());
				
				responceDTO.setCode(200);
				responceDTO.setMessage("New Mail Manager Added Successfully");
			}
				
			commomService.addNewMailManager(mailManager); 
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}


	@RequestMapping(value = "/changeStatusMailManager", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatusMailManager(@RequestBody MailManager  mailManager) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			if(mailManager.getActive()==1){
				mailManager.setActive(0);
			}else{
				mailManager.setActive(1);
			}
			responceDTO.setCode(200);
			responceDTO.setMessage("Status Change Successfully");
			commomService.addNewMailManager(mailManager); 
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	
}
