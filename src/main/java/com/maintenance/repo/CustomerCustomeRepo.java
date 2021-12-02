/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.Customer;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CustomerCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Customer> getCustomerByPagination(int page_no, int item_per_page);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Customer> getCustomerByPaginationAndSerach(int page_no, int item_per_page, String search);
}



