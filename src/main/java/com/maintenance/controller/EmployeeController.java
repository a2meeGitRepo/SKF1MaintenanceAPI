/**
 * Dattatray Bodhale
	05-May-2021
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

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.maintenance.dto.ResponceObj;
import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.Customer;
import com.maintenance.model.Department;
import com.maintenance.model.Designation;
import com.maintenance.model.Employee;
import com.maintenance.model.Role;
import com.maintenance.model.ServiceReason;
import com.maintenance.model.Spindle;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.model.UserDetails;
import com.maintenance.service.AccessService;
import com.maintenance.service.CommomService;
import com.maintenance.service.CustomerService;
import com.maintenance.service.EmailSmsService;
import com.maintenance.service.EmployeeService;
import com.maintenance.service.ServiceSer;
import com.maintenance.service.SpindleService;

/**
 * @author Dattatray Bodhale
 *
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AccessService accessService; 
	@Autowired
	EmailSmsService emailSmsService;
	@Autowired
	CommomService commomService;
	@Autowired
	CustomerService customerService;
	@Autowired
	SpindleService spindleService;
	
	@Autowired
	ServiceSer serviceSer;
/********************************************************* Employee ******************************************************************/	


/*
 *  Dattatray Bodhale
 *  
 *  05-05-2021
 *  
 *    List Of  Employee By Pagination
 * 
 * */
