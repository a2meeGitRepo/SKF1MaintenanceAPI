/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOP;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOPRepo extends JpaRepository<SOP, Integer>,SOPCustomeRepo{

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.primaryStatus='InProcess' and s.technician.employeeId=?1")
	List<SOP> getInProcessSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.primaryStatus='Intiated' and s.technician.employeeId=?1")
	List<SOP> getPendingSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.primaryStatus='Completed' and s.technician.employeeId=?1")
	List<SOP> getCompletedSOPByEnginner(int employeeId);
	
	@Query("select count(s) From SOP s")
	int getAllSOPCount();

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	@Query("From SOP s where  s.sprindleServiceRequestId=?1")
	Optional<SOP> getSOPByServiceRequestID(int sprindleServiceRequestId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.secondaryStatus='InProcess' and s.technician.employeeId=?1")
	List<SOP> getFinalInProcessSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.secondaryStatus='Completed' and s.technician.employeeId=?1")
	List<SOP> getFinalCompletedSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("From SOP s where s.secondaryStatus='Intiated' and s.technician.employeeId=?1")
	List<SOP> getFinalPendingSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*) from SOP s where s.primaryStatus='Completed' and s.technician.employeeId=?1")
	int getPrimaryCompletedSOPCountByEmployeeId(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*)  From SOP s where s.primaryStatus='InProcess' and s.technician.employeeId=?1")
	int getPrimaryInProcessSOPCountByEmployeeId(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*)  From SOP s where s.primaryStatus='Intiated' and s.technician.employeeId=?1")
	int getPrimaryPendingSOPCountByEmployeeId(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*)  From SOP s where s.secondaryStatus='Completed' and s.technician.employeeId=?1")
	int getFinalCompletedSOPCountByEmployeeId(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*)  From SOP s where s.secondaryStatus='InProcess' and s.technician.employeeId=?1")
	int getFinalInProcessSOPCountByEmployeeId(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	@Query("select count(*)  From SOP s where s.secondaryStatus='Intiated' and s.technician.employeeId=?1")
	int getFinalPendingSOPCountByEmployeeId(int employeeId);

	/**
	 * @param sopId
	 * @return
	 */
	

}



