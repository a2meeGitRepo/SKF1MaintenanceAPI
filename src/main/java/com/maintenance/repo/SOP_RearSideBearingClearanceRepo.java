/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_RearSideBearingClearance;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_RearSideBearingClearanceRepo extends JpaRepository<SOP_RearSideBearingClearance, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_RearSideBearingClearance p where p.sopId=?1")

	Optional<SOP_RearSideBearingClearance> getRearSideBearingClearanceSopId(int sopId);

}



