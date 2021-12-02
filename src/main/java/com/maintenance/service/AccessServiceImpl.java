/**
 * Dattatray Bodhale
	26-Apr-2021
 */
package com.maintenance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.dto.AssignRoleDTO;
import com.maintenance.dto.PermissionDto;
import com.maintenance.dto.PermissionTypeDto;
import com.maintenance.dto.RoleDetailDto;
import com.maintenance.dto.UserPermissionDto;
import com.maintenance.dto.UsersWithRolesDto;
import com.maintenance.model.AccessPermission;
import com.maintenance.model.Role;
import com.maintenance.model.RoleHierarchy;
import com.maintenance.model.RolePermission;
import com.maintenance.model.UserDetails;
import com.maintenance.model.UserRole;
import com.maintenance.repo.PermissionRepo;
import com.maintenance.repo.RoleHierarchyRepo;
import com.maintenance.repo.RolePermissionRepo;
import com.maintenance.repo.RoleRepo;
import com.maintenance.repo.UserRepo;
import com.maintenance.repo.UserRoleRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class AccessServiceImpl implements AccessService {

	
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PermissionRepo permissionRepo;
	@Autowired
	RoleHierarchyRepo roleHierarchyRepo;
	@Autowired
	UserRoleRepo userRoleRepo;
	@Autowired
	RolePermissionRepo rolePermissionRepo;
	
	
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getRoleList()
	 */
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#addRole(com.maintenance.model.Role)
	 */
	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleRepo.save(role);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getRoleByName(java.lang.String)
	 */
	@Override
	public Optional<Role> getRoleByName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepo.getRoleByName(roleName);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getPermissionsByUser(java.lang.String)
	 */
	@Override
	public Set<PermissionDto> getPermissionsByUser(String userId) {
		// TODO Auto-generated method stub
		 Set<PermissionDto> hmap = new HashSet<PermissionDto>();

		List<UserRole> list =userRoleRepo.getUserRoleByUserId(userId);
		
		System.out.println("ROle List : "+list.size()+"  "+userId);
		list.forEach(role->{
			List<RolePermission> permissions=rolePermissionRepo.getPermissionByRoleId(role.getRole().getRoleId());
			
			System.out.println("permissions : "+permissions.size()+"  "+role.getRole().getRoleId());
			permissions.forEach(permission->{
				PermissionDto permissionDto= new PermissionDto();
				String permname=permission.getPermission().getName();
			
				permissionDto.setAccessType(permission.getAccessType());
				permissionDto.setName(permname);
				permissionDto.setValue(permission.getPermission().getPvalue());
				 hmap.add(permissionDto);
			
				
				//if(hmap.contains(permissionDto)){}
			
			
			});
		});
		return hmap;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getAllUser()
	 */
	@Override
	public List<UserDetails> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.getAllUser();
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getAllUserById(java.lang.String)
	 */
	@Override
	public UserDetails getAllUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional =userRepo.findAllByUserId(userId);
		return optional.isPresent()?optional.get():null;
		
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserByUserName(java.lang.String)
	 */
	@Override
	public UserDetails getUserByUserName(String username) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional= userRepo.findUserDetialsByUserName(username);
		return optional.isPresent()?optional.get():null;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getMaxUserd()
	 */
	@Override
	public String getMaxUserd() {
		// TODO Auto-generated method stub
	
		String newCode="";
		  int count=(int) userRepo.getCountBySubString();
		 if(count==0){ 
			  newCode= "10001";
			}else{
				String maxCode=userRepo.getMaxCodeBySubString();
				//String maxCode= (String) entityManager.createQuery("select MAX(p.packingCode) from PackingTr p where substr(p.packingCode,1,4)=:grnNo").setParameter("packingCode", string).getSingleResult();
				
			
				int intCode=Integer.parseInt(maxCode);
				intCode++;
				newCode=String.valueOf(intCode);
				
			}
		return newCode;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#addUser(com.maintenance.model.UserDetails)
	 */
	@Override
	public void addUser(UserDetails user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserByUserId(java.lang.String)
	 */
	@Override
	public UserDetails getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional=userRepo.findAllByUserId(userId);
		return optional.isPresent()?optional.get():null;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getAllPermsisons()
	 */
	@Override
	public List<AccessPermission> getAllPermsisons() {
		// TODO Auto-generated method stub
		return permissionRepo.findAll();
		
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#addHierarchy(com.maintenance.model.RoleHierarchy)
	 */
	@Override
	public void addHierarchy(RoleHierarchy roleHierarchy) {
		// TODO Auto-generated method stub
		roleHierarchyRepo.save(roleHierarchy);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getRoleHierarchyList()
	 */
	@Override
	public List<RoleHierarchy> getRoleHierarchyList() {
		// TODO Auto-generated method stub
		return roleHierarchyRepo.getRoleHierarchyList();
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getRoleHierarchyByRole(int)
	 */
	@Override
	public List<RoleHierarchy> getRoleHierarchyByRole(int roleId) {
		// TODO Auto-generated method stub
		return roleHierarchyRepo.getRoleHierarchyByRole(roleId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserRolesByUserId(java.lang.String)
	 */
	@Override
	public List<UserRole> getUserRolesByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRoleRepo.getUserRoleByUserId(userId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#saveUser(com.maintenance.model.UserDetails)
	 */
	@Override
	public void saveUser(UserDetails user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserByRole(int)
	 */
	@Override
	public UsersWithRolesDto getUserByRole(int roleId) {
		// TODO Auto-generated method stub
		UsersWithRolesDto dto= new UsersWithRolesDto();
		Set<UserDetails> userWithRoleSet=new HashSet<>();
		Set<UserDetails> userWithOutRoleSet=new HashSet<>();
		List<UserDetails> userWithRole=new ArrayList<UserDetails>();
		List<UserDetails> userWithOutRole=new ArrayList<UserDetails>();
		List<UserRole> userRoles = userRoleRepo.getUserRoleByRoleId(roleId);
	//	System.out.println("ROLE ID "+roleId+" Role Size "+userRoles.size());
		for(int i=0;i<userRoles.size();i++){
			userWithRoleSet.add(userRoles.get(i).getUserDetails());
		}
	//	System.out.println("userWithRoleSet "+userWithRoleSet.size());
		List<UserDetails> allUsers= userRepo.getAllUser();
		for(int i=0;i<allUsers.size();i++){
			if(!userWithRoleSet.contains(allUsers.get(i))){
				userWithOutRoleSet.add(allUsers.get(i));
			}
			
		}
		for(UserDetails userDetails:userWithRoleSet){
			userWithRole.add(userDetails);
		}
		//System.out.println("userWithRoleSet "+userWithRoleSet.size());
		for(UserDetails userDetails:userWithOutRoleSet){
			userWithOutRole.add(userDetails);
		}
		dto.setUserwithoutrole(userWithOutRole);
		dto.setUserwithrole(userWithRole);
		return dto;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#addUserRoles(java.util.List)
	 */
	@Override
	public void addUserRoles(List<UserRole> userRoles) {
		// TODO Auto-generated method stub
		userRoleRepo.saveAll(userRoles);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserRolesByUserIdAndRoleId(java.lang.String, int)
	 */
	@Override
	public UserRole getUserRolesByUserIdAndRoleId(String id, int roleId) {
		// TODO Auto-generated method stub
		return userRoleRepo.getUserRolesByUserIdAndRoleId(id,roleId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#deleteUserRole(com.maintenance.model.UserRole)
	 */
	@Override
	public void deleteUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		//System.out.println("DELETING ::  "+userRole.getUserRoleId());
		userRoleRepo.deleteById(userRole.getUserRoleId());
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getAllRoleDetails()
	 */
	@Override
	public List<RoleDetailDto> getAllRoleDetails() {
		// TODO Auto-generated method stub
		List<RoleDetailDto> returnbody = new ArrayList <RoleDetailDto>();
		
		List<Role> rolelist = roleRepo.findAll();
		rolelist.forEach(role ->{
			RoleDetailDto dto = new RoleDetailDto();
			dto.setId(role.getRoleId());
			dto.setRoleName(role.getRoleName());
			List<RolePermission> rolepermissions=rolePermissionRepo.getPermissionByRoleId(role.getRoleId());
			for (RolePermission rolePermission :rolepermissions) {
				PermissionTypeDto permissionTypeDto = new PermissionTypeDto();
				permissionTypeDto.setPermissionId(rolePermission.getPermission().getPermissionId());
				permissionTypeDto.setPermission(rolePermission.getPermission().getName());
				permissionTypeDto.setPermissionValue(rolePermission.getPermission().getPvalue());
				permissionTypeDto.setType(rolePermission.getAccessType());
				dto.getPermission().add(permissionTypeDto);
			}
			
			returnbody.add(dto);
		});
		return returnbody;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#assignPermissions(com.maintenance.dto.RoleDetailDto)
	 */
	@Override
	public RoleDetailDto assignPermissions(AssignRoleDTO assignRoleDTO) {
		
		// TODO Auto-generated method stub
		List<RolePermission> rolepermissions=rolePermissionRepo.getPermissionByRoleId(assignRoleDTO.getId());
		rolePermissionRepo.deleteAll(rolepermissions);
		for(AccessPermission accessPermission:assignRoleDTO.getPermission()){
			RolePermission permission= new RolePermission();
			Role  role= new Role();
			role.setRoleId(assignRoleDTO.getId());
			permission.setRole(role);
			permission.setPermission(accessPermission);
			rolePermissionRepo.save(permission);
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#deleteRoleHierarchy(com.maintenance.model.RoleHierarchy)
	 */
	@Override
	public void deleteRoleHierarchy(RoleHierarchy roleHierarchy) {
		// TODO Auto-generated method stub
		roleHierarchyRepo.delete(roleHierarchy);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserCountBySearch(java.lang.String)
	 */
	@Override
	public int getUserCountBySearch(String search) {
		// TODO Auto-generated method stub
		return userRepo.getUserCountBySearch(search);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<UserDetails> getUserByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return userRepo.getUserByPaginationAndSerach(page_no,item_per_page,search);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserCount()
	 */
	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return userRepo.getUserCount();
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.AccessService#getUserByPagination(int, int)
	 */
	@Override
	public List<UserDetails> getUserByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return userRepo.getUserByPagination(page_no,item_per_page);
	}

}



