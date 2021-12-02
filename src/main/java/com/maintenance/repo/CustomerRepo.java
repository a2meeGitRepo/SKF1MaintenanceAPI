/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.Customer;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer>,CustomerCustomeRepo{

	/**
	 * @return
	 */
	@Query("select count(c)from Customer c where c.delBit=0")
	int getCustomerCount();

	/**
	 * @param search
	 * @return
	 */
	@Query("select count(*) from Customer c where c.delBit=0  and c.customerCode  LIKE %:searchText% OR c.contactPerson  LIKE %:searchText%")
	int getCustomerCountBySearch(@Param("searchText")String searchText);

	/**
	 * @return
	 */
	@Query("from Customer c where c.delBit=0")
	List<Customer> getAllCustomerList();

	/**
	 * @param customerCode
	 * @return
	 */
	@Query("from Customer c where c.delBit=0 and c.customerCode=?1")
	Optional<Customer> checkCustomerCode(String customerCode);

	/**
	 * @return
	 */
	@Query("from Customer c where c.delBit=0 and c.active=1")
	List<Customer> getActiveCustomerList();

	

}



