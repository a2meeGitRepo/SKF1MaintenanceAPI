/**
 * Dattatray Bodhale
	12-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.CustomerSpindleRegistration;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CustomerSpindleRegistrationRepo extends JpaRepository<CustomerSpindleRegistration, Integer>{

	/**
	 * @param customerId
	 * @return
	 */
	@Query("from CustomerSpindleRegistration c where c.customer.customerId=?1")
	List<CustomerSpindleRegistration> getCustomerSpindleRegistrationByCustomer(int customerId);

}



