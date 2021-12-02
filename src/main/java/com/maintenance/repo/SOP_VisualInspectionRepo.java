/**
 * Dattatray Bodhale
	18-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_VisualInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_VisualInspectionRepo extends JpaRepository<SOP_VisualInspection, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_VisualInspection v where v.sopId=?1")
	List<SOP_VisualInspection> getVisualIspectionBySOPId(int sopId);

}



