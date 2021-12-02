/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.Department;

/**
 * @author Dattatray Bodhale
 *
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	/**
	 * @param departmentName
	 * @return
	 */
	@Query("From Department d where d.departmentName=?1")
	Optional<Department> getDepartmentByName(String departmentName);

}



