/**
 * Dattatray Bodhale
	09-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_SpareRequired;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_SpareRequiredRepo extends JpaRepository<SOP_SpareRequired, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_SpareRequired s where s.sopId=?1")
	List<SOP_SpareRequired> getSOP_SpareRequiredBySOPId(int sopId);

}



