/**
 * Dattatray Bodhale
	15-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOPStageStatus;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOPStageStatusRepo extends JpaRepository<SOPStageStatus, Integer>{



	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOPStageStatus s where s.sop.sopId=?1 and s.stageType='Secondary Inspeaction'")
	List<SOPStageStatus> getSecondarySOPStagesBySOP(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("from SOPStageStatus s where s.sop.sopId=?1 and s.stageType='Primary Inspeaction'")

	List<SOPStageStatus> getPrimarySOPStagesBySOP(int sopId);
	

	/**
	 * @param sopId
	 * @param stageNo
	 * @return
	 */
	@Query("from SOPStageStatus s where s.sop.sopId=?1 and s.stageNo=?2")
	Optional<SOPStageStatus> getStageBySOPIdAndStageNo(int sopId, int stageNo);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("select count(*) from SOPStageStatus s where s.sop.sopId=?1 and s.status='Completed'   and s.stageType='Primary Inspeaction'")
	int getNoOfPrimaryInspectinStageCompletedBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	@Query("select count(*) from SOPStageStatus s where s.sop.sopId=?1 and s.stageType='Secondary Inspeaction' and s.status='Completed'")
	int getNoOfFinaleInspectinStageCompletedBySOPId(int sopId);


}



