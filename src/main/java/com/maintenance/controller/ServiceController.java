/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.dto.BearingDTO;
import com.maintenance.dto.Email;
import com.maintenance.dto.ResponceObj;
import com.maintenance.dto.SpindleServiceRequestDTO;
import com.maintenance.model.BearringAccessory;
import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.Customer;
import com.maintenance.model.Department;
import com.maintenance.model.Designation;
import com.maintenance.model.Employee;
import com.maintenance.model.MailManager;
import com.maintenance.model.SOP;
import com.maintenance.model.ServiceReason;
import com.maintenance.model.ServiceRequestMappedEnginner;
import com.maintenance.model.Spindle;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.service.CommomService;
import com.maintenance.service.CustomerService;
import com.maintenance.service.EmailSmsService;
import com.maintenance.service.EmployeeService;
import com.maintenance.service.SOPService;
import com.maintenance.service.ServiceSer;
import com.maintenance.service.SpindleService;

/**
 * @author Dattatray Bodhale
 *
 */
@RestController
@RequestMapping("/service")
@CrossOrigin("*")
public class ServiceController {
	
	@Autowired
	ServiceSer serviceSer;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmailSmsService emailSmsService;
	
	@Autowired
	SOPService sopService;
	
	@Autowired
	CustomerService customerService;
	@Autowired
	SpindleService spindleService;
	@Autowired
	CommomService commomService;
	//******************************************** SERVICE RRQUEST **************************************/

/*
 *  Dattatray Bodhale
 *  
 *  10-05-2021
 *  
 *    List Of  Spindle Service Request By Pagination
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestByPagination", method = RequestMethod.GET)
public @ResponseBody List<SpindleServiceRequest> getSpindleServiceRequestByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<SpindleServiceRequest> list= new  ArrayList<SpindleServiceRequest>();
	try {	
		list=serviceSer.getSpindleServiceRequestByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  10-05-2021
 *  
 *   Count Of  Spindle Service Request
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestCount", method = RequestMethod.GET)
public @ResponseBody int  getSpindleServiceRequestCount() {
	int  count= 0;
	try {
		count= serviceSer.getSpindleServiceRequestCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  10-05-2021
 *  
 *    List Of  Spindle Service Request By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<SpindleServiceRequest> getSpindleServiceRequestByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<SpindleServiceRequest> list= new  ArrayList<SpindleServiceRequest>();
	try {	
		System.out.println("Search By "+search);
		list=serviceSer.getSpindleServiceRequestByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  10-05-2021
 *  
 *   Count Of  Spindle Service Request by Search
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getSpindleServiceRequestCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= serviceSer.getSpindleServiceRequestCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  14-05-2021
 *  
 *   Get List Of All ServiceReason
 * 
 * */


@RequestMapping(value = "/bearingListBySSCNo", method = RequestMethod.GET)
public @ResponseBody BearingDTO bearingListBySSCNo(@RequestParam("sscNo") String sscNo) {
	BearingDTO bearingDTO = new BearingDTO();
	List<BearringAccessory> frontBearing= serviceSer.getFrontBearingBySSCNo(sscNo);
	List<BearringAccessory> rearBearing= serviceSer.getRearBearingBySSCNo(sscNo);
	bearingDTO.setFrontBearing(frontBearing);
	bearingDTO.setRearBearing(rearBearing);
	return bearingDTO;
}

@RequestMapping(value = "/bearingReqListFrontBycustReqId", method = RequestMethod.GET)
public @ResponseBody List<BearringAccessoryCustReq> bearingReqListFrontBycustReqId(@RequestParam("custReqId") int custReqId) {
	
	return serviceSer.bearingReqListFrontBycustReqId(custReqId);
}
@RequestMapping(value = "/bearingReqListRearBycustReqId", method = RequestMethod.GET)
public @ResponseBody List<BearringAccessoryCustReq> bearingReqListRearBycustReqId(@RequestParam("custReqId") int custReqId) {
	
	return serviceSer.bearingReqListRearBycustReqId(custReqId);
}




