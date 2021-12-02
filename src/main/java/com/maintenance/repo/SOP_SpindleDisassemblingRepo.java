/**
 * Dattatray Bodhale
	25-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_SpindleDisassembling;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_SpindleDisassemblingRepo extends JpaRepository<SOP_SpindleDisassembling, Integer> {

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOP_SpindleDisassembling s where s.sopId=?1")
	List<SOP_SpindleDisassembling> getSpindleDisassemblingBySOPId(int sopId);

}



