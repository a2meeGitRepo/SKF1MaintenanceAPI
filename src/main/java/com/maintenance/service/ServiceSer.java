/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import com.maintenance.model.BearringAccessory;
import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.SOP;
import com.maintenance.model.ServiceReason;
import com.maintenance.model.ServiceRequestMappedEnginner;
import com.maintenance.model.SpindleServiceRequest;

/**
 * @author Dattatray Bodhale
 *
 */
public interface ServiceSer {

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<ServiceReason> getServiceReasonByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getServiceReasonCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<ServiceReason> getServiceReasonByPaginationAndSerach(int page_no, int item_per_page, String search);

	/**
	 * @param search
	 * @return
	 */
	int getServiceReasonCountBySearch(String search);

	/**
	 * @return
	 */
	List<ServiceReason> getAllSpindleList();

	/**
	 * @param reasonName
	 * @return
	 */
	Optional<ServiceReason> getServiceReasonByname(String reasonName);

	/**
	 * @param serviceReason
	 */
	void addServiceReason(ServiceReason serviceReason);

	/**
	 * @param page_no
	 * @param item_per_page
	 * @return
	 */
	List<SpindleServiceRequest> getSpindleServiceRequestByPagination(int page_no, int item_per_page);

	/**
	 * @return
	 */
	int getSpindleServiceRequestCount();

	/**
	 * @param page_no
	 * @param item_per_page
	 * @param search
	 * @return
	 */
	List<SpindleServiceRequest> getSpindleServiceRequestByPaginationAndSerach(int page_no, int item_per_page,
			String search);

	/**
	 * @param search
	 * @return
	 */
	int getSpindleServiceRequestCountBySearch(String search);

	/**
	 * @return
	 */
	List<SpindleServiceRequest> getAllSpindleServiceRequestList();

	/**
	 * @param spindleServiceRequest
	 */
	void addSpindleServiceRequest(SpindleServiceRequest spindleServiceRequest);

	/**
	 * @param sscNo
	 * @return
	 */
	Optional<SpindleServiceRequest> getSpindleServiceRequestBySSCNo(String sscNo);

	/**
	 * @return
	 */
	List<ServiceReason> getActiveServiceReasonList();

	/**
	 * @param branchCode
	 * @return
	 */
	String getNewSSCNoForBranch(String branchCode);

	/**
	 * @param bearringAccessory
	 */
	void saveBearringAccessory(BearringAccessory bearringAccessory);

	/**
	 * @param sscNo
	 * @return
	 */
	List<BearringAccessory> getRearBearingBySSCNo(String sscNo);

	/**
	 * @param sscNo
	 * @return
	 */
	List<BearringAccessory> getFrontBearingBySSCNo(String sscNo);

	/**
	 * @param serviceRequestMappedEnginner
	 */
	void saveServiceRequestMappedEnginner(ServiceRequestMappedEnginner serviceRequestMappedEnginner);

	/**
	 * @param i
	 * @return
	 */
	List<SpindleServiceRequest> getSpindleServiceRequestListByEngineer(int i);

	/**
	 * @param engineerId
	 * @return
	 */
	List<ServiceRequestMappedEnginner> getUnApprovedMappedServiceRequestByEng(int engineerId);

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	SpindleServiceRequest getSpindleServiceRequestId(int sprindleServiceRequestId);

	/**
	 * @param qrCode
	 * @return
	 */
	SpindleServiceRequest getSpindleServiceRequestByQRCode(String qrCode);

	/**
	 * @param serviceRequestMappedEnginner
	 */
	void addServiceRequestMappedEnginner(ServiceRequestMappedEnginner serviceRequestMappedEnginner);

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	Optional<ServiceRequestMappedEnginner> getServiceRequestMappedEnginnerByServiceRequest(int sprindleServiceRequestId);

	/**
	 * @param reasonId
	 * @return
	 */
	ServiceReason getServiceReasonById(int reasonId);

	/**
	 * @param sprindleServiceRequestId
	 * @return
	 */
	Optional<SpindleServiceRequest> getSpindleServiceRequestById(int sprindleServiceRequestId);

	/**
	 * @param sopId
	 * @return
	 */
	Optional<SOP> geSOpById(int sopId);

	/**
	 * @param custReqId
	 * @return
	 */
	List<BearringAccessoryCustReq> bearingReqListRearBycustReqId(int custReqId);

	/**
	 * @param custReqId
	 * @return
	 */
	List<BearringAccessoryCustReq> bearingReqListFrontBycustReqId(int custReqId);

	/**
	 * @param string
	 * @return
	 */
	ServiceReason getServiceReasonByName(String string);

	/**
	 * @param request
	 * @return
	 */
	SpindleServiceRequest addSpindleServiceRequestR(SpindleServiceRequest request);

}



