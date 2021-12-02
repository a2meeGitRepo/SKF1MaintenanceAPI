/**
 * Dattatray Bodhale
	14-Jun-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

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

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOPService {

	/**
	 * @param sop
	 */
	void addSOP(SOP sop);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getInProcessSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getPendingSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getCompletedSOPByEnginner(int employeeId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOPStageStatus> getPrimarySOPStagesBySOP(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOPStageStatus> getSecondarySOPStagesBySOP(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_VisualInspection> getVisualIspectionBySOPId(int sopId);

	/**
	 * @param sop_VisualInspection
	 */
	void addVisualInspection(SOP_VisualInspection sop_VisualInspection);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_VisualInspection> getVisualIspectionById(int id);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_PowerCables> getPowerCableBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_PowerCables> getPowerCableById(int id);

	/**
	 * @param powerCables
	 */
	void addPowerCable(SOP_PowerCables powerCables);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<SOP> getAllSOPByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getAllSOPCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<SOP> getAllSOPByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getAllSOPCountBySearch(String search);

	/**
	 * @param sop_VisualInspection
	 */
	void deletVisualInspection(SOP_VisualInspection sop_VisualInspection);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP> getSopById(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_BearingInspection> getBearingIspectionBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_BearingInspection> getBearingIspectionById(int id);

	/**
	 * @param sop_BearingInspection
	 */
	void addBearingInspection(SOP_BearingInspection sop_BearingInspection);

	/**
	 * @param sop_BearingInspection
	 */
	void deletBearingInspection(SOP_BearingInspection sop_BearingInspection);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_SpindleDisassembling> getSpindleDisassemblingBySOPId(int sopId);

	/**
	 * @param sop_SpindleDisassembling
	 */
	void addSpindleDisassembling(SOP_SpindleDisassembling sop_SpindleDisassembling);

	/**
	 * @param sop_SpindleDisassembling
	 */
	void deletSpindleDisassembling(SOP_SpindleDisassembling sop_SpindleDisassembling);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_SpindleDisassembling> getSpindleDisassemblingById(int id);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_RCFA> getRCFABySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_RCFA> getRCFAById(int id);

	/**
	 * @param rcfa
	 */
	void addRCFA(SOP_RCFA rcfa);

	/**
	 * @param rcfa
	 */
	void deletRCF(SOP_RCFA rcfa);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_Bearing> getBearingBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_Bearing> getBearingById(int id);

	/**
	 * @param sop_Bearing
	 */
	void addBearing(SOP_Bearing sop_Bearing);

	/**
	 * @param sop_Bearing
	 */
	void deletBearing(SOP_Bearing sop_Bearing);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_WashingCleaning> getWashingCleaningById(int id);

	/**
	 * @param washingCleaning
	 */
	void addWashingCleaning(SOP_WashingCleaning washingCleaning);

	/**
	 * @param washingCleaning
	 */
	void deletWashingCleaning(SOP_WashingCleaning washingCleaning);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_WashingCleaning> getWashingCleaningBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_InOutCoolent> getInOutCoolentBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_InOutCoolent> getInOutCoolentById(int id);

	/**
	 * @param inOutCoolent
	 */
	void addInOutCoolent(SOP_InOutCoolent inOutCoolent);

	/**
	 * @param inOutCoolent
	 */
	void deletInOutCoolent(SOP_InOutCoolent inOutCoolent);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_IncomingTestInspection> getIncomingTestInspectionBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_IncomingTestInspection> getIncomingTestInspectionById(int id);

	/**
	 * @param sop_IncomingTestInspection
	 */
	void addIncomingTestInspection(SOP_IncomingTestInspection sop_IncomingTestInspection);

	/**
	 * @param sop_IncomingTestInspection
	 */
	void deletIncomingTestInspection(SOP_IncomingTestInspection sop_IncomingTestInspection);

	/**
	 * @param sopId
	 * @param string
	 * @return
	 */
	Optional<SOP_BearingCondition> getBearingConditionBySOPIdAndItem(int sopId, String string);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_BearingCondition> getBearingConditionById(int id);

	/**
	 * @param bearingInspection
	 */
	void addBearingCondition(SOP_BearingCondition SOP_BearingCondition);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_MotorCheckDisassembly> getMotorCheckDisassemblyBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_MotorCheckDisassembly> getMotorCheckDisassemblyById(int id);

	/**
	 * @param sop_MotorCheckDisassembly
	 */
	void addMotorCheckDisassembly(SOP_MotorCheckDisassembly sop_MotorCheckDisassembly);

	/**
	 * @param sop_MotorCheckDisassembly
	 */
	void deletMotorCheckDisassembly(SOP_MotorCheckDisassembly sop_MotorCheckDisassembly);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_ColloingSystemInspection> getColloingSystemInspectionBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ColloingSystemInspection> getColloingSystemInspectionById(int id);

	/**
	 * @param colloingSystemInspection
	 */
	void addColloingSystemInspection(SOP_ColloingSystemInspection colloingSystemInspection);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_RotaryUnit> getRotaryUnitById(int id);

	/**
	 * @param rotaryUnit
	 */
	void addRotaryUnit(SOP_RotaryUnit rotaryUnit);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_RotaryUnit> getRotaryUnitBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_1> getComponentInspection1BySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_1> getSOP_ComponentInspection_1ById(int id);

	/**
	 * @param componentInspection_1
	 */
	void addComponentInspection1(SOP_ComponentInspection_1 componentInspection_1);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_2> getComponentInspection2BySOPId(int sopId);
	
	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_2> getSOP_ComponentInspection_2ById(int id);
	
	/**
	 * @param componentInspection_2
	 */
	void addComponentInspection2(SOP_ComponentInspection_2 componentInspection_2);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_3> getSOP_ComponentInspection_3ById(int id);

	/**
	 * @param componentInspection_3
	 */
	void addComponentInspection3(SOP_ComponentInspection_3 componentInspection_3);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_3> getComponentInspection3BySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_SpareRequired> getSOP_SpareRequiredBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_SpareRequired> getspareRequiredById(int id);

	/**
	 * @param spareRequired
	 */
	void addSpareRequired(SOP_SpareRequired spareRequired);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ClampingSystemSensors> getSpindleCSSById(int id);

	/**
	 * @param spindleCSS
	 */
	void addSpindleCSS(SOP_ClampingSystemSensors spindleCSS);

	/**
	 * @param spindleCSS
	 */
	void deletSpindeCSS(SOP_ClampingSystemSensors spindleCSS);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_ClampingSystemSensors> getSpindleCSSBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_Encoder> getSpindleEncoderById(int id);

	/**
	 * @param spindleEncoder
	 */
	void addSpindleEncoder(SOP_Encoder spindleEncoder);

	/**
	 * @param spindleEncoder
	 */
	void deletSpindeEncoder(SOP_Encoder spindleEncoder);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_Encoder> getSpindleEncoderBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_DrawbarSpringInspection> getSpindleDSIById(int id);

	/**
	 * @param spindleDSI
	 */
	void addSpindleDSI(SOP_DrawbarSpringInspection spindleDSI);

	/**
	 * @param spindleDSI
	 */
	void deletSpindeDSI(SOP_DrawbarSpringInspection spindleDSI);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_DrawbarSpringInspection> getSpindleDSIBySOPId(int sopId);

	/**
	 * @param spindleLSI
	 */
	void addSpindleLSI(SOP_LubricationSystemInspection spindleLSI);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_LubricationSystemInspection> getSpindleLSIById(int id);

	/**
	 * @param spindleLSI
	 */
	void deletSpindeLSI(SOP_LubricationSystemInspection spindleLSI);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_SealingInspection> getSpindleSIById(int id);

	/**
	 * @param spindleSI
	 */
	void deletSpindeSI(SOP_SealingInspection spindleSI);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_SealingInspection> getSpindleSIBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ShaftBalancing> getSopStaffBalanceById(int id);

	/**
	 * @param spindleStaffBalance
	 */
	void addSpidleStaffBalancing(SOP_ShaftBalancing spindleStaffBalance);

	/**
	 * @param sopStaffBalance
	 */
	void deletStaffBalance(SOP_ShaftBalancing sopStaffBalance);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_ShaftBalancing> getSpindleStaffBalanceBySOPId(int sopId);

	/**
	 * @param spindleSI
	 */
	void addSpindleSI(SOP_SealingInspection spindleSI);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_LubricationSystemInspection> getSpindleLSIbySopId(int sopId);

	/**
	 * @param sopRunOutInspection
	 */
	void addRunOutInspection(SOP_SpindleRunOutInspection sopRunOutInspection);

	/**
	 * @param sopRunOutInspection
	 */
	void deletRunOutInspection(SOP_SpindleRunOutInspection sopRunOutInspection);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_SpindleRunOutInspection> getSpindleROIBySOPId(int sopId);





	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_SpindleRunOutInspection> getSpindleRunOutInspectionById(int id);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getPendingSOPFinalByEnginner(int employeeId);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP> getSOPById(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_SpindleClearanceInspection> getSpindleClearanceInspectionBySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_SpindleClearanceInspection> getSpindleClearanceInspectionById(int id);

	/**
	 * @param spindleClearanceInspection
	 */
	void addSpindleClearanceInspection(SOP_SpindleClearanceInspection spindleClearanceInspection);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceSopId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_TimeSpentSpindleService> getTimeSpentSpindleServiceById(int id);

	/**
	 * @param spindleClearanceInspection
	 */
	void addTimeSpentSpindleService(SOP_TimeSpentSpindleService spindleClearanceInspection);




	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_RunningTestResult2> getRunningTestResult2SopId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_RunningTestResult2> getRunningTestResult2nById(int id);

	/**
	 * @param runningTestResult
	 */
	void addRunningTestResult2(SOP_RunningTestResult2 runningTestResult);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_RunningTestResult> getRunningTestResultById(int id);

	/**
	 * @param runningTestResult
	 */
	void addRunningTestResult(SOP_RunningTestResult runningTestResult);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_RunningTestResult> getRunningTestResultbySopId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_1_19> getComponentInspection1_19BySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_1_19> getSOP_ComponentInspection_1_19ById(int id);

	/**
	 * @param componentInspection_1
	 */
	void addComponentInspection1_19(SOP_ComponentInspection_1_19 componentInspection_1);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_2_19> getComponentInspection2_19BySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_2_19> getSOP_ComponentInspection_2_19ById(int id);

	/**
	 * @param componentInspection_2
	 */
	void addComponentInspection2_19(SOP_ComponentInspection_2_19 componentInspection_2);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ComponentInspection_3_19> getComponentInspection3_19BySOPId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ComponentInspection_3_19> getSOP_ComponentInspection_3_19ById(int id);

	/**
	 * @param componentInspection_3
	 */
	void addComponentInspection3_19(SOP_ComponentInspection_3_19 componentInspection_3);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_PositiveLockFrontSideBearing> getPositiveLockFrontSideBearingById(int id);

	/**
	 * @param positiveLockFrontSideBearing
	 */
	void addPositiveLockFrontSideBearing(SOP_PositiveLockFrontSideBearing positiveLockFrontSideBearing);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_PositiveLockFrontSideBearing> getPositiveLockFrontSideBearingSopId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_RearSideBearingClearance> getRearSideBearingClearanceById(int id);

	/**
	 * @param rearSideBearingClearance
	 */
	void addRearSideBearingClearance(SOP_RearSideBearingClearance rearSideBearingClearance);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_RearSideBearingClearance> getRearSideBearingClearanceSopId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_BeltInspection> getBeltInspectionSopId(int sopId);

	/**
	 * @param beltInspection
	 */
	void addBeltInspection(SOP_BeltInspection beltInspection);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_BeltInspection> getBeltInspectionById(int id);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_DrawbarAssembling> getDrawbarAssemblingnById(int id);

	/**
	 * @param drawbarAssembling
	 */
	void addDrawbarAssembling(SOP_DrawbarAssembling drawbarAssembling);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_DrawbarAssembling> getDrawbarAssemblingSopId(int sopId);

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	Optional<SOP> getSOPByServiceRequestID(int sprindleServiceRequestId);

	/**
	 * @param sop2
	 */
	void updateSOP(SOP sop2);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP_ShaftBalancingNew> getSpindleStaffBalanceNewBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_ShaftBalancingNewMapped> shaftBalancingNewMappedbySopId(int sopId);

	/**
	 * @param id
	 * @return
	 */
	Optional<SOP_ShaftBalancingNew> getSopStaffBalanceNewById(int id);

	/**
	 * @param balancingNewMapped
	 */
	void saveShaftBalancingNewMapped(SOP_ShaftBalancingNewMapped balancingNewMapped);

	/**
	 * @param spindleStaffBalance
	 */
	void addSpidleStaffBalancingNew(SOP_ShaftBalancingNew spindleStaffBalance);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_TimeSpentSpindleService> getListTimeSpentSpindleServiceSopId(int sopId);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getFinalInProcessSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getFinalCompletedSOPByEnginner(int employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	List<SOP> getFinalPendingSOPByEnginner(int employeeId);

	/**
	 * @param list
	 */
	void addListVisualInspection(List<SOP_VisualInspection> list);

	/**
	 * @param sopId
	 * @param i
	 * @return
	 */
	SOPStageStatus getStageBySOPIdAndStageNo(int sopId, int i);

	/**
	 * @param sopStageStatus
	 */
	void saveSOPStage(SOPStageStatus sopStageStatus);

	/**
	 * @param sopId
	 * @return
	 */
	int getNoOfPrimaryInspectinStageCompletedBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	int getNoOfFinaleInspectinStageCompletedBySOPId(int sopId);

	/**
	 * @param list
	 */
	void addLisySpindleDisassembling(List<SOP_SpindleDisassembling> list);

	/**
	 * @param list
	 */
	void addListBearingInspection(List<SOP_BearingInspection> list);

	/**
	 * @param list
	 */
	void addListSpareRequired(List<SOP_SpareRequired> list);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_BearingInspection> getBearingIspectionFrontBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_BearingInspection> getBearingIspectionRearBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_Bearing> getNewBearingRearBySOPId(int sopId);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOP_Bearing> getNewBearingFrontBySOPId(int sopId);

	void checkPrimaryInspectionClosed(int sopId);

	void checkSecondaryInspectionClosed(int sopId);



}



