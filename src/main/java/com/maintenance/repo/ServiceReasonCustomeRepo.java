/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.ServiceReason;

/**
 * @author Dattatray Bodhale
 *
 */
public interface ServiceReasonCustomeRepo {
	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<ServiceReason> getServiceReasonByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<ServiceReason> getServiceReasonByPagination(int page_no, int item_per_page);
}



