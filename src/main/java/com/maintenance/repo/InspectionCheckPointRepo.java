/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.InspectionCheckPoint;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionCheckPointRepo extends JpaRepository<InspectionCheckPoint, Integer>,InspectionCheckPointCustomeRepo {

	
	/**
	 * @return
	 */
	@Query("select count(i) from InspectionCheckPoint i where i.delBit=0")
	int getInspectionCheckPointCount();

	/**
	 * @return
	 */
	@Query("select count(i) from InspectionCheckPoint i where i.delBit=0 and i.checkPointName  LIKE %:searchText% OR  i.defaultValue  LIKE %:searchText% OR  i.defaultCondistion  LIKE %:searchText% OR  i.remark  LIKE %:searchText% ")
	int getInspectionCheckPointCountBySearch(@Param("searchText")String searchText);

	/**
	 * @return
	 */
	@Query("from InspectionCheckPoint i where i.delBit=0")
	List<InspectionCheckPoint> getAllInspectionCheckPointList();

	/**
	 * @return
	 */
	@Query("from InspectionCheckPoint i where i.delBit=0 and i.active=1")
	List<InspectionCheckPoint> getActiveInspectionCheckPointList();

	/**
	 * @param checkPointName
	 * @return
	 */
	@Query("from InspectionCheckPoint i where i.delBit=0 and i.checkPointName=?1")
	Optional<InspectionCheckPoint> getInspectionCheckPointByName(String checkPointName);

}



