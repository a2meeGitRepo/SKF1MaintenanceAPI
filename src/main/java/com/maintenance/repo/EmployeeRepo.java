/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer>,EmployeeRepoCustome{

	/**
	 * @param emoloyeeCode
	 * @return
	 */
	@Query("from Employee e where e.emoloyeeCode=?1 and e.delBit=0")
	Optional<Employee> getEmployeeByCode(String emoloyeeCode);

	/**
	 * @return
	 */
	@Query("select count(e)from Employee e where e.delBit=0")
	int getEmployeeCount();

	
	/**
	 * @param search
	 * @return
	 */
	@Query("select count(*) from Employee e where e.delBit=0 and e.fName  LIKE %:searchText% OR e.emoloyeeCode  LIKE %:searchText%")
	int getEmployeeCountBySearch(@Param("searchText")String searchText);

	/**
	 * @return
	 */
	@Query("From Employee e  where e.designation.designationId=2 and e.delBit=0")
	List<Employee> getAllManagers();

	/**
	 * @param employeeCode
	 * @return
	 */
	@Query("From Employee e  where e.emoloyeeCode=?1 and e.delBit=0")
	Optional<Employee> getEmployeeByEmployeeCode(String employeeCode);

	/**
	 * @return
	 */
	@Query("From Employee e  where e.designation.designationName='Engineer' and e.delBit=0")
	List<Employee> getAllEngineer();

	

}



