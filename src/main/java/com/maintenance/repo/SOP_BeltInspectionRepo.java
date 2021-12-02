/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_BeltInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_BeltInspectionRepo extends JpaRepository<SOP_BeltInspection, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_BeltInspection b where sopId=?1")
	Optional<SOP_BeltInspection> getBeltInspectionSopId(int sopId);

}



