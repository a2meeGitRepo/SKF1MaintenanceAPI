/**
 * Dattatray Bodhale
	19-Jun-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_PowerCables;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_PowerCablesRepo extends JpaRepository<SOP_PowerCables, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_PowerCables p where p.sopId=?1")
	Optional<SOP_PowerCables> getPowerCableBySOPId(int sopId);

}



