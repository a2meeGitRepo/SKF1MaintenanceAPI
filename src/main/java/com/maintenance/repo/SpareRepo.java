/**
 * Dattatray Bodhale
	19-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.Spare;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SpareRepo extends JpaRepository<Spare, Integer>,SpareCustomeRepo {

	/**
	 * @return
	 */
	@Query("select count(s) from Spare s where s.delBit=0")
	int getSpareCount();

	/**
	 * @param model
	 * @return
	 */
	@Query("from Spare s where s.delBit=0  and s.spindleModel=?1")
	List<Spare> getSpareByModels(String model);

	/**
	 * @param search
	 * @return
	 */
	@Query("select count(s) from Spare s where s.delBit=0 and  s.spareName  LIKE %:searchText% OR s.description  LIKE %:searchText% OR s.spindleModel  LIKE %:searchText% OR s.uom  LIKE %:searchText% OR s.price  LIKE %:searchText% ")
	int getSpareCountBySearch(@Param("searchText")String searchText);

	/**
	 * @param spareName
	 * @param spindleModel
	 * @return
	 */
	@Query("from Spare s where s.delBit=0  and s.spareName=?1 and  s.spindleModel=?2")
	Optional<Spare> getSpareBySpareNameAndSpindleModel(String spareName, String spindleModel);

	/**
	 * @return
	 */
	@Query("from Spare s where s.delBit=0  and s.active=1")
	List<Spare> getActiceSpareList();

	/**
	 * @return
	 */
	@Query("from Spare s where s.delBit=0")
	List<Spare> getAllSpareList();


}



