/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.InspectionStage;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionStageRepo  extends JpaRepository<InspectionStage, Integer>,InspectionStageCustomeRepo{

	/**
	 * @param stageName
	 * @param spindleModel
	 * @return
	 */
	@Query("from InspectionStage i where i.stageName=?1 and i.spindleModel=?2 and i.delBit=0")
	Optional<InspectionStage> getInspectionStageByName(String stageName, String spindleModel);

	/**
	 * @return
	 */
	@Query("select count(i)from InspectionStage i where i.delBit=0")
	int getInspectionStageCount();

	/**
	 * @return
	 */
	@Query("from InspectionStage i where i.delBit=0")
	List<InspectionStage> getAllInspectionStage();

	
	/**
	 * @param search
	 * @return
	 */
	@Query("select count(*) from InspectionStage i where i.delBit=0 and i.stageNo  LIKE %:searchText% OR i.stageName  LIKE %:searchText% OR i.spindleModel  LIKE %:searchText%")
	int getInspectionStageCountBySeach(@Param("searchText")String searchText);

	
	

	


}



