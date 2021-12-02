/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_WashingCleaning;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_WashingCleaningRepo extends JpaRepository<SOP_WashingCleaning, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_WashingCleaning w where w.sopId=?1")
	Optional<SOP_WashingCleaning> getWashingCleaningBySOPId(int sopId);

}



