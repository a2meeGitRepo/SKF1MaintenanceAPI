/**
 * Dattatray Bodhale
	26-Apr-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.AccessPermission;

/**
 * @author Dattatray Bodhale
 *
 */
public interface PermissionRepo  extends JpaRepository<AccessPermission, Integer>{

	/**
	 * @return
	 */
	@Query("from AccessPermission")
	List<AccessPermission> getAllPermsisons();

	/**
	 * @param string
	 * @return
	 */
	@Query("from AccessPermission p where p.name=?1")
	Optional<AccessPermission> getPermissionByName(String string);

}



