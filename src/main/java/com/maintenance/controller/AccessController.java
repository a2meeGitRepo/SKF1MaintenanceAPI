package com.maintenance.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maintenance.dto.AssignRoleDTO;
import com.maintenance.dto.PermissionDto;
import com.maintenance.dto.ResponceObj;
import com.maintenance.dto.RoleDetailDto;
import com.maintenance.dto.UserPermissionDto;
import com.maintenance.dto.UsersWithRolesDto;
import com.maintenance.model.AccessPermission;
import com.maintenance.model.Employee;
import com.maintenance.model.Role;
import com.maintenance.model.RoleHierarchy;
import com.maintenance.model.UserDetails;
import com.maintenance.model.UserRole;
import com.maintenance.service.AccessService;



@RestController
@RequestMapping("/access")
@CrossOrigin("*")

public class AccessController {
	
	@Autowired
	AccessService accessService;
	
	

/*
 *  Dattatray Bodhale
 *  
 *  15-06-2021
 *  
 *    List Of  USER By Pagination
 * 
 * */
@RequestMapping(value = "/getUserByPagination", method = RequestMethod.GET)
public @ResponseBody List<UserDetails> getUserByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<UserDetails> list= new  ArrayList<UserDetails>();
	try {	
		list=accessService.getUserByPagination(page_no,item_per_page);
		
		
		
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
 *   Count Of  User
 * 
 * */
@RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
public @ResponseBody int  getUserCount() {
	int  count= 0;
	try {
		count= accessService.getUserCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  15-06-2021
 *  
 *    List Of  USER By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getUserByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<UserDetails> getUserByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<UserDetails> list= new  ArrayList<UserDetails>();
	try {	
		list=accessService.getUserByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
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
 *   Count Of  User by Search
 * 
 * */
@RequestMapping(value = "/getUserCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getUserCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= accessService.getUserCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  23-04-2021
	 *  
	 *   Get All Role List
	 * 
	 * */
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
	public @ResponseBody List<Role> getRoleList() {
		List<Role> roleList = null;

		roleList= accessService.getRoleList();

		return roleList;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  23-04-2021
	 *  
	 *   Change Status of  Role 
	 * 
	 * */
	@RequestMapping(value = "/changeStatusRole", method = RequestMethod.POST)
	public ResponseEntity<Role> changeStatusRole(@RequestBody Role role){

		if(role.getActive()==1){
			role.setActive(0);
			accessService.addRole(role);

		}else{
			role.setActive(1);
			accessService.addRole(role);

		}
	return new ResponseEntity<Role>(role,HttpStatus.ACCEPTED)	;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  23-04-2021
	 *  
	 *   Change Add New  Role 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewRole", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewRole(@RequestBody Role  role) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			Optional<Role> optional= accessService.getRoleByName(role.getRoleName());
			
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Part No already .....Exits");
			}else{
				role.setActive(1);
				role.setAddedDate(new Date());
				accessService.addRole(role);
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
	 *  23-04-2021
	 *  
	 *   Update Role
	 * 
	 * */
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> updateRole(@RequestBody Role  role) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
				accessService.addRole(role);
				responceDTO.setCode(200);
				responceDTO.setMessage("Role Update Successfully");
				
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
	 *  23-04-2021
	 *  
	 *   Add  Role Hierarchy
	 * 
	 * */
	@RequestMapping(value = "/addHierarchy", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addHierarchy(@RequestBody RoleHierarchy  roleHierarchy) {
		ResponceObj responceDTO= new ResponceObj();

		try {
				roleHierarchy.setActive(1);
				roleHierarchy.setAddedDate(new Date());
				accessService.addHierarchy(roleHierarchy);
				responceDTO.setCode(200);
				responceDTO.setMessage("Role Hierarchy Successfully");
				
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
	 *  23-04-2021
	 *  
	 *   Get All Role Hierarchy List
	 * 
	 * */
	
	@RequestMapping(value = "/getRoleHierarchyList", method = RequestMethod.GET)
	public @ResponseBody List<RoleHierarchy> getRoleHierarchyList() {
		List<RoleHierarchy> roleList = null;

		roleList= accessService.getRoleHierarchyList();

		return roleList;
	}
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get All Role Hierarchy List By Role Id
	 * 
	 * */
	
	@RequestMapping(value = "/getRoleHierarchyByRole", method = RequestMethod.GET)
	public @ResponseBody List<RoleHierarchy> getRoleHierarchyByRole(@RequestParam("roleId") int roleId) {
		List<RoleHierarchy> roleList = null;

		roleList= accessService.getRoleHierarchyByRole(roleId);

		return roleList;
	}
	
	
	@RequestMapping(value = "/getNewByRole", method = RequestMethod.GET)
	public @ResponseBody List<Role> getNewByRole(@RequestParam("roleId") int roleId) {
		List<RoleHierarchy> roleList = null;
		Set<Role>roles = new HashSet<>();
		List<Role> roleListq= new ArrayList<Role>();
		roleList= accessService.getRoleHierarchyByRole(roleId);
		for(RoleHierarchy hierarchy:roleList){
			roles.add(hierarchy.getRole());
		}
		List<Role> list = accessService.getRoleList();
		for(Role role:list){
			if(!roles.contains(role) && role.getRoleId()!=roleId){
				roleListq.add(role);
			}
		}
		
		return roleListq;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get All Role Hierarchy List By Role Id
	 * 
	 * */
	
	@RequestMapping(value = "/getReporteeRole", method = RequestMethod.GET)
	public @ResponseBody List<Role> getReporteeRoleByRole(@RequestParam("roleId") int roleId) {
		List<Role> roleList = new ArrayList<Role>();

		List<RoleHierarchy> rolehierachy= accessService.getRoleHierarchyByRole(roleId);
		for(RoleHierarchy hierarchy:rolehierachy){
			roleList.add(hierarchy.getRole());
		}

		return roleList;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  23-04-2021
	 *  
	 *   Get All Role List
	 * 
	 * */
	@RequestMapping(value = "/getUserByRole", method = RequestMethod.GET)
	public @ResponseBody UsersWithRolesDto getUserByRole(@RequestParam("roleId") int roleId) {
		UsersWithRolesDto withRolesDto = new UsersWithRolesDto();

		withRolesDto= accessService.getUserByRole(roleId);

		return withRolesDto;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User Role 
	 * 
	 * */
	@RequestMapping(value = "/deleteRoleHierarchy", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> deleteRoleHierarchy(@RequestBody RoleHierarchy roleHierarchy) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			accessService.deleteRoleHierarchy(roleHierarchy);
			responceDTO.setCode(200);
			responceDTO.setMessage("Role Remove Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage("Something Wrong");
		}
		
		return new ResponseEntity <ResponceObj> (responceDTO,HttpStatus.CREATED);
		

	}
	@RequestMapping(value = "/addRoleHierarchy", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> addRoleHierarchy(@RequestBody RoleHierarchy roleHierarchy) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			accessService.addHierarchy(roleHierarchy);
			responceDTO.setCode(200);
			responceDTO.setMessage("Role Hierarchy Added Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage("Something Wrong");
		}
		
		return new ResponseEntity <ResponceObj> (responceDTO,HttpStatus.CREATED);
		

	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User Role 
	 * 
	 * */
	@RequestMapping(value = "/addUserRoles", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> addUserRoles(@RequestBody List<UserRole> userRoles) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			accessService.addUserRoles(userRoles);
			responceDTO.setCode(200);
			responceDTO.setMessage("User  Role Added Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage("Something Wrong");
		}
		
		return new ResponseEntity <ResponceObj> (responceDTO,HttpStatus.CREATED);
		

	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User Role 
	 * 
	 * */
	@RequestMapping(value = "/removeUserRoles", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> removeUserRoles(@RequestBody List<UserRole> userRoles) {
		ResponceObj responceDTO= new ResponceObj();
		try {
			for(UserRole userRole:userRoles){
				UserRole  userRole2= accessService.getUserRolesByUserIdAndRoleId(userRole.getUserDetails().getId(),userRole.getRole().getRoleId());
				accessService.deleteUserRole(userRole2);
			}
			responceDTO.setCode(200);
			responceDTO.setMessage("User  Role Remove Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage("Something Wrong");
		}
		
		return new ResponseEntity <ResponceObj> (responceDTO,HttpStatus.CREATED);
		

	}
	
	

	@RequestMapping(value = "/allRoleDetails", method = RequestMethod.GET)
	public ResponseEntity<List<RoleDetailDto>> getAllRoleDetails() {

		List<RoleDetailDto> allroles = accessService.getAllRoleDetails();
		return new ResponseEntity<List<RoleDetailDto>>(allroles, HttpStatus.OK);

	}
	
	

	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User Role 
	 * 
	 * */
	@RequestMapping(value = "/assignPermissions", method = RequestMethod.POST)
	public ResponseEntity<ResponceObj> assignPermissions( @RequestBody AssignRoleDTO assignRoleDTO ){
		ResponceObj responceObj= new ResponceObj();
		try {
			RoleDetailDto permissions = accessService.assignPermissions(assignRoleDTO);
			responceObj.setCode(200);
			responceObj.setMessage("Permission Updated Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			responceObj.setCode(200);
			responceObj.setMessage("Something Wrong");
		}
		
		
	
		return new ResponseEntity< ResponceObj>(responceObj,HttpStatus.OK);
	}
//************************** USER *********************************************************
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get  All User
	 * 
	 * */
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UserDetails>> getAllUser() {
		List<UserDetails> list = new ArrayList<UserDetails>();

		list= accessService.getAllUser();
		

		return new ResponseEntity<List<UserDetails>>(list,HttpStatus.ACCEPTED)	;
	}
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get   User  by Id
	 * 
	 * */
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UserDetails> getAllUserById(@RequestParam("userId") String userId) {
		UserDetails userDetails = new UserDetails();

		userDetails= accessService.getAllUserById(userId);
		

		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.ACCEPTED)	;
	}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User 
	 * 
	 * */
	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> addUser(@RequestBody UserDetails user) {
		ResponceObj obj= new ResponceObj();
		String maxUserId=accessService.getMaxUserd();
		System.out.println("MAX ID :: "+maxUserId);
		user.setId(maxUserId);
		user.setActive(1);
		user.setAddedDatetime(new Date());
		UserDetails optional= accessService.getUserByUserName(user.getUsername());
		if(optional==null){
			accessService.addUser(user);
			obj.setCode(200);
			obj.setMessage("User Detials Added Successfully");
		}else{
			obj.setCode(500);
			obj.setMessage("User Name already exit");
		}
		
		return new ResponseEntity <ResponceObj> (obj,HttpStatus.CREATED);
		

	}

	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Add New User 
	 * 
	 * */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> updateUser(@RequestBody UserDetails user) {
		ResponceObj obj= new ResponceObj();
		System.out.println("updateUser USER ");

		user.setUpdDatetime(new Date());
		accessService.addUser(user);
		obj.setCode(200);
		obj.setMessage("User Detials update Successfully");
		
		return new ResponseEntity<ResponceObj>(obj, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/deletUser", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> deletUser(@RequestBody UserDetails user) {
		ResponceObj obj= new ResponceObj();
user.setDeletbit(1);
user.setActive(0);
		user.setUpdDatetime(new Date());
		accessService.addUser(user);
		obj.setCode(200);
		obj.setMessage("User Deleted Successfully");
		
		return new ResponseEntity<ResponceObj>(obj, HttpStatus.OK);

	}
	//*******************************************************************************************************
	
	
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get   Role User   by User Id
	 * 
	 * */
	@RequestMapping(value = "/getUserRolesByUserId", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UserRole>> getUserRolesByUserId(@RequestParam("userId") String userId) {
		List<UserRole> userRoles = new ArrayList<UserRole>();

		userRoles= accessService.getUserRolesByUserId(userId);
		

		return new ResponseEntity<List<UserRole>>(userRoles,HttpStatus.ACCEPTED)	;
	}
	
	
	
	
	
	
	
	
	//************************** Permission *********************************************************

	/*
	 *  Dattatray Bodhale
	 *  
	 *  26-04-2021
	 *  
	 *   Get All Permission 
	 * 
	 * */

	@RequestMapping(value = "/allPermissions", method = RequestMethod.GET)
	public ResponseEntity<List<AccessPermission>> getPermissions() {
		List<AccessPermission> allpermissions =	accessService.getAllPermsisons();
		return new ResponseEntity<List<AccessPermission>>(allpermissions, HttpStatus.OK);
	}
	
		
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  23-04-2021
	 *  
	 *   Change Add New  Role 
	 * 
	 * */
	@RequestMapping(value = "/getPermissionsByUser", method = RequestMethod.GET)
	public ResponseEntity<Set<PermissionDto>> getPermissionsByUser(@RequestParam("userId") String  userId) {
		Set<PermissionDto> userPermissions = null;
		
		userPermissions= accessService.getPermissionsByUser(userId);
		System.out.println("Permission Size "+userPermissions.size());
		return new ResponseEntity<Set<PermissionDto>>(userPermissions,HttpStatus.ACCEPTED)	;

	}
}
