/**
 * Dattatray Bodhale
	21-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.SOP;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOPCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<SOP> getAllSOPByPagination(int page_no, int item_per_page);

	


	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<SOP> getAllSOPByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getAllSOPCountBySearch(String search);
}



