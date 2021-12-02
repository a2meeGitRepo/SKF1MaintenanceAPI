/**
 * Dattatray Bodhale
	19-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.Spare;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpareCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Spare> getSpareByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Spare> getSpareByPagination(int page_no, int item_per_page);

}



