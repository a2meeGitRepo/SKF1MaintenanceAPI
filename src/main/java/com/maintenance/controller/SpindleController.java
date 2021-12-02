/**
 * Dattatray Bodhale
	06-May-2021
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
import java.util.Set;

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

import com.maintenance.dto.ResponceObj;
import com.maintenance.model.BearringAccessory;
import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.Customer;
import com.maintenance.model.CustomerSpindleRegistration;
import com.maintenance.model.Department;
import com.maintenance.model.Designation;
import com.maintenance.model.Employee;
import com.maintenance.model.MailManager;
import com.maintenance.model.SOP;
import com.maintenance.model.ServiceReason;
import com.maintenance.model.Spindle;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.service.CommomService;
import com.maintenance.service.CustomerService;
import com.maintenance.service.EmailSmsService;
import com.maintenance.service.SOPService;
import com.maintenance.service.ServiceSer;
import com.maintenance.service.SpindleService;

/**
 * @author Dattatray Bodhale
 *
 */
@RestController
@RequestMapping("/spindle")
@CrossOrigin("*")
public class SpindleController {

	@Autowired
	SpindleService spindleService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ServiceSer serviceSer;
	@Autowired
	EmailSmsService emailSmsService;
	@Autowired
	CommomService commomService;
	@Autowired
	SOPService sopService;
/*
 *  Dattatray Bodhale
 *  
 *  06-05-2021
 *  
 *    List Of  Spindle By Pagination
 * 
 * */
@RequestMapping(value = "/getSpindleByPagination", method = RequestMethod.GET)
public @ResponseBody List<Spindle> getCustomerByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<Spindle> list= new  ArrayList<Spindle>();
	try {	
		list=spindleService.getSpindleByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  06-05-2021
 *  
 *   Count Of  Spindle
 * 
 * */
@RequestMapping(value = "/getSpindleCount", method = RequestMethod.GET)
public @ResponseBody int  getSpindleCount() {
	int  count= 0;
	try {
		count= spindleService.getSpindleCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  06-05-2021
 *  
 *    List Of  Spindle By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getSpindleByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<Spindle> getSpindleByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<Spindle> list= new  ArrayList<Spindle>();
	try {	
		list=spindleService.getSpindleByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  06-05-2021
 *  
 *   Count Of  Spindle by Search
 * 
 * */
@RequestMapping(value = "/getSpindleCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getSpindleCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= spindleService.getSpindleCountBySearch(search);
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
 *    List Of  Spindle Model
 * 
 * */
@RequestMapping(value = "/getSpindleModels", method = RequestMethod.GET)
public @ResponseBody Set<String>  getSpindleModels() {
	Set<String>  list = null;
	try {	
		list=spindleService.getSpindleModels();
		
		
		
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
	 *   Get List Of All Spindle
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllSpindleList", method = RequestMethod.GET)
	public @ResponseBody List<Spindle> getAllSpindleList() {
		List<Spindle> list = null;

		list= spindleService.getAllSpindleList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  12-05-2021
	 *  
	 *   Get List Of All Spindle
	 * 
	 * */
	
	
	@RequestMapping(value = "/getActiceSpindleList", method = RequestMethod.GET)
	public @ResponseBody List<Spindle> getActiceSpindleList() {
		List<Spindle> list = null;

		list= spindleService.getActiceSpindleList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  06-05-2021
	 *  
	 *   Check duplicate Spindle Code
	 * 
	 * */
	
	@RequestMapping(value = "/checkSerialNo", method = RequestMethod.GET)
	public @ResponseBody boolean  checkCustomerCode(@RequestParam("serialNo") String serialNo) {
		boolean customerCodeISAvailable= false;
		try {
			customerCodeISAvailable= spindleService.checkSerialNo(serialNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerCodeISAvailable;
	}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewSpindle", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewCustomer(@RequestBody Spindle  spindle) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Spindle> optional= spindleService.getSpindleBySerialNo(spindle.getSerialNo());
			//System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+spindle.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Spindle  is  already .....Exits");
			}else{
				spindle.setActive(1);
				spindle.setAddedDate(new Date());
				spindleService.addSpindle(spindle);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Added Successfully");
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
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody Spindle  spindle) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				
				spindleService.addSpindle(spindle);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle status updated successfully");
			
				
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
	
	

	@RequestMapping(value = "/updateSpindle", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateEmployee(@RequestBody Spindle  spindle) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			spindle.setUpdDatetime(new Date());
				spindleService.addSpindle(spindle);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Update Successfully");
			
				
		
			
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
	
	

	@RequestMapping(value = "/deletSpindle", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletSpindle(@RequestBody Spindle  spindle) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			spindle.setDelBit(1);
				spindleService.addSpindle(spindle);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Deleted successfully");
			
				
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity postFile(@ModelAttribute(value = "file") MultipartFile file
		) throws ParseException {
		try {
			
		//	System.out.println("CALLL UPLOAD :::: "+file.getOriginalFilename());
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
							
							Optional<Spindle>optional = spindleService.getSpindleBySerialNo(row.getCell(1).toString());
							Spindle spindle= new Spindle();
							if(optional.isPresent()){
								spindle= optional.get();
								
							}else{
								spindle.setActive(1);
								spindle.setAddedDate(new Date());
								
							}
							
							spindle.setAssemblyDrawing(row.getCell(14).toString());
							spindle.setCurrent(row.getCell(11).toString());
							spindle.setLubrication(row.getCell(13).toString());
							spindle.setMachineBrand(row.getCell(4).toString());
							spindle.setMachineModel(row.getCell(5).toString());
							spindle.setMaxSpeed(row.getCell(7).toString());
							spindle.setOperatingSpeed(row.getCell(8).toString());
							spindle.setPoles(row.getCell(9).toString());
							spindle.setPower(row.getCell(6).toString());
							spindle.setSerialNo(row.getCell(1).toString());
							spindle.setSpindleBrand(row.getCell(2).toString());
							spindle.setSpindleModel(row.getCell(2).toString());
							spindle.setToolTaper(row.getCell(10).toString());
							spindle.setVoltage(row.getCell(12).toString());
							
							spindleService.addSpindle(spindle);
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
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Spindle 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addCustomerSpindleRegistration", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addCustomerSpindleRegistration(@RequestBody CustomerSpindleRegistration  customerSpindleRegistration) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<CustomerSpindleRegistration> optional= spindleService.getCustomerSpindleRegistrationById(customerSpindleRegistration.getCusSpindleRegId());
			//System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+spindle.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Spindle Registration   detials Updated is  alreadye .....Exits");
			}else{
				Customer customer= customerService.getCustomerRegById(customerSpindleRegistration.getSpecId());
				customerSpindleRegistration.setCustomer(customer);
				customerSpindleRegistration.setActive(1);
				customerSpindleRegistration.setAddedDate(new Date());
				customerSpindleRegistration.setStatus("Requested");
				CustomerSpindleRegistration	customerSpindleRegistration1=	spindleService.addCustomerSpindleRegistration(customerSpindleRegistration);
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Registration Added Successfully");
				for(BearringAccessoryCustReq bearringAccessory: customerSpindleRegistration.getRearBearings()){
					bearringAccessory.setAddedBy(customerSpindleRegistration.getAddedBy());
					bearringAccessory.setAddedDate(new Date());
					bearringAccessory.setSide("Rear");
					bearringAccessory.setCusSpindleRegId(customerSpindleRegistration1.getCusSpindleRegId());
					spindleService.saveBearringAccessory(bearringAccessory);
					
				}
				for(BearringAccessoryCustReq bearringAccessory:customerSpindleRegistration.getFrontBearings()){
					bearringAccessory.setAddedBy(customerSpindleRegistration.getAddedBy());
					bearringAccessory.setAddedDate(new Date());
					bearringAccessory.setSide("Front");
					bearringAccessory.setCusSpindleRegId(customerSpindleRegistration1.getCusSpindleRegId());
					spindleService.saveBearringAccessory(bearringAccessory);

				}
			}
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	@RequestMapping(value = "/approve", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> approve(@RequestBody CustomerSpindleRegistration  customerSpindleRegistration) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			SpindleServiceRequest  request = new SpindleServiceRequest();
			
			
			String  sscNo=serviceSer.getNewSSCNoForBranch(customerSpindleRegistration.getBranch().getBranchCode());
				Customer customer= customerService.getCustomerRegById(customerSpindleRegistration.getSpecId());
			//	customerSpindleRegistration.setCustomer(customer);
				
				customerSpindleRegistration.setUpdDatetime(new Date());
				customerSpindleRegistration.setSscNo(sscNo);
				customerSpindleRegistration.setStatus("Approve");
				CustomerSpindleRegistration	customerSpindleRegistration1=	spindleService.addCustomerSpindleRegistration(customerSpindleRegistration);
				
				Spindle spindle = new Spindle();
				spindle.setActive(1);
				spindle.setAddedDate(new Date());
				spindle.setAssemblyDrawing(customerSpindleRegistration.getAssemblyDrawing());
				spindle.setCurrent(customerSpindleRegistration.getCurrent());
				spindle.setLubrication(customerSpindleRegistration.getLubrication());
				spindle.setMachineBrand(customerSpindleRegistration.getMachineBrand());
				spindle.setMachineModel(customerSpindleRegistration.getMachineModel());
				spindle.setMaxSpeed(customerSpindleRegistration.getMaxSpeed());
				spindle.setOperatingSpeed(customerSpindleRegistration.getOperatingSpeed());
				spindle.setPoles(customerSpindleRegistration.getPoles());
				spindle.setPower(customerSpindleRegistration.getPower());
				spindle.setSerialNo(customerSpindleRegistration.getSerialNo());
				spindle.setSpindleBrand(customerSpindleRegistration.getSpindleBrand());
				spindle.setSpindleModel(customerSpindleRegistration.getSpindleModel());
				spindle.setToolTaper(customerSpindleRegistration.getToolTaper());
				spindle.setVoltage(customerSpindleRegistration.getVoltage()); 
				
				
				Spindle spindle1= spindleService.saveSpindle(spindle);
				request.setSpindle(spindle1);
				request.setActive(1);
				request.setSscNo(sscNo);
				//request.setAddedBy(addedBy);
				request.setAddedDate(new Date());
				request.setAdditionDetials(customerSpindleRegistration.getAdditionDetials());
				request.setApplication(customerSpindleRegistration.getApplication());
				request.setBranch(customerSpindleRegistration.getBranch());
				request.setCustomer(customerSpindleRegistration.getCustomer());
				request.setDelBit(0);
				request.setDrive(customerSpindleRegistration.getDrive());
				request.setMoutingType(customerSpindleRegistration.getMoutingType());
				request.setOrientation(customerSpindleRegistration.getOrientation());
				request.setReason(customerSpindleRegistration.getReason());
				request.setReplacementSpindle(customerSpindleRegistration.getReplacementSpindle());
				request.setServiceRequested(customerSpindleRegistration.getServiceRequested());
				request.setSpindleDesign(customerSpindleRegistration.getSpindleDesign());
				request.setStatus("INITIATED");
				
					serviceSer.addSpindleServiceRequest(request);
				
				
				SOP sop= new SOP();  
				sop.setCustomer(request.getCustomer());
				sop.setIssue(request.getAdditionDetials());
				sop.setNoOfstage(33);
				sop.setNoOfStageComplete(0);
				sop.setSpindle(request.getSpindle());
				sop.setSprindleServiceRequestId(request.getSprindleServiceRequestId());
			//	sop.set
				sopService.addSOP(sop);
				
			
				responceDTO.setCode(200);
				responceDTO.setMessage("Spindle Registration Added Successfully");
				for(BearringAccessoryCustReq bearringAccessory: serviceSer.bearingReqListRearBycustReqId(customerSpindleRegistration.getCusSpindleRegId())){
					BearringAccessory accessory = new BearringAccessory();
					accessory.setDetials(bearringAccessory.getDetials());
					accessory.setQty(bearringAccessory.getQty());
					accessory.setAddedBy(customerSpindleRegistration.getAddedBy());
					accessory.setAddedDate(new Date());
					accessory.setSide("Rear");
					accessory.setSscNo(sscNo);
					serviceSer.saveBearringAccessory(accessory);
					
				}
				for(BearringAccessoryCustReq bearringAccessory:serviceSer.bearingReqListFrontBycustReqId(customerSpindleRegistration.getCusSpindleRegId())){
					BearringAccessory accessory = new BearringAccessory();
					accessory.setDetials(bearringAccessory.getDetials());
					accessory.setQty(bearringAccessory.getQty());
					accessory.setAddedBy(customerSpindleRegistration.getAddedBy());
					accessory.setAddedDate(new Date());
					accessory.setSide("Front");
					accessory.setSscNo(sscNo);				
					serviceSer.saveBearringAccessory(accessory);

				}
				ServiceReason  reason=serviceSer.getServiceReasonById(request.getReason().getReasonId());

				if(request.getCustomer().getEmailId()!=""){
					String message="<h5> Hello "+request.getCustomer().getCompanyName()+" "+",</h5> Your Spindle Service Registration has done Successfully ,Please refer following detials <br><br> SSC No : "+request.getSscNo()+"</br> Spindle Model :"+request.getSpindle().getSpindleModel()+"<br> Spindle : "+request.getSpindle().getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
					emailSmsService.sendMail(request.getCustomer().getEmailId(), "Service Request Registration Sucessfull", message);
			
				}
				List<MailManager> mailManagers = commomService.getAllMailManagerForNewService();
				if(mailManagers.size()!=0){
					for(MailManager mailManager: mailManagers){
						
						String message="<h5> Hello "+mailManager.getName()+" "+",</h5> New  Spindle Service Registration has done Successfully ,Please refer following detials <br><br> Customer :"+customerSpindleRegistration.getCustomer().getCustomerCode()+"-"+customerSpindleRegistration.getCustomer().getCompanyName() +"</br> SSC No : "+request.getSscNo()+"</br> Spindle Model :"+spindle.getSpindleModel()+"<br> Spindle : "+spindle.getSpindleBrand()+"<br> Reason :"+reason.getReasonName()+"</br></br>";
						emailSmsService.sendMail(mailManager.getMailTo(), "Service Request Registration Sucessfull", message);
				
						
					}
					
				}
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  12-05-2021
	 *  
	 *   Get List Of All Spindle
	 * 
	 * */
	
	
	@RequestMapping(value = "/getCustomerSpindleRegistrationByCustomer", method = RequestMethod.GET)
	public @ResponseBody List<CustomerSpindleRegistration> getCustomerSpindleRegistrationByCustomer(@RequestParam("customerId") int customerId) {
		List<CustomerSpindleRegistration> list = null;

		list= spindleService.getCustomerSpindleRegistrationByCustomer(customerId);

		return list;
	}
	@RequestMapping(value = "/getAllCustomerSpindleRegistration", method = RequestMethod.GET)
	public @ResponseBody List<CustomerSpindleRegistration> getAllCustomerSpindleRegistration() {
		List<CustomerSpindleRegistration> list = null;

		list= spindleService.getAllCustomerSpindleRegistration();

		return list;
	}
}



