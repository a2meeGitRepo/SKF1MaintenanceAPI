/**
 * Dattatray Bodhale
	25-Jul-2021
 */
package com.maintenance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maintenance.model.Quotation;

/**
 * @author Dattatray Bodhale
 *
 */
public interface QuotationRepo extends JpaRepository<Quotation, Integer> {

}



