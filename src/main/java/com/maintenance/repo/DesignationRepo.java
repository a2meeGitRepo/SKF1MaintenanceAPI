/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.Designation;

/**
 * @author Dattatray Bodhale
 *
 */
public interface DesignationRepo extends JpaRepository<Designation, Integer>{

	/**
	 * @param designationName
	 * @return
	 */
	@Query("from Designation d where d.designationName=?1")
	Optional<Designation> getDesignationByName(String designationName);

}



