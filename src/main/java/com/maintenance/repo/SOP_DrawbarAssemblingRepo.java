/**
 * Dattatray Bodhale
	15-Jul-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP_DrawbarAssembling;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOP_DrawbarAssemblingRepo extends JpaRepository<SOP_DrawbarAssembling, Integer>{

	/**
	 * @param sopI
	 * @return
	 */
	@Query("from SOP_DrawbarAssembling d where d.sopId=?1")
	Optional<SOP_DrawbarAssembling> getDrawbarAssemblingSopId(int sopId);

}



