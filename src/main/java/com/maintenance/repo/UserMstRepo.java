/**
 * Dattatray Bodhale
	09-Jun-2021
 */
package com.maintenance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.Usermst;

/**
 * @author Dattatray Bodhale
 *
 */
public interface UserMstRepo extends JpaRepository<Usermst, Integer> {

	/**
	 * @return
	 */
	@Query("select MAX(id) from Usermst")
	String getMaxId();

}



