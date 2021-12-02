/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_SpindleClearanceInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_SpindleClearanceInspectionRepo extends JpaRepository<SOP_SpindleClearanceInspection, Integer>{

	/**
	 * @param sopId
	 * @return
	 */	@Query("from SOP_SpindleClearanceInspection t where t.sopId=?1")

	Optional<SOP_SpindleClearanceInspection> getSpindleClearanceInspectionBySOPId(int sopId);

}



