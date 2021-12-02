/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_PositiveLockFrontSideBearing;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_PositiveLockFrontSideBearingRepo extends JpaRepository<SOP_PositiveLockFrontSideBearing, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_PositiveLockFrontSideBearing p where p.sopId=?1")
	Optional<SOP_PositiveLockFrontSideBearing> getPositiveLockFrontSideBearingSopId(int sopId);

}



