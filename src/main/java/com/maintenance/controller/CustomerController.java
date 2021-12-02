/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
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
import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.Customer;
import com.maintenance.model.CustomerRegistratin;
import com.maintenance.model.Employee;
import com.maintenance.model.UserDetails;
import com.maintenance.model.Usermst;
import com.maintenance.service.AuthenticationService;
import com.maintenance.service.CommomService;
import com.maintenance.service.CustomerService;
import com.maintenance.service.EmailSmsService;

/**
 * @author Dattatray Bodhale
 *
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CommomService commomService;
	
	@Autowired
	private AuthenticationService userDetailsService;
	@Autowired
	EmailSmsService emailSmsService;

/*
 *  Dattatray Bodhale
 *  
 *  06-05-2021
 *  
 *    List Of  Customer By Pagination
 * 
 * */
@RequestMapping(value = "/getCustomerByPagination", method = RequestMethod.GET)
public @ResponseBody List<Customer> getCustomerByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<Customer> list= new  ArrayList<Customer>();
	try {	
		list=customerService.getCustomerByPagination(page_no,item_per_page);
		
		
		
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
 *   Count Of  Customer
 * 
 * */
@RequestMapping(value = "/getCustomerCount", method = RequestMethod.GET)
public @ResponseBody int  getCustomerCount() {
	int  count= 0;
	try {
		count= customerService.getCustomerCount();
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
 *    List Of  Customer By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getCustomerByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<Customer> getCustomerByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<Customer> list= new  ArrayList<Customer>();
	try {	
		list=customerService.getCustomerByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
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
 *   Count Of  Customer by Search
 * 
 * */
@RequestMapping(value = "/getCustomerCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getCustomerCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= customerService.getCustomerCountBySearch(search);
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
	 *   Get List Of All Customer
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllCustomerList", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomerList() {
		List<Customer> list = null;

		list= customerService.getAllCustomerList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Customer
	 * 
	 * */
	
	
	@RequestMapping(value = "/getActiveCustomerList", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getActiveCustomerList() {
		List<Customer> list = null;

		list= customerService.getActiveCustomerList();

		return list;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  06-05-2021
	 *  
	 *   Check duplicate Customer Code
	 * 
	 * */
	
	@RequestMapping(value = "/checkCustomerCode", method = RequestMethod.GET)
	public @ResponseBody boolean  checkCustomerCode(@RequestParam("customerCode") String customerCode) {
		boolean customerCodeISAvailable= false;
		try {
			customerCodeISAvailable= customerService.checkCustomerCode(customerCode);
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
	 *    Add New  Employee 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewCustomer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewCustomer(@RequestBody Customer  customer) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Customer> optional= customerService.getCustomerByCode(customer.getCustomerCode());
			System.out.println(" CODE IS PRESEN "+optional.isPresent()+"   "+customer.getCustomerCode());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Customer  is  already .....Exits");
			}else{
				customer.setActive(1);
				customer.setAddedDate(new Date());
				customerService.addCustomer(customer);
				responceDTO.setCode(200);
				responceDTO.setMessage("Customer Added Successfully");
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
	 *    Add New  Employee 
	 * 
	 * */
	
	

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody Customer  customer) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				
				customerService.addCustomer(customer);
				responceDTO.setCode(200);
				responceDTO.setMessage("Customer status updated successfully");
			
				
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
//	 *    Delete  Customer
	 * 
	 * */
	
	

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deleteCustomer(@RequestBody Customer  customer) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			customer.setDelBit(1);
				customerService.addCustomer(customer);
				responceDTO.setCode(200);
				responceDTO.setMessage("Customer Delet successfully");
			
				
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
	 *  Update  Department 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateEmployee(@RequestBody Customer  customer) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			customer.setUpdDatetime(new Date());
				customerService.addCustomer(customer);
				responceDTO.setCode(200);
				responceDTO.setMessage("Customer Update Successfully");
			
				
		
			
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
		) {
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
						System.out.println("getLastRowNum  "+datatypeSheet.getLastRowNum());
						while (i <= datatypeSheet.getLastRowNum()) { 

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							System.out.println("ROW 0  "+row.getCell(0).toString());
							if(str.length()==0) {
								continue;
							}
							
							Optional<Customer>optional = customerService.getCustomerByCode(row.getCell(1).toString());
							Customer customer= new Customer();
							if(optional.isPresent()){
								customer= optional.get();
								
							}else{
								customer.setActive(1);
								customer.setAddedDate(new Date());
								
							}
							Branch branch = commomService.getBranchByName(row.getCell(6).toString());
							City city= commomService.getCityByName(row.getCell(8).toString());
							customer.setCustomerCode(row.getCell(1).toString());
							customer.setBranch(branch);
							customer.setCity(city);
							customer.setCompanyName(row.getCell(2).toString());
							customer.setContactPerson(row.getCell(3).toString());
							customer.setPhoneNo(row.getCell(4).toString());
							System.out.println("PHONE NO :: "+String.valueOf(row.getCell(4)));
							customer.setEmailId(row.getCell(5).toString());
							customer.setAddress(row.getCell(7).toString());
						
							customer.setPincode(row.getCell(9).toString());
							

							
							
						
						customerService.addCustomer(customer);
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
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody void  check() {
		
		try {
			System.out.println("YESY :: ======");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//********************************************** CUSTOMER REGISTER ***********************************//
	
	@RequestMapping(value = "/addCustomerRegistration", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addCustomerRegistration(@RequestBody Customer  customer) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			System.out.println("REGISTER CUSTOMER");
				customer.setActive(1);
				customer.setAddedDate(new Date());
			Customer customer2=customerService.addCustomer1(customer);
				
			
				Usermst details = new Usermst();
				String userName=userDetailsService.getNewUserName();
				int i=Integer.parseInt(userName);  
				i++;
				String usename="SKFC"+i;
				System.out.println("USER NAME "+usename);
				details.setUsername(usename);
				details.setId(i);
				details.setSpecId(customer2.getCustomerId());
				details.setActive(1);
				details.setContact_no(customer.getPhoneNo());
			//	details.setAddedDatetime(new Date());
				details.setEmailId(customer.getEmailId());
				details.setFirstName(customer.getCompanyName());
				details.setUserType("Customer");
				//details.setUsername("");
				details.setPassword("Reset123");
				userDetailsService.saveUserMst(details);
				String message="<h5> Hello "+customer.getCompanyName()+",</h5> Your User Registration has done Successfully ,Please refer following detials <br><br>  UserName :"+usename+"<br> Password : "+details.getPassword()+"<br>";
					emailSmsService.sendMail(customer.getEmailId(), "User Registration Sucessfull", message);
				
					
					
					
					responceDTO.setCode(200);
					responceDTO.setMessage("Customer Regsiter Successfully");
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	@RequestMapping(value = "/getCustomerById", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomerById(@RequestParam("custId") int custId) {
		Customer customer = new Customer();

		customer= customerService.getCustomerRegById(custId);

		return customer;
	}
}



