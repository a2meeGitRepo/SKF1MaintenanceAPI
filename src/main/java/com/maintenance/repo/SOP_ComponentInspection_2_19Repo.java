/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_ComponentInspection_2_19;
import com.maintenance.model.SOP_ComponentInspection_3_19;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_ComponentInspection_2_19Repo extends JpaRepository<SOP_ComponentInspection_2_19, Integer>{


	@Query("from SOP_ComponentInspection_2_19 c where c.sopId=?1")
	List<SOP_ComponentInspection_2_19> getComponentInspection2_19BySOPId(int sopId);

}



