/**
 * Dattatray Bodhale
	01-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_MotorCheckDisassembly;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_MotorCheckDisassemblyRepo extends JpaRepository<SOP_MotorCheckDisassembly, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOP_MotorCheckDisassembly m where m.sopId=?1")
	Optional<SOP_MotorCheckDisassembly> getMotorCheckDisassemblyBySOPId(int sopId);

}



