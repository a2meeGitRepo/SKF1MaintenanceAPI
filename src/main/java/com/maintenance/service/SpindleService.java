/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.CustomerSpindleRegistration;
import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpindleService {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Spindle> getSpindleByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getSpindleCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Spindle> getSpindleByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getSpindleCountBySearch(String search);

	/**
	 * @return
	 */
	List<Spindle> getAllSpindleList();

	/**
	 * @param serialNo
	 * @return
	 */
	boolean checkSerialNo(String serialNo);

	/**
	 * @param serialNo
	 * @return
	 */
	Optional<Spindle> getSpindleBySerialNo(String serialNo);

	/**
	 * @param spindle
	 */
	void addSpindle(Spindle spindle);

	/**
	 * @return
	 */
	List<Spindle> getActiceSpindleList();

	/**
	 * @return
	 */
	Set<String>  getSpindleModels();

	/**
	 * @param customerSpindleRegistration
	 */
	CustomerSpindleRegistration addCustomerSpindleRegistration(CustomerSpindleRegistration customerSpindleRegistration);

	/**
	 * @param cusSpindleRegId
	 * @return
	 */
	Optional<CustomerSpindleRegistration> getCustomerSpindleRegistrationById(int cusSpindleRegId);

	/**
	 * @param bearringAccessory
	 */
	void saveBearringAccessory(BearringAccessoryCustReq bearringAccessory);

	/**
	 * @param customerId
	 * @return
	 */
	List<CustomerSpindleRegistration> getCustomerSpindleRegistrationByCustomer(int customerId);

	/**
	 * @return
	 */
	List<CustomerSpindleRegistration> getAllCustomerSpindleRegistration();

	/**
	 * @param spindle
	 * @return
	 */
	Spindle saveSpindle(Spindle spindle);

}



