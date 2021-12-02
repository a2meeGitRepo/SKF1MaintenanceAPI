/**
 * Dattatray Bodhale
	04-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_RotaryUnit;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_RotaryUnitRepo extends JpaRepository<SOP_RotaryUnit, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_RotaryUnit s where s.sopId=?1")
	Optional<SOP_RotaryUnit> getRotaryUnitBySOPId(int sopId);

}



