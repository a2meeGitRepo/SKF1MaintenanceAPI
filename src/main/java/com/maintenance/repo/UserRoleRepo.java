/**
 * Dattatray Bodhale
	30-Apr-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.UserRole;

/**
 * @author Dattatray Bodhale
 *
 */
public interface UserRoleRepo extends JpaRepository<UserRole, Integer>{

	/**
	 * @param parseLong
	 * @return
	 */
	@Query("from UserRole u where u.userDetails.id=?1")
	List<UserRole> getUserRoleByUserId(String userId);

	/**
	 * @param roleId
	 * @return
	 */
	@Query("from UserRole u where u.role.roleId=?1")
	List<UserRole> getUserRoleByRoleId(int roleId);

	/**
	 * @param id
	 * @param roleId
	 * @return
	 */
	@Query("from UserRole u where u.userDetails.id=?1 and u.role.roleId=?2")
	UserRole getUserRolesByUserIdAndRoleId(String id, int roleId);

}



