/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.BearringAccessory;

/**
 * @author Dattatray Bodhale
 *
 */
public interface BearringAccessoryRepo extends JpaRepository<BearringAccessory, Integer>{

	/**
	 * @param sscNo
	 * @return
	 */
	@Query("from BearringAccessory b where b.sscNo=?1 and b.side='Rear'")
	List<BearringAccessory> getRearBearingBySSCNo(String sscNo);

	/**
	 * @param sscNo
	 * @return
	 */
	@Query("from BearringAccessory b where b.sscNo=?1 and b.side='Front'")
	List<BearringAccessory> getFrontBearingBySSCNo(String sscNo);

}



