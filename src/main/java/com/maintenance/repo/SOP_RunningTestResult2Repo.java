/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_RunningTestResult2;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_RunningTestResult2Repo extends JpaRepository<SOP_RunningTestResult2, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_RunningTestResult2 r where sopId=?1")
	Optional<SOP_RunningTestResult2> getRunningTestResult2SopId(int sopId);

}



