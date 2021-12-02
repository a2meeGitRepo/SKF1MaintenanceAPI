/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;
import com.maintenance.model.InspectionStagesCheckpoint;

/**
 * @author Dattatray Bodhale
 *
 */
public interface InspectionService {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<InspectionCheckPoint> getInspectionCheckPointByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getInspectionCheckPointCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<InspectionCheckPoint> getInspectionCheckPointByPaginationAndSerach(int page_no, int item_per_page,
			String search);

	/**
	 * @param search
	 * @return
	 */
	int getInspectionCheckPointCountBySearch(String search);

	/**
	 * @return
	 */
	List<InspectionCheckPoint> getAllInspectionCheckPointList();

	/**
	 * @return
	 */
	List<InspectionCheckPoint> getActiveInspectionCheckPointList();

	/**
	 * @param checkPointName
	 * @return
	 */
	Optional<InspectionCheckPoint> getInspectionCheckPointByName(String checkPointName);

	/**
	 * @param inspectionCheckPoint
	 */
	void addInspectionCheckPoint(InspectionCheckPoint inspectionCheckPoint);

	/**
	 * @param inspectionStage
	 * @return
	 */
	InspectionStage saveInspectionStaege(InspectionStage inspectionStage);

	/**
	 * @param inspectionCheckPoint
	 */
	void addInspectionStageCheckPoint(InspectionStagesCheckpoint inspectionCheckPoint);

	/**
	 * @param stageName
	 * @param spindleModel
	 * @return
	 */
	Optional<InspectionStage> getInspectionStageByName(String stageName, String spindleModel);

	/**
	 * @return
	 */
	int getInspectionStageCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<InspectionStage> getInspectionStageByPagination(int page_no, int item_per_page);

	/**
	 * @param model
	 * @return
	 */
	int getNewStageNoByModel(String model);

	/**
	 * @param inspectionStage
	 * @return
	 */
	List<InspectionStagesCheckpoint> getInspeactionStagesMappedCheckPoint(int inspectionStage);

	/**
	 * @param inspectionStageId
	 * @param inspectionCheckpointId
	 * @return
	 */
	Optional<InspectionStagesCheckpoint> getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(
			int inspectionStageId, int inspectionCheckpointId);

	/**
	 * @return
	 */
	List<InspectionStage> getAllInspectionStage();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<InspectionStage> getInspectionStageByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getInspectionStageCountBySeach(String search);

}



