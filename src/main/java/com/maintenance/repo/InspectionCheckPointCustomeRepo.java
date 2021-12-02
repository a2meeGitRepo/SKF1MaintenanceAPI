/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.InspectionCheckPoint;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionCheckPointCustomeRepo {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<InspectionCheckPoint> getInspectionCheckPointByPaginationAndSerach(int page_no, int item_per_page,
			String search);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<InspectionCheckPoint> getInspectionCheckPointByPagination(int page_no, int item_per_page);


}



