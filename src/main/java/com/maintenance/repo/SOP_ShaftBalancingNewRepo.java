/**
 * Dattatray Bodhale
	22-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ShaftBalancingNew;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_ShaftBalancingNewRepo extends JpaRepository<SOP_ShaftBalancingNew, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_ShaftBalancingNew where sopId=?1")
	Optional<SOP_ShaftBalancingNew> getSpindleStaffBalanceNewBySOPId(int sopId);

}



