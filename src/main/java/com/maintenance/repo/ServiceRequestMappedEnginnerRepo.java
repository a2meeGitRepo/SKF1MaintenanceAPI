/**
 * Dattatray Bodhale
	17-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.ServiceRequestMappedEnginner;

/**
 * @author Dattatray Bodhale
 *
 */
public interface ServiceRequestMappedEnginnerRepo extends JpaRepository<ServiceRequestMappedEnginner, Integer>{

	/**
	 * @param engineerId
	 * @return
	 */
	@Query("From ServiceRequestMappedEnginner s where s.status='Requested' and s.engineerId=?1")
	List<ServiceRequestMappedEnginner> getUnApprovedMappedServiceRequestByEng(int engineerId);

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	@Query("From ServiceRequestMappedEnginner s where s.status='Requested' and s.sprindleServiceRequestId=?1")
	Optional<ServiceRequestMappedEnginner> getServiceRequestMappedEnginnerByServiceRequest(int sprindleServiceRequestId);

}



