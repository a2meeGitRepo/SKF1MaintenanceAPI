/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;
import com.maintenance.model.InspectionStagesCheckpoint;
import com.maintenance.repo.InspectionCheckPointRepo;
import com.maintenance.repo.InspectionStageRepo;
import com.maintenance.repo.InspectionStagesCheckpointRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class InspectionServiceImpl implements InspectionService {
	@Autowired
	InspectionCheckPointRepo inspectionCheckPointRepo;
	@Autowired
	InspectionStageRepo inspectionStageRepo;
	
	
	@Autowired
	InspectionStagesCheckpointRepo inspectionStagesCheckpointRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointByPagination(int, int)
	 */
	@Override
	public List<InspectionCheckPoint> getInspectionCheckPointByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getInspectionCheckPointByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointCount()
	 */
	@Override
	public int getInspectionCheckPointCount() {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getInspectionCheckPointCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<InspectionCheckPoint> getInspectionCheckPointByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getInspectionCheckPointByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointCountBySearch(java.lang.String)
	 */
	@Override
	public int getInspectionCheckPointCountBySearch(String search) {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getInspectionCheckPointCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getAllInspectionCheckPointList()
	 */
	@Override
	public List<InspectionCheckPoint> getAllInspectionCheckPointList() {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getAllInspectionCheckPointList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getActiveInspectionCheckPointList()
	 */
	@Override
	public List<InspectionCheckPoint> getActiveInspectionCheckPointList() {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getActiveInspectionCheckPointList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointByName(java.lang.String)
	 */
	@Override
	public Optional<InspectionCheckPoint> getInspectionCheckPointByName(String checkPointName) {
		// TODO Auto-generated method stub
		return inspectionCheckPointRepo.getInspectionCheckPointByName(checkPointName);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#addInspectionCheckPoint(com.maintenance.model.InspectionCheckPoint)
	 */
	@Override
	public void addInspectionCheckPoint(InspectionCheckPoint inspectionCheckPoint) {
		// TODO Auto-generated method stub
		inspectionCheckPointRepo.save(inspectionCheckPoint);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#saveInspectionStaege(com.maintenance.model.InspectionStage)
	 */
	@Override
	public InspectionStage saveInspectionStaege(InspectionStage inspectionStage) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.save(inspectionStage);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#addInspectionStageCheckPoint(com.maintenance.model.InspectionStagesCheckpoint)
	 */
	@Override
	public void addInspectionStageCheckPoint(InspectionStagesCheckpoint inspectionCheckPoint) {
		// TODO Auto-generated method stub
		inspectionStagesCheckpointRepo.save(inspectionCheckPoint);	
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionCheckPointByName(java.lang.String, java.lang.String)
	 */
	@Override
	public Optional<InspectionStage> getInspectionStageByName(String stageName, String spindleModel) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getInspectionStageByName(stageName,spindleModel);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionStageCount()
	 */
	@Override
	public int getInspectionStageCount() {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getInspectionStageCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionStageByPagination(int, int)
	 */
	@Override
	public List<InspectionStage> getInspectionStageByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getInspectionStageByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getNewStageNoByModel(java.lang.String)
	 */
	@Override
	public int getNewStageNoByModel(String model) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getNewStageNoByModel(model);
		
		
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspeactionStagesMappedCheckPoint(int)
	 */
	@Override
	public List<InspectionStagesCheckpoint> getInspeactionStagesMappedCheckPoint(int inspectionStage) {
		// TODO Auto-generated method stub
		return inspectionStagesCheckpointRepo.getInspeactionStagesMappedCheckPoint(inspectionStage);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(int, int)
	 */
	@Override
	public Optional<InspectionStagesCheckpoint> getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(
			int inspectionStageId, int inspectionCheckpointId) {
		// TODO Auto-generated method stub
		return inspectionStagesCheckpointRepo.getInspeacctionStageCheckPointByInspectionStageAndCheckPoint(inspectionStageId,inspectionCheckpointId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getAllInspectionStage()
	 */
	@Override
	public List<InspectionStage> getAllInspectionStage() {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getAllInspectionStage();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionStageByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<InspectionStage> getInspectionStageByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getInspectionStageByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.InspectionService#getInspectionStageCountBySeach(java.lang.String)
	 */
	@Override
	public int getInspectionStageCountBySeach(String search) {
		// TODO Auto-generated method stub
		return inspectionStageRepo.getInspectionStageCountBySeach(search);
	}

}



