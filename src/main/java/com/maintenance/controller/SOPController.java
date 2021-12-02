/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.maintenance.dto.SOPDTO;
import com.maintenance.dto.SOP_TechnicalDetials;
import com.maintenance.model.SOP;
import com.maintenance.model.SOPStageStatus;
import com.maintenance.model.SOP_Bearing;
import com.maintenance.model.SOP_BearingCondition;
import com.maintenance.model.SOP_BearingInspection;
import com.maintenance.model.SOP_BeltInspection;
import com.maintenance.model.SOP_ClampingSystemSensors;
import com.maintenance.model.SOP_ColloingSystemInspection;
import com.maintenance.model.SOP_ComponentInspection_1;
import com.maintenance.model.SOP_ComponentInspection_1_19;
import com.maintenance.model.SOP_ComponentInspection_2;
import com.maintenance.model.SOP_ComponentInspection_2_19;
import com.maintenance.model.SOP_ComponentInspection_3;
import com.maintenance.model.SOP_ComponentInspection_3_19;
import com.maintenance.model.SOP_DrawbarAssembling;
import com.maintenance.model.SOP_DrawbarSpringInspection;
import com.maintenance.model.SOP_Encoder;
import com.maintenance.model.SOP_InOutCoolent;
import com.maintenance.model.SOP_IncomingTestInspection;
import com.maintenance.model.SOP_LubricationSystemInspection;
import com.maintenance.model.SOP_MotorCheckDisassembly;
import com.maintenance.model.SOP_PositiveLockFrontSideBearing;
import com.maintenance.model.SOP_PowerCables;
import com.maintenance.model.SOP_RCFA;
import com.maintenance.model.SOP_RearSideBearingClearance;
import com.maintenance.model.SOP_RotaryUnit;
import com.maintenance.model.SOP_RunningTestResult;
import com.maintenance.model.SOP_RunningTestResult2;
import com.maintenance.model.SOP_RunningTestResults;
import com.maintenance.model.SOP_SealingInspection;
import com.maintenance.model.SOP_ShaftBalancing;
import com.maintenance.model.SOP_ShaftBalancingNew;
import com.maintenance.model.SOP_ShaftBalancingNewMapped;
import com.maintenance.model.SOP_SpareRequired;
import com.maintenance.model.SOP_SpindleClearanceInspection;
import com.maintenance.model.SOP_SpindleDisassembling;
import com.maintenance.model.SOP_SpindleRunOutInspection;
import com.maintenance.model.SOP_TimeSpentSpindleService;
import com.maintenance.model.SOP_VisualInspection;
import com.maintenance.model.SOP_WashingCleaning;
import com.maintenance.model.Spindle;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.service.EmployeeService;
import com.maintenance.service.SOPService;
import com.maintenance.service.ServiceSer;
import com.maintenance.service.SpindleService;

/**
 * @author Dattatray Bodhale
 *
 */

@Controller
 @RequestMapping("/sop")
public class SOPController {
	
