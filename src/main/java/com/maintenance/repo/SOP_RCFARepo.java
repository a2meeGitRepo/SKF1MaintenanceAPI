/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_RCFA;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_RCFARepo extends JpaRepository<SOP_RCFA, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_RCFA r where r.sopId=?1")
	Optional<SOP_RCFA> getRCFABySOPId(int sopId);

}



