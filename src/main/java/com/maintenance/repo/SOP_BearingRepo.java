/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_Bearing;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_BearingRepo extends JpaRepository<SOP_Bearing, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_Bearing s where s.sopId=?1")
	List<SOP_Bearing> getBearingBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_Bearing s where s.bearingSide='Back End' and s.sopId=?1")
	List<SOP_Bearing> getNewBearingRearBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_Bearing s where s.bearingSide='Front End' and s.sopId=?1")
	List<SOP_Bearing> getNewBearingFrontBySOPId(int sopId);

}



