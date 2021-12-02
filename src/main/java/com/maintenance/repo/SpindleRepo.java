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

import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpindleRepo  extends JpaRepository<Spindle, Integer>,SpindleCustomeRepo{

	/**
	 * @param search
	 * @return
	 */
	@Query("select count(s) from Spindle s where s.delBit=0 and  s.spindleBrand  LIKE %:searchText% OR s.machineBrand  LIKE %:searchText% OR s.serialNo  LIKE %:searchText% OR s.spindleModel  LIKE %:searchText% OR s.machineModel  LIKE %:searchText% OR s.power  LIKE %:searchText% OR s.toolTaper  LIKE %:searchText%")
	int getSpindleCountBySearch(@Param("searchText")String searchText);

	/**
	 * @return
	 */
	@Query("select count(s) from Spindle s where s.delBit=0")
	int getSpindleCount();

	/**
	 * @return
	 */
	@Query("from Spindle s where s.delBit=0")
	List<Spindle> getAllSpindleList();

	/**
	 * @param serialNo
	 * @return
	 */
	@Query("from Spindle s where s.serialNo=?1")
	Optional<Spindle> findBySerialNo(String serialNo);

	/**
	 * @return
	 */
	@Query("from Spindle s where s.delBit=0 and s.active=1")
	List<Spindle> getActiceSpindleList();

	

}



