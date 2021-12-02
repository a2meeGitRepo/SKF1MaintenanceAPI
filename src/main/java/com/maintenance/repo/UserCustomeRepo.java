/**
 * Dattatray Bodhale
	15-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.UserDetails;

/**
 * @author Dattatray Bodhale
 *
 */
public interface UserCustomeRepo {
	/**
	 * @param search
	 * @return
	 */
	int getUserCountBySearch(String search);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<UserDetails> getUserByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @return
	 */
	int getUserCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<UserDetails> getUserByPagination(int page_no, int item_per_page);
}



