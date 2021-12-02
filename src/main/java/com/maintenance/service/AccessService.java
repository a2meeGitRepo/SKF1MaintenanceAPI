/**
 * Dattatray Bodhale
	26-Apr-2021
 */
package com.maintenance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.maintenance.dto.AssignRoleDTO;
import com.maintenance.dto.PermissionDto;
import com.maintenance.dto.RoleDetailDto;
import com.maintenance.dto.UserPermissionDto;
import com.maintenance.dto.UsersWithRolesDto;
import com.maintenance.model.AccessPermission;
import com.maintenance.model.Role;
import com.maintenance.model.RoleHierarchy;
import com.maintenance.model.UserDetails;
import com.maintenance.model.UserRole;

/**
 * @author Dattatray Bodhale
 *
 */
public interface AccessService {

	/**
	 * @return
	 */
	List<Role> getRoleList();

	/**
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * @param roleName
	 * @return
	 */
	Optional<Role> getRoleByName(String roleName);

	/**
	 * @param userId
	 * @return
	 */
	Set<PermissionDto> getPermissionsByUser(String userId);

	/**
	 * @return
	 */
	List<UserDetails> getAllUser();

	/**
	 * @param userId
	 * @return
	 */
	UserDetails getAllUserById(String userId);

	/**
	 * @param username
	 * @return
	 */
	UserDetails getUserByUserName(String username);

	/**
	 * @return
	 */
	String getMaxUserd();

	/**
	 * @param user
	 */
	void addUser(UserDetails user);

	/**
	 * @param userId
	 * @return
	 */
	UserDetails getUserByUserId(String userId);

	/**
	 * @return
	 */
	List<AccessPermission> getAllPermsisons();

	/**
	 * @param roleHierarchy
	 */
	void addHierarchy(RoleHierarchy roleHierarchy);

	/**
	 * @return
	 */
	List<RoleHierarchy> getRoleHierarchyList();

	/**
	 * @param roleId
	 * @return
	 */
	List<RoleHierarchy> getRoleHierarchyByRole(int roleId);

	/**
	 * @param userId
	 * @return
	 */
	List<UserRole> getUserRolesByUserId(String userId);

	/**
	 * @param user
	 */
	void saveUser(UserDetails user);

	/**
	 * @param roleId
	 * @return
	 */
	UsersWithRolesDto getUserByRole(int roleId);

	/**
	 * @param userRoles
	 */
	void addUserRoles(List<UserRole> userRoles);

	/**
	 * @param id
	 * @param roleId
	 * @return
	 */
	UserRole getUserRolesByUserIdAndRoleId(String id, int roleId);

	/**
	 * @param userRole
	 */
	void deleteUserRole(UserRole userRole);

	/**
	 * @return
	 */
	List<RoleDetailDto> getAllRoleDetails();

	/**
	 * @param rolesDetail
	 * @return
	 */
	RoleDetailDto assignPermissions(AssignRoleDTO assignRoleDTO);

	/**
	 * @param roleHierarchy
	 */
	void deleteRoleHierarchy(RoleHierarchy roleHierarchy);

	/**
	 * @param search
	 * @return
	 */
	int getUserCountBySearch(String search);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<UserDetails> getUserByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @return
	 */
	int getUserCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<UserDetails> getUserByPagination(int page_no, int item_per_page);

}



