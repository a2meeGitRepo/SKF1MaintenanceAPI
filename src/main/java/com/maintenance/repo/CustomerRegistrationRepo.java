/**
 * Dattatray Bodhale
	08-Jul-2021
 */
package com.maintenance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.model.CustomerRegistratin;

/**
 * @author Dattatray Bodhale
 *
 */
public interface CustomerRegistrationRepo extends JpaRepository<CustomerRegistratin, Integer>{

}



