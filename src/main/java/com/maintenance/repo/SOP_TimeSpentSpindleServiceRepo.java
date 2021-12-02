/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_TimeSpentSpindleService;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_TimeSpentSpindleServiceRepo extends JpaRepository<SOP_TimeSpentSpindleService, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_TimeSpentSpindleService t where t.sopId=?1")
	Optional<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceSopId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_TimeSpentSpindleService t where t.sopId=?1")
	List<SOP_TimeSpentSpindleService> getListTimeSpentSpindleServiceSopId(int sopId);

}