	/*
	 *  Dattatray Bodhale
	 *  
	 *  07-05-2021
	 *  
	 *   Get List Of All ServiceReason
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllSpindleServiceRequestList", method = RequestMethod.GET)
	public @ResponseBody List<SpindleServiceRequest> getAllSpindleServiceRequestList() {
		List<SpindleServiceRequest> list = null;

		list= serviceSer.getAllSpindleServiceRequestList();

		return list;
	}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  07-05-2021
	 *  
	 *    Add New  Service Reason 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewSpindleServiceRequest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewSpindleServiceRequest(@RequestBody SpindleServiceRequest  spindleServiceRequest) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			System.out.println("Branch Id :: "+spindleServiceRequest.getBranch().getBranchId());
			Branch branch= employeeService.getBranchById(spindleServiceRequest.getBranch().getBranchId());
			Optional<SpindleServiceRequest> optional= serviceSer.getSpindleServiceRequestBySSCNo(spindleServiceRequest.getSscNo());
			//System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+spindle.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Spindle Service Request is  already .....Exits");
			}else{
				System.out.println("BranchCode :: "+branch.getBranchCode());
				String  sscNo=serviceSer.getNewSSCNoForBranch(branch.getBranchCode());
				
				System.out.println("SSC NO :: "+sscNo);
				spindleServiceRequest.setStatus("INITIATED");
				spindleServiceRequest.setSscNo(sscNo);
				spindleServiceRequest.setActive(1);
				spindleServiceRequest.setAddedDate(new Date());
				serviceSer.addSpindleServiceRequest(spindleServiceRequest);
				
				
				SOP sop= new SOP();  
				sop.setCustomer(spindleServiceRequest.getCustomer());
				sop.setIssue(spindleServiceRequest.getAdditionDetials());
				sop.setNoOfstage(33);
				sop.setNoOfStageComplete(0);
				sop.setSpindle(spindleServiceRequest.getSpindle());
				sop.setSprindleServiceRequestId(spindleServiceRequest.getSprindleServiceRequestId());
			//	sop.set
				sopService.addSOP(sop);
				for(BearringAccessory bearringAccessory: spindleServiceRequest.getRearBearings()){
					bearringAccessory.setAddedBy(spindleServiceRequest.getAddedBy());
					bearringAccessory.setAddedDate(new Date());
					bearringAccessory.setSide("Rear");
					bearringAccessory.setSscNo(sscNo);
					serviceSer.saveBearringAccessory(bearringAccessory);
					
				}
				for(BearringAccessory bearringAccessory:spindleServiceRequest.getFrontBearings()){
					bearringAccessory.setAddedBy(spindleServiceRequest.getAddedBy());
					bearringAccessory.setAddedDate(new Date());
					bearringAccessory.setSide("Front");
					bearringAccessory.setSscNo(sscNo);
					serviceSer.saveBearringAccessory(bearringAccessory);

				}
				ServiceReason  reason=serviceSer.getServiceReasonById(spindleServiceRequest.getReason().getReasonId());
				if(spindleServiceRequest.getCustomer().getEmailId()!=""){
					String message="<h5> Hello "+spindleServiceRequest.getCustomer().getCompanyName()+" "+",</h5> Your Spindle Service Registration has done Successfully ,Please refer following detials <br><br> SSC No : "+spindleServiceRequest.getSscNo()+"</br> Spindle Model :"+spindleServiceRequest.getSpindle().getSpindleModel()+"<br> Spindle : "+spindleServiceRequest.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
					emailSmsService.sendMail(spindleServiceRequest.getCustomer().getEmailId(), "Service Request Registration Sucessfull", message);
			
				}
				
				if(spindleServiceRequest.getEmails().size()!=0){
					for(Email email:spindleServiceRequest.getEmails()){
						String message="<h5> Hello "+email.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+spindleServiceRequest.getCustomer().getCustomerCode()+"-"+spindleServiceRequest.getCustomer().getCompanyName() +"</br> SSC No : "+spindleServiceRequest.getSscNo()+"</br> Spindle Model :"+spindleServiceRequest.getSpindle().getSpindleModel()+"<br> Spindle : "+spindleServiceRequest.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
						emailSmsService.sendMail(email.getEmailId(), "Service Request Registration Sucessfull", message);
				
					}
					
				}
				
				List<MailManager> mailManagers = commomService.getAllMailManagerForNewService();
				if(mailManagers.size()!=0){
					for(MailManager mailManager: mailManagers){
						
						String message="<h5> Hello "+mailManager.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+spindleServiceRequest.getCustomer().getCustomerCode()+"-"+spindleServiceRequest.getCustomer().getCompanyName() +"</br> SSC No : "+spindleServiceRequest.getSscNo()+"</br> Spindle Model :"+spindleServiceRequest.getSpindle().getSpindleModel()+"<br> Spindle : "+spindleServiceRequest.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
						emailSmsService.sendMail(mailManager.getMailTo(), "Service Request Registration Sucessfull", message);
				
						
					}
					
				}
				responceDTO.setCode(200);
				responceDTO.setMessage("SpindleService Request Added Successfully");
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
	 *  05-05-2021
	 *  
	 *    Change Status
	 * 
	 * */
	
	

