/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.Branch;

/**
 * @author Dattatray Bodhale
 *
 */
public interface BranchRepo extends JpaRepository<Branch, Integer>{

	/**
	 * @param branchCode
	 * @return
	 */
	@Query("from Branch b where b.branchCode=?1")
	Optional<Branch> getBranchByCode(String branchCode);

	/**
	 * @param branchId
	 * @return
	 */
	@Query("from Branch b where b.branchId=?1")
	Optional<Branch> getBranchById(int branchId);

	/**
	 * @param branchName
	 * @return
	 */
	@Query("From Branch b where b.branchName=?1")
	Optional<Branch> getBranchByName(String branchName);

}



