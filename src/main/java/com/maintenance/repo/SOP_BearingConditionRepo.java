/**
 * Dattatray Bodhale
	30-Jun-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_BearingCondition;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_BearingConditionRepo extends JpaRepository<SOP_BearingCondition, Integer>{

	/**
	 * @param sopId
	 * @param item
	 * @return
	 */
	@Query("from SOP_BearingCondition b where b.sopId=?1 and b.bearingItems=?2")
	Optional<SOP_BearingCondition> getBearingConditionBySOPIdAndItem(int sopId, String item);

}



