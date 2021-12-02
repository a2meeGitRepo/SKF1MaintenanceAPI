/**
 * Dattatray Bodhale
	09-Jun-2021
 */
package com.maintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maintenance.dto.EngineerMobileDashboard;
import com.maintenance.model.Customer;
import com.maintenance.repo.SOPRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Controller
@RequestMapping("/dashbaord")
public class DashboardController {


	/*
	 *  Dattatray Bodhale
	 *  
	 *  09-06-2021
	 *  
	 *   Mobile Dashboard Count
	 * 
	 * */
	@Autowired
	SOPRepo  sOPRepo;
	
	
	@RequestMapping(value = "/getEngineerMobileDashboard", method = RequestMethod.GET)
	public @ResponseBody EngineerMobileDashboard getEngineerMobileDashboard(@RequestParam("employeeId") int employeeId) {
		EngineerMobileDashboard mobileDashboard= new EngineerMobileDashboard();
		int completedCounnt=sOPRepo.getPrimaryCompletedSOPCountByEmployeeId(employeeId);
		int inProcessCount=sOPRepo.getPrimaryInProcessSOPCountByEmployeeId(employeeId);
		int pendingCount=sOPRepo.getPrimaryPendingSOPCountByEmployeeId(employeeId);
		
		int finalcompletedCounnt=sOPRepo.getFinalCompletedSOPCountByEmployeeId(employeeId);
		int finalinProcessCount=sOPRepo.getFinalInProcessSOPCountByEmployeeId(employeeId);
		int finalpendingCount=sOPRepo.getFinalPendingSOPCountByEmployeeId(employeeId);
		
		
		mobileDashboard.setCompletedSop(completedCounnt);
		mobileDashboard.setInprocessSop(inProcessCount);
		mobileDashboard.setPendingSop(pendingCount);
		
		mobileDashboard.setFinalcompletedSop(finalcompletedCounnt);
		mobileDashboard.setFinalinprocessSop(finalinProcessCount);
		mobileDashboard.setFinalpendingSop(finalpendingCount);
		return mobileDashboard;
	}
}



