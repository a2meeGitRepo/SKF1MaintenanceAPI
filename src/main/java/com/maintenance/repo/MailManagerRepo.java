/**
 * Dattatray Bodhale
	29-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.MailManager;

/**
 * @author Dattatray Bodhale
 *
 */
public interface MailManagerRepo extends JpaRepository<MailManager, Integer>{

	/**
	 * @return
	 */
	@Query("from MailManager m where m.mailFor='Service Request'")
	List<MailManager> getAllMailManagerForNewService();

	/**
	 * @return
	 */
	@Query("from MailManager m where m.mailFor='Offer'")
	List<MailManager> getAllMailManagerForNewOffer();

	/**
	 * @return
	 */
	@Query("from MailManager m where m.mailFor='Inspection Report'")
	List<MailManager> getAllMailManagerForInspectionReport();

}



