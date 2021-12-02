/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.ServiceReason;

/**
 * @author Dattatray Bodhale
 *
 */
public interface ServiceReasonRepo extends JpaRepository<ServiceReason, Integer>,ServiceReasonCustomeRepo{

	/**
	 * @return
	 */
	@Query("select count(s) from ServiceReason s where s.deletBit=0")
	int getServiceReasonCount();

	/**
	 * @param search
	 * @return
	 */
	@Query("select count(s) from ServiceReason s where s.deletBit=0 and  s.reasonName  LIKE %:searchText% ")
	int getServiceReasonCountBySearch(String search);

	/**
	 * @return
	 */
	@Query(" from ServiceReason s where s.deletBit=0")
	List<ServiceReason> getAllSpindleList();

	/**
	 * @param reasonName
	 * @return
	 */
	@Query(" from ServiceReason s where s.deletBit=0 and s.reasonName=?1")
	Optional<ServiceReason> getServiceReasonByname(String reasonName);

	/**
	 * @return
	 */
	@Query(" from ServiceReason s where s.deletBit=0 and s.active=1")
	List<ServiceReason> getActiveServiceReasonList();

	

}



