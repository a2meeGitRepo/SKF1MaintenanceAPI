/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.Customer;
import com.maintenance.model.CustomerRegistratin;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CustomerService {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<Customer> getCustomerByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getCustomerCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<Customer> getCustomerByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getCustomerCountBySearch(String search);

	/**
	 * @return
	 */
	List<Customer> getAllCustomerList();

	/**
	 * @param customerCode
	 * @return
	 */
	boolean checkCustomerCode(String customerCode);

	/**
	 * @param customerCode
	 * @return
	 */
	Optional<Customer> getCustomerByCode(String customerCode);

	/**
	 * @param customer
	 */
	void addCustomer(Customer customer);

	/**
	 * @return
	 */
	List<Customer> getActiveCustomerList();

	/**
	 * @param customer
	 */
	void addCustomerRegistration(CustomerRegistratin customer);

	/**
	 * @param custId
	 * @return
	 */
	Customer getCustomerRegById(int custId);

	/**
	 * @param customer
	 * @return
	 */
	Customer addCustomer1(Customer customer);

}



