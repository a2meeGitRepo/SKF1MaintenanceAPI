/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.InspectionStagesCheckpoint;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionStagesCheckpointRepo extends JpaRepository<InspectionStagesCheckpoint, Integer> {

	/**
	 * @param inspectionStage
	 * @return
	 */
	@Query("from  InspectionStagesCheckpoint i where i.inspectionStage.inspectionStageId=?1")
	List<InspectionStagesCheckpoint> getInspeactionStagesMappedCheckPoint(int inspectionStage);

	/**
	 * @param inspectionStageId
	 * @param inspectionCheckpointId
	 * @return
	 */
	@Query("from  InspectionStagesCheckpoint i where i.inspectionStage.inspectionStageId=?1 and i.inspectionCheckPoint.inspectionCheckpointId=?2")
	Optional<InspectionStagesCheckpoint> getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(
			int inspectionStageId, int inspectionCheckpointId);

}



