/**
 * Dattatray Bodhale
	22-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ShaftBalancingNewMapped;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_ShaftBalancingNewMappedRepo extends JpaRepository<SOP_ShaftBalancingNewMapped, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_ShaftBalancingNewMapped where sopId=?1")
	List<SOP_ShaftBalancingNewMapped> shaftBalancingNewMappedbySopId(int sopId);

}



