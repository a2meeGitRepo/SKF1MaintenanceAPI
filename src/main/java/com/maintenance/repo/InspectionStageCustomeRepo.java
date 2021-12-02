/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import com.maintenance.model.InspectionStage;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionStageCustomeRepo {
	
	
	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<InspectionStage> getInspectionStageByPagination(int page_no, int item_per_page);
	int getNewStageNoByModel(String model);
	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<InspectionStage> getInspectionStageByPaginationAndSerach(int page_no, int item_per_page, String search);
	

}



