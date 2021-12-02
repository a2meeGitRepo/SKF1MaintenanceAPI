/**
 * Dattatray Bodhale
	26-Apr-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.Role;

/**
 * @author Dattatray Bodhale
 *
 */

public interface RoleRepo extends JpaRepository<Role, Integer> {

	/**
	 * @param roleName
	 * @return
	 */
	@Query("from Role r where r.roleName=?1")
	Optional<Role> getRoleByName(String roleName);

}



