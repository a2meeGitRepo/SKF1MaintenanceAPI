/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_BearingInspection;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_BearingInspectionRepo extends JpaRepository<SOP_BearingInspection, Integer>{

	/**
	 * @return
	 */
	@Query("from SOP_BearingInspection b where b.sopId=?1")
	List<SOP_BearingInspection> getBearingIspectionBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_BearingInspection b where b.bearingSide='Front End' and  b.sopId=?1")
	List<SOP_BearingInspection> getBearingIspectionFrontBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_BearingInspection b  where b.bearingSide='Back End' and  b.sopId=?1")
	List<SOP_BearingInspection> getBearingIspectionRearBySOPId(int sopId);

}



