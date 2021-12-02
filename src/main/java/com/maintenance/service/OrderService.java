/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.Order;

/**
 * @author Dattatray Bodhale
 *
 */
public interface OrderService {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Order> getOrderByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getOrderCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Order> getOrderByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getOrderCountBySearch(String search);

	/**
	 * @return
	 */
	List<Order> getAllOrderList();

	/**
	 * @param order
	 */
	void addNewOrder(Order order);

	/**
	 * @param sscNo
	 * @return
	 */
	Optional<Order> getOrdeBySSCNo(String sscNo);

}



