/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.apache.xmlbeans.impl.jam.JParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_InOutCoolent;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_InOutCoolentRepo extends JpaRepository<SOP_InOutCoolent, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_InOutCoolent i where i.sopId=?1")
	Optional<SOP_InOutCoolent> getInOutCoolentBySOPId(int sopId);

}



