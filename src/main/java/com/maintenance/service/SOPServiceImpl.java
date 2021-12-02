/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.SOP;
import com.maintenance.model.SOPStageStatus;
import com.maintenance.model.SOP_Bearing;
import com.maintenance.model.SOP_BearingCondition;
import com.maintenance.model.SOP_BearingInspection;
import com.maintenance.model.SOP_BeltInspection;
import com.maintenance.model.SOP_ClampingSystemSensors;
import com.maintenance.model.SOP_ColloingSystemInspection;
import com.maintenance.model.SOP_ComponentInspection_1;
import com.maintenance.model.SOP_ComponentInspection_1_19;
import com.maintenance.model.SOP_ComponentInspection_2;
import com.maintenance.model.SOP_ComponentInspection_2_19;
import com.maintenance.model.SOP_ComponentInspection_3;
import com.maintenance.model.SOP_ComponentInspection_3_19;
import com.maintenance.model.SOP_DrawbarAssembling;
import com.maintenance.model.SOP_DrawbarSpringInspection;
import com.maintenance.model.SOP_Encoder;
import com.maintenance.model.SOP_InOutCoolent;
import com.maintenance.model.SOP_IncomingTestInspection;
import com.maintenance.model.SOP_LubricationSystemInspection;
import com.maintenance.model.SOP_MotorCheckDisassembly;
import com.maintenance.model.SOP_PositiveLockFrontSideBearing;
import com.maintenance.model.SOP_PowerCables;
import com.maintenance.model.SOP_RCFA;
import com.maintenance.model.SOP_RearSideBearingClearance;
import com.maintenance.model.SOP_RotaryUnit;
import com.maintenance.model.SOP_RunningTestResult;
import com.maintenance.model.SOP_RunningTestResult2;
import com.maintenance.model.SOP_RunningTestResults;
import com.maintenance.model.SOP_SealingInspection;
import com.maintenance.model.SOP_ShaftBalancing;
import com.maintenance.model.SOP_ShaftBalancingNew;
import com.maintenance.model.SOP_ShaftBalancingNewMapped;
import com.maintenance.model.SOP_SpareRequired;
import com.maintenance.model.SOP_SpindleClearanceInspection;
import com.maintenance.model.SOP_SpindleDisassembling;
import com.maintenance.model.SOP_SpindleRunOutInspection;
import com.maintenance.model.SOP_TimeSpentSpindleService;
import com.maintenance.model.SOP_VisualInspection;
import com.maintenance.model.SOP_WashingCleaning;
import com.maintenance.repo.SOPRepo;
import com.maintenance.repo.SOPStageStatusRepo;
import com.maintenance.repo.SOP_BearingConditionRepo;
import com.maintenance.repo.SOP_BearingInspectionRepo;
import com.maintenance.repo.SOP_BearingRepo;
import com.maintenance.repo.SOP_BeltInspectionRepo;
import com.maintenance.repo.SOP_ClampingSystemSensorsRepo;
import com.maintenance.repo.SOP_ColloingSystemInspectionRepo;
import com.maintenance.repo.SOP_ComponentInspection_1Repo;
import com.maintenance.repo.SOP_ComponentInspection_1_19Repo;
import com.maintenance.repo.SOP_ComponentInspection_2Repo;
import com.maintenance.repo.SOP_ComponentInspection_2_19Repo;
import com.maintenance.repo.SOP_ComponentInspection_3Repo;
import com.maintenance.repo.SOP_ComponentInspection_3_19Repo;
import com.maintenance.repo.SOP_DrawbarAssemblingRepo;
import com.maintenance.repo.SOP_DrawbarSpringInspectionRepo;
import com.maintenance.repo.SOP_EncoderRepo;
import com.maintenance.repo.SOP_InOutCoolentRepo;
import com.maintenance.repo.SOP_IncomingTestInspectionRepo;
import com.maintenance.repo.SOP_LubricationSystemInspectionRepo;
import com.maintenance.repo.SOP_MotorCheckDisassemblyRepo;
import com.maintenance.repo.SOP_PositiveLockFrontSideBearingRepo;
import com.maintenance.repo.SOP_PowerCablesRepo;
import com.maintenance.repo.SOP_RCFARepo;
import com.maintenance.repo.SOP_RearSideBearingClearanceRepo;
import com.maintenance.repo.SOP_RotaryUnitRepo;
import com.maintenance.repo.SOP_RunningTestResult2Repo;
import com.maintenance.repo.SOP_RunningTestResultsRepo;
import com.maintenance.repo.SOP_SealingInspectionRepo;
import com.maintenance.repo.SOP_ShaftBalancingNewMappedRepo;
import com.maintenance.repo.SOP_ShaftBalancingNewRepo;
import com.maintenance.repo.SOP_ShaftBalancingRepo;
import com.maintenance.repo.SOP_SpareRequiredRepo;
import com.maintenance.repo.SOP_SpindleClearanceInspectionRepo;
import com.maintenance.repo.SOP_SpindleDisassemblingRepo;
import com.maintenance.repo.SOP_TimeSpentSpindleServiceRepo;
import com.maintenance.repo.SOP_VisualInspectionRepo;
import com.maintenance.repo.SOP_WashingCleaningRepo;
import com.maintenance.repo.Sop_SpindleRunOutInspectionRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class SOPServiceImpl implements SOPService{

	
	
	@Autowired
	SOPRepo sOPRepo;
	@Autowired
	SOPStageStatusRepo sOPStageStatusRepo;
	@Autowired
	SOP_VisualInspectionRepo visualInspectionRepo;
	@Autowired
	SOP_PowerCablesRepo powerCablesRepo;
	@Autowired
	SOP_BearingInspectionRepo bearingInspectionRepo;
	@Autowired
	SOP_SpindleDisassemblingRepo  spindleDisassemblingRepo;
	@Autowired
	SOP_RCFARepo rCFARepo;
	@Autowired
	SOP_BearingRepo bearingRepo;
	@Autowired
	SOP_WashingCleaningRepo washingCleaningRepo;
	@Autowired
	SOP_InOutCoolentRepo inOutCoolentRepo;
	@Autowired
	SOP_IncomingTestInspectionRepo incomingTestInspectionRepo;
	
	@Autowired
	SOP_BearingConditionRepo bearingCondtionRepo;
	
	@Autowired
	SOP_MotorCheckDisassemblyRepo motorCheckDisassemblyRepo;
	
	@Autowired
	SOP_ColloingSystemInspectionRepo colloingSystemInspectionRepo;
	
	@Autowired
	SOP_RotaryUnitRepo rotaryUnitRepo;
	
	@Autowired
	SOP_ComponentInspection_1Repo componentInspection1Repo;
	 
	@Autowired
	SOP_ComponentInspection_2Repo componentInspection2Repo;
	 
	@Autowired
	SOP_ComponentInspection_3Repo componentInspection3Repo;
	
	
	
	@Autowired
	SOP_ComponentInspection_1_19Repo componentInspection1_19Repo;
	 
	@Autowired
	SOP_ComponentInspection_2_19Repo componentInspection2_19Repo;
	 
	@Autowired
	SOP_ComponentInspection_3_19Repo componentInspection3_19Repo;
	
	@Autowired
	SOP_SpareRequiredRepo spareRequiredRepo;
	@Autowired
	SOP_ClampingSystemSensorsRepo clampingSystemSensorsRepo;
	
	@Autowired
	SOP_EncoderRepo encoderRepo;
	
	@Autowired
	SOP_DrawbarSpringInspectionRepo drawbarSpringInspectionRepo;
	
	@Autowired
	SOP_LubricationSystemInspectionRepo  lubricationSystemInspectionRepo;
	
	@Autowired
	SOP_SealingInspectionRepo sealingInspectionRepo;
	
	@Autowired
	SOP_ShaftBalancingRepo shaftBalancingRepo;
	@Autowired
	Sop_SpindleRunOutInspectionRepo spindleRunOutInspectionRepo;

	
	@Autowired
	SOP_TimeSpentSpindleServiceRepo timeSpentSpindleServiceRepo;
	@Autowired
	SOP_SpindleClearanceInspectionRepo  spindleClearanceInspectionRepo;
	
	@Autowired
	SOP_RunningTestResult2Repo runningTestResult2Repo;
	@Autowired
	SOP_RunningTestResultsRepo runningTestResultsRepo;
	
	@Autowired
	SOP_RearSideBearingClearanceRepo rearSideBearingClearanceRepo;
	@Autowired
	SOP_PositiveLockFrontSideBearingRepo positiveLockFrontSideBearingRepo;
	@Autowired
	SOP_BeltInspectionRepo beltInspectionRepo;
	
	@Autowired
	SOP_DrawbarAssemblingRepo drawbarAssemblingRepo;
	
	
	@Autowired
	SOP_ShaftBalancingNewRepo shaftBalancingNewRepo;
	@Autowired
	SOP_ShaftBalancingNewMappedRepo  shaftBalancingNewMappedRepo;
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSOP(com.maintenance.model.SOP)
	 */
	@Override
	public void addSOP(SOP sop) {
		// TODO Auto-generated method stub
		sop.setStatus("Intiated");
		sop.setPrimaryStatus("Intiated");
		sop.setSecondaryStatus("Intiated");
		SOP sop2=sOPRepo.save(sop);
		
		for(int i=1;i<=33;i++){
			SOPStageStatus sopStageStatus = new SOPStageStatus();
			sopStageStatus.setAdded_date(new Date());
			sopStageStatus.setStageNo(i);
			sopStageStatus.setStatus("Not Attempt");
			sopStageStatus.setSop(sop2);
			if(i<=18){
				sopStageStatus.setStageType("Primary Inspeaction");
				
			}else{
				sopStageStatus.setStageType("Secondary Inspeaction");
			
			}
			if(i==1){
				sopStageStatus.setStageName("Technician");
				sopStageStatus.setStatus("Completed");
			}
			if(i==2){
				sopStageStatus.setStageName("Spindle Data");
				sopStageStatus.setStatus("Completed");
			}
			if(i==3){
				sopStageStatus.setStageName("Visual Inspection");
			}
			if(i==4){
				sopStageStatus.setStageName("Incoming Test Inspection");
			}
			if(i==5){
				sopStageStatus.setStageName("Power Cables,Visual check");
			}
			if(i==6){
				sopStageStatus.setStageName("Spindle Disassembling");
			}
			if(i==7){
				sopStageStatus.setStageName("Bearing Inspection");
			}
			if(i==8){
				sopStageStatus.setStageName("Bearing Condition");
			}
			if(i==9){
				sopStageStatus.setStageName("RCFA for Bearing Failure");
			}
			if(i==10){
				sopStageStatus.setStageName("New Brearing");
			}
			if(i==11){
				sopStageStatus.setStageName("Motor check After disassembly");
			}
			if(i==12){
				sopStageStatus.setStageName("Washing & Cleaning");
			}
			if(i==13){
				sopStageStatus.setStageName("In & Outlet Coolent/Air/Lub/Clamping Identifying & Marking");
			}
			if(i==14){
				sopStageStatus.setStageName("Cooling System Inspection");
			}
			if(i==15){
				sopStageStatus.setStageName("Rotary Unit");
			}
			if(i==16){
				sopStageStatus.setStageName("COMPONENT INSPECTION");
			}
			if(i==17){
				sopStageStatus.setStageName("Positive lock when received from customer");
				sopStageStatus.setStatus("Completed");
			}
			if(i==18){
				sopStageStatus.setStageName(" Spares Required");
			}
			if(i==19){
				sopStageStatus.setStageName("COMPONENT INSPECTION ( Before assembly & after Machining)");
			}
			if(i==20){
				sopStageStatus.setStageName("Positive lock Front side Bearing set");
			}
			if(i==21){
				sopStageStatus.setStageName("Positive lock Rear side Bearing set");
			}
			if(i==22){
				sopStageStatus.setStageName("Clamping system sensors");
			}
			if(i==23){
				sopStageStatus.setStageName("Encoder");
			}
			if(i==24){
				sopStageStatus.setStageName("Belt Inspection");
			}
			if(i==25){
				sopStageStatus.setStageName("Drawbar Spring Inspection");
			}
			if(i==26){
				sopStageStatus.setStageName("Lubrication System Inspection");
			}
			if(i==27){
				sopStageStatus.setStageName("Sealing Inspection");
			}
			if(i==28){
				sopStageStatus.setStageName("Shaft Balancing :");
			}
			if(i==29){
				sopStageStatus.setStageName("Drawbar assembling & Pull force test");
			}
			if(i==30){
				sopStageStatus.setStageName("Spindle Run Out Inspection");
			}
			if(i==31){
				sopStageStatus.setStageName("Spindle Clearance Inspection");
			}
			if(i==32){
				sopStageStatus.setStageName("RUNNING TEST RESULTS");
			}
			if(i==33){
				sopStageStatus.setStageName("Time spent on spindle service");
			}
			
			
			sOPStageStatusRepo.save(sopStageStatus);
		}
		
	}
	
	@Override
	public void checkPrimaryInspectionClosed(int  sopId) {
		int stageCompletedCount=sOPStageStatusRepo.getNoOfPrimaryInspectinStageCompletedBySOPId(sopId);
		Optional<SOP> optional= sOPRepo.findById(sopId);
		SOP sop=optional.get();
		if(stageCompletedCount==18){
			
			sop.setPrimaryStatus("Completed");
			if(sop.getSecondaryStatus().equalsIgnoreCase("Completed")){
				sop.setStatus("Completed");
			}
			
		}else{
			sop.setStatus("InProcess");
		}
		
		sOPRepo.save(sop);

	}
	@Override
	public void checkSecondaryInspectionClosed(int  sopId) {
		int stageCompletedCount=sOPStageStatusRepo.getNoOfFinaleInspectinStageCompletedBySOPId(sopId);
	System.out.println("NO Of TOTAL STAGE COMPLETED :: "+stageCompletedCount);
		
		if(stageCompletedCount==15){
			Optional<SOP> optional= sOPRepo.findById(sopId);
			SOP sop=optional.get();
			sop.setSecondaryStatus("Completed");
			if(sop.getPrimaryStatus().equalsIgnoreCase("Completed")){
				sop.setStatus("Completed");
			}
			sOPRepo.save(sop);
		}

	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getInProcessSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getInProcessSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getInProcessSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPendingSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getPendingSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getPendingSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getCompletedSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getCompletedSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getCompletedSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOPStagesBySOP(int)
	 */
	@Override
	public List<SOPStageStatus> getPrimarySOPStagesBySOP(int sopId) {
		// TODO Auto-generated method stub
		return sOPStageStatusRepo.getPrimarySOPStagesBySOP(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSecondarySOPStagesBySOP(int)
	 */
	@Override
	public List<SOPStageStatus> getSecondarySOPStagesBySOP(int sopId) {
		// TODO Auto-generated method stub
		return sOPStageStatusRepo.getSecondarySOPStagesBySOP(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getVisualIspectionBySOPId(int)
	 */
	@Override
	public List<SOP_VisualInspection> getVisualIspectionBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return visualInspectionRepo.getVisualIspectionBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addVisualInspection(com.maintenance.model.SOP_VisualInspection)
	 */
	@Override
	public void addVisualInspection(SOP_VisualInspection sop_VisualInspection) {
		// TODO Auto-generated method stub
		visualInspectionRepo.save(sop_VisualInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getVisualIspectionById(int)
	 */
	@Override
	public Optional<SOP_VisualInspection> getVisualIspectionById(int id) {
		// TODO Auto-generated method stub
		return visualInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPowerCableBySOPId(int)
	 */
	@Override
	public Optional<SOP_PowerCables> getPowerCableBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return powerCablesRepo.getPowerCableBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPowerCableById(int)
	 */
	@Override
	public Optional<SOP_PowerCables> getPowerCableById(int id) {
		// TODO Auto-generated method stub
		return powerCablesRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addPowerCable(com.maintenance.model.SOP_PowerCables)
	 */
	@Override
	public void addPowerCable(SOP_PowerCables powerCables) {
		// TODO Auto-generated method stub
		powerCablesRepo.save(powerCables);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getAllSOPByPagination(int, int)
	 */
	@Override
	public List<SOP> getAllSOPByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return sOPRepo.getAllSOPByPagination(page_no,item_per_page);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getAllSOPCount()
	 */
	@Override
	public int getAllSOPCount() {
		// TODO Auto-generated method stub
		return sOPRepo.getAllSOPCount();
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getAllSOPByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<SOP> getAllSOPByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return sOPRepo.getAllSOPByPaginationAndSerach(page_no,item_per_page,search);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getAllSOPCountBySearch(java.lang.String)
	 */
	@Override
	public int getAllSOPCountBySearch(String search) {
		// TODO Auto-generated method stub
		return sOPRepo.getAllSOPCountBySearch(search);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletVisualInspection(com.maintenance.model.SOP_VisualInspection)
	 */
	@Override
	public void deletVisualInspection(SOP_VisualInspection sop_VisualInspection) {
		// TODO Auto-generated method stub
		visualInspectionRepo.delete(sop_VisualInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSopById(int)
	 */
	@Override
	public Optional<SOP> getSopById(int sopId) {
		// TODO Auto-generated method stub
		return sOPRepo.findById(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingIspectionBySOPId(int)
	 */
	@Override
	public List<SOP_BearingInspection> getBearingIspectionBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingInspectionRepo.getBearingIspectionBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingIspectionById(int)
	 */
	@Override
	public Optional<SOP_BearingInspection> getBearingIspectionById(int id) {
		// TODO Auto-generated method stub
		return bearingInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addBearingInspection(com.maintenance.model.SOP_BearingInspection)
	 */
	@Override
	public void addBearingInspection(SOP_BearingInspection sop_BearingInspection) {
		// TODO Auto-generated method stub
		bearingInspectionRepo.save(sop_BearingInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletBearingInspection(com.maintenance.model.SOP_BearingInspection)
	 */
	@Override
	public void deletBearingInspection(SOP_BearingInspection sop_BearingInspection) {
		// TODO Auto-generated method stub
		bearingInspectionRepo.delete(sop_BearingInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleDisassemblingBySOPId(int)
	 */
	@Override
	public List<SOP_SpindleDisassembling> getSpindleDisassemblingBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return spindleDisassemblingRepo.getSpindleDisassemblingBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleDisassembling(com.maintenance.model.SOP_SpindleDisassembling)
	 */
	@Override
	public void addSpindleDisassembling(SOP_SpindleDisassembling sop_SpindleDisassembling) {
		// TODO Auto-generated method stub
		spindleDisassemblingRepo.save(sop_SpindleDisassembling);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindleDisassembling(com.maintenance.model.SOP_SpindleDisassembling)
	 */
	@Override
	public void deletSpindleDisassembling(SOP_SpindleDisassembling sop_SpindleDisassembling) {
		// TODO Auto-generated method stub
		spindleDisassemblingRepo.delete(sop_SpindleDisassembling);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleDisassemblingById(int)
	 */
	@Override
	public Optional<SOP_SpindleDisassembling> getSpindleDisassemblingById(int id) {
		// TODO Auto-generated method stub
		return spindleDisassemblingRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRCFABySOPId(int)
	 */
	@Override
	public Optional<SOP_RCFA> getRCFABySOPId(int sopId) {
		// TODO Auto-generated method stub
		return rCFARepo.getRCFABySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRCFAById(int)
	 */
	@Override
	public Optional<SOP_RCFA> getRCFAById(int id) {
		// TODO Auto-generated method stub
		return rCFARepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRCFA(com.maintenance.model.SOP_RCFA)
	 */
	@Override
	public void addRCFA(SOP_RCFA rcfa) {
		// TODO Auto-generated method stub
			rCFARepo.save(rcfa);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletRCF(com.maintenance.model.SOP_RCFA)
	 */
	@Override
	public void deletRCF(SOP_RCFA rcfa) {
		// TODO Auto-generated method stub
		rCFARepo.delete(rcfa);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingBySOPId(int)
	 */
	@Override
	public List<SOP_Bearing> getBearingBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingRepo.getBearingBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingById(int)
	 */
	@Override
	public Optional<SOP_Bearing> getBearingById(int id) {
		// TODO Auto-generated method stub
		return bearingRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addBearing(com.maintenance.model.SOP_Bearing)
	 */
	@Override
	public void addBearing(SOP_Bearing sop_Bearing) {
		// TODO Auto-generated method stub
		bearingRepo.save(sop_Bearing);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletBearing(com.maintenance.model.SOP_Bearing)
	 */
	@Override
	public void deletBearing(SOP_Bearing sop_Bearing) {
		// TODO Auto-generated method stub
		bearingRepo.delete(sop_Bearing);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getWashingCleaningById(int)
	 */
	@Override
	public Optional<SOP_WashingCleaning> getWashingCleaningById(int id) {
		// TODO Auto-generated method stub
		return washingCleaningRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addWashingCleaning(com.maintenance.model.SOP_WashingCleaning)
	 */
	@Override
	public void addWashingCleaning(SOP_WashingCleaning washingCleaning) {
		// TODO Auto-generated method stub
		washingCleaningRepo.save(washingCleaning);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletWashingCleaning(com.maintenance.model.SOP_WashingCleaning)
	 */
	@Override
	public void deletWashingCleaning(SOP_WashingCleaning washingCleaning) {
		// TODO Auto-generated method stub
		washingCleaningRepo.delete(washingCleaning);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getWashingCleaningBySOPId(int)
	 */
	@Override
	public Optional<SOP_WashingCleaning> getWashingCleaningBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return washingCleaningRepo.getWashingCleaningBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getInOutCoolentBySOPId(int)
	 */
	@Override
	public Optional<SOP_InOutCoolent> getInOutCoolentBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return inOutCoolentRepo.getInOutCoolentBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getInOutCoolentById(int)
	 */
	@Override
	public Optional<SOP_InOutCoolent> getInOutCoolentById(int id) {
		// TODO Auto-generated method stub
		return inOutCoolentRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addInOutCoolent(com.maintenance.model.SOP_InOutCoolent)
	 */
	@Override
	public void addInOutCoolent(SOP_InOutCoolent inOutCoolent) {
		// TODO Auto-generated method stub
		inOutCoolentRepo.save(inOutCoolent);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletInOutCoolent(com.maintenance.model.SOP_InOutCoolent)
	 */
	@Override
	public void deletInOutCoolent(SOP_InOutCoolent inOutCoolent) {
		// TODO Auto-generated method stub
		inOutCoolentRepo.delete(inOutCoolent);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getIncomingTestInspectionBySOPId(int)
	 */
	@Override
	public List<SOP_IncomingTestInspection> getIncomingTestInspectionBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return incomingTestInspectionRepo.getIncomingTestInspectionBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getIncomingTestInspectionById(int)
	 */
	@Override
	public Optional<SOP_IncomingTestInspection> getIncomingTestInspectionById(int id) {
		// TODO Auto-generated method stub
		return incomingTestInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addIncomingTestInspection(com.maintenance.model.SOP_IncomingTestInspection)
	 */
	@Override
	public void addIncomingTestInspection(SOP_IncomingTestInspection sop_IncomingTestInspection) {
		// TODO Auto-generated method stub
		incomingTestInspectionRepo.save(sop_IncomingTestInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletIncomingTestInspection(com.maintenance.model.SOP_IncomingTestInspection)
	 */
	@Override
	public void deletIncomingTestInspection(SOP_IncomingTestInspection sop_IncomingTestInspection) {
		// TODO Auto-generated method stub
		incomingTestInspectionRepo.delete(sop_IncomingTestInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingConditionBySOPIdAndItem(int, java.lang.String)
	 */
	@Override
	public Optional<SOP_BearingCondition> getBearingConditionBySOPIdAndItem(int sopId, String item) {
		// TODO Auto-generated method stub
		return bearingCondtionRepo.getBearingConditionBySOPIdAndItem(sopId,item);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingConditionById(int)
	 */
	@Override
	public Optional<SOP_BearingCondition> getBearingConditionById(int id) {
		// TODO Auto-generated method stub
		return bearingCondtionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addBearingCondition(com.maintenance.model.SOP_BearingInspection)
	 */
	@Override
	public void addBearingCondition(SOP_BearingCondition bearingCondition) {
		// TODO Auto-generated method stub
		bearingCondtionRepo.save(bearingCondition);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getMotorCheckDisassemblyBySOPId(int)
	 */
	@Override
	public Optional<SOP_MotorCheckDisassembly> getMotorCheckDisassemblyBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return motorCheckDisassemblyRepo.getMotorCheckDisassemblyBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getMotorCheckDisassemblyById(int)
	 */
	@Override
	public Optional<SOP_MotorCheckDisassembly> getMotorCheckDisassemblyById(int id) {
		// TODO Auto-generated method stub
		return motorCheckDisassemblyRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addMotorCheckDisassembly(com.maintenance.model.SOP_MotorCheckDisassembly)
	 */
	@Override
	public void addMotorCheckDisassembly(SOP_MotorCheckDisassembly sop_MotorCheckDisassembly) {
		// TODO Auto-generated method stub
		motorCheckDisassemblyRepo.save(sop_MotorCheckDisassembly);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletMotorCheckDisassembly(com.maintenance.model.SOP_MotorCheckDisassembly)
	 */
	@Override
	public void deletMotorCheckDisassembly(SOP_MotorCheckDisassembly sop_MotorCheckDisassembly) {
		// TODO Auto-generated method stub
		motorCheckDisassemblyRepo.delete(sop_MotorCheckDisassembly);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getColloingSystemInspectionBySOPId(int)
	 */
	@Override
	public Optional<SOP_ColloingSystemInspection> getColloingSystemInspectionBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return colloingSystemInspectionRepo.getColloingSystemInspectionBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getColloingSystemInspectionById(int)
	 */
	@Override
	public Optional<SOP_ColloingSystemInspection> getColloingSystemInspectionById(int id) {
		// TODO Auto-generated method stub
		return colloingSystemInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addColloingSystemInspection(com.maintenance.model.SOP_ColloingSystemInspection)
	 */
	@Override
	public void addColloingSystemInspection(SOP_ColloingSystemInspection colloingSystemInspection) {
		// TODO Auto-generated method stub
		colloingSystemInspectionRepo.save(colloingSystemInspection);
		
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRotaryUnitById(int)
	 */
	@Override
	public Optional<SOP_RotaryUnit> getRotaryUnitById(int id) {
		// TODO Auto-generated method stub
		return rotaryUnitRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRotaryUnit(com.maintenance.model.SOP_RotaryUnit)
	 */
	@Override
	public void addRotaryUnit(SOP_RotaryUnit rotaryUnit) {
		// TODO Auto-generated method stub
		rotaryUnitRepo.save(rotaryUnit);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRotaryUnitBySOPId(int)
	 */
	@Override
	public Optional<SOP_RotaryUnit> getRotaryUnitBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return rotaryUnitRepo.getRotaryUnitBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection1BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_1> getComponentInspection1BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection1Repo.getComponentInspection1BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_1ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_1> getSOP_ComponentInspection_1ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection1Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection1(com.maintenance.model.SOP_ComponentInspection_1)
	 */
	@Override
	public void addComponentInspection1(SOP_ComponentInspection_1 componentInspection_1) {
		// TODO Auto-generated method stub
		componentInspection1Repo.save(componentInspection_1);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection2BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_2> getComponentInspection2BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection2Repo.getComponentInspection2BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_2ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_2> getSOP_ComponentInspection_2ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection2Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection2(com.maintenance.model.SOP_ComponentInspection_2)
	 */
	@Override
	public void addComponentInspection2(SOP_ComponentInspection_2 componentInspection_2) {
		// TODO Auto-generated method stub
		componentInspection2Repo.save(componentInspection_2);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_3ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_3> getSOP_ComponentInspection_3ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection3Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection3(com.maintenance.model.SOP_ComponentInspection_3)
	 */
	@Override
	public void addComponentInspection3(SOP_ComponentInspection_3 componentInspection_3) {
		// TODO Auto-generated method stub
		componentInspection3Repo.save(componentInspection_3);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection3BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_3> getComponentInspection3BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection3Repo.getComponentInspection3BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_SpareRequiredBySOPId(int)
	 */
	@Override
	public List<SOP_SpareRequired> getSOP_SpareRequiredBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return spareRequiredRepo.getSOP_SpareRequiredBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getspareRequiredById(int)
	 */
	@Override
	public Optional<SOP_SpareRequired> getspareRequiredById(int id) {
		// TODO Auto-generated method stub
		return spareRequiredRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpareRequired(com.maintenance.model.SOP_SpareRequired)
	 */
	@Override
	public void addSpareRequired(SOP_SpareRequired spareRequired) {
		// TODO Auto-generated method stub
		spareRequiredRepo.save(spareRequired);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleCSSById(int)
	 */
	@Override
	public Optional<SOP_ClampingSystemSensors> getSpindleCSSById(int id) {
		// TODO Auto-generated method stub
		return clampingSystemSensorsRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleCSS(com.maintenance.model.SOP_ClampingSystemSensors)
	 */
	@Override
	public void addSpindleCSS(SOP_ClampingSystemSensors spindleCSS) {
		// TODO Auto-generated method stub
		clampingSystemSensorsRepo.save(spindleCSS);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindeCSS(com.maintenance.model.SOP_ClampingSystemSensors)
	 */
	@Override
	public void deletSpindeCSS(SOP_ClampingSystemSensors spindleCSS) {
		// TODO Auto-generated method stub
		clampingSystemSensorsRepo.delete(spindleCSS);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleCSSBySOPId(int)
	 */
	@Override
	public Optional<SOP_ClampingSystemSensors> getSpindleCSSBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return clampingSystemSensorsRepo.getSpindleCSSBySopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleEncoderById(int)
	 */
	@Override
	public Optional<SOP_Encoder> getSpindleEncoderById(int id) {
		// TODO Auto-generated method stub
		return encoderRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleEncoder(com.maintenance.model.SOP_Encoder)
	 */
	@Override
	public void addSpindleEncoder(SOP_Encoder spindleEncoder) {
		// TODO Auto-generated method stub
		encoderRepo.save(spindleEncoder);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindeEncoder(com.maintenance.model.SOP_Encoder)
	 */
	@Override
	public void deletSpindeEncoder(SOP_Encoder spindleEncoder) {
		// TODO Auto-generated method stub
		encoderRepo.delete(spindleEncoder);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleEncoderBySOPId(int)
	 */
	@Override
	public Optional<SOP_Encoder> getSpindleEncoderBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return encoderRepo.getSpindleEncoderBySopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleDSIById(int)
	 */
	@Override
	public Optional<SOP_DrawbarSpringInspection> getSpindleDSIById(int id) {
		// TODO Auto-generated method stub
		return drawbarSpringInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleDSI(com.maintenance.model.SOP_DrawbarSpringInspection)
	 */
	@Override
	public void addSpindleDSI(SOP_DrawbarSpringInspection spindleDSI) {
		// TODO Auto-generated method stub
		drawbarSpringInspectionRepo.save(spindleDSI);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindeDSI(com.maintenance.model.SOP_DrawbarSpringInspection)
	 */
	@Override
	public void deletSpindeDSI(SOP_DrawbarSpringInspection spindleDSI) {
		// TODO Auto-generated method stub
		drawbarSpringInspectionRepo.delete(spindleDSI);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleDSIBySOPId(int)
	 */
	@Override
	public Optional<SOP_DrawbarSpringInspection> getSpindleDSIBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return drawbarSpringInspectionRepo.getSpindleDSIBySopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleLSI(com.maintenance.model.SOP_LubricationSystemInspection)
	 */
	@Override
	public void addSpindleLSI(SOP_LubricationSystemInspection spindleLSI) {
		// TODO Auto-generated method stub
		lubricationSystemInspectionRepo.save(spindleLSI);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleLSIById(int)
	 */
	@Override
	public Optional<SOP_LubricationSystemInspection> getSpindleLSIById(int id) {
		// TODO Auto-generated method stub
		return lubricationSystemInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindeLSI(com.maintenance.model.SOP_LubricationSystemInspection)
	 */
	@Override
	public void deletSpindeLSI(SOP_LubricationSystemInspection spindleLSI) {
		// TODO Auto-generated method stub
		lubricationSystemInspectionRepo.delete(spindleLSI);
	}
	@Override
	public Optional<SOP_LubricationSystemInspection> getSpindleLSIbySopId(int sopId) {
		// TODO Auto-generated method stub
		return lubricationSystemInspectionRepo.getSpindleLSIBySopId(sopId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleSIById(int)
	 */
	@Override
	public Optional<SOP_SealingInspection> getSpindleSIById(int id) {
		// TODO Auto-generated method stub
		return sealingInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletSpindeSI(com.maintenance.model.SOP_SealingInspection)
	 */
	@Override
	public void deletSpindeSI(SOP_SealingInspection spindleSI) {
		// TODO Auto-generated method stub
		sealingInspectionRepo.delete(spindleSI);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleSIBySOPId(int)
	 */
	@Override
	public Optional<SOP_SealingInspection> getSpindleSIBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return sealingInspectionRepo.getSpindleSIBySopId(sopId);
	}
	@Override
	public void addSpindleSI(SOP_SealingInspection spindleSI) {
		// TODO Auto-generated method stub
		sealingInspectionRepo.save(spindleSI)	;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSopStaffBalanceById(int)
	 */
	@Override
	public Optional<SOP_ShaftBalancing> getSopStaffBalanceById(int id) {
		// TODO Auto-generated method stub
		return shaftBalancingRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpidleStaffBalancing(com.maintenance.model.SOP_ShaftBalancing)
	 */
	@Override
	public void addSpidleStaffBalancing(SOP_ShaftBalancing spindleStaffBalance) {
		// TODO Auto-generated method stub
		shaftBalancingRepo.save(spindleStaffBalance);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletStaffBalance(com.maintenance.model.SOP_ShaftBalancing)
	 */
	@Override
	public void deletStaffBalance(SOP_ShaftBalancing sopStaffBalance) {
		// TODO Auto-generated method stub
		shaftBalancingRepo.delete(sopStaffBalance);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleStaffBalanceBySOPId(int)
	 */
	@Override
	public Optional<SOP_ShaftBalancing> getSpindleStaffBalanceBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return shaftBalancingRepo.getStaffBalanceBySopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRunOutInspection(com.maintenance.model.SOP_SpindleRunOutInspection)
	 */
	@Override
	public void addRunOutInspection(SOP_SpindleRunOutInspection sopRunOutInspection) {
		// TODO Auto-generated method stub
		spindleRunOutInspectionRepo.save(sopRunOutInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#deletRunOutInspection(com.maintenance.model.SOP_SpindleRunOutInspection)
	 */
	@Override
	public void deletRunOutInspection(SOP_SpindleRunOutInspection sopRunOutInspection) {
		// TODO Auto-generated method stub
		spindleRunOutInspectionRepo.delete(sopRunOutInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleROIBySOPId(int)
	 */
	@Override
	public Optional<SOP_SpindleRunOutInspection> getSpindleROIBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return spindleRunOutInspectionRepo.getSpindleROIBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSopRunningTestById(int)
	 */

	@Override
	public Optional<SOP_SpindleRunOutInspection> getSpindleRunOutInspectionById(int id) {
		// TODO Auto-generated method stub
		return spindleRunOutInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPendingSOPFinalByEnginner(int)
	 */
	@Override
	public List<SOP> getPendingSOPFinalByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOPById(int)
	 */
	@Override
	public Optional<SOP> getSOPById(int sopId) {
		// TODO Auto-generated method stub
		return sOPRepo.findById(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleClearanceInspectionBySOPId(int)
	 */
	@Override
	public Optional<SOP_SpindleClearanceInspection> getSpindleClearanceInspectionBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return spindleClearanceInspectionRepo.getSpindleClearanceInspectionBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleClearanceInspectionById(int)
	 */
	@Override
	public Optional<SOP_SpindleClearanceInspection> getSpindleClearanceInspectionById(int id) {
		// TODO Auto-generated method stub
		return spindleClearanceInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpindleClearanceInspection(com.maintenance.model.SOP_SpindleClearanceInspection)
	 */
	@Override
	public void addSpindleClearanceInspection(SOP_SpindleClearanceInspection spindleClearanceInspection) {
		// TODO Auto-generated method stub
		spindleClearanceInspectionRepo.save(spindleClearanceInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getTimeSpentSpindleServiceSopId(int)
	 */
	@Override
	public Optional<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceSopId(int sopId) {
		// TODO Auto-generated method stub
		return timeSpentSpindleServiceRepo.getTimeSpentSpindleServiceSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getTimeSpentSpindleServiceById(int)
	 */
	@Override
	public Optional<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceById(int id) {
		// TODO Auto-generated method stub
		return timeSpentSpindleServiceRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addTimeSpentSpindleService(com.maintenance.model.SOP_TimeSpentSpindleService)
	 */
	@Override
	public void addTimeSpentSpindleService(SOP_TimeSpentSpindleService spindleClearanceInspection) {
		// TODO Auto-generated method stub
		timeSpentSpindleServiceRepo.save(spindleClearanceInspection);
	}


	@Override
	public Optional<SOP_RunningTestResult2> getRunningTestResult2SopId(int sopId) {
		// TODO Auto-generated method stub
		return runningTestResult2Repo.getRunningTestResult2SopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRunningTestResult2nById(int)
	 */
	@Override
	public Optional<SOP_RunningTestResult2> getRunningTestResult2nById(int id) {
		// TODO Auto-generated method stub
		return runningTestResult2Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRunningTestResult2(com.maintenance.model.SOP_RunningTestResult2)
	 */
	@Override
	public void addRunningTestResult2(SOP_RunningTestResult2 runningTestResult) {
		// TODO Auto-generated method stub
		runningTestResult2Repo.save(runningTestResult);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRunningTestResultbySopId(int)
	 */

	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRunningTestResultById(int)
	 */
	@Override
	public Optional<SOP_RunningTestResult> getRunningTestResultById(int id) {
		// TODO Auto-generated method stub
		return runningTestResultsRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRunningTestResult(com.maintenance.model.SOP_RunningTestResult)
	 */
	@Override
	public void addRunningTestResult(SOP_RunningTestResult runningTestResult) {
		// TODO Auto-generated method stub
		runningTestResultsRepo.save(runningTestResult);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRunningTestResultbySopId(int)
	 */
	@Override
	public List<SOP_RunningTestResult> getRunningTestResultbySopId(int sopId) {
		// TODO Auto-generated method stub
		return runningTestResultsRepo.getRunningTestResultsBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection1_19BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_1_19> getComponentInspection1_19BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection1_19Repo.getComponentInspection1_19BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_1_19ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_1_19> getSOP_ComponentInspection_1_19ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection1_19Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection1_19(com.maintenance.model.SOP_ComponentInspection_1_19)
	 */
	@Override
	public void addComponentInspection1_19(SOP_ComponentInspection_1_19 componentInspection_1) {
		// TODO Auto-generated method stub
		componentInspection1_19Repo.save(componentInspection_1);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection2_19BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_2_19> getComponentInspection2_19BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection2_19Repo.getComponentInspection2_19BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_2_19ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_2_19> getSOP_ComponentInspection_2_19ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection2_19Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection2_19(com.maintenance.model.SOP_ComponentInspection_2_19)
	 */
	@Override
	public void addComponentInspection2_19(SOP_ComponentInspection_2_19 componentInspection_2) {
		// TODO Auto-generated method stub
		componentInspection2_19Repo.save(componentInspection_2);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getComponentInspection3_19BySOPId(int)
	 */
	@Override
	public List<SOP_ComponentInspection_3_19> getComponentInspection3_19BySOPId(int sopId) {
		// TODO Auto-generated method stub
		return componentInspection3_19Repo.getComponentInspection3_19BySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOP_ComponentInspection_3_19ById(int)
	 */
	@Override
	public Optional<SOP_ComponentInspection_3_19> getSOP_ComponentInspection_3_19ById(int id) {
		// TODO Auto-generated method stub
		return componentInspection3_19Repo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addComponentInspection3_19(com.maintenance.model.SOP_ComponentInspection_3_19)
	 */
	@Override
	public void addComponentInspection3_19(SOP_ComponentInspection_3_19 componentInspection_3) {
		// TODO Auto-generated method stub
		componentInspection3_19Repo.save(componentInspection_3);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPositiveLockFrontSideBearingById(int)
	 */
	@Override
	public Optional<SOP_PositiveLockFrontSideBearing> getPositiveLockFrontSideBearingById(int id) {
		// TODO Auto-generated method stub
		return positiveLockFrontSideBearingRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addPositiveLockFrontSideBearing(com.maintenance.model.SOP_PositiveLockFrontSideBearing)
	 */
	@Override
	public void addPositiveLockFrontSideBearing(SOP_PositiveLockFrontSideBearing positiveLockFrontSideBearing) {
		// TODO Auto-generated method stub
		positiveLockFrontSideBearingRepo.save(positiveLockFrontSideBearing);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getPositiveLockFrontSideBearingSopId(int)
	 */
	@Override
	public Optional<SOP_PositiveLockFrontSideBearing> getPositiveLockFrontSideBearingSopId(int sopId) {
		// TODO Auto-generated method stub
		return positiveLockFrontSideBearingRepo.getPositiveLockFrontSideBearingSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRearSideBearingClearanceById(int)
	 */
	@Override
	public Optional<SOP_RearSideBearingClearance> getRearSideBearingClearanceById(int id) {
		// TODO Auto-generated method stub
		return rearSideBearingClearanceRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addRearSideBearingClearance(com.maintenance.model.SOP_RearSideBearingClearance)
	 */
	@Override
	public void addRearSideBearingClearance(SOP_RearSideBearingClearance rearSideBearingClearance) {
		// TODO Auto-generated method stub
		rearSideBearingClearanceRepo.save(rearSideBearingClearance);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getRearSideBearingClearanceSopId(int)
	 */
	@Override
	public Optional<SOP_RearSideBearingClearance> getRearSideBearingClearanceSopId(int sopId) {
		// TODO Auto-generated method stub
		return rearSideBearingClearanceRepo.getRearSideBearingClearanceSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBeltInspectionSopId(int)
	 */
	@Override
	public Optional<SOP_BeltInspection> getBeltInspectionSopId(int sopId) {
		// TODO Auto-generated method stub
		return beltInspectionRepo.getBeltInspectionSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addBeltInspection(com.maintenance.model.SOP_BeltInspection)
	 */
	@Override
	public void addBeltInspection(SOP_BeltInspection beltInspection) {
		// TODO Auto-generated method stub
		beltInspectionRepo.save(beltInspection);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBeltInspectionById(int)
	 */
	@Override
	public Optional<SOP_BeltInspection> getBeltInspectionById(int id) {
		// TODO Auto-generated method stub
		return beltInspectionRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getDrawbarAssemblingnById(int)
	 */
	@Override
	public Optional<SOP_DrawbarAssembling> getDrawbarAssemblingnById(int id) {
		// TODO Auto-generated method stub
		return drawbarAssemblingRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addDrawbarAssembling(com.maintenance.model.SOP_DrawbarAssembling)
	 */
	@Override
	public void addDrawbarAssembling(SOP_DrawbarAssembling drawbarAssembling) {
		// TODO Auto-generated method stub
		drawbarAssemblingRepo.save(drawbarAssembling);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getDrawbarAssemblingSopId(int)
	 */
	@Override
	public Optional<SOP_DrawbarAssembling> getDrawbarAssemblingSopId(int sopId) {
		// TODO Auto-generated method stub
		return drawbarAssemblingRepo.getDrawbarAssemblingSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSOPByServiceRequestID(int)
	 */
	@Override
	public Optional<SOP> getSOPByServiceRequestID(int sprindleServiceRequestId) {
		// TODO Auto-generated method stub
		return sOPRepo.getSOPByServiceRequestID(sprindleServiceRequestId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#updateSOP(com.maintenance.model.SOP)
	 */
	@Override
	public void updateSOP(SOP sop2) {
		// TODO Auto-generated method stub
		sOPRepo.save(sop2);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSpindleStaffBalanceNewBySOPId(int)
	 */
	@Override
	public Optional<SOP_ShaftBalancingNew> getSpindleStaffBalanceNewBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return shaftBalancingNewRepo.getSpindleStaffBalanceNewBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#shaftBalancingNewMappedbySopId(int)
	 */
	@Override
	public List<SOP_ShaftBalancingNewMapped> shaftBalancingNewMappedbySopId(int sopId) {
		// TODO Auto-generated method stub
		return shaftBalancingNewMappedRepo.shaftBalancingNewMappedbySopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getSopStaffBalanceNewById(int)
	 */
	@Override
	public Optional<SOP_ShaftBalancingNew> getSopStaffBalanceNewById(int id) {
		// TODO Auto-generated method stub
		return shaftBalancingNewRepo.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#saveShaftBalancingNewMapped(com.maintenance.model.SOP_ShaftBalancingNewMapped)
	 */
	@Override
	public void saveShaftBalancingNewMapped(SOP_ShaftBalancingNewMapped balancingNewMapped) {
		// TODO Auto-generated method stub
		shaftBalancingNewMappedRepo.save(balancingNewMapped);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addSpidleStaffBalancingNew(com.maintenance.model.SOP_ShaftBalancingNew)
	 */
	@Override
	public void addSpidleStaffBalancingNew(SOP_ShaftBalancingNew spindleStaffBalance) {
		// TODO Auto-generated method stub
		shaftBalancingNewRepo.save(spindleStaffBalance);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getListTimeSpentSpindleServiceSopId(int)
	 */
	@Override
	public List<SOP_TimeSpentSpindleService> getListTimeSpentSpindleServiceSopId(int sopId) {
		// TODO Auto-generated method stub
		return timeSpentSpindleServiceRepo.getListTimeSpentSpindleServiceSopId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getFinalInProcessSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getFinalInProcessSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getFinalInProcessSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getFinalCompletedSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getFinalCompletedSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getFinalCompletedSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getFinalPendingSOPByEnginner(int)
	 */
	@Override
	public List<SOP> getFinalPendingSOPByEnginner(int employeeId) {
		// TODO Auto-generated method stub
		return sOPRepo.getFinalPendingSOPByEnginner(employeeId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addListVisualInspection(java.util.List)
	 */
	@Override
	public void addListVisualInspection(List<SOP_VisualInspection> list) {
		// TODO Auto-generated method stub
		visualInspectionRepo.saveAll(list);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getStageBySOPIdAndStageNo(int, int)
	 */
	@Override
	public SOPStageStatus getStageBySOPIdAndStageNo(int sopId, int stageNo) {
		// TODO Auto-generated method stub
		Optional<SOPStageStatus> optional= sOPStageStatusRepo.getStageBySOPIdAndStageNo(sopId,stageNo);
		return optional.isPresent()?optional.get():null;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#saveSOPStage(com.maintenance.model.SOPStageStatus)
	 */
	@Override
	public void saveSOPStage(SOPStageStatus sopStageStatus) {
		// TODO Auto-generated method stub
		sOPStageStatusRepo.save(sopStageStatus);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getNoOfPrimaryInspectinStageCompletedBySOPId(int)
	 */
	@Override
	public int getNoOfPrimaryInspectinStageCompletedBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return sOPStageStatusRepo.getNoOfPrimaryInspectinStageCompletedBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getNoOfFinaleInspectinStageCompletedBySOPId(int)
	 */
	@Override
	public int getNoOfFinaleInspectinStageCompletedBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return sOPStageStatusRepo.getNoOfFinaleInspectinStageCompletedBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addLisySpindleDisassembling(java.util.List)
	 */
	@Override
	public void addLisySpindleDisassembling(List<SOP_SpindleDisassembling> list) {
		// TODO Auto-generated method stub
		spindleDisassemblingRepo.saveAll(list);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addListBearingInspection(java.util.List)
	 */
	@Override
	public void addListBearingInspection(List<SOP_BearingInspection> list) {
		// TODO Auto-generated method stub
		bearingInspectionRepo.saveAll(list);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#addListSpareRequired(java.util.List)
	 */
	@Override
	public void addListSpareRequired(List<SOP_SpareRequired> list) {
		// TODO Auto-generated method stub
		spareRequiredRepo.saveAll(list);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingIspectionFrontBySOPId(int)
	 */
	@Override
	public List<SOP_BearingInspection> getBearingIspectionFrontBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingInspectionRepo.getBearingIspectionFrontBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getBearingIspectionRearBySOPId(int)
	 */
	@Override
	public List<SOP_BearingInspection> getBearingIspectionRearBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingInspectionRepo.getBearingIspectionRearBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getNewBearingRearBySOPId(int)
	 */
	@Override
	public List<SOP_Bearing> getNewBearingRearBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingRepo.getNewBearingRearBySOPId(sopId);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.SOPService#getNewBearingFrontBySOPId(int)
	 */
	@Override
	public List<SOP_Bearing> getNewBearingFrontBySOPId(int sopId) {
		// TODO Auto-generated method stub
		return bearingRepo.getNewBearingFrontBySOPId(sopId);
	}
	



}



