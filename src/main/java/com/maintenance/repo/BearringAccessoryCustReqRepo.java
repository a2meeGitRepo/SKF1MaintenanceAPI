/**
 * Dattatray Bodhale
	12-Jul-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.BearringAccessoryCustReq;

/**
 * @author Dattatray Bodhale
 *
 */
public interface BearringAccessoryCustReqRepo extends JpaRepository<BearringAccessoryCustReq, Integer> {

	/**
	 * @param custReqId
	 * @return
	 */
	@Query("From BearringAccessoryCustReq b where b.cusSpindleRegId=?1 and b.side='Front'")
	List<BearringAccessoryCustReq> bearingReqListFrontBycustReqId(int custReqId);

	/**
	 * @param custReqId
	 * @return
	 */
	@Query("From BearringAccessoryCustReq b where b.cusSpindleRegId=?1 and b.side='Rear'")

	List<BearringAccessoryCustReq> bearingReqListRearBycustReqId(int custReqId);

}



