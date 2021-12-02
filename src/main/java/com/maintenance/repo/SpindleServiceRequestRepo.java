/**
 * Dattatray Bodhale
	12-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.SpindleServiceRequest;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpindleServiceRequestRepo  extends JpaRepository<SpindleServiceRequest, Integer>,SpindleServiceRequestCustomeRepo{

	/**
	 * @return
	 */
	@Query("select count(s) from SpindleServiceRequest s where s.delBit=0")
	int getSpindleServiceRequestCount();

	/**
	 * @param sscNo
	 * @return
	 */
	@Query("from SpindleServiceRequest s where s.delBit=0 and s.sscNo=?1")
	Optional<SpindleServiceRequest> getSpindleServiceRequestBySSCNo(String sscNo);

	/**
	 * @return
	 */
	@Query("from SpindleServiceRequest s where s.delBit=0")
	List<SpindleServiceRequest> getAllSpindleServiceRequestList();

	/**
	 * @param search
	 * @return
	 */
	/*@Query("select count(s) from SpindleServiceRequest s where s.delBit=0 and s.sscNo LIKE %:searchText% OR s.customer.companyName LIKE %:searchText%  OR s.reason.reasonName LIKE %:searchText% OR s.spindle.serialNo LIKE %:searchText% OR s.spindle.spindleModel LIKE %:searchText% ")
	long getSpindleServiceRequestCountBySearch(@Param("searchText")String searchText);
*/
	/**
	 * @param i
	 * @return
	 */
	@Query("from SpindleServiceRequest s where s.delBit=0 and s.engineer.employeeId=?1")
	List<SpindleServiceRequest> getSpindleServiceRequestListByEngineer(int i);

	/**
	 * @param qrCode
	 * @return
	 */
	@Query("from SpindleServiceRequest s where s.delBit=0 and s.qrCode=?1")
	SpindleServiceRequest getSpindleServiceRequestByQRCode(String qrCode);

	/**
	 * @param search
	 * @return
	 */

	

	

}



