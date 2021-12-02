/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.Order;

/**
 * @author Dattatray Bodhale
 *
 */
public interface OrderCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Order> getOrderByPagination(int page_no, int item_per_page);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Order> getOrderByPaginationAndSerach(int page_no, int item_per_page, String search);
}