	@RequestMapping(value = "/changeStatusSpindleServiceRequest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody SpindleServiceRequest  spindleServiceRequest) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			spindleServiceRequest.setUpdDatetime(new Date());;
				serviceSer.addSpindleServiceRequest(spindleServiceRequest);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Service Request status updated successfully");
			
				
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
	 *  05-05-2021
	 *  
	 *  Update  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateSpindleServiceRequest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> updateSpindleServiceRequest(@RequestBody SpindleServiceRequest  spindleServiceRequest) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			spindleServiceRequest.setUpdDatetime(new Date());
				serviceSer.addSpindleServiceRequest(spindleServiceRequest);
				responceDTO.setCode(200);
				responceDTO.setMessage("Service Reason Update Successfully");
			
				
		
			
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
	 *  05-05-2021
	 *  
	 *  Update  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/deletSpindleServiceRequest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletSpindleServiceRequest(@RequestBody SpindleServiceRequest  spindleServiceRequest) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			spindleServiceRequest.setDelBit(1);
			spindleServiceRequest.setUpdDatetime(new Date());
				serviceSer.addSpindleServiceRequest(spindleServiceRequest);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Service Request Deleted Successfully");
			
				
		
			
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
	 *  17-05-2021
	 *  
	 *  Assign Engineer
	 * 
	 * */
	
	

	@RequestMapping(value = "/assignEngineer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> assignEngineer(@RequestBody SpindleServiceRequest  spindleServiceRequest) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
				
				
				spindleServiceRequest.setUpdDatetime(new Date());
				serviceSer.addSpindleServiceRequest(spindleServiceRequest);
				
				Optional<SOP> optional= sopService.getSOPByServiceRequestID(spindleServiceRequest.getSprindleServiceRequestId());
				if(optional.isPresent()){
					SOP sop2= new SOP();
					sop2=optional.get();
					sop2.setTechnician(spindleServiceRequest.getEngineer());
					sopService.updateSOP(sop2);
				}
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Engineer Assigned Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
	
	@RequestMapping(value = "/requestServiceSpindleByEngineer", method = RequestMethod.GET)
	public ResponseEntity<ResponceObj> requestServiceSpindleByEngineer(@RequestParam("engineerId") int engineerId,@RequestParam("sscNo") String sscNo) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
					ServiceRequestMappedEnginner  serviceRequestMappedEnginner= new ServiceRequestMappedEnginner();
					Optional<SpindleServiceRequest>  spindleServiceRequest =serviceSer.getSpindleServiceRequestBySSCNo(sscNo);
					Employee employee =employeeService.getEmployeeById(engineerId);
					serviceRequestMappedEnginner.setEngineerId(engineerId);
					serviceRequestMappedEnginner.setRequestedBy(employee.getfName()+" "+employee.getlName());
					serviceRequestMappedEnginner.setRequestedDate(new Date());
					serviceRequestMappedEnginner.setStatus("Requested");
					serviceRequestMappedEnginner.setSprindleServiceRequestId(spindleServiceRequest.get().getSprindleServiceRequestId());
				
					serviceSer.saveServiceRequestMappedEnginner(serviceRequestMappedEnginner);
					responceDTO.setCode(200);
				responceDTO.setMessage("Engineer Assigned Successfully");
			
				
		
			
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
	 *  17-05-2021
	 *  
	 *   Get List Of All SpindleServiceRequest Assigned to Enginner
	 * 
	 * */
	
	
	@RequestMapping(value = "/getSpindleServiceRequestListByEngineer", method = RequestMethod.GET)
	public @ResponseBody List<SpindleServiceRequest> getSpindleServiceRequestListByEngineer(@RequestParam("engineerId") int engineerId) {
		List<SpindleServiceRequest> list1 = null;

		list1= serviceSer.getSpindleServiceRequestListByEngineer(engineerId);
		List<ServiceRequestMappedEnginner> serviceRequestMappedEnginners=serviceSer.getUnApprovedMappedServiceRequestByEng(engineerId);
		for(ServiceRequestMappedEnginner serviceRequestMappedEnginner:serviceRequestMappedEnginners){
			SpindleServiceRequest spindleServiceRequest = serviceSer.getSpindleServiceRequestId(serviceRequestMappedEnginner.getSprindleServiceRequestId());
		
			list1.add(spindleServiceRequest);
		}
		
		

		return list1;
	}
	//******************************************** SERVICE REASON **************************************/

	
	
	
/*
 *  Dattatray Bodhale
 *  
 *  07-05-2021
 *  
 *    List Of  Service Reason By Pagination
 * 
 * */
@RequestMapping(value = "/getServiceReasonByPagination", method = RequestMethod.GET)
public @ResponseBody List<ServiceReason> getServiceReasonByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<ServiceReason> list= new  ArrayList<ServiceReason>();
	try {	
		list=serviceSer.getServiceReasonByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  07-05-2021
 *  
 *   Count Of  Service Reason
 * 
 * */
@RequestMapping(value = "/getServiceReasonCount", method = RequestMethod.GET)
public @ResponseBody int  getServiceReasonCount() {
	int  count= 0;
	try {
		count= serviceSer.getServiceReasonCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  07-05-2021
 *  
 *    List Of  Service Reason By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getServiceReasonByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<ServiceReason> getServiceReasonByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<ServiceReason> list= new  ArrayList<ServiceReason>();
	try {	
		list=serviceSer.getServiceReasonByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  07-05-2021
 *  
 *   Count Of  Service Reason by Search
 * 
 * */
@RequestMapping(value = "/getServiceReasonCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getServiceReasonCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= serviceSer.getServiceReasonCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}



	/*
	 *  Dattatray Bodhale
	 *  
	 *  07-05-2021
	 *  
	 *   Get List Of All ServiceReason
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllServiceReasonList", method = RequestMethod.GET)
	public @ResponseBody List<ServiceReason> getAllServiceReasonList() {
		List<ServiceReason> list = null;

		list= serviceSer.getAllSpindleList();

		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  12-05-2021
	 *  
	 *   Get List Of active ServiceReason
	 * 
	 * */
	
	
	@RequestMapping(value = "/getActiveServiceReasonList", method = RequestMethod.GET)
	public @ResponseBody List<ServiceReason> getActiveServiceReasonList() {
		List<ServiceReason> list = null;

		list= serviceSer.getActiveServiceReasonList();

		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  07-05-2021
	 *  
	 *    Add New  Service Reason 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewServiceReason", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewServiceReason(@RequestBody ServiceReason  serviceReason) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<ServiceReason> optional= serviceSer.getServiceReasonByname(serviceReason.getReasonName());
			//System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+spindle.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Service Reason  is  already .....Exits");
			}else{
				serviceReason.setActive(1);
				serviceReason.setAddedDate(new Date());
				serviceSer.addServiceReason(serviceReason);
				responceDTO.setCode(200);
				responceDTO.setMessage("Service Reason Added Successfully");
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
	 *  05-05-2021
	 *  
	 *    Change Status
	 * 
	 * */
	
	

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody ServiceReason  serviceReason) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			serviceReason.setUpdDatetime(new Date());
				serviceSer.addServiceReason(serviceReason);
				responceDTO.setCode(200);
				responceDTO.setMessage("Service Reason status updated successfully");
			
				
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
	 *  05-05-2021
	 *  
	 *  Update  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateServiceReason", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> updateServiceReason(@RequestBody ServiceReason  serviceReason) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			serviceReason.setUpdDatetime(new Date());
				serviceSer.addServiceReason(serviceReason);
				responceDTO.setCode(200);
				responceDTO.setMessage("Service Reason Update Successfully");
			
				
		
			
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
	 *  05-05-2021
	 *  
	 *  Update  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/deletServiceReason", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletServiceReason(@RequestBody ServiceReason  serviceReason) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			serviceReason.setDeletBit(1);
			serviceReason.setUpdDatetime(new Date());
				serviceSer.addServiceReason(serviceReason);
				responceDTO.setCode(200);
				responceDTO.setMessage("Service Reason Deleted Successfully");
			
				
		
			
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
 *  16-06-2021
 *  
 *    Get Spindle Service Request By QrCode 
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestByQRCode", method = RequestMethod.GET)
public @ResponseBody SpindleServiceRequest getSpindleServiceRequestByQRCode(@RequestParam("qrCode") String  qrCode) {
	SpindleServiceRequest spindleServiceRequest= new SpindleServiceRequest();
	try {	
		spindleServiceRequest=serviceSer.getSpindleServiceRequestByQRCode(qrCode);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return spindleServiceRequest;
}
/*
 *  Dattatray Bodhale
 *  
 *  16-06-2021
 *  
 *    Get Spindle Service Request By SSC NO 
 * 
 * */
@RequestMapping(value = "/getSpindleServiceRequestBySSCNo", method = RequestMethod.GET)
public @ResponseBody ResponceObj getSpindleServiceRequestBySSCNo(@RequestParam("sscNo") String  sscNo) {
	ResponceObj responceObj= new ResponceObj();
	try {	
		Optional <SpindleServiceRequest> optional =serviceSer.getSpindleServiceRequestBySSCNo(sscNo);
	
		if(optional.isPresent()){
			System.out.println("Hello "+optional.get().getSprindleServiceRequestId());
			Optional <ServiceRequestMappedEnginner > enginnerMap=serviceSer.getServiceRequestMappedEnginnerByServiceRequest(optional.get().getSprindleServiceRequestId());
			if(optional.get().getEngineer()!=null){
				responceObj.setCode(500);
				responceObj.setMessage("Engineer is already Assined");
				
			  }else if (enginnerMap.isPresent()){
				  responceObj.setCode(500);
					responceObj.setMessage("Already Requested");
				
			  }else{
				  responceObj.setCode(200);
					responceObj.setMessage("Data Found Successfully");
					SpindleServiceRequestDTO spindleServiceRequestDTO=new SpindleServiceRequestDTO();
					spindleServiceRequestDTO.setMachineBrand(optional.get().getSpindle().getMachineBrand());
					spindleServiceRequestDTO.setMachineModel(optional.get().getSpindle().getMachineModel());
					spindleServiceRequestDTO.setSpindleBrand(optional.get().getSpindle().getSpindleBrand());
					spindleServiceRequestDTO.setSpindleModel(optional.get().getSpindle().getSpindleModel());
					spindleServiceRequestDTO.setSpindleServicceRequestId(optional.get().getSprindleServiceRequestId());
					spindleServiceRequestDTO.setSerialNo(optional.get().getSpindle().getSerialNo());
					spindleServiceRequestDTO.setSscNo(optional.get().getSscNo());
					spindleServiceRequestDTO.setSpindleRequestedDate(optional.get().getAddedDate());
					responceObj.setData(spindleServiceRequestDTO);
					System.out.println("222Hello "+optional.get().getSprindleServiceRequestId());
			  }
			
			
			
		}else{
			responceObj.setCode(500);
			responceObj.setMessage("InValid SSC NO ");
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return responceObj;
}




/*
 *  Dattatray Bodhale
 *  
 *  14-06-2021
 *  
 *  Add Spindle Service Request By  Engineer
 * 
 * */



@RequestMapping(value = "/addSpindleServiceRequestByEngineer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponceObj> addSpindleServiceRequestByEngineer(@RequestBody SpindleServiceRequestDTO spindleServiceRequestDTO ) {
	ResponceObj responceDTO= new ResponceObj();

	try {
		System.out.println("Hello "+spindleServiceRequestDTO.getSscNo());

		Optional<SpindleServiceRequest>  spindleServiceRequest= serviceSer.getSpindleServiceRequestBySSCNo(spindleServiceRequestDTO.getSscNo());
		Employee employee=employeeService.getEmployeeById(spindleServiceRequestDTO.getEmployeeId());
		
		
		ServiceRequestMappedEnginner serviceRequestMappedEnginner= new ServiceRequestMappedEnginner();
		serviceRequestMappedEnginner.setSprindleServiceRequestId(spindleServiceRequest.get().getSprindleServiceRequestId());
		serviceRequestMappedEnginner.setEngineerId(employee.getEmployeeId());
		serviceRequestMappedEnginner.setRequestedBy(employee.getfName()+" "+employee.getlName());
		serviceRequestMappedEnginner.setRequestedDate(new Date());
		serviceRequestMappedEnginner.setStatus("Requested");
			//spindleServiceRequest.setUpdDatetime(new Date());
			serviceSer.addServiceRequestMappedEnginner(serviceRequestMappedEnginner);
			
			
			SOP sop= new SOP();
			sop.setCustomer(spindleServiceRequest.get().getCustomer());
			sop.setIssue(spindleServiceRequest.get().getAdditionDetials());
			sop.setNoOfstage(33);
			sop.setNoOfStageComplete(0);
			sop.setSpindle(spindleServiceRequest.get().getSpindle());
			sop.setSprindleServiceRequestId(spindleServiceRequest.get().getSprindleServiceRequestId());
			sop.setTechnician(employee);
			sop.setStatus("Intiated");
			sopService.addSOP(sop);
			responceDTO.setCode(200);
			responceDTO.setMessage("Engineer Assigned Successfully");
		
			
	
		
		return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		responceDTO.setCode(500);
		responceDTO.setMessage(e.getMessage());
		return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
	}
	
		
	}

@RequestMapping(value = "/uploadServiceRequest", method = RequestMethod.POST)
public @ResponseBody ResponseEntity postFile(@ModelAttribute(value = "file") MultipartFile file
	) throws ParseException {
	try {
		
	System.out.println("CALLL UPLOAD :::: "+file.getOriginalFilename());
		if (!(file == null)) {
			if (file.isEmpty()) {
			//	logger.info("File not found");
				System.out.println("File not found");
			} else {
				System.out.println(file.getOriginalFilename());
				try {
					File dir = new File(System.getProperty("catalina.base"), "uploads");
					File uplaodedFile = new File(dir + file.getOriginalFilename());
					file.transferTo(uplaodedFile);
					FileInputStream excelFile = new FileInputStream(uplaodedFile);
				//	logger.info("hiiii@  :: " + excelFile);
					Workbook workbook = new XSSFWorkbook(excelFile);
					Sheet datatypeSheet = workbook.getSheetAt(0); 
					int i = 1;
					
					while (i <= datatypeSheet.getLastRowNum()) { 

						XSSFRow row = null;
						row = (XSSFRow) datatypeSheet.getRow(i++);
						String str = row.getCell(0).toString();
						
						if(str.length()==0) {
							continue;
						}
						Branch branch = commomService.getBranchByName(row.getCell(35).toString());
						
						System.out.println("Branch :: "+row.getCell(35).toString());
						City city= commomService.getCityByName(row.getCell(5).toString());
						ServiceReason  reason=serviceSer.getServiceReasonByName(row.getCell(24).toString());

						Optional<Customer> optional = customerService.getCustomerByCode(row.getCell(6).toString());
						Customer customer1 = new Customer(); 
						if(optional.isPresent()){
							customer1=optional.get();
						}else{
							Customer customer = new Customer(); 
							customer.setCustomerCode(row.getCell(1).toString());
							customer.setCompanyName(row.getCell(2).toString());
							customer.setContactPerson(row.getCell(3).toString());
							customer.setAddress(row.getCell(4).toString());
							customer.setCity(city);
							customer.setPincode(row.getCell(7).toString());
							customer.setPhoneNo(row.getCell(8).toString());
							customer.setEmailId(row.getCell(9).toString());
							customer.setActive(1);
							customer.setBranch(branch);
							customer.setDelBit(0);
							customer1=customerService.addCustomer1(customer);
							
							
						}
						Optional<Spindle> optional2= spindleService.getSpindleBySerialNo(row.getCell(6).toString());
						Spindle spindle1= new Spindle();
						if(optional2.isPresent()){
							spindle1=optional2.get();
						}else{
							
							
							Spindle spindle= new Spindle();
							spindle.setSpindleBrand(row.getCell(10).toString());
							spindle.setSpindleModel(row.getCell(11).toString());
							spindle.setMachineBrand(row.getCell(12).toString());
							spindle.setMachineModel(row.getCell(13).toString());
							spindle.setSerialNo(row.getCell(14).toString());
							spindle.setPower(row.getCell(15).toString());
							spindle.setMaxSpeed(row.getCell(16).toString());
							spindle.setOperatingSpeed(row.getCell(17).toString());
							spindle.setPoles(row.getCell(18).toString());
							spindle.setToolTaper(row.getCell(19).toString());
							spindle.setCurrent(row.getCell(20).toString());
							spindle.setVoltage(row.getCell(21).toString());
							spindle.setLubrication(row.getCell(22).toString());
							spindle.setAssemblyDrawing(row.getCell(23).toString());
							spindle.setActive(1);
							spindle.setDelBit(0);
							spindle.setAddedDate(new Date());
							spindle1=spindleService.saveSpindle(spindle);
							
						}
						
						
						SpindleServiceRequest request = new SpindleServiceRequest();
						String  sscNo=serviceSer.getNewSSCNoForBranch(branch.getBranchCode());
						request.setSscNo(sscNo);
						request.setSpindleDesign(row.getCell(25).toString());
						request.setApplication(row.getCell(26).toString());
						request.setDrive(row.getCell(27).toString());
						request.setMoutingType(row.getCell(28).toString());
						request.setOrientation(row.getCell(29).toString());
						request.setReplacementSpindle(row.getCell(30).toString());
						request.setServiceRequested(row.getCell(31).toString());
						
						request.setAdditionDetials(row.getCell(32).toString());
						request.setServiceRequested(row.getCell(31).toString());
						
						request.setActive(1);
						request.setAddedDate(new Date());
						
						request.setBranch(branch);
						request.setCustomer(customer1);
						request.setDelBit(0);
						
						
						request.setSpindle(spindle1);
						
						request.setStatus("INITIATED");
						
						SpindleServiceRequest request2=serviceSer.addSpindleServiceRequestR(request);
						SOP sop= new SOP();  
						sop.setCustomer(request.getCustomer());
						sop.setIssue(request.getAdditionDetials());
						sop.setNoOfstage(33);
						sop.setNoOfStageComplete(0);
						sop.setSpindle(request.getSpindle());
						sop.setSprindleServiceRequestId(request2.getSprindleServiceRequestId());
					//	sop.set
						sopService.addSOP(sop);
						if(request.getCustomer().getEmailId()!=""){
							String message="<h5> Hello "+request.getCustomer().getCompanyName()+" "+",</h5> Your Spindle Service Registration has done Successfully ,Please refer following detials <br><br> SSC No : "+request.getSscNo()+"</br> Spindle Model :"+request.getSpindle().getSpindleModel()+"<br> Spindle : "+request.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
							emailSmsService.sendMail(request.getCustomer().getEmailId(), "Service Request Registration Sucessfull", message);
					
						}
						List<MailManager> mailManagers = commomService.getAllMailManagerForNewService();
						if(mailManagers.size()!=0){
							for(MailManager mailManager: mailManagers){
								
								String message="<h5> Hello "+mailManager.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+request.getCustomer().getCustomerCode()+"-"+request.getCustomer().getCompanyName() +"</br> SSC No : "+request.getSscNo()+"</br> Spindle Model :"+request.getSpindle().getSpindleModel()+"<br> Spindle : "+request.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
								emailSmsService.sendMail(mailManager.getMailTo(), "Service Request Registration Sucessfull", message);
						
								
							}
							
						}
					}


				//	logger.info("Successfully imported");
					workbook.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}
}



