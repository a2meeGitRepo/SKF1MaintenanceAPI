/**
 * Dattatray Bodhale
	19-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.Spare;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpareService {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Spare> getSpareByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getSpareCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Spare> getSpareByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getSpareCountBySearch(String search);

	/**
	 * @param model
	 * @return
	 */
	List<Spare> getSpareByModels(String model);

	/**
	 * @return
	 */
	List<Spare> getAllSpareList();

	/**
	 * @return
	 */
	List<Spare> getActiceSpareList();

	/**
	 * @param spareName
	 * @param spindleModel
	 * @return
	 */
	Optional<Spare> getSpareBySpareNameAndSpindleModel(String spareName, String spindleModel);

	/**
	 * @param spare
	 */
	void addSpare(Spare spare);

}



