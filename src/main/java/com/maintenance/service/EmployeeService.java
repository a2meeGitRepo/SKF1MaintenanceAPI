/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.Branch;
import com.maintenance.model.Department;
import com.maintenance.model.Designation;
import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public interface EmployeeService {

	/**
	 * @return
	 */
	List<Designation> getDesignationList();

	/**
	 * @param designationName
	 * @return
	 */
	Optional<Designation> getDesignationByName(String designationName);

	/**
	 * @param designation
	 */
	void addDesignation(Designation designation);

	/**
	 * @return
	 */
	List<Department> getDepartmentList();

	/**
	 * @param departmentName
	 * @return
	 */
	Optional<Department> getDepartmentByName(String departmentName);

	/**
	 * @param department
	 */
	void addDepartment(Department department);

	/**
	 * @return
	 */
	List<Branch> getBranchList();

	/**
	 * @param branchCode
	 * @return
	 */
	Optional<Branch> getBranchByCode(String branchCode);

	/**
	 * @param branch
	 */
	void addBranch(Branch branch);

	/**
	 * @return
	 */
	List<Employee> getAllEmployeeList();

	/**
	 * @param employee
	 */
	void addEmployee(Employee employee);

	/**
	 * @param emoloyeeCode
	 * @return
	 */
	Optional<Employee> getEmployeeByCode(String emoloyeeCode);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Employee> getEmployeeByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getEmployeeCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Employee> getEmployeeByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getEmployeeCountBySearch(String search);

	/**
	 * @return
	 */
	List<Employee> getAllManagers();

	/**
	 * @param employeeCode
	 * @return
	 */
	boolean checkEmployeeCode(String employeeCode);

	/**
	 * @param branchId
	 * @return
	 */
	Branch getBranchById(int branchId);

	/**
	 * @return
	 */
	List<Employee> getAllEngineer();

	/**
	 * @param engineerId
	 * @return
	 */
	Employee getEmployeeById(int engineerId);

}



