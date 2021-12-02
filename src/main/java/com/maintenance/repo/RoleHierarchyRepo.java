/**
 * Dattatray Bodhale
	27-Apr-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.RoleHierarchy;

/**
 * @author Dattatray Bodhale
 *
 */
public interface RoleHierarchyRepo extends JpaRepository<RoleHierarchy, Integer>{

	/**
	 * @return
	 */
	@Query("from RoleHierarchy")
	List<RoleHierarchy> getRoleHierarchyList();

	/**
	 * @param roleId
	 * @return
	 */
	@Query("from RoleHierarchy r where r.reportToRole.roleId=?1")
	List<RoleHierarchy> getRoleHierarchyByRole(int roleId);

}



