/**
 * Dattatray Bodhale
	07-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ComponentInspection_1;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_ComponentInspection_1Repo extends JpaRepository<SOP_ComponentInspection_1, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_ComponentInspection_1 c where sopId=?1")
	List<SOP_ComponentInspection_1> getComponentInspection1BySOPId(int sopId);

}



