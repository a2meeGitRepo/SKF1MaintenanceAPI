/**
 * Dattatray Bodhale
	12-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.SpindleServiceRequest;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpindleServiceRequestCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<SpindleServiceRequest> getSpindleServiceRequestByPagination(int page_no, int item_per_page);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<SpindleServiceRequest> getSpindleServiceRequestByPaginationAndSerach(int page_no, int item_per_page,
			String search);
	/**
	 * @param branchCode
	 * @return
	 */
	String getMaxSSCNoBybranchCode(String branchCode);
	
	int getSpindleServiceRequestCountBySearch(String search);

}