	@Autowired
	SOPService sOPService;
	@Autowired
	ServiceSer serviceSer;
	@Autowired
	SpindleService spindleService;
	@Autowired
	EmployeeService  employeeService;
	
	
	
	
	/*
	 *    Point No 3 
	 * 
	 *  Visual Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Inspeaccrion  
	 * 
	 * */
	@RequestMapping(value = "/startFinalSOPInProcess", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> startFinalSOPInProcess(@RequestBody SOP  sop) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP> optional = serviceSer.geSOpById(sop.getSopId());
			
		
			if(optional.isPresent()){
				SOP sop2= optional.get();
					//	sop2.setStatus("InProcess");
						sop2.setSecondaryStatus("InProcess");
				responceDTO.setCode(200);
				responceDTO.setMessage("Sop Transfer in Inprocess Successfully");
				sOPService.updateSOP(sop2);
			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	@RequestMapping(value = "/startSOPInProcess", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> startSOPInProcess(@RequestBody SOP  sop) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP> optional = serviceSer.geSOpById(sop.getSopId());
			
			System.out.println("START WORK :: "+sop.getSopId()+"    "+optional.isPresent());
			if(optional.isPresent()){
				SOP sop2= optional.get();
					//	sop2.setStatus("InProcess");
						sop2.setPrimaryStatus("InProcess");
				responceDTO.setCode(200);
				responceDTO.setMessage("Sop Transfer in Inprocess Successfully");
				sOPService.updateSOP(sop2);
			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  21-06-2021
	 *  
	 *    List Of  SOP By Pagination
	 * 
	 * */
	@RequestMapping(value = "/getSOPById", method = RequestMethod.GET)
	public @ResponseBody SOP getSOPById(@RequestParam("sopId") int sopId) {
		 SOP sop = new  SOP();
		try {	
			Optional<SOP>  optional=sOPService.getSOPById(sopId);
			
		if (optional.isPresent()) {
			
			
			sop=optional.get();
			SpindleServiceRequest spindleServiceRequest = serviceSer.getSpindleServiceRequestId(sop.getSprindleServiceRequestId());

			sop.setSpindleServiceRequest(spindleServiceRequest);
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sop;
	}	
	
	@RequestMapping(value = "/getsscNo", method = RequestMethod.GET)
	public @ResponseBody String getsscNo(@RequestParam("sopId") int sopId) {
		 String  sscNo= "";
		try {	
			Optional<SOP>  optional=sOPService.getSOPById(sopId);
			
		if (optional.isPresent()) {
			
			
			SOP sop=optional.get();
			SpindleServiceRequest spindleServiceRequest = serviceSer.getSpindleServiceRequestId(sop.getSprindleServiceRequestId());

			sscNo=spindleServiceRequest.getSscNo();
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sscNo;
	}	
/*
 *  Dattatray Bodhale
 *  
 *  21-06-2021
 *  
 *    List Of  SOP By Pagination
 * 
 * */
@RequestMapping(value = "/getAllSOPByPagination", method = RequestMethod.GET)
public @ResponseBody List<SOP> getAllSOPByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<SOP> list= new  ArrayList<SOP>();
	try {	
		List<SOP>  list1=sOPService.getAllSOPByPagination(page_no,item_per_page);
		for(SOP sop : list1){ 
			SOP  sop2 = new  SOP();
			sop2.setSopId(sop.getSopId());
			sop2.setCustomer(sop.getCustomer());
			sop2.setIssue(sop.getIssue());
			sop2.setNoOfStageComplete(sop.getNoOfstage());
			sop2.setTechnician(sop.getTechnician());
			sop2.setNoOfstage(sop.getNoOfstage());
			sop2.setSpindle(sop.getSpindle());
			sop2.setStatus(sop.getStatus());
			sop2.setPrimaryStatus(sop.getPrimaryStatus());
			sop2.setSecondaryStatus(sop.getSecondaryStatus());
			SpindleServiceRequest request= serviceSer.getSpindleServiceRequestId(sop.getSprindleServiceRequestId());
			sop2.setSpindleServiceRequest(request);
			list.add(sop2);
			
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  05-05-2021
 *  
 *   Count Of  Employee
 * 
 * */
@RequestMapping(value = "/getAllSOPCount", method = RequestMethod.GET)
public @ResponseBody int  getAllSOPCount() {
	int  count= 0;
	try {
		count= sOPService.getAllSOPCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  05-05-2021
 *  
 *    List Of  Employee By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getAllSOPByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<SOP> getAllSOPByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<SOP> list= new  ArrayList<SOP>();
	try {	
		List<SOP> 	list1=sOPService.getAllSOPByPaginationAndSerach(page_no,item_per_page,search);
		for(SOP sop : list1){ 
			SOP  sop2 = new  SOP();
			sop2.setSopId(sop.getSopId());
			sop2.setCustomer(sop.getCustomer());
			sop2.setIssue(sop.getIssue());
			sop2.setNoOfStageComplete(sop.getNoOfstage());
			sop2.setTechnician(sop.getTechnician());
			sop2.setNoOfstage(sop.getNoOfstage());
			sop2.setSpindle(sop.getSpindle());
			sop2.setStatus(sop.getStatus());
			sop2.setPrimaryStatus(sop.getPrimaryStatus());
			sop2.setSecondaryStatus(sop.getSecondaryStatus());
			SpindleServiceRequest request= serviceSer.getSpindleServiceRequestId(sop.getSprindleServiceRequestId());
			sop2.setSpindleServiceRequest(request);
			list.add(sop2);
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  05-05-2021
 *  
 *   Count Of  Employee by Search
 * 
 * */
@RequestMapping(value = "/getAllSOPCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getAllSOPCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= sOPService.getAllSOPCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  14-06-2021
	 *  
	 *    List Of  InProcess SOP (Primary )
	 * 
	 * */
	@RequestMapping(value = "/getFinalInProcessSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getFinalInProcessSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			
			List<SOP>  list2 =sOPService.getFinalInProcessSOPByEnginner(employeeId);
			for(SOP sop:list2){
				int stageCompletedCount=sOPService.getNoOfFinaleInspectinStageCompletedBySOPId(sop.getSopId());

				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfstage(sop.getNoOfstage());
				sopdto.setSopId(sop.getSopId());
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				list.add(sopdto);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Completed SOP
	 * 
	 * */
	@RequestMapping(value = "/getFinalCompletedSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getFinalCompletedSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			System.out.println("Complete AAA");
			List<SOP> spindleServiceRequests =sOPService.getFinalCompletedSOPByEnginner(employeeId);
			for(SOP sop:spindleServiceRequests){
				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfstage(sop.getNoOfstage());
				sopdto.setSopId(sop.getSopId());
				
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				list.add(sopdto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Pending SOP
	 * 
	 * */
	@RequestMapping(value = "/getFinalPendingSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getFinalPendingSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			System.out.println("Pending AAA   "+employeeId);
			List<SOP> spindleServiceRequests =sOPService.getFinalPendingSOPByEnginner(employeeId);
			
			for(SOP sop:spindleServiceRequests){
				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfstage(sop.getNoOfstage());
				sopdto.setSopId(sop.getSopId());
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				list.add(sopdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/*
	 *  Dattatray Bodhale
	 *  
	 *  14-06-2021
	 *  
	 *    List Of  InProcess SOP (Primary )
	 * 
	 * */
	@RequestMapping(value = "/getInProcessSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getInProcessSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			
			List<SOP>  list2 =sOPService.getInProcessSOPByEnginner(employeeId);
			for(SOP sop:list2){
				int stageCompletedCount=sOPService.getNoOfPrimaryInspectinStageCompletedBySOPId(sop.getSopId());
				
				System.out.println("NO Of Stages Compleed ");
				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfStageComplete(stageCompletedCount);
				sopdto.setNoOfstage(18);
				sopdto.setSopId(sop.getSopId());
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				
				list.add(sopdto);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Completed SOP
	 * 
	 * */
	@RequestMapping(value = "/getCompletedSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getCompletedSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			
			List<SOP> spindleServiceRequests =sOPService.getCompletedSOPByEnginner(employeeId);
			System.out.println("Complete "+spindleServiceRequests.size());
			for(SOP sop:spindleServiceRequests){
				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfstage(sop.getNoOfstage());
				sopdto.setSopId(sop.getSopId());
				
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				list.add(sopdto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Pending SOP
	 * 
	 * */
	@RequestMapping(value = "/getPendingSOPByEnginner", method = RequestMethod.GET)
	public @ResponseBody List<SOPDTO> getPendingSOPByEnginner(@RequestParam("employeeId") int employeeId) {
		List<SOPDTO> list= new  ArrayList<SOPDTO>();
		try {	
			System.out.println("Pending AAA   "+employeeId);
			List<SOP> spindleServiceRequests =sOPService.getPendingSOPByEnginner(employeeId);
			
			for(SOP sop:spindleServiceRequests){
				SOPDTO sopdto= new SOPDTO();
				sopdto.setCustomerCode(sop.getCustomer().getCustomerCode());
				sopdto.setCustomerName(sop.getCustomer().getCompanyName());
				sopdto.setSpindleBrand(sop.getSpindle().getSpindleBrand());
				sopdto.setSpindleModel(sop.getSpindle().getSpindleModel());
				sopdto.setIssue(sop.getIssue());
				sopdto.setNoOfstage(sop.getNoOfstage());
				sopdto.setSopId(sop.getSopId());
				sopdto.setSprindleServiceRequestId(sop.getSprindleServiceRequestId());
				list.add(sopdto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Primary Inspection stages
	 * 
	 * */
	@RequestMapping(value = "/getPrimarySOPStagesBySOP", method = RequestMethod.GET)
	public @ResponseBody List<SOPStageStatus> getPrimarySOPStagesBySOP(@RequestParam("sopId") int sopId) {
		List<SOPStageStatus> list= new  ArrayList<SOPStageStatus>();
		try {	
			List<SOPStageStatus> list2 =sOPService.getPrimarySOPStagesBySOP(sopId);
			for(SOPStageStatus sopStageStatus:list2){
				SOPStageStatus sopStageStatus2= new SOPStageStatus();
				sopStageStatus2.setAdded_date(sopStageStatus.getAdded_date());
				sopStageStatus2.setCompleteDate(sopStageStatus.getCompleteDate());
				sopStageStatus2.setSopId(sopStageStatus.getSop().getSopId());
				sopStageStatus2.setSopStageId(sopStageStatus.getSopStageId());
				sopStageStatus2.setStageName(sopStageStatus.getStageName());
				sopStageStatus2.setStageNo(sopStageStatus.getStageNo());
				sopStageStatus2.setStageType(sopStageStatus.getStageType());
				sopStageStatus2.setStartDate(sopStageStatus.getStartDate());
				sopStageStatus2.setStatus(sopStageStatus.getStatus());
				list.add(sopStageStatus2);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  15-06-2021
	 *  
	 *    List Of  Secondary Inspection stages
	 * 
	 * */
	@RequestMapping(value = "/getSecondarySOPStagesBySOP", method = RequestMethod.GET)
	public @ResponseBody List<SOPStageStatus> getSecondarySOPStagesBySOP(@RequestParam("sopId") int sopId) {
		List<SOPStageStatus> list= new  ArrayList<SOPStageStatus>();
		try {	
			List<SOPStageStatus> 	list2 =sOPService.getSecondarySOPStagesBySOP(sopId);
			for(SOPStageStatus sopStageStatus:list2){
				SOPStageStatus sopStageStatus2= new SOPStageStatus();
				sopStageStatus2.setAdded_date(sopStageStatus.getAdded_date());
				sopStageStatus2.setCompleteDate(sopStageStatus.getCompleteDate());
				sopStageStatus2.setSopId(sopStageStatus.getSop().getSopId());
				sopStageStatus2.setSopStageId(sopStageStatus.getSopStageId());
				sopStageStatus2.setStageName(sopStageStatus.getStageName());
				sopStageStatus2.setStageNo(sopStageStatus.getStageNo());
				sopStageStatus2.setStageType(sopStageStatus.getStageType());
				sopStageStatus2.setStartDate(sopStageStatus.getStartDate());
				sopStageStatus2.setStatus(sopStageStatus.getStatus());
				list.add(sopStageStatus2);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//************************************************** POINT APIs *************************//
	
	
	/* 
	 *  Point No 1 
	 *   
	 *  Techinical Detials    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  
	 * 
	 * */
	
	
	@RequestMapping(value = "/getTechnicalDetialsBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_TechnicalDetials getTechnicalDetialsBySOPId(@RequestParam("sopId") int sopId) {
		SOP_TechnicalDetials technicalDetials= new  SOP_TechnicalDetials();
		try {	
			Optional<SOP> optional = sOPService.getSopById(sopId);
			Optional<SpindleServiceRequest> optional2= serviceSer.getSpindleServiceRequestById(optional.get().getSprindleServiceRequestId());
		
			if(optional.isPresent()){
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
				String strDate = dateFormat.format(optional2.get().getAddedDate());  
				technicalDetials.setTechnician(optional.get().getTechnician());
				technicalDetials.setSscNo(optional2.get().getSscNo());
				technicalDetials.setDate(strDate);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return technicalDetials;
	}
	
	/* 
	 *  Point No 2 
	 *   
	 *  Spindle Detials    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  
	 * 
	 * */
	
	
	@RequestMapping(value = "/getSpindleDetialsBySOPId", method = RequestMethod.GET)
	public @ResponseBody Spindle getSpindleDetialsBySOPId(@RequestParam("sopId") int sopId) {
		Spindle spindle= new  Spindle();
		try {	
			Optional<SOP> optional = sOPService.getSopById(sopId);
			Optional<SpindleServiceRequest> optional2= serviceSer.getSpindleServiceRequestById(optional.get().getSprindleServiceRequestId());
		
			if(optional.isPresent()){
				spindle=optional2.get().getSpindle();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spindle;
	}
	

	
	
	
	
	/* 
	 *  Point No 3 
	 *   
	 *  Visual Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  Visual Inspection By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getVisualIspectionBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_VisualInspection> getVisualIspectionBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_VisualInspection> list= new  ArrayList<SOP_VisualInspection>();
		try {	
			List<SOP_VisualInspection> list2 =sOPService.getVisualIspectionBySOPId(sopId);
			if(list2.size()==0){
				SOP_VisualInspection visualInspection= new SOP_VisualInspection();
				list.add(visualInspection);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	/*
	 *    Point No 3 
	 * 
	 *  Visual Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Inspeaccrion  
	 * 
	 * */
	@RequestMapping(value = "/addVisualInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addVisualInspection(@RequestBody SOP_VisualInspection  sop_VisualInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_VisualInspection> optional=sOPService.getVisualIspectionById(sop_VisualInspection.getId());
			if(optional.isPresent()){
				sop_VisualInspection.setUpdatedBy(sop_VisualInspection.getAddedBy());
				sop_VisualInspection.setUpdatedDate(new Date());
				sop_VisualInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Visual Inspection Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_VisualInspection.getSopId(),3);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sOPService.checkPrimaryInspectionClosed(sopStageStatus.getSop().getSopId());
				
				sop_VisualInspection.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Visual Inspection Added Successfully");
			}
				
			sOPService.addVisualInspection(sop_VisualInspection);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	@RequestMapping(value = "/addListVisualInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addVisualInspection(@RequestBody List<SOP_VisualInspection>  list) {
		ResponceObj responceDTO = new ResponceObj();

		try {
			/*Optional<SOP_VisualInspection> optional=sOPService.getVisualIspectionById(sop_VisualInspection.getId());
			if(optional.isPresent()){
				sop_VisualInspection.setUpdatedBy(sop_VisualInspection.getAddedBy());
				sop_VisualInspection.setUpdatedDate(new Date());
				sop_VisualInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Visual Inspection Updated Successfully");
			}else{
				sop_VisualInspection.setAddedDate(new Date());
				
			}
				*/
			responceDTO.setCode(200);
			responceDTO.setMessage("Visual Inspection updated Successfully");
			sOPService.addListVisualInspection(list);
			sOPService.checkPrimaryInspectionClosed(list.get(0).getSopId());

			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 3 
	 * 
	 *  Visual Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Inspeaccrion  
	 * 
	 * */
	@RequestMapping(value = "/deletVisualInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletVisualInspection(@RequestBody SOP_VisualInspection  sop_VisualInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("Visual Inspection Deleted Successfully");
			
				
			sOPService.deletVisualInspection(sop_VisualInspection);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	
	

	
	/* 
	 *  Point No 4 
	 *   
	 *  IncomingTestInspection
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  
	 * 
	 * */
	
	
	@RequestMapping(value = "/getIncomingTestInspectionBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_IncomingTestInspection getIncomingTestInspectionBySOPId(@RequestParam("sopId") int sopId) {
		SOP_IncomingTestInspection incomingTestInspection= new  SOP_IncomingTestInspection();
		try {	
			List<SOP_IncomingTestInspection> list2 =sOPService.getIncomingTestInspectionBySOPId(sopId);
			System.out.println("INComming Test Inspection "+sopId+"  Size "+list2.size());
			if(list2.size()==0){
				incomingTestInspection=new SOP_IncomingTestInspection();
				
			}else{
				incomingTestInspection=list2.get(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return incomingTestInspection;
	}
	

	/*
	 *    Point No 4
	 * 
	 *  IncomingTestInspection
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   
	 * 
	 * */
	@RequestMapping(value = "/addIncomingTestInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addIncomingTestInspection(@RequestBody SOP_IncomingTestInspection  sop_IncomingTestInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_IncomingTestInspection> optional=sOPService.getIncomingTestInspectionById(sop_IncomingTestInspection.getId());
			if(optional.isPresent()){
				sop_IncomingTestInspection.setUpdatedBy(sop_IncomingTestInspection.getAddedBy());
				sop_IncomingTestInspection.setUpdatedDate(new Date());
				sop_IncomingTestInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Incoming Test Inspection Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_IncomingTestInspection.getSopId(),4);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sop_IncomingTestInspection.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Incoming Test InspectionAdded Successfully");
			}
				
			sOPService.addIncomingTestInspection(sop_IncomingTestInspection);
			sOPService.checkPrimaryInspectionClosed(sop_IncomingTestInspection.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 4
	 * 
	 *  IncomingTestInspection
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   
	 * 
	 * */
	@RequestMapping(value = "/deletIncomingTestInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletIncomingTestInspection(@RequestBody SOP_IncomingTestInspection  sop_IncomingTestInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("Incoming Test Inspection Deleted Successfully");
			
				
			sOPService.deletIncomingTestInspection(sop_IncomingTestInspection);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	
	/* 
	 *  Point No 5
	 *   
	 *  Power Cables and Visual 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 * GET  Power Cable Details  By SOP Id 
	 * 
	 * */
	
	
	@RequestMapping(value = "/getPowerCableBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_PowerCables getPowerCableBySOPId(@RequestParam("sopId") int sopId) {
		SOP_PowerCables cables= new  SOP_PowerCables();
		try {	
			Optional<SOP_PowerCables> optional =sOPService.getPowerCableBySOPId(sopId);
			System.out.println("SOP Power Cables "+optional.isPresent());
			if(optional.isPresent()){
				cables=optional.get();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cables;
	}
	

	/*
	 *    Point No 5 
	 * 
	 *  Power Cables   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Power Cables Details
	 * 
	 * */
	@RequestMapping(value = "/addPowerCable", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addPowerCable(@RequestBody SOP_PowerCables powerCables) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_PowerCables> optional=sOPService.getPowerCableById(powerCables.getId());
			if(optional.isPresent()){
				powerCables.setUpdatedBy(powerCables.getAddedBy());
				powerCables.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Power Cables Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(powerCables.getSopId(),5);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				powerCables.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Power Cables Added Successfully");
			}
				
			sOPService.addPowerCable(powerCables);
			sOPService.checkPrimaryInspectionClosed(powerCables.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	

	
	
	/* 
	 *  Point No 6
	 *   
	 *  SpindleDisassembling
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  SpindleDisassembling By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getSpindleDisassemblingBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_SpindleDisassembling> getSpindleDisassemblingBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_SpindleDisassembling> list= new  ArrayList<SOP_SpindleDisassembling>();
		try {	
			List<SOP_SpindleDisassembling> list2 =sOPService.getSpindleDisassemblingBySOPId(sopId);
			if(list2.size()==0){
				SOP_SpindleDisassembling spindleDisassembling= new SOP_SpindleDisassembling();
				list.add(spindleDisassembling);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	/*
	 *    Point No 6
	 * 
	 *  SpindleDisassembling
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Bearing  
	 * 
	 * */
	@RequestMapping(value = "/addSpindleDisassembling", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addSpindleDisassembling(@RequestBody SOP_SpindleDisassembling  sop_SpindleDisassembling) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_SpindleDisassembling> optional=sOPService.getSpindleDisassemblingById(sop_SpindleDisassembling.getId());
			if(optional.isPresent()){
				sop_SpindleDisassembling.setUpdatedBy(sop_SpindleDisassembling.getAddedBy());
				sop_SpindleDisassembling.setUpdatedDate(new Date());
				sop_SpindleDisassembling.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Disassembling Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_SpindleDisassembling.getSopId(),6);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sop_SpindleDisassembling.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Disassembling Added Successfully");
			}
				
			sOPService.addSpindleDisassembling(sop_SpindleDisassembling);
			sOPService.checkPrimaryInspectionClosed(sop_SpindleDisassembling.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	@RequestMapping(value = "/addLisySpindleDisassembling", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addLisySpindleDisassembling(@RequestBody List<SOP_SpindleDisassembling>  list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			/*Optional<SOP_SpindleDisassembling> optional=sOPService.getSpindleDisassemblingById(sop_SpindleDisassembling.getId());
			if(optional.isPresent()){
				sop_SpindleDisassembling.setUpdatedBy(sop_SpindleDisassembling.getAddedBy());
				sop_SpindleDisassembling.setUpdatedDate(new Date());
				sop_SpindleDisassembling.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Disassembling Updated Successfully");
			}else{
				sop_SpindleDisassembling.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Disassembling Added Successfully");
			}
				*/
			responceDTO.setCode(200);
			responceDTO.setMessage("Spindle Disassembling updated Successfully");
			sOPService.addLisySpindleDisassembling(list);
			sOPService.checkPrimaryInspectionClosed(list.get(0).getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 6
	 * 
	 *  SpindleDisassembling
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Bearing Inspeaccrion  
	 * 
	 * */
	@RequestMapping(value = "/deletSpindleDisassembling", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletSpindleDisassembling(@RequestBody SOP_SpindleDisassembling  sop_SpindleDisassembling) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("SpindleDisassembling Deleted Successfully");
			
				
			sOPService.deletSpindleDisassembling(sop_SpindleDisassembling);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	

	
	
	
	
	/* 
	 *  Point No 7
	 *   
	 *  Bearing Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  Bearing Inspection By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getBearingIspectionBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_BearingInspection> getBearingIspectionBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_BearingInspection> list= new  ArrayList<SOP_BearingInspection>();
		try {	
			List<SOP_BearingInspection> list2 =sOPService.getBearingIspectionBySOPId(sopId);
			if(list2.size()==0){
				SOP_BearingInspection bearingInspection= new SOP_BearingInspection();
				list.add(bearingInspection);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getBearingIspectionFrontBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_BearingInspection> getBearingIspectionFrontBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_BearingInspection> list= new  ArrayList<SOP_BearingInspection>();
		try {	
			List<SOP_BearingInspection> list2 =sOPService.getBearingIspectionFrontBySOPId(sopId);
			if(list2.size()==0){
				SOP_BearingInspection bearingInspection= new SOP_BearingInspection();
				list.add(bearingInspection);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getBearingIspectionRearBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_BearingInspection> getBearingIspectionRearBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_BearingInspection> list= new  ArrayList<SOP_BearingInspection>();
		try {	
			List<SOP_BearingInspection> list2 =sOPService.getBearingIspectionRearBySOPId(sopId);
			if(list2.size()==0){
				SOP_BearingInspection bearingInspection= new SOP_BearingInspection();
				list.add(bearingInspection);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 *    Point No 7
	 * 
	 *  Bearing Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Bearing  
	 * 
	 * */
	@RequestMapping(value = "/addBearingInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addBearingInspection(@RequestBody SOP_BearingInspection  sop_BearingInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_BearingInspection> optional=sOPService.getBearingIspectionById(sop_BearingInspection.getId());
			if(optional.isPresent()){
				sop_BearingInspection.setUpdatedBy(sop_BearingInspection.getAddedBy());
				sop_BearingInspection.setUpdatedDate(new Date());
				sop_BearingInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing Inspection Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_BearingInspection.getSopId(),7);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sop_BearingInspection.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing Inspection Added Successfully");
			}
				
			sOPService.addBearingInspection(sop_BearingInspection);
			sOPService.checkPrimaryInspectionClosed(sop_BearingInspection.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	@RequestMapping(value = "/addListBearingInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addListBearingInspection(@RequestBody List<SOP_BearingInspection>  list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			/*Optional<SOP_BearingInspection> optional=sOPService.getBearingIspectionById(sop_BearingInspection.getId());
			if(optional.isPresent()){
				sop_BearingInspection.setUpdatedBy(sop_BearingInspection.getAddedBy());
				sop_BearingInspection.setUpdatedDate(new Date());
				sop_BearingInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing Inspection Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_BearingInspection.getSopId(),7);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sop_BearingInspection.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing Inspection Added Successfully");
			}
				*/
			responceDTO.setCode(200);
			responceDTO.setMessage("Bearing Inspection updated Successfully");
			sOPService.addListBearingInspection(list);
			sOPService.checkPrimaryInspectionClosed(list.get(0).getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 7
	 * 
	 *  Bearing Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Bearing Inspeaccrion  
	 * 
	 * */
	@RequestMapping(value = "/deletBearingInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletBearingInspection(@RequestBody SOP_BearingInspection  sop_BearingInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing Inspection Deleted Successfully");
			
				
			sOPService.deletBearingInspection(sop_BearingInspection);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/* 
	 *  Point No 8
	 *   
	 *  Bearing Condition   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  
	 * 
	 * */
	
	
	@RequestMapping(value = "/getBearingConditionBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_BearingCondition> getBearingConditionBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_BearingCondition> list= new  ArrayList<SOP_BearingCondition>();
		try {
			for(int i=0; i<=4;i++){
				if(i==0){
					Optional <SOP_BearingCondition> optional=sOPService.getBearingConditionBySOPIdAndItem(sopId,"No Lubrication");
					if(optional.isPresent()){
						list.add(optional.get());
					}else{
						SOP_BearingCondition bearingCondition= new SOP_BearingCondition();
						bearingCondition.setBearingItems("No Lubrication");
						list.add(bearingCondition);
					}
				}
				if(i==1){
					Optional <SOP_BearingCondition> optional=sOPService.getBearingConditionBySOPIdAndItem(sopId,"Cage Broken");
					if(optional.isPresent()){
						list.add(optional.get());
					}else{
						SOP_BearingCondition bearingCondition= new SOP_BearingCondition();
						bearingCondition.setBearingItems("Cage Broken");
						list.add(bearingCondition);
					}
				}
				if(i==2){
					Optional <SOP_BearingCondition> optional=sOPService.getBearingConditionBySOPIdAndItem(sopId,"Burned");
					if(optional.isPresent()){
						list.add(optional.get());
					}else{
						SOP_BearingCondition bearingCondition= new SOP_BearingCondition();
						bearingCondition.setBearingItems("Burned");
						list.add(bearingCondition);
					}
				}
				if(i==3){
					Optional <SOP_BearingCondition> optional=sOPService.getBearingConditionBySOPIdAndItem(sopId,"Rusty");
					if(optional.isPresent()){
						list.add(optional.get());
					}else{
						SOP_BearingCondition bearingCondition= new SOP_BearingCondition();
						bearingCondition.setBearingItems("Rusty");
						list.add(bearingCondition);
					}
				}
				if(i==3){
					Optional <SOP_BearingCondition> optional=sOPService.getBearingConditionBySOPIdAndItem(sopId,"Noise");
					if(optional.isPresent()){
						list.add(optional.get());
					}else{
						SOP_BearingCondition bearingCondition= new SOP_BearingCondition();
						bearingCondition.setBearingItems("Noise");
						list.add(bearingCondition);
					}
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	/*
	 *    Point No 8
	 * 
	 *  Bearing Condition  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Bearing  
	 * 
	 * */
	@RequestMapping(value = "/addBearingCondition", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addBearingCondition(@RequestBody List<SOP_BearingCondition> bearingConditions ) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			for(SOP_BearingCondition bearingCondition:bearingConditions){
				System.out.println("Be Con :: "+bearingCondition.toString());
				SOP_BearingCondition bearingCondition2= new SOP_BearingCondition();
				Optional<SOP_BearingCondition> optional= sOPService.getBearingConditionById(bearingCondition.getId());
				if(optional.isPresent()){
					System.out.println("UPDATE :: ");
					
					bearingCondition.setUpdatedBy(optional.get().getAddedBy());
					bearingCondition.setUpdatedDate(new Date());
					sOPService.addBearingCondition(bearingCondition);
					sOPService.checkPrimaryInspectionClosed(bearingCondition.getSopId());

				}else{
					SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(bearingConditions.get(0).getSopId(),8);
					sopStageStatus.setStatus("Completed");
					sOPService.saveSOPStage(sopStageStatus);
					
					
					bearingCondition2=bearingCondition;
					sOPService.addBearingCondition(bearingCondition);
					sOPService.checkPrimaryInspectionClosed(bearingCondition.getSopId());

				}
				
			}
			responceDTO.setCode(200);
			responceDTO.setMessage("Bearing Condition Updated ");
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	
	

	/* 
	 *  Point No 9
	 *   
	 *  RCFA   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  RCFA By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getRCFABySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_RCFA getRCFABySOPId(@RequestParam("sopId") int sopId) {
		SOP_RCFA rcfa= new  SOP_RCFA();
		try {	
			Optional<SOP_RCFA> optional=sOPService.getRCFABySOPId(sopId);
			if(optional.isPresent()){
				rcfa=optional.get();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rcfa;
	}
	

	/*
	 *    Point No 9
	 * 
	 *  RCFA  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New RCFA
	 * 
	 * */
	@RequestMapping(value = "/addRCFA", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addRCFA(@RequestBody SOP_RCFA rcfa) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_RCFA> optional=sOPService.getRCFAById(rcfa.getId());
			if(optional.isPresent()){
				rcfa.setUpdatedBy(rcfa.getAddedBy());
				rcfa.setUpdatedDate(new Date());
				rcfa.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("RCFA Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(rcfa.getSopId(),9);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				rcfa.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("RCFA  Added Successfully");
			}
				
			sOPService.addRCFA(rcfa);
			sOPService.checkPrimaryInspectionClosed(rcfa.getSopId());

			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 9
	 * 
	 *  RCFA 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add Delet RCF  
	 * 
	 * */
	@RequestMapping(value = "/deletRCF", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletRCF(@RequestBody SOP_RCFA  rcfa) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("RCFA Deleted Successfully");
			
				
			sOPService.deletRCF(rcfa);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	

	/* 
	 *  Point No 10
	 *   
	 *  New Bearing    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  Bearing  By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getBearingBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_Bearing> getBearingBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_Bearing> list= new  ArrayList<SOP_Bearing>();
		try {	
			List<SOP_Bearing> list2 =sOPService.getBearingBySOPId(sopId);
			if(list2.size()==0){
				SOP_Bearing bearing= new SOP_Bearing();
				list.add(bearing);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getNewBearingRearBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_Bearing> getNewBearingRearBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_Bearing> list= new  ArrayList<SOP_Bearing>();
		try {	
			List<SOP_Bearing> list2 =sOPService.getNewBearingRearBySOPId(sopId);
			if(list2.size()==0){
				SOP_Bearing bearing= new SOP_Bearing();
				list.add(bearing);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getNewBearingFrontBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_Bearing> getNewBearingFrontBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_Bearing> list= new  ArrayList<SOP_Bearing>();
		try {	
			List<SOP_Bearing> list2 =sOPService.getNewBearingFrontBySOPId(sopId);
			if(list2.size()==0){
				SOP_Bearing bearing= new SOP_Bearing();
				list.add(bearing);
			}else{
				list=list2;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 *    Point No 10
	 * 
	 *  Bearing Inspection   
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Visual Bearing  
	 * 
	 * */
	@RequestMapping(value = "/addBearing", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addBearing(@RequestBody SOP_Bearing  sop_Bearing) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_Bearing> optional=sOPService.getBearingById(sop_Bearing.getId());
			if(optional.isPresent()){
				sop_Bearing.setUpdatedBy(sop_Bearing.getAddedBy());
				sop_Bearing.setUpdatedDate(new Date());
				sop_Bearing.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing  Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_Bearing.getSopId(),10);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				sop_Bearing.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing  Added Successfully");
			}
				
			sOPService.addBearing(sop_Bearing);
			sOPService.checkPrimaryInspectionClosed(sop_Bearing.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 10
	 * 
	 *  Bearing    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Bearing   
	 * 
	 * */
	@RequestMapping(value = "/deletBearing", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletBearing(@RequestBody SOP_Bearing  sop_Bearing) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("Bearing  Deleted Successfully");
			
				
			sOPService.deletBearing(sop_Bearing);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/* 
	 *  Point No 11
	 *   
	 *  GET Motor check After disassembly    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  
	 * 
	 * */
	
	
	@RequestMapping(value = "/getMotorCheckDisassembly", method = RequestMethod.GET)
	public @ResponseBody SOP_MotorCheckDisassembly getMotorCheckDisassemblyBySOPId(@RequestParam("sopId") int sopId) {
		SOP_MotorCheckDisassembly motorCheckDisassembly= new  SOP_MotorCheckDisassembly();
		try {	
			Optional<SOP_MotorCheckDisassembly> optional =sOPService.getMotorCheckDisassemblyBySOPId(sopId);
			if(optional.isPresent()){
				motorCheckDisassembly= optional.get();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return motorCheckDisassembly;
	}
	

	/*
	 *    Point No 11
	 * 
	 *  ADD  MotorCheckDisassembly  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   
	 * 
	 * */
	@RequestMapping(value = "/addMotorCheckDisassembly", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addMotorCheckDisassembly(@RequestBody SOP_MotorCheckDisassembly  sop_MotorCheckDisassembly) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_MotorCheckDisassembly> optional=sOPService.getMotorCheckDisassemblyById(sop_MotorCheckDisassembly.getId());
			if(optional.isPresent()){
				sop_MotorCheckDisassembly.setUpdatedBy(sop_MotorCheckDisassembly.getAddedBy());
				sop_MotorCheckDisassembly.setUpdatedDate(new Date());
				sop_MotorCheckDisassembly.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("MotorCheckDisassembly  Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sop_MotorCheckDisassembly.getSopId(),11);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				
				sop_MotorCheckDisassembly.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("MotorCheckDisassembly  Added Successfully");
			}
				
			sOPService.addMotorCheckDisassembly(sop_MotorCheckDisassembly);
			sOPService.checkPrimaryInspectionClosed(sop_MotorCheckDisassembly.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 11
	 * 
	 *  MotorCheckDisassembly    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New MotorCheckDisassembly   
	 * 
	 * */
	@RequestMapping(value = "/deletMotorCheckDisassembly", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletMotorCheckDisassembly(@RequestBody SOP_MotorCheckDisassembly  sop_MotorCheckDisassembly) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("MotorCheckDisassembly  Deleted Successfully");
			
				
			sOPService.deletMotorCheckDisassembly(sop_MotorCheckDisassembly);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/* 
	 *  Point No 12
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  WashingCleaning By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getWashingCleaningBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_WashingCleaning getWashingCleaningBySOPId(@RequestParam("sopId") int sopId) {
		SOP_WashingCleaning washingCleaning= new  SOP_WashingCleaning();
		try {	
			Optional<SOP_WashingCleaning> optional=sOPService.getWashingCleaningBySOPId(sopId);
			if(optional.isPresent()){
				washingCleaning=optional.get();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return washingCleaning;
	}
	

	/*
	 *    Point No 12
	 * 
	 *  WashingCleaning  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New WashingCleaning
	 * 
	 * */
	@RequestMapping(value = "/addWashingCleaning", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addWashingCleaning(@RequestBody SOP_WashingCleaning washingCleaning) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_WashingCleaning> optional=sOPService.getWashingCleaningById(washingCleaning.getId());
			if(optional.isPresent()){
				washingCleaning.setUpdatedBy(washingCleaning.getAddedBy());
				washingCleaning.setUpdatedDate(new Date());
				washingCleaning.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("WashingCleaning Updated Successfully");
			}else{
				
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(washingCleaning.getSopId(),12);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				
				washingCleaning.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("WashingCleaning  Added Successfully");
			}
				
			sOPService.addWashingCleaning(washingCleaning);
			sOPService.checkPrimaryInspectionClosed(washingCleaning.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 12
	 * 
	 *  WashingCleaning 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add Delet WashingCleaning  
	 * 
	 * */
	@RequestMapping(value = "/deletWashingCleaning", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletWashingCleaning(@RequestBody SOP_WashingCleaning  washingCleaning) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("WashingCleaning  Deleted Successfully");
			
				
			sOPService.deletWashingCleaning(washingCleaning);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	

	/* 
	 *  Point No 13
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  InOutCoolent By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getInOutCoolentBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_InOutCoolent getInOutCoolentBySOPId(@RequestParam("sopId") int sopId) {
		SOP_InOutCoolent washingCleaning= new  SOP_InOutCoolent();
		try {	
			Optional<SOP_InOutCoolent> optional=sOPService.getInOutCoolentBySOPId(sopId);
			if(optional.isPresent()){
				washingCleaning=optional.get();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return washingCleaning;
	}
	

	/*
	 *    Point No 13
	 * 
	 *  InOutCoolent  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New InOutCoolent
	 * 
	 * */
	@RequestMapping(value = "/addInOutCoolent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addInOutCoolent(@RequestBody SOP_InOutCoolent inOutCoolent) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_InOutCoolent> optional=sOPService.getInOutCoolentById(inOutCoolent.getId());
			if(optional.isPresent()){
				inOutCoolent.setUpdatedBy(inOutCoolent.getAddedBy());
				inOutCoolent.setUpdatedDate(new Date());
				inOutCoolent.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("InOutCoolent Updated Successfully");
			}else{
				
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(inOutCoolent.getSopId(),13);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				inOutCoolent.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("InOutCoolent  Added Successfully");
			}
				
			sOPService.addInOutCoolent(inOutCoolent);
			sOPService.checkPrimaryInspectionClosed(inOutCoolent.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *    Point No 13
	 * 
	 *  InOutCoolent 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add Delet InOutCoolent  
	 * 
	 * */
	@RequestMapping(value = "/deletInOutCoolent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletInOutCoolent(@RequestBody SOP_InOutCoolent  inOutCoolent) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				responceDTO.setCode(200);
				responceDTO.setMessage("InOutCoolent  Deleted Successfully");
			
				
			sOPService.deletInOutCoolent(inOutCoolent);
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	

	
	

	/* 
	 *  Point No 14
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  colloingSystemInspection By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getColloingSystemInspectionBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_ColloingSystemInspection getColloingSystemInspectionBySOPId(@RequestParam("sopId") int sopId) {
		SOP_ColloingSystemInspection colloingSystemInspection= new  SOP_ColloingSystemInspection();
		try {	
			Optional<SOP_ColloingSystemInspection> optional=sOPService.getColloingSystemInspectionBySOPId(sopId);
			if(optional.isPresent()){
				colloingSystemInspection=optional.get();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colloingSystemInspection;
	}
	

	/*
	 *    Point No 14
	 * 
	 *  ColloingSystemInspection  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New InOutCoolent
	 * 
	 * */
	@RequestMapping(value = "/addColloingSystemInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addColloingSystemInspection(@RequestBody SOP_ColloingSystemInspection colloingSystemInspection) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_ColloingSystemInspection> optional=sOPService.getColloingSystemInspectionById(colloingSystemInspection.getId());
			if(optional.isPresent()){
				colloingSystemInspection.setUpdatedBy(colloingSystemInspection.getAddedBy());
				colloingSystemInspection.setUpdatedDate(new Date());
				colloingSystemInspection.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("ColloingSystemInspection Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(colloingSystemInspection.getSopId(),14);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				colloingSystemInspection.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("ColloingSystemInspection   Added Successfully");
			}
				
			sOPService.addColloingSystemInspection(colloingSystemInspection);
			sOPService.checkPrimaryInspectionClosed(colloingSystemInspection.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	
	
	
	
	
	


	/* 
	 *  Point No 15
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  Rotaru Unit  By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getRotaryUnitBySOPId", method = RequestMethod.GET)
	public @ResponseBody SOP_RotaryUnit getRotaryUnitBySOPId(@RequestParam("sopId") int sopId) {
		SOP_RotaryUnit rotaryUnit= new  SOP_RotaryUnit();
		try {	
			Optional<SOP_RotaryUnit> optional=sOPService.getRotaryUnitBySOPId(sopId);
			if(optional.isPresent()){
				rotaryUnit=optional.get();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rotaryUnit;
	}
	

	/*
	 *    Point No 15
	 * 
	 *  ColloingSystemInspection  
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New RotaryUnit
	 * 
	 * */
	@RequestMapping(value = "/addRotaryUnit", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addRotaryUnit(@RequestBody SOP_RotaryUnit rotaryUnit) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_RotaryUnit> optional=sOPService.getRotaryUnitById(rotaryUnit.getId());
			if(optional.isPresent()){
				rotaryUnit.setUpdatedBy(rotaryUnit.getAddedBy());
				rotaryUnit.setUpdatedDate(new Date());
				rotaryUnit.setAddedDate(optional.get().getAddedDate());
				responceDTO.setCode(200);
				responceDTO.setMessage("RotaryUnit Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(rotaryUnit.getSopId(),15);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				rotaryUnit.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("RotaryUnit   Added Successfully");
			}
				
			sOPService.addRotaryUnit(rotaryUnit);
			sOPService.checkPrimaryInspectionClosed(rotaryUnit.getSopId());

			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	

	/* 
	 *  Point No 16 Part 1
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection1BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_1> getComponentInspection1BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_1>componentInspection_1s= new  ArrayList<SOP_ComponentInspection_1>();
		try {	
			List<SOP_ComponentInspection_1> list=sOPService.getComponentInspection1BySOPId(sopId);
			System.out.println("List :: "+list.size());
			if(list.size()==0){
				for(int i=0;i<=3;i++){
					System.out.println("I :: "+i);
					SOP_ComponentInspection_1 componentInspection_1= new SOP_ComponentInspection_1();
					if(i==0){
						componentInspection_1.setType("Shaft (Front)");
					}
					if(i==1){
						componentInspection_1.setType("Shaft (Rear)");
					}
					if(i==2){
						componentInspection_1.setType("Housing (Front)");
					}
					if(i==3){
						componentInspection_1.setType("Housing (Rear)");
					}
					componentInspection_1s.add(componentInspection_1);
				}
				
			}else{
				componentInspection_1s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_1s;
	}
	

	/*
	 *    Point No 16 Part 1
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection1", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont1(@RequestBody List<SOP_ComponentInspection_1> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				
			
			for(SOP_ComponentInspection_1 componentInspection_1 :list ){
				Optional<SOP_ComponentInspection_1> optional=sOPService.getSOP_ComponentInspection_1ById(componentInspection_1.getId());
				
				if(optional.isPresent()){
					componentInspection_1.setUpdatedBy(componentInspection_1.getAddedBy());
					componentInspection_1.setUpdatedDate(new Date());
					componentInspection_1.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(componentInspection_1.getSopId(),16);
					sopStageStatus.setStatus("Completed");
					sOPService.saveSOPStage(sopStageStatus);
					
					
					componentInspection_1.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection1(componentInspection_1);
				sOPService.checkPrimaryInspectionClosed(componentInspection_1.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	

	/* 
	 *  Point No 16 Part 2
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection2BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_2> getComponentInspection2BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_2>componentInspection_1s= new  ArrayList<SOP_ComponentInspection_2>();
		try {	
			List<SOP_ComponentInspection_2> list=sOPService.getComponentInspection2BySOPId(sopId);
			if(list.size()==0){
				for(int i=0;i<=7;i++){
					SOP_ComponentInspection_2 componentInspection_1= new SOP_ComponentInspection_2();
					if(i==0){
						componentInspection_1.setType("Spacer 1- IR");
					}
					if(i==1){
						componentInspection_1.setType("Spacer 1- OR)");
					}
					if(i==2){
						componentInspection_1.setType("Spacer 2- IR");
					}
					if(i==3){
						componentInspection_1.setType("Spacer 2- OR)");
					}
					if(i==4){
						componentInspection_1.setType("Spacer 3- IR");
					}
					if(i==5){
						componentInspection_1.setType("Spacer 3- OR)");
					}
					if(i==6){
						componentInspection_1.setType("Spacer 4- IR");
					}
					if(i==7){
						componentInspection_1.setType("Spacer 4- OR)");
					}
					componentInspection_1s.add(componentInspection_1);
				}
				
			}else{
				componentInspection_1s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_1s;
	}
	

	/*
	 *    Point No 16 Part 2
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection2", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont2(@RequestBody List<SOP_ComponentInspection_2> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				
			
			for(SOP_ComponentInspection_2 componentInspection_2 :list ){
				Optional<SOP_ComponentInspection_2> optional=sOPService.getSOP_ComponentInspection_2ById(componentInspection_2.getId());
				
				if(optional.isPresent()){
					componentInspection_2.setUpdatedBy(componentInspection_2.getAddedBy());
					componentInspection_2.setUpdatedDate(new Date());
					componentInspection_2.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					componentInspection_2.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection2(componentInspection_2);
				sOPService.checkPrimaryInspectionClosed(componentInspection_2.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	/* 
	 *  Point No 16 Part 3
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection3BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_3> getComponentInspection3BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_3>componentInspection_3s= new  ArrayList<SOP_ComponentInspection_3>();
		try {	
			List<SOP_ComponentInspection_3> list=sOPService.getComponentInspection3BySOPId(sopId);
			if(list.size()==0){
				
				for(int i=0;i<=8;i++){
					SOP_ComponentInspection_3 componentInspection_3= new SOP_ComponentInspection_3();
					System.out.println("Value :: "+i);
					if(i==0){
						componentInspection_3.setShaftTaper("Blue match (%) (>80%)");
					}
					if(i==1){
						componentInspection_3.setShaftTaper("Runout@Nose (<2μm)");
					}
					if(i==2){
						componentInspection_3.setShaftTaper("R/O @300mm (<20μm)");
					}
					if(i==3){
						componentInspection_3.setShaftTaper("Runout- Face (0-2μm))");
					}
					if(i==4){
						componentInspection_3.setShaftTaper("Brg resting face R/O Front (0-2μm)");
					}
					if(i==5){
						componentInspection_3.setShaftTaper("Brg resting face R/O Rear (0-2μm))");
					}
					if(i==6){
						componentInspection_3.setShaftTaper("Gap between taper face & collar of tool holder");
					}
					if(i==7){
						componentInspection_3.setShaftTaper("Gap between taper face & collar of Mandrel");
					}
					if(i==8){
						componentInspection_3.setShaftTaper("Reference distance for HSK 63 face before Plating & Gridning");
					}
					componentInspection_3s.add(componentInspection_3);
				}
				
				
			}else{
				componentInspection_3s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_3s;
	}
	

	/*
	 *    Point No 16 Part 3
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection3", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont3(@RequestBody List<SOP_ComponentInspection_3> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				
			
			for(SOP_ComponentInspection_3 componentInspection_3 :list ){
				Optional<SOP_ComponentInspection_3> optional=sOPService.getSOP_ComponentInspection_3ById(componentInspection_3.getId());
				
				if(optional.isPresent()){
					componentInspection_3.setUpdatedBy(componentInspection_3.getAddedBy());
					componentInspection_3.setUpdatedDate(new Date());
					componentInspection_3.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					componentInspection_3.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection3(componentInspection_3);
				sOPService.checkPrimaryInspectionClosed(componentInspection_3.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/* 
	 *  Point No 18
	 *   
	 *  Power Cables and Visual 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 * GET  Power Cable Details  By SOP Id 
	 * 
	 * */
	
	
	@RequestMapping(value = "/getRequiredSpareBySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_SpareRequired> getRequiredSpareBySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_SpareRequired> spares= new  ArrayList<SOP_SpareRequired>();
		try {	
			
		 spares =sOPService.getSOP_SpareRequiredBySOPId(sopId);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spares;
	}
	

	/*
	 *    Point No 18
	 * 
	 *  Spare Required 
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New Spare
	 * 
	 * */
	@RequestMapping(value = "/addSpareRequired", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addSpareRequired(@RequestBody SOP_SpareRequired spareRequired) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<SOP_SpareRequired> optional=sOPService.getspareRequiredById(spareRequired.getId());
			
			System.out.println("SPARE :: "+spareRequired.getId());
			if(optional.isPresent()){
				spareRequired.setUpdatedBy(spareRequired.getAddedBy());
				spareRequired.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spareRequired.getSopId(),18);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
			//	spareRequired.setPrice(spareRequired.getSpare().getPrice());
				spareRequired.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Added Successfully");
			}
				
			sOPService.addSpareRequired(spareRequired);
			sOPService.checkPrimaryInspectionClosed(spareRequired.getSopId());

			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	@RequestMapping(value = "/addListSpareRequired", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addListSpareRequired(@RequestBody List<SOP_SpareRequired> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
	/*		Optional<SOP_SpareRequired> optional=sOPService.getspareRequiredById(spareRequired.getId());
			
			System.out.println("SPARE :: "+spareRequired.getId());
			if(optional.isPresent()){
				spareRequired.setUpdatedBy(spareRequired.getAddedBy());
				spareRequired.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Updated Successfully");
			}else{
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spareRequired.getSopId(),18);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				spareRequired.setPrice(spareRequired.getSpare().getPrice());
				spareRequired.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spare Added Successfully");
			}
				*/
			for (SOP_SpareRequired sop_SpareRequired:list) {
				sop_SpareRequired.setPrice(sop_SpareRequired.getSpare().getPrice()*sop_SpareRequired.getQuantity());
			}
			responceDTO.setCode(200);
			responceDTO.setMessage("Spare Detials Updated Successfully");
			sOPService.addListSpareRequired(list);
			sOPService.checkPrimaryInspectionClosed(list.get(0).getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	
	
	
	
	
	
	//*******************************************************************************************************************************
	
	

	/* 
	 *  Point No 19 Part 1
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection1_19BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_1_19> getComponentInspection1_19BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_1_19>componentInspection_1s= new  ArrayList<SOP_ComponentInspection_1_19>();
		try {	
			List<SOP_ComponentInspection_1_19> list=sOPService.getComponentInspection1_19BySOPId(sopId);
			if(list.size()==0){
				for(int i=0;i<=3;i++){
					SOP_ComponentInspection_1_19 componentInspection_1= new SOP_ComponentInspection_1_19();
					if(i==0){
						componentInspection_1.setType("Shaft (Front)");
					}
					if(i==1){
						componentInspection_1.setType("Shaft (Rear)");
					}
					if(i==2){
						componentInspection_1.setType("Housing (Front)");
					}
					if(i==3){
						componentInspection_1.setType("Housing (Rear)");
					}
					componentInspection_1s.add(componentInspection_1);
				}
				
			}else{
				componentInspection_1s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_1s;
	}
	

	/*
	 *    Point No 19 Part 1
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection1_19", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont1_19(@RequestBody List<SOP_ComponentInspection_1_19> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				System.out.println("HII CAL 19 Part 1"+list.size());
			
			for(SOP_ComponentInspection_1_19 componentInspection_1 :list ){
				Optional<SOP_ComponentInspection_1_19> optional=sOPService.getSOP_ComponentInspection_1_19ById(componentInspection_1.getId());
				System.out.println("Hiiiiiiiii  "+optional.isPresent()+" for "+componentInspection_1.getId());
				if(optional.isPresent()){
					System.out.println("Hiiiiiiiii  "+componentInspection_1.toString());
					componentInspection_1.setUpdatedBy(componentInspection_1.getAddedBy());
					componentInspection_1.setUpdatedDate(new Date());
					componentInspection_1.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(list.get(0).getSopId(),19);
					sopStageStatus.setStatus("Completed");
					sOPService.saveSOPStage(sopStageStatus);
					
					
					componentInspection_1.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection1_19(componentInspection_1);
				sOPService.checkSecondaryInspectionClosed(componentInspection_1.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	/* 
	 *  Point No 19 Part 2
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection2_19BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_2_19> getComponentInspection2_19BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_2_19>componentInspection_1s= new  ArrayList<SOP_ComponentInspection_2_19>();
		try {	
			List<SOP_ComponentInspection_2_19> list=sOPService.getComponentInspection2_19BySOPId(sopId);
			if(list.size()==0){
				for(int i=0;i<=7;i++){
					SOP_ComponentInspection_2_19 componentInspection_1= new SOP_ComponentInspection_2_19();
					if(i==0){
						componentInspection_1.setType("Spacer 1- IR");
					}
					if(i==1){
						componentInspection_1.setType("Spacer 1- OR)");
					}
					if(i==2){
						componentInspection_1.setType("Spacer 2- IR");
					}
					if(i==3){
						componentInspection_1.setType("Spacer 2- OR)");
					}
					if(i==4){
						componentInspection_1.setType("Spacer 3- IR");
					}
					if(i==5){
						componentInspection_1.setType("Spacer 3- OR)");
					}
					if(i==6){
						componentInspection_1.setType("Spacer 4- IR");
					}
					if(i==7){
						componentInspection_1.setType("Spacer 4- OR)");
					}
					componentInspection_1s.add(componentInspection_1);
				}
				
			}else{
				componentInspection_1s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_1s;
	}
	

	/*
	 *    Point No 19 Part 2
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection2_19", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont2_19(@RequestBody List<SOP_ComponentInspection_2_19> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				
			
			for(SOP_ComponentInspection_2_19 componentInspection_2 :list ){
				Optional<SOP_ComponentInspection_2_19> optional=sOPService.getSOP_ComponentInspection_2_19ById(componentInspection_2.getId());
				
				if(optional.isPresent()){
					componentInspection_2.setUpdatedBy(componentInspection_2.getAddedBy());
					componentInspection_2.setUpdatedDate(new Date());
					componentInspection_2.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					componentInspection_2.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection2_19(componentInspection_2);
				sOPService.checkSecondaryInspectionClosed(componentInspection_2.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	/* 
	 *  Point No 19 Part 3
	 *   
	 *     
	 * 
	 *  Dattatray Bodhale
	 *  
	 *    
	 *  List Of  ComponentInspection   Part 2 By SOP Id and Stage No
	 * 
	 * */
	
	
	@RequestMapping(value = "/getComponentInspection3_19BySOPId", method = RequestMethod.GET)
	public @ResponseBody List<SOP_ComponentInspection_3_19> getComponentInspection3_19BySOPId(@RequestParam("sopId") int sopId) {
		List<SOP_ComponentInspection_3_19>componentInspection_3s= new  ArrayList<SOP_ComponentInspection_3_19>();
		try {	
			List<SOP_ComponentInspection_3_19> list=sOPService.getComponentInspection3_19BySOPId(sopId);
			if(list.size()==0){
				
				for(int i=0;i<=8;i++){
					SOP_ComponentInspection_3_19 componentInspection_3= new SOP_ComponentInspection_3_19();
					System.out.println("Value :: "+i);
					if(i==0){
						componentInspection_3.setShaftTaper("Blue match (%) (>80%)");
					}
					if(i==1){
						componentInspection_3.setShaftTaper("Runout@Nose (<2μm)");
					}
					if(i==2){
						componentInspection_3.setShaftTaper("R/O @300mm (<20μm)");
					}
					if(i==3){
						componentInspection_3.setShaftTaper("Runout- Face (0-2μm))");
					}
					if(i==4){
						componentInspection_3.setShaftTaper("Brg resting face R/O Front (0-2μm)");
					}
					if(i==5){
						componentInspection_3.setShaftTaper("Brg resting face R/O Rear (0-2μm))");
					}
					if(i==6){
						componentInspection_3.setShaftTaper("Gap between taper face & collar of tool holder");
					}
					if(i==7){
						componentInspection_3.setShaftTaper("Gap between taper face & collar of Mandrel");
					}
					if(i==8){
						componentInspection_3.setShaftTaper("Reference distance for HSK 63 face before Plating & Gridning");
					}
					componentInspection_3s.add(componentInspection_3);
				}
				
				
			}else{
				componentInspection_3s=list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return componentInspection_3s;
	}
	

	/*
	 *    Point No 19 Part 3
	 * 
	 *    
	 * 
	 *  Dattatray Bodhale
	 *  
	 *  
	 *  
	 *   Add New ComponentInspection
	 * 
	 * */
	@RequestMapping(value = "/addComponentInspection3_19", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addComponentInspectiont3_19(@RequestBody List<SOP_ComponentInspection_3_19> list) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
				
			
			for(SOP_ComponentInspection_3_19 componentInspection_3 :list ){
				Optional<SOP_ComponentInspection_3_19> optional=sOPService.getSOP_ComponentInspection_3_19ById(componentInspection_3.getId());
				
				if(optional.isPresent()){
					componentInspection_3.setUpdatedBy(componentInspection_3.getAddedBy());
					componentInspection_3.setUpdatedDate(new Date());
					componentInspection_3.setAddedDate(optional.get().getAddedDate());
					
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection Updated Successfully");
				}else{
					componentInspection_3.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("ComponentInspection  Added Successfully");
				}
				
				sOPService.addComponentInspection3_19(componentInspection_3);
				sOPService.checkSecondaryInspectionClosed(componentInspection_3.getSopId());

			}
			
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	/*
	 *    Point No 20
	 * 
	 *  Spindle Clamping System Sensors
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/addPositiveLockFrontSideBearing", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addPositiveLockFrontSideBearing(@RequestBody SOP_PositiveLockFrontSideBearing  positiveLockFrontSideBearing) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			
			Optional<SOP_PositiveLockFrontSideBearing> optional=sOPService.getPositiveLockFrontSideBearingById(positiveLockFrontSideBearing.getId());
			if(optional.isPresent()) {
				positiveLockFrontSideBearing.setUpdatedBy(positiveLockFrontSideBearing.getAddedBy());
				positiveLockFrontSideBearing.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Positive Lock Front Side Bearing Updated Successfully");
			}else {
				
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(positiveLockFrontSideBearing.getSopId(),20);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				
				positiveLockFrontSideBearing.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("SPositive Lock Front Side Bearing  Added Successfully");
			}
			sOPService.addPositiveLockFrontSideBearing(positiveLockFrontSideBearing);
			sOPService.checkSecondaryInspectionClosed(positiveLockFrontSideBearing.getSopId());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		} catch (Exception e) {
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		}
	
	
	/*
	 *    Point No 20
	 * 
	 *  PositiveLockFrontSideBearing
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/getPositiveLockFrontSideBearingSopId", method = RequestMethod.GET)
	public @ResponseBody SOP_PositiveLockFrontSideBearing getPositiveLockFrontSideBearingSopId(@RequestParam("sopId") int sopId) {
		SOP_PositiveLockFrontSideBearing positiveLockFrontSideBearing=new SOP_PositiveLockFrontSideBearing();
		try {	
			Optional<SOP_PositiveLockFrontSideBearing> optional=sOPService.getPositiveLockFrontSideBearingSopId(sopId);
			if(optional.isPresent()){
				positiveLockFrontSideBearing=optional.get();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positiveLockFrontSideBearing;
	}
	
	/*
	 *    Point No 21
	 * 
	 *  Spindle Clamping System Sensors
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/addRearSideBearingClearance", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addRearSideBearingClearance(@RequestBody SOP_RearSideBearingClearance rearSideBearingClearance) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			System.out.println("CCCCCC");
			Optional<SOP_RearSideBearingClearance> optional=sOPService.getRearSideBearingClearanceById(rearSideBearingClearance.getId());
			System.out.println("CCCCCC   "+optional.isPresent()+"  "+rearSideBearingClearance.getId());
			
			if(optional.isPresent()) {
				rearSideBearingClearance.setUpdatedBy(rearSideBearingClearance.getAddedBy());
				rearSideBearingClearance.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Rear Side Bearing Clearance Updated Successfully");
			}else {
				
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(rearSideBearingClearance.getSopId(),21);
				sopStageStatus.setStatus("Completed");
				rearSideBearingClearance.setAddedDate(new Date());

				sOPService.saveSOPStage(sopStageStatus);
				
				
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Rear Side Bearing Clearance  Added Successfully");
			}
			sOPService.addRearSideBearingClearance(rearSideBearingClearance);
			sOPService.checkSecondaryInspectionClosed(rearSideBearingClearance.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		} catch (Exception e) {
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		}
	
	
	/*
	 *    Point No 21
	 * 
	 *  PositiveLockFrontSideBearing
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/getRearSideBearingClearanceSopId", method = RequestMethod.GET)
	public @ResponseBody SOP_RearSideBearingClearance getRearSideBearingClearanceSopId(@RequestParam("sopId") int sopId) {
		SOP_RearSideBearingClearance positiveLockFrontSideBearing=new SOP_RearSideBearingClearance();
		try {	
			Optional<SOP_RearSideBearingClearance> optional=sOPService.getRearSideBearingClearanceSopId(sopId);
			if(optional.isPresent()){
				positiveLockFrontSideBearing=optional.get();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positiveLockFrontSideBearing;
	}
	
	
	
	
	
	
	/*
	 *    Point No 22
	 * 
	 *  Spindle Clamping System Sensors
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/addSpindleCSS", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addSpindleCSS(@RequestBody SOP_ClampingSystemSensors  spindleCSS) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			
			Optional<SOP_ClampingSystemSensors> optional=sOPService.getSpindleCSSById(spindleCSS.getId());
			if(optional.isPresent()) {
				spindleCSS.setUpdatedBy(spindleCSS.getAddedBy());
				spindleCSS.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Clamping System Sensors Updated Successfully");
			}else {
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleCSS.getSopId(),22);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				
				spindleCSS.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Clamping System Sensors Added Successfully");
			}
			sOPService.addSpindleCSS(spindleCSS);
			sOPService.checkSecondaryInspectionClosed(spindleCSS.getSopId());

			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		} catch (Exception e) {
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *    Point No 22
	 * 
	 *  Spindle Clamping System Sensors
	 * 
	 *  Mahesh Pund
	 * 
	 * */
			@RequestMapping(value = "/deletSpindleCSS", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> deletSpindleCSS(@RequestBody SOP_ClampingSystemSensors  spindleCSS) {
				ResponceObj responceDTO= new ResponceObj();

				try {
					sOPService.deletSpindeCSS(spindleCSS);
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Clamping System Sensors Deleted Successfully");
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
			}
			
			/*
			 *    Point No 22
			 * 
			 *  Spindle Clamping System Sensors
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/getSpindleCSSbySopId", method = RequestMethod.GET)
			public @ResponseBody SOP_ClampingSystemSensors getSpindleCSS(@RequestParam("sopId") int sopId) {
				SOP_ClampingSystemSensors spindleCSS=new SOP_ClampingSystemSensors();
				try {	
					Optional<SOP_ClampingSystemSensors> optional=sOPService.getSpindleCSSBySOPId(sopId);
					if(optional.isPresent()){
						spindleCSS=optional.get();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				return spindleCSS;
			}
			
			
			
			/*
			 *    Point No 23
			 * 
			 *  Spindle Encoder
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/addSpindleEncoder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> addSpindleEncoder(@RequestBody SOP_Encoder  spindleEncoder) {
				ResponceObj responceDTO= new ResponceObj();
				try {
					
					Optional<SOP_Encoder> optional=sOPService.getSpindleEncoderById(spindleEncoder.getId());
					if(optional.isPresent()) {
						spindleEncoder.setUpdatedBy(spindleEncoder.getAddedBy());
						spindleEncoder.setUpdatedDate(new Date());
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Encoder Updated Successfully");
					}else {
						
						SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleEncoder.getSopId(),23);
						sopStageStatus.setStatus("Completed");
						sOPService.saveSOPStage(sopStageStatus);
						
						
						spindleEncoder.setAddedDate(new Date());
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Encoder Added Successfully");
					}
					sOPService.addSpindleEncoder(spindleEncoder);
					sOPService.checkSecondaryInspectionClosed(spindleEncoder.getSopId());

					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
				}

			/*
			 *    Point No 23
			 * 
			 *  Spindle Encoder
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/deletSpindleEncoder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> deletSpindleCSS(@RequestBody SOP_Encoder  spindleEncoder) {
				ResponceObj responceDTO= new ResponceObj();

				try {
					sOPService.deletSpindeEncoder(spindleEncoder);
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Encoder Deleted Successfully");
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
			}

			/*
			 *    Point No 23
			 * 
			 *  Spindle Encoder
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/getSpindleEncoderbySopId", method = RequestMethod.GET)
			public @ResponseBody SOP_Encoder getSpindleEncoder(@RequestParam("sopId") int sopId) {
				SOP_Encoder spindleEncoder=new SOP_Encoder();
				try {	
					Optional<SOP_Encoder> optional=sOPService.getSpindleEncoderBySOPId(sopId);
					if(optional.isPresent()){
						spindleEncoder=optional.get();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				return spindleEncoder;
			}
			
			/*
			 *    Point No 24
			 * 
			 *  Belt Inspection
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/addBeltInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> addBeltInspection(@RequestBody SOP_BeltInspection beltInspection) {
				ResponceObj responceDTO= new ResponceObj();
				try {
					System.out.println("Belt Inspecation Addd ");
					Optional<SOP_BeltInspection> optional=sOPService.getBeltInspectionById(beltInspection.getId());
					if(optional.isPresent()) {
						beltInspection.setUpdatedBy(beltInspection.getAddedBy());
						beltInspection.setUpdatedDate(new Date());
						responceDTO.setCode(200);
						SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(beltInspection.getSopId(),24);
						sopStageStatus.setStatus("Completed");
						sOPService.saveSOPStage(sopStageStatus);
						responceDTO.setMessage("Belt Inspection Updated Successfully");
					}else {
						
						SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(beltInspection.getSopId(),24);
						sopStageStatus.setStatus("Completed");
						sOPService.saveSOPStage(sopStageStatus);
						
						
						beltInspection.setAddedDate(new Date());
						responceDTO.setCode(200);
						responceDTO.setMessage("Belt Inspection  Added Successfully");
					}
					sOPService.addBeltInspection(beltInspection);
					sOPService.checkSecondaryInspectionClosed(beltInspection.getSopId());

					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
				}
			
			
			/*
			 *    Point No 24
			 * 
			 *  Belt Inspection
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/getBeltInspectionSopId", method = RequestMethod.GET)
			public @ResponseBody SOP_BeltInspection getBeltInspectionSopId(@RequestParam("sopId") int sopId) {
				SOP_BeltInspection beltInspection=new SOP_BeltInspection();
				try {	
					Optional<SOP_BeltInspection> optional=sOPService.getBeltInspectionSopId(sopId);
					if(optional.isPresent()){
						beltInspection=optional.get();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				return beltInspection;
			}
			
			
			
			
			/*
			 *    Point No 25
			 * 
			 *  Spindle Drawbar Spring Inspection
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/addSpindleDSI", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> addSpindleDSI(@RequestBody SOP_DrawbarSpringInspection  spindleDSI) {
				ResponceObj responceDTO= new ResponceObj();
				try {
					
					Optional<SOP_DrawbarSpringInspection> optional=sOPService.getSpindleDSIById(spindleDSI.getId());
					if(optional.isPresent()) {
						spindleDSI.setUpdatedBy(spindleDSI.getAddedBy());
						spindleDSI.setUpdatedDate(new Date());
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Drawbar Spring Inspection Updated Successfully");
					}else {
						
						SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleDSI.getSopId(),25);
						sopStageStatus.setStatus("Completed");
						sOPService.saveSOPStage(sopStageStatus);
						
						
						spindleDSI.setAddedDate(new Date());
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Drawbar Spring Inspection Added Successfully");
					}
					sOPService.addSpindleDSI(spindleDSI);
					sOPService.checkSecondaryInspectionClosed(spindleDSI.getSopId());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
				}
			

			/*
			 *    Point No 25
			 * 
			 *  Spindle Drawbar Spring Inspection
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/deletSpindleDSI", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ResponceObj> deletSpindleDSI(@RequestBody SOP_DrawbarSpringInspection  spindleDSI) {
				ResponceObj responceDTO= new ResponceObj();

				try {
					sOPService.deletSpindeDSI(spindleDSI);
						responceDTO.setCode(200);
						responceDTO.setMessage("Spindle Drawbar Spring Inspection Deleted Successfully");
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					
				} catch (Exception e) {
					responceDTO.setCode(500);
					responceDTO.setMessage(e.getMessage());
					return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				}
			}
			

			/*
			 *    Point No 25
			 * 
			 *  Spindle Drawbar Spring Inspection
			 * 
			 *  Mahesh Pund
			 * 
			 * */
			@RequestMapping(value = "/getSpindleDSIbySopId", method = RequestMethod.GET)
			public @ResponseBody SOP_DrawbarSpringInspection getSpindleDSI(@RequestParam("sopId") int sopId) {
				SOP_DrawbarSpringInspection spindleDSI=new SOP_DrawbarSpringInspection();
				try {	
					Optional<SOP_DrawbarSpringInspection> optional=sOPService.getSpindleDSIBySOPId(sopId);
					if(optional.isPresent()){
						spindleDSI=optional.get();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				return spindleDSI;
			}
	/*
	 *    Point No 26
	 * 
	 *  Spindle Lubrication System Inspection
	 * 
	 *  Mahesh Pund
	 * 
	 * */
	@RequestMapping(value = "/addSpindleLSI", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addSpindleLSI(@RequestBody SOP_LubricationSystemInspection  SpindleLSI) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			
			Optional<SOP_LubricationSystemInspection> optional=sOPService.getSpindleLSIById(SpindleLSI.getId());
			if(optional.isPresent()) {
			//	SpindleLSI=optional.get();
				SpindleLSI.setUpdatedBy(SpindleLSI.getAddedBy());
				SpindleLSI.setUpdatedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Lubrication System Inspection Updated Successfully");
			}else {
				
				SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(SpindleLSI.getSopId(),26);
				sopStageStatus.setStatus("Completed");
				sOPService.saveSOPStage(sopStageStatus);
				sOPService.checkSecondaryInspectionClosed(sopStageStatus.getSopId());
				
				
				
				SpindleLSI.setAddedDate(new Date());
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Lubrication System Inspection Added Successfully");
			}
			sOPService.addSpindleLSI(SpindleLSI);
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		} catch (Exception e) {
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		}
	
	/*
	 *    Point No 26
	 * 
	 *  Spindle Lubrication System Inspection
	 * 
	 *  Mahesh Pund
	 * 
	 * */
		@RequestMapping(value = "/deletSpindleLSI", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponceObj> deletSpindleLSI(@RequestBody SOP_LubricationSystemInspection  SpindleLSI) {
			ResponceObj responceDTO= new ResponceObj();

			try {
				sOPService.deletSpindeLSI(SpindleLSI);
					responceDTO.setCode(200);
					responceDTO.setMessage("Spindle Lubrication System Inspection Deleted Successfully");
				return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
				
			} catch (Exception e) {
				responceDTO.setCode(500);
				responceDTO.setMessage(e.getMessage());
				return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			}
		}
		/*
		 *    Point No 26
		 * 
		 *  Spindle Lubrication System Inspection
		 * 
		 *  Mahesh Pund
		 * 
		 * */
		@RequestMapping(value = "/getSpindleLSIbySopId", method = RequestMethod.GET)
		public @ResponseBody SOP_LubricationSystemInspection getSpindleLSI(@RequestParam("sopId") int sopId) {
			SOP_LubricationSystemInspection spindleLSI=new SOP_LubricationSystemInspection();
			try {	
				Optional<SOP_LubricationSystemInspection> optional=sOPService.getSpindleLSIbySopId(sopId);
				if(optional.isPresent()){
					spindleLSI=optional.get();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return spindleLSI;
		}
		/*
		 *    Point No 27
		 * 
		 *  Spindle Sealing Inspection
		 * 
		 *  Mahesh Pund
		 * 
		 * */
		
		@RequestMapping(value = "/addSpindleSI",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponceObj> addSpindleSI(@RequestBody SOP_SealingInspection  SpindleSI) {
			ResponceObj responceDTO= new ResponceObj();
			try {
				Optional<SOP_SealingInspection> optional=sOPService.getSpindleSIById(SpindleSI.getId());
				if(optional.isPresent()) {
					//SpindleSI=optional.get();
					SpindleSI.setUpdatedBy(SpindleSI.getAddedBy());
					SpindleSI.setUpdatedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("Sealing Inspection Updated Successfully");
				}else {
					SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(SpindleSI.getSopId(),27);
					sopStageStatus.setStatus("Completed");
					sOPService.saveSOPStage(sopStageStatus);
					
					
					SpindleSI.setAddedDate(new Date());
					responceDTO.setCode(200);
					responceDTO.setMessage("Sealing Inspection Added Successfully");
				}
				sOPService.addSpindleSI(SpindleSI);
				sOPService.checkSecondaryInspectionClosed(SpindleSI.getSopId());
				return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			} catch (Exception e) {
				responceDTO.setCode(500);
				responceDTO.setMessage(e.getMessage());
				return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			}		
		}
		/*
		 *    Point No 27
		 * 
		 *  Spindle Sealing Inspection
		 * 
		 *  Mahesh Pund
		 * 
		 * */
		
				@RequestMapping(value = "/deletSpindleSI", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> deletSpindleSI(@RequestBody SOP_SealingInspection  SpindleSI) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						sOPService.deletSpindeSI(SpindleSI);
							responceDTO.setCode(200);
							responceDTO.setMessage("Sealing Inspection Deleted Successfully");
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
				}
				/*
				 *    Point No 27
				 * 
				 *  Spindle Sealing Inspection
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				@RequestMapping(value = "/getSpindleSIbySopId", method = RequestMethod.GET)
				public @ResponseBody SOP_SealingInspection getSpindleSI(@RequestParam("sopId") int sopId) {
					SOP_SealingInspection spindleSI=new SOP_SealingInspection();
					try {	
						Optional<SOP_SealingInspection> optional=sOPService.getSpindleSIBySOPId(sopId);
						if(optional.isPresent()){
							spindleSI=optional.get();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return spindleSI;
				}
				
				/*
				 *    Point No 28
				 * 
				 *  Spindle Shaft Balancing
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				
				@RequestMapping(value = "/addSpindleStaffBalancing", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> addSopStaffBalance(@RequestBody SOP_ShaftBalancing spindleStaffBalance) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						Optional<SOP_ShaftBalancing> optional=sOPService.getSopStaffBalanceById(spindleStaffBalance.getId());
						if(optional.isPresent()){
							//sopRunOutInspection=optional.get();
							spindleStaffBalance.setUpdatedBy(spindleStaffBalance.getAddedBy());
							spindleStaffBalance.setUpdatedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Shaft Balancing Updated Successfully");
						}else{
							SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleStaffBalance.getSopId(),28);
							sopStageStatus.setStatus("Completed");
							sOPService.saveSOPStage(sopStageStatus);
							
							
							spindleStaffBalance.setAddedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Shaft Balancing Added Successfully");
						}
						
						sOPService.addSpidleStaffBalancing(spindleStaffBalance);
						sOPService.checkSecondaryInspectionClosed(spindleStaffBalance.getSopId());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						// TODO: handle exception	
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
					
						
					}
				
				
				/*
				 *    Point No 28
				 * 
				 *  Spindle Shaft Balancing
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				
				@RequestMapping(value = "/deletSpindleStafffBalance", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> deletStaffBalance(@RequestBody SOP_ShaftBalancing  sopStaffBalance) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						sOPService.deletStaffBalance(sopStaffBalance);
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Staff Balance Deleted Successfully");
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
				}
				
				
				/*
				 *    Point No 28
				 * 
				 *  Spindle Shaft Balancing
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				
				@RequestMapping(value = "/getSpindleStaffBalanceSopId", method = RequestMethod.GET)
				public @ResponseBody SOP_ShaftBalancing getSpindleStaffBalance(@RequestParam("sopId") int sopId) {
					SOP_ShaftBalancing spindleStaffBalance=new SOP_ShaftBalancing();
					try {	
						Optional<SOP_ShaftBalancing> optional=sOPService.getSpindleStaffBalanceBySOPId(sopId);
						if(optional.isPresent()){
							spindleStaffBalance=optional.get();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return spindleStaffBalance;
				}

				
				
				

				/*
				 *    Point No 28   NEW 
				 * 
				 *  Spindle Shaft Balancing
				 * 
				 *  Dattatray Bodhale
				 * 
				 * */
				
				@RequestMapping(value = "/getSpindleStaffBalanceNew", method = RequestMethod.GET)
				public @ResponseBody SOP_ShaftBalancingNew getSpindleStaffBalanceNew(@RequestParam("sopId") int sopId) {
					SOP_ShaftBalancingNew shaftBalancingNew=new SOP_ShaftBalancingNew();
					try {	
						Optional<SOP_ShaftBalancingNew> optional=sOPService.getSpindleStaffBalanceNewBySOPId(sopId);
						System.out.println("OPTION :: "+optional.isPresent());
						
						if(optional.isPresent()){
							shaftBalancingNew=optional.get();
							List<SOP_ShaftBalancingNewMapped> list= sOPService.shaftBalancingNewMappedbySopId(sopId);
							shaftBalancingNew.setList(list);
						}else{
							List<SOP_ShaftBalancingNewMapped> list = new ArrayList<SOP_ShaftBalancingNewMapped>();
						//	shaftBalancingNew.setWeightAddition("false");
						//	shaftBalancingNew.setWeightRemoval("false");
							for(int i=0;i<=2;i++){
								SOP_ShaftBalancingNewMapped shaftBalancingNewMapped= new SOP_ShaftBalancingNewMapped();
								if(i==0){
									shaftBalancingNewMapped.setShaftWeight("Unbalance");
								}
								if(i==1){
									shaftBalancingNewMapped.setShaftWeight("Plane 1");
								}
								if(i==2){
									shaftBalancingNewMapped.setShaftWeight("Plane 2");
								}
								list.add(shaftBalancingNewMapped);
							}
							shaftBalancingNew.setList(list);
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return shaftBalancingNew;
				}

				
				
				/*
				 *    Point No 28    New 
				 * 
				 *  Spindle Shaft Balancing
				 * 
				 *  Dattatray Boddhale
				 * 
				 * */
				
				@RequestMapping(value = "/addSpindleStaffBalancingNew", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> addSpindleStaffBalancingNew(@RequestBody SOP_ShaftBalancingNew spindleStaffBalance) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						Optional<SOP_ShaftBalancingNew> optional=sOPService.getSopStaffBalanceNewById(spindleStaffBalance.getId());
						if(optional.isPresent()){
							//sopRunOutInspection=optional.get();
							spindleStaffBalance.setUpdatedBy(spindleStaffBalance.getAddedBy());
							spindleStaffBalance.setUpdatedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Shaft Balancing Updated Successfully");
							for(SOP_ShaftBalancingNewMapped balancingNewMapped:spindleStaffBalance.getList()){
								balancingNewMapped.setUpdatedBy(spindleStaffBalance.getAddedBy());
								balancingNewMapped.setUpdatedDate(new Date());
								sOPService.saveShaftBalancingNewMapped(balancingNewMapped);
							}
						}else{
							
							SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleStaffBalance.getSopId(),28);
							sopStageStatus.setStatus("Completed");
							sOPService.saveSOPStage(sopStageStatus);
							spindleStaffBalance.setAddedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Shaft Balancing Added Successfully");
							for(SOP_ShaftBalancingNewMapped balancingNewMapped:spindleStaffBalance.getList()){
							
								balancingNewMapped.setAddedDate(new Date());
								sOPService.saveShaftBalancingNewMapped(balancingNewMapped);
							}
						}
						
						sOPService.addSpidleStaffBalancingNew(spindleStaffBalance);
						sOPService.checkSecondaryInspectionClosed(spindleStaffBalance.getSopId());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						// TODO: handle exception	
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
					
						
					}
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*
				 *    Point No 29
				 * 
				 *  Drawbar assembling & Pull force test:
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				
				@RequestMapping(value = "/addDrawbarAssembling", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> addDrawbarAssembling(@RequestBody SOP_DrawbarAssembling drawbarAssembling) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						Optional<SOP_DrawbarAssembling> optional=sOPService.getDrawbarAssemblingnById(drawbarAssembling.getId());
						if(optional.isPresent()){
							//sopRunOutInspection=optional.get();
							drawbarAssembling.setUpdatedBy(drawbarAssembling.getAddedBy());
							drawbarAssembling.setUpdatedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Drawbar Assembling Updated Successfully");
						}else{
							
							SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(drawbarAssembling.getSopId(),29);
							sopStageStatus.setStatus("Completed");
							sOPService.saveSOPStage(sopStageStatus);
							
							
							drawbarAssembling.setAddedDate(new Date());
							responceDTO.setCode(200);
							responceDTO.setMessage("Drawbar Assembling Added Successfully");
						}
						
						sOPService.addDrawbarAssembling(drawbarAssembling);
						sOPService.checkSecondaryInspectionClosed(drawbarAssembling.getSopId());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						// TODO: handle exception	
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
					
						
					}

				
				
				/*
				 *    Point No 29
				 * 
				 *  Drawbar assembling & Pull force test:
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				
				@RequestMapping(value = "/getDrawbarAssemblingSopId", method = RequestMethod.GET)
				public @ResponseBody SOP_DrawbarAssembling getDrawbarAssemblingSopId(@RequestParam("sopId") int sopId) {
					SOP_DrawbarAssembling drawbarAssembling=new SOP_DrawbarAssembling();
					try {	
						Optional<SOP_DrawbarAssembling> optional=sOPService.getDrawbarAssemblingSopId(sopId);
						if(optional.isPresent()){
							drawbarAssembling=optional.get();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return drawbarAssembling;
				}
				
				
				
				
				
				
				
				
				/*
				 *    Point No 30
				 * 
				 *  Spindle Run Out Inspection
				 * 
				 *  Mahesh Pund
				 * 
				 * */
							@RequestMapping(value = "/addSpindleRunOutInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
							public ResponseEntity<ResponceObj> addRunOutInspection(@RequestBody SOP_SpindleRunOutInspection sopRunOutInspection) {
								ResponceObj responceDTO= new ResponceObj();

								try {
									Optional<SOP_SpindleRunOutInspection> optional=sOPService.getSpindleRunOutInspectionById(sopRunOutInspection.getId());
									if(optional.isPresent()){
										//sopRunOutInspection=optional.get();
										sopRunOutInspection.setUpdatedBy(sopRunOutInspection.getAddedBy());
										sopRunOutInspection.setUpdatedDate(new Date());
										responceDTO.setCode(200);
										responceDTO.setMessage("Spindle Run Out Inspection Updated Successfully");
									}else{
										

										SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(sopRunOutInspection.getSopId(),30);
										sopStageStatus.setStatus("Completed");
										sOPService.saveSOPStage(sopStageStatus);
										
										
										sopRunOutInspection.setAddedDate(new Date());
										responceDTO.setCode(200);
										responceDTO.setMessage("Spindle Run Out Inspection Added Successfully");
									}
									
									sOPService.addRunOutInspection(sopRunOutInspection);
									sOPService.checkSecondaryInspectionClosed(sopRunOutInspection.getSopId());
									return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
									
								} catch (Exception e) {
									// TODO: handle exception	
									responceDTO.setCode(500);
									responceDTO.setMessage(e.getMessage());
									return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
								}
								
									
								}

				
							/*
							 *    Point No 30
							 * 
							 *  Spindle Run Out Inspection
							 * 
							 *  Mahesh Pund
							 * 
							 * */
				@RequestMapping(value = "/deletSpindleRunOutInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<ResponceObj> deletRunOutInspection(@RequestBody SOP_SpindleRunOutInspection  sopRunOutInspection) {
					ResponceObj responceDTO= new ResponceObj();

					try {
						sOPService.deletRunOutInspection(sopRunOutInspection);
							responceDTO.setCode(200);
							responceDTO.setMessage("Spindle Run Out inspection Deleted Successfully");
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
						
					} catch (Exception e) {
						responceDTO.setCode(500);
						responceDTO.setMessage(e.getMessage());
						return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
					}
				}
				/*
				 *    Point No 30
				 * 
				 *  Spindle Run Out Inspection
				 * 
				 *  Mahesh Pund
				 * 
				 * */
				@RequestMapping(value = "/getSpindleROIbySopId", method = RequestMethod.GET)
				public @ResponseBody SOP_SpindleRunOutInspection getSpindleROI(@RequestParam("sopId") int sopId) {
					SOP_SpindleRunOutInspection spindleROI=new SOP_SpindleRunOutInspection();
					try {	
						Optional<SOP_SpindleRunOutInspection> optional=sOPService.getSpindleROIBySOPId(sopId);
						if(optional.isPresent()){
							spindleROI=optional.get();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return spindleROI;
				}
				
				
				/*
				 *    Point No 31
				 * 
				 *  Spindle Clearance Inspection:
				 * 
				 * Dattatray Bodhale
				 *  getSpindleROIbySopId
				 * */
				@RequestMapping(value = "/getSpindleClearanceInspectionbySopId", method = RequestMethod.GET)
				public @ResponseBody SOP_SpindleClearanceInspection getSpindleClearanceInspectionbySopId(@RequestParam("sopId") int sopId) {
					SOP_SpindleClearanceInspection spindleROI=new SOP_SpindleClearanceInspection();
					try {	
						Optional<SOP_SpindleClearanceInspection> optional=sOPService.getSpindleClearanceInspectionBySOPId(sopId);
						if(optional.isPresent()){
							spindleROI=optional.get();
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					return spindleROI;
				}
				/*
				 *    Point No 31
				 *   ADD
				 *  Spindle Clearance Inspection:
				 * 
				 *  Mahesh Pund
				 * 
				 * */
							@RequestMapping(value = "/addSpindleClearanceInspection", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
							public ResponseEntity<ResponceObj> addSpindleClearanceInspection(@RequestBody SOP_SpindleClearanceInspection spindleClearanceInspection ) {
								ResponceObj responceDTO= new ResponceObj();

								try {
									Optional<SOP_SpindleClearanceInspection> optional=sOPService.getSpindleClearanceInspectionById(spindleClearanceInspection.getId());
									if(optional.isPresent()){
										//sopRunOutInspection=optional.get();
										spindleClearanceInspection.setUpdatedBy(spindleClearanceInspection.getAddedBy());
										spindleClearanceInspection.setUpdatedDate(new Date());
										responceDTO.setCode(200);
										responceDTO.setMessage("Spindle Clearance Inspection Updated Successfully");
									}else{
										
										SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleClearanceInspection.getSopId(),31);
										sopStageStatus.setStatus("Completed");
										sOPService.saveSOPStage(sopStageStatus);
										
										
										
										spindleClearanceInspection.setAddedDate(new Date());
										responceDTO.setCode(200);
										responceDTO.setMessage("Spindle Clearance Inspection Added Successfully");
									}
									
									sOPService.addSpindleClearanceInspection(spindleClearanceInspection);
									sOPService.checkSecondaryInspectionClosed(spindleClearanceInspection.getSopId());
									return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
									
								} catch (Exception e) {
									// TODO: handle exception	
									responceDTO.setCode(500);
									responceDTO.setMessage(e.getMessage());
									return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
								}
								
									
								}


							

							/*
							 *    Point No 32  part 1
							 * 
							 *  SOP_RunningTestResult
							 * 
							 * Dattatray Bodhale
							 *  getSpindleROIbySopId
							 * */
							@RequestMapping(value = "/getRunningTestResultbySopId", method = RequestMethod.GET)
							public @ResponseBody List<SOP_RunningTestResult> getRunningTestResultbySopId(@RequestParam("sopId") int sopId) {
								List<SOP_RunningTestResult>  list1=new ArrayList<SOP_RunningTestResult>();
								try {	
									List<SOP_RunningTestResult> list=sOPService.getRunningTestResultbySopId(sopId);
									System.out.println("List Size :: "+list.size());
									if(list.size()!=0){
										list1=list;
										System.out.println("Alrady Data Exits ");
									}else{
										System.out.println("Empty Data Created ");
										for(int i=0;i<=15;i++){
											SOP_RunningTestResult clearanceInspection= new SOP_RunningTestResult();
											if(i==0){
												clearanceInspection.setRpm("500");
											}
											if(i==1){
												clearanceInspection.setRpm("1000");
											}
											if(i==2){
												clearanceInspection.setRpm("2000");
											}
											if(i==3){
												clearanceInspection.setRpm("3000");
											}
											if(i==4){
												clearanceInspection.setRpm("4000");
											}
											if(i==5){
												clearanceInspection.setRpm("5000");
											}
											if(i==6){
												clearanceInspection.setRpm("6000");
											}
											if(i==7){
												clearanceInspection.setRpm("7000");
											}
											if(i==8){
												clearanceInspection.setRpm("8000");
											}
											if(i==9){
												clearanceInspection.setRpm("9000");
											}
											if(i==10){
												clearanceInspection.setRpm("10000");
											}
											
											if(i==11){
												clearanceInspection.setRpm("11000");
											}
											if(i==12){
												clearanceInspection.setRpm("12000");
											}
											if(i==13){
												clearanceInspection.setRpm("13000");
											}
											if(i==14){
												clearanceInspection.setRpm("14000");
											}
											if(i==15){
												clearanceInspection.setRpm("15000");
											}
											list1.add(clearanceInspection);
										}
										
										
										
										
									}
								
								} catch (Exception e) {
									e.printStackTrace();
								}
								return list1;
							}
							/*
							 *   Point No 32  part 1
							 *   ADD
							 *  SOP_RunningTestResult
							 * 
							 *  Mahesh Pund
							 * 
							 * */
										@RequestMapping(value = "/addRunningTestResult", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
										public ResponseEntity<ResponceObj> addRunningTestResult(@RequestBody List<SOP_RunningTestResult> runningTestResults  ) {
											ResponceObj responceDTO= new ResponceObj();
											System.out.println("Test Result 1");
											try {
												for (SOP_RunningTestResult runningTestResult:runningTestResults) {
													Optional<SOP_RunningTestResult> optional=sOPService.getRunningTestResultById(runningTestResult.getId());
													if(optional.isPresent()){
														//sopRunOutInspection=optional.get();
														runningTestResult.setUpdatedBy(runningTestResult.getAddedBy());
														runningTestResult.setUpdatedDate(new Date());
														responceDTO.setCode(200);
														responceDTO.setMessage("Running Test Result Updated Successfully");
													}else{
														SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(runningTestResult.getSopId(),32);
														sopStageStatus.setStatus("Completed");
														sOPService.saveSOPStage(sopStageStatus);
														
														
														runningTestResult.setAddedDate(new Date());
														responceDTO.setCode(200);
														responceDTO.setMessage("Running Test Result Added Successfully");
													}
													
													sOPService.addRunningTestResult(runningTestResult);
												}
												
												sOPService.checkSecondaryInspectionClosed(runningTestResults.get(0).getSopId());
												return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
												
											} catch (Exception e) {
												// TODO: handle exception	
												responceDTO.setCode(500);
												responceDTO.setMessage(e.getMessage());
												return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
											}
											
												
											}
							
										/*
										 *    Point No 32 Part 2
										 * 
										 *   GET Time spent on spindle service
										 * 
										 * Dattatray Bodhale
										 *  
										 * */
										@RequestMapping(value = "/getRunningTestResult2SopId", method = RequestMethod.GET)
										public @ResponseBody SOP_RunningTestResult2 getRunningTestResult2SopId(@RequestParam("sopId") int sopId) {
											SOP_RunningTestResult2 spindleROI=new SOP_RunningTestResult2();
											try {	
												Optional<SOP_RunningTestResult2> optional=sOPService.getRunningTestResult2SopId(sopId);
												if(optional.isPresent()){
													spindleROI=optional.get();
												}
											
											} catch (Exception e) {
												e.printStackTrace();
											}
											return spindleROI;
										}
										/*
										 *   Point No 32  part 2
										 *   ADD
										 *  SOP_RunningTestResult
										 * 
										 *  Mahesh Pund
										 * 
										 * */
													@RequestMapping(value = "/addRunningTestResult2", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
													public ResponseEntity<ResponceObj> addRunningTestResult2(@RequestBody SOP_RunningTestResult2 runningTestResult  ) {
														ResponceObj responceDTO= new ResponceObj();
														System.out.println("Test Result 2");
														try {
															Optional<SOP_RunningTestResult2> optional=sOPService.getRunningTestResult2nById(runningTestResult.getId());
															if(optional.isPresent()){
																//sopRunOutInspection=optional.get();
																runningTestResult.setUpdatedBy(runningTestResult.getAddedBy());
																runningTestResult.setUpdatedDate(new Date());
																responceDTO.setCode(200);
																responceDTO.setMessage("Running Test Result Updated Successfully");
															}else{
																runningTestResult.setAddedDate(new Date());
																responceDTO.setCode(200);
																responceDTO.setMessage("Running Test Result Added Successfully");
															}
															
															sOPService.addRunningTestResult2(runningTestResult);
															sOPService.checkSecondaryInspectionClosed(runningTestResult.getSopId());
															return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
															
														} catch (Exception e) {
															// TODO: handle exception	
															responceDTO.setCode(500);
															responceDTO.setMessage(e.getMessage());
															return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
														}
														
															
														}
										
										
							
							
							
							/*
							 *    Point No 33
							 * 
							 *   GET Time spent on spindle service
							 * 
							 * Dattatray Bodhale
							 *  
							 * */
							@RequestMapping(value = "/getTimeSpentSpindleServiceSopId", method = RequestMethod.GET)
							public @ResponseBody List<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceSopId(@RequestParam("sopId") int sopId) {
								List<SOP_TimeSpentSpindleService> spindleROI=new ArrayList<SOP_TimeSpentSpindleService>();
								try {	
									List<SOP_TimeSpentSpindleService> list=sOPService.getListTimeSpentSpindleServiceSopId(sopId);
									if(list.size()!=0){
										spindleROI=list;
									}else{
										
										for(int i=0 ; i<=3;i++){
											SOP_TimeSpentSpindleService service= new SOP_TimeSpentSpindleService();
											if(i==0){
												service.setActivity("Disassembly+Washing");
											}
											if(i==1){
												service.setActivity("Checking");
											}
											if(i==2){
												service.setActivity("Assembly");
											}
											if(i==3){
												service.setActivity("Testing");
											}
											spindleROI.add(service);
										}
									}
								
								} catch (Exception e) {
									e.printStackTrace();
								}
								return spindleROI;
							}
							/*
							 *    Point No 33
							 *   ADD
							 *  Spindle Clearance Inspection:
							 * 
							 *  Mahesh Pund
							 * 
							 * */
										@RequestMapping(value = "/addTimeSpentSpindleService", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
										public ResponseEntity<ResponceObj> addTimeSpentSpindleService(@RequestBody List<SOP_TimeSpentSpindleService> spindleClearanceInspections ) {
											ResponceObj responceDTO= new ResponceObj();

											try {
												for(SOP_TimeSpentSpindleService spindleClearanceInspection:spindleClearanceInspections){
													Optional<SOP_TimeSpentSpindleService> optional=sOPService.getTimeSpentSpindleServiceById(spindleClearanceInspection.getId());
													if(optional.isPresent()){
														//sopRunOutInspection=optional.get();
														spindleClearanceInspection.setUpdatedBy(spindleClearanceInspection.getAddedBy());
														spindleClearanceInspection.setUpdatedDate(new Date());
														responceDTO.setCode(200);
														responceDTO.setMessage("Time Spent Spindle Service Updated Successfully");
													}else{
														SOPStageStatus sopStageStatus= sOPService.getStageBySOPIdAndStageNo(spindleClearanceInspections.get(0).getSopId(),33);
														sopStageStatus.setStatus("Completed");
														sOPService.saveSOPStage(sopStageStatus);
														
														spindleClearanceInspection.setAddedDate(new Date());
														responceDTO.setCode(200);
														responceDTO.setMessage("Time Spent Spindle Service Added Successfully");
													}
													
													sOPService.addTimeSpentSpindleService(spindleClearanceInspection);
													sOPService.checkSecondaryInspectionClosed(spindleClearanceInspection.getSopId());
												}
											
												return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
												
											} catch (Exception e) {
												// TODO: handle exception	
												responceDTO.setCode(500);
												responceDTO.setMessage(e.getMessage());
												return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
											}
											
												
											}

					
	//************************************************** POINT APIs *************************//
}



