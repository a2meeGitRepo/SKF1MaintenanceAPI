/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public interface EmployeeRepoCustome {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Employee> getEmployeeByPagination(int page_no, int item_per_page);
	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Employee> getEmployeeByPaginationAndSerach(int page_no, int item_per_page, String search);
}



