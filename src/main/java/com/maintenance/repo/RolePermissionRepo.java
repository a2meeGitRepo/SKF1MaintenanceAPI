/**
 * Dattatray Bodhale
	30-Apr-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.RolePermission;

/**
 * @author Dattatray Bodhale
 *
 */
public interface RolePermissionRepo extends JpaRepository<RolePermission, Integer> {

	/**
	 * @param roleId
	 * @return
	 */
	@Query("from RolePermission r where r.role.roleId=?1")
	List<RolePermission> getPermissionByRoleId(int roleId);

}



