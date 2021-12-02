/**
 * Dattatray Bodhale
	04-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ColloingSystemInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_ColloingSystemInspectionRepo extends JpaRepository<SOP_ColloingSystemInspection, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_ColloingSystemInspection c where c.sopId=?1")
	Optional<SOP_ColloingSystemInspection> getColloingSystemInspectionBySOPId(int sopId);

}