@RequestMapping(value = "/getEmployeeByPagination", method = RequestMethod.GET)
public @ResponseBody List<Employee> getEmployeeByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<Employee> list= new  ArrayList<Employee>();
	try {	
		list=employeeService.getEmployeeByPagination(page_no,item_per_page);
		
		
		
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
@RequestMapping(value = "/getEmployeeCount", method = RequestMethod.GET)
public @ResponseBody int  getEmployeeCount() {
	int  count= 0;
	try {
		count= employeeService.getEmployeeCount();
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
@RequestMapping(value = "/getEmployeeByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<Employee> getEmployeeByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<Employee> list= new  ArrayList<Employee>();
	try {	
		list=employeeService.getEmployeeByPaginationAndSerach(page_no,item_per_page,search);
		
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
@RequestMapping(value = "/getEmployeeCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getEmployeeCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= employeeService.getEmployeeCountBySearch(search);
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
	 *   Get List Of All Employee
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllEmployeeList", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployeeList() {
		List<Employee> list = null;

		list= employeeService.getAllEmployeeList();

		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Employee
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllManagers", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllManagers() {
		List<Employee> list = null;

		list= employeeService.getAllManagers();

		return list;
	}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Engineer
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllEngineer", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEngineer() {
		List<Employee> list = null;

		list= employeeService.getAllEngineer();

		return list;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Check duplicate Employee Code
	 * 
	 * */
	
	@RequestMapping(value = "/checkEmployeeCode", method = RequestMethod.GET)
	public @ResponseBody boolean  checkEmployeeCode(@RequestParam("employeeCode") String employeeCode) {
		boolean employeeCodeISAvailable= false;
		try {
			employeeCodeISAvailable= employeeService.checkEmployeeCode(employeeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeCodeISAvailable;
	}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Employee 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewEmployee(@RequestBody Employee  employee) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Employee> optional= employeeService.getEmployeeByCode(employee.getEmoloyeeCode());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Employee  is  already .....Exits");
			}else{
				employee.setActive(1);
				employee.setAddedDate(new Date());
				employeeService.addEmployee(employee);
				responceDTO.setCode(200);
				responceDTO.setMessage("Employee Added Successfully");
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
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody Employee  employee) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				
				employeeService.addEmployee(employee);
				responceDTO.setCode(200);
				responceDTO.setMessage("Employee status updated successfully");
			
				
		
			
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
	
	

	@RequestMapping(value = "/deletEmployee", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> deletEmployee(@RequestBody Employee  employee) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			employee.setDelBit(1);
				employeeService.addEmployee(employee);
				responceDTO.setCode(200);
				responceDTO.setMessage("Employee Deleted successfully");
			
				
		
			
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
	 *  Update  Employee 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateEmployee(@RequestBody Employee  employee) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			employee.setUpdDate(new Date());
				employeeService.addEmployee(employee);
				responceDTO.setCode(200);
				responceDTO.setMessage("Employee Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}	
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ResponceObj> createUser(@RequestBody Employee employee) {
	
		ResponceObj responceObject= new ResponceObj();
		try {
			System.out.println("EMPLOYEEE :: ");
			UserDetails  user = new UserDetails();
					user.setActive(1);
					user.setAddedDatetime(new Date());
					//user.setBranch(1);
					user.setFirstName(employee.getfName());
					user.setLastName(employee.getlName());
					user.setPassword("Reset123");
					user.setEmployeeId(employee.getEmployeeId());
					Role role = new Role();
					System.out.println("Des :: "+employee.getDesignation().getDesignationId());
					
					if(employee.getDesignation().getDesignationName()=="Team Manager"){
						role.setRoleId(2);
					}else if (employee.getDesignation().getDesignationName()=="Engineer"){
						role.setRoleId(3);
					}else{
						role.setRoleId(4);
					}
					
					String maxUserId=accessService.getMaxUserd();
					System.out.println("MAX ID :: "+maxUserId);
					user.setId(maxUserId);
					user.setBranch(employee.getBranch());
					user.setContactNo(employee.getContactNo());
					user.setEmailId(employee.getEmailId());
					user.setGender(employee.getGender());
					user.setUsername(maxUserId);
					user.setAddedBy(employee.getAddedBy());
					user.setUserType("Employee");
					accessService.saveUser(user);
			
					employee.setUserCreated(1);
					employeeService.addEmployee(employee);
					if(!employee.getEmailId().equalsIgnoreCase("")){
						String message="<h5> Hello "+employee.getTitle()+" "+employee.getfName()+" "+employee.getlName()+",</h5> Your User Registration has done Successfully ,Please refer following detials <br><br>  UserName :"+user.getUsername()+"<br> Password : "+user.getPassword()+"<br>";
						emailSmsService.sendMail(employee.getEmailId(), "User Registration Sucessfull", message);
					}
					
			responceObject.setCode(200);
			responceObject.setMessage("User Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			responceObject.setCode(500);
			responceObject.setMessage("Something Wrong");
		}
		return new ResponseEntity<ResponceObj>(responceObject,HttpStatus.ACCEPTED)	;
	}
	
	
	
/********************************************************* Department ******************************************************************	
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Designation
	 * 
	 * */
	
	
	@RequestMapping(value = "/getDesignationList", method = RequestMethod.GET)
	public @ResponseBody List<Designation> getDesignationList() {
		List<Designation> list = null;

		list= employeeService.getDesignationList();

		return list;
	}
	
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Designation 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewDesignation", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewDesignation(@RequestBody Designation  designation) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Designation> optional= employeeService.getDesignationByName(designation.getDesignationName());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Designation  is  already .....Exits");
			}else{
				designation.setActive(1);
				
				employeeService.addDesignation(designation);
				responceDTO.setCode(200);
				responceDTO.setMessage("Designation Added Successfully");
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
	 *  Update  Department 
	 * 
	 * */
	
	

	@RequestMapping(value = "/UpdateDesignation", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateDesignation(@RequestBody Designation  designation) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			
				employeeService.addDesignation(designation);
				responceDTO.setCode(200);
				responceDTO.setMessage("Designation Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}	
/********************************************************* Department ******************************************************************	
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Department
	 * 
	 * */
	
	
	@RequestMapping(value = "/getDepartmentList", method = RequestMethod.GET)
	public @ResponseBody List<Department> getDepartmentList() {
		List<Department> list = null;

		list= employeeService.getDepartmentList();

		return list;
	}
	
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Department 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewDepartment", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewDepartment(@RequestBody Department  department) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Department> optional= employeeService.getDepartmentByName(department.getDepartmentName());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Department  is  already .....Exits");
			}else{
				department.setActive(1);
				
				employeeService.addDepartment(department);
				responceDTO.setCode(200);
				responceDTO.setMessage("Department Added Successfully");
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
	 *  Update  Department 
	 * 
	 * */
	
	

	@RequestMapping(value = "/UpdateDepartment", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> UpdateDepartment(@RequestBody Department  department) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
			
				employeeService.addDepartment(department);
				responceDTO.setCode(200);
				responceDTO.setMessage("Department Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	
	
/********************************************************* BRANCH ******************************************************************	
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *   Get List Of All Branch
	 * 
	 * */
	
	
	@RequestMapping(value = "/getBranchList", method = RequestMethod.GET)
	public @ResponseBody List<Branch> getBranchList() {
		List<Branch> list = null;

		list= employeeService.getBranchList();

		return list;
	}
	
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  05-05-2021
	 *  
	 *    Add New  Branch 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewBranch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewBranch(@RequestBody Branch  branch) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Branch> optional= employeeService.getBranchByCode(branch.getBranchCode());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Branch Code  No already .....Exits");
			}else{
				branch.setActive(1);
				branch.setAddedDate(new Date());
				employeeService.addBranch(branch);
				responceDTO.setCode(200);
				responceDTO.setMessage("Role Added Successfully");
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
	 *  Update  Branch 
	 * 
	 * */
	
	

	@RequestMapping(value = "/UpdateBranch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewRole(@RequestBody Branch  branch) {
		ResponceObj responceDTO= new ResponceObj();

		try {
		
			
		
			
				branch.setUpdDatetime(new Date());
				employeeService.addBranch(branch);
				responceDTO.setCode(200);
				responceDTO.setMessage("Branch Update Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity postFiles(@ModelAttribute(value = "file") MultipartFile file
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
						FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
						DataFormatter formatter = new DataFormatter();
						int i = 1;
						
						while (i <= datatypeSheet.getLastRowNum()) { 

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							
							
							if(row.getCell(0)==null) {
								continue;
							}
							String str = row.getCell(0).toString();
							
							Optional<Employee>optional = employeeService.getEmployeeByCode(row.getCell(1).toString());
							Employee employee= new Employee();
							if(optional.isPresent()){
								employee= optional.get();
								
							}else{
								employee.setActive(1);
								employee.setAddedDate(new Date());
								
							}
							Branch branch = commomService.getBranchByName(row.getCell(6).toString());
							City city= commomService.getCityByName(row.getCell(8).toString());
							Optional<Department>departmentOP = employeeService.getDepartmentByName(row.getCell(8).toString());
							Department department= new Department(); 
							if(departmentOP.isPresent()){
								department= departmentOP.get();
							}
							Optional<Designation> designationOP = employeeService.getDesignationByName(row.getCell(10).toString());
							Designation designation= new Designation();
							if(departmentOP.isPresent()){
								department= departmentOP.get();
							}
							Employee manager= new Employee();
							if(row.getCell(14)!=null){
								Optional<Employee> employeeOp = employeeService.getEmployeeByCode(row.getCell(14).toString());
								
								if(employeeOp.isPresent()){
									manager= employeeOp.get();
								}
								employee.setManagerId(manager.getEmployeeId());
							}
							
							  Date dateOfBirth=new SimpleDateFormat("dd-MM-yyyy").parse(row.getCell(11).toString());  
							  Date dateOfJoining=new SimpleDateFormat("dd-MM-yyyy").parse(row.getCell(12).toString());  
							  
							String ss=String.valueOf(row.getCell(5));
							String mobileno = formatter.formatCellValue(row.getCell(5), evaluator);

						//	System.out.println("  CODE "+mobileno);
							employee.setBranch(branch);
							employee.setContactNo(mobileno);
							employee.setDateOfBirth(dateOfBirth);
							employee.setDateOfJoining(dateOfJoining);
							employee.setDepartment(department);
							employee.setEmailId(row.getCell(6).toString());
							employee.setEmoloyeeCode(row.getCell(1).toString());
							employee.setfName(row.getCell(3).toString());
							employee.setGender(row.getCell(7).toString());
							employee.setlName(row.getCell(4).toString());
							
							employee.setTitle(row.getCell(2).toString());
							employee.setWorkLocation(row.getCell(13).toString());
							
							employeeService.addEmployee(employee);
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
	
	
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity postFiles1(@ModelAttribute(value = "file") MultipartFile file
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
							Branch branch = commomService.getBranchByName(row.getCell(6).toString());
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
							
							serviceSer.addSpindleServiceRequest(request);
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



