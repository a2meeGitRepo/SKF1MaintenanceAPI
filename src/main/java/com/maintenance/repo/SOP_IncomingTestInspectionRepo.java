/**
 * Dattatray Bodhale
	29-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_IncomingTestInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_IncomingTestInspectionRepo extends JpaRepository<SOP_IncomingTestInspection, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_IncomingTestInspection i where i.sopId=?1")
	List<SOP_IncomingTestInspection> getIncomingTestInspectionBySOPId(int sopId);

}



