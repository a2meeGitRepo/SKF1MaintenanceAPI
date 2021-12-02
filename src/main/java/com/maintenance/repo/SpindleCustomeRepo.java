/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpindleCustomeRepo {
	
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Spindle> getSpindleByPagination(int page_no, int item_per_page);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Spindle> getSpindleByPaginationAndSerach(int page_no, int item_per_page, String search);

}



