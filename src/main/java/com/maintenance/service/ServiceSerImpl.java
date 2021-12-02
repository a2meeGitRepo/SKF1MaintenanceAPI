/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.BearringAccessory;
import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.SOP;
import com.maintenance.model.ServiceReason;
import com.maintenance.model.ServiceRequestMappedEnginner;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.repo.BearringAccessoryCustReqRepo;
import com.maintenance.repo.BearringAccessoryRepo;
import com.maintenance.repo.SOPRepo;
import com.maintenance.repo.ServiceReasonRepo;
import com.maintenance.repo.ServiceRequestMappedEnginnerRepo;
import com.maintenance.repo.SpindleServiceRequestRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class ServiceSerImpl implements ServiceSer {
	
	@Autowired
	ServiceReasonRepo serviceReasonRepo;
	@Autowired
	SpindleServiceRequestRepo spindleServiceRequestRepo;
	@Autowired
	BearringAccessoryRepo  bearringAccessoryRepo;
	@Autowired
	ServiceRequestMappedEnginnerRepo serviceRequestMappedEnginnerRepo;
	@Autowired
	SOPRepo sOPRepo;
	@Autowired
	BearringAccessoryCustReqRepo bearringAccessoryCustReqRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonByPagination(int, int)
	 */
	@Override
	public List<ServiceReason> getServiceReasonByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getServiceReasonByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonCount()
	 */
	@Override
	public int getServiceReasonCount() {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getServiceReasonCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<ServiceReason> getServiceReasonByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getServiceReasonByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonCountBySearch(java.lang.String)
	 */
	@Override
	public int getServiceReasonCountBySearch(String search) {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getServiceReasonCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getAllSpindleList()
	 */
	@Override
	public List<ServiceReason> getAllSpindleList() {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getAllSpindleList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonByname(java.lang.String)
	 */
	@Override
	public Optional<ServiceReason> getServiceReasonByname(String reasonName) {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getServiceReasonByname(reasonName);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#addServiceReason(com.maintenance.model.ServiceReason)
	 */
	@Override
	public void addServiceReason(ServiceReason serviceReason) {
		// TODO Auto-generated method stub
		serviceReasonRepo.save(serviceReason);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestByPagination(int, int)
	 */
	@Override
	public List<SpindleServiceRequest> getSpindleServiceRequestByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestCount()
	 */
	@Override
	public int getSpindleServiceRequestCount() {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<SpindleServiceRequest> getSpindleServiceRequestByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestCountBySearch(java.lang.String)
	 */
	@Override
	public int getSpindleServiceRequestCountBySearch(String search) {
		// TODO Auto-generated method stub
		return (int) spindleServiceRequestRepo.getSpindleServiceRequestCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getAllSpindleServiceRequestList()
	 */
	@Override
	public List<SpindleServiceRequest> getAllSpindleServiceRequestList() {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getAllSpindleServiceRequestList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#addSpindleServiceRequest(com.maintenance.model.SpindleServiceRequest)
	 */
	@Override
	public void addSpindleServiceRequest(SpindleServiceRequest spindleServiceRequest) {
		// TODO Auto-generated method stub
		spindleServiceRequestRepo.save(spindleServiceRequest);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestBySSCNo(java.lang.String)
	 */
	@Override
	public Optional<SpindleServiceRequest> getSpindleServiceRequestBySSCNo(String sscNo) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestBySSCNo(sscNo);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getActiveServiceReasonList()
	 */
	@Override
	public List<ServiceReason> getActiveServiceReasonList() {
		// TODO Auto-generated method stub
		return serviceReasonRepo.getActiveServiceReasonList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getNewSSCNoForBranch(java.lang.String)
	 */
	@Override
	public String getNewSSCNoForBranch(String branchCode) {
		// TODO Auto-generated method stub
		String maxCode=spindleServiceRequestRepo.getMaxSSCNoBybranchCode(branchCode);
		return maxCode;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#saveBearringAccessory(com.maintenance.model.BearringAccessory)
	 */
	@Override
	public void saveBearringAccessory(BearringAccessory bearringAccessory) {
		// TODO Auto-generated method stub
		bearringAccessoryRepo.save(bearringAccessory);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getRearBearingBySSCNo(java.lang.String)
	 */
	@Override
	public List<BearringAccessory> getRearBearingBySSCNo(String sscNo) {
		// TODO Auto-generated method stub
		return bearringAccessoryRepo.getRearBearingBySSCNo(sscNo);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getFrontBearingBySSCNo(java.lang.String)
	 */
	@Override
	public List<BearringAccessory> getFrontBearingBySSCNo(String sscNo) {
		// TODO Auto-generated method stub
		return bearringAccessoryRepo.getFrontBearingBySSCNo(sscNo);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#saveServiceRequestMappedEnginner(com.maintenance.model.ServiceRequestMappedEnginner)
	 */
	@Override
	public void saveServiceRequestMappedEnginner(ServiceRequestMappedEnginner serviceRequestMappedEnginner) {
		// TODO Auto-generated method stub
		serviceRequestMappedEnginnerRepo.save(serviceRequestMappedEnginner);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestListByEngineer(int)
	 */
	@Override
	public List<SpindleServiceRequest> getSpindleServiceRequestListByEngineer(int i) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestListByEngineer(i);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getUnApprovedMappedServiceRequestByEng(int)
	 */
	@Override
	public List<ServiceRequestMappedEnginner> getUnApprovedMappedServiceRequestByEng(int engineerId) {
		// TODO Auto-generated method stub
		return serviceRequestMappedEnginnerRepo.getUnApprovedMappedServiceRequestByEng(engineerId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestId(int)
	 */
	@Override
	public SpindleServiceRequest getSpindleServiceRequestId(int sprindleServiceRequestId) {
		// TODO Auto-generated method stub
		Optional<SpindleServiceRequest> optional=spindleServiceRequestRepo.findById(sprindleServiceRequestId);
		System.out.println("SpindleServiceRequest is "+optional.isPresent()+"for "+sprindleServiceRequestId );

		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestByQRCode(java.lang.String)
	 */
	@Override
	public SpindleServiceRequest getSpindleServiceRequestByQRCode(String qrCode) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.getSpindleServiceRequestByQRCode(qrCode);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#addServiceRequestMappedEnginner(com.maintenance.model.ServiceRequestMappedEnginner)
	 */
	@Override
	public void addServiceRequestMappedEnginner(ServiceRequestMappedEnginner serviceRequestMappedEnginner) {
		// TODO Auto-generated method stub
		serviceRequestMappedEnginnerRepo.save(serviceRequestMappedEnginner);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceRequestMappedEnginnerByServiceRequest(int)
	 */
	@Override
	public Optional<ServiceRequestMappedEnginner> getServiceRequestMappedEnginnerByServiceRequest(int sprindleServiceRequestId) {
		// TODO Auto-generated method stub
		Optional<ServiceRequestMappedEnginner> optional= serviceRequestMappedEnginnerRepo.getServiceRequestMappedEnginnerByServiceRequest(sprindleServiceRequestId);
	return optional;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonById(int)
	 */
	@Override
	public ServiceReason getServiceReasonById(int reasonId) {
		// TODO Auto-generated method stub
		Optional<ServiceReason> optional=serviceReasonRepo.findById(reasonId);
		 return optional.isPresent()?optional.get():null;
				 
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getSpindleServiceRequestById(int)
	 */
	@Override
	public Optional<SpindleServiceRequest> getSpindleServiceRequestById(int sprindleServiceRequestId) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.findById(sprindleServiceRequestId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#geSOpById(int)
	 */
	@Override
	public Optional<SOP> geSOpById(int sopId) {
		// TODO Auto-generated method stub
		return sOPRepo.findById(sopId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#bearingReqListRearBycustReqId(int)
	 */
	@Override
	public List<BearringAccessoryCustReq> bearingReqListRearBycustReqId(int custReqId) {
		// TODO Auto-generated method stub
		return bearringAccessoryCustReqRepo.bearingReqListRearBycustReqId(custReqId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#bearingReqListFrontBycustReqId(int)
	 */
	@Override
	public List<BearringAccessoryCustReq> bearingReqListFrontBycustReqId(int custReqId) {
		// TODO Auto-generated method stub
		return bearringAccessoryCustReqRepo.bearingReqListFrontBycustReqId(custReqId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#getServiceReasonByName(java.lang.String)
	 */
	@Override
	public ServiceReason getServiceReasonByName(String name) {
		// TODO Auto-generated method stub
		Optional<ServiceReason> optional= serviceReasonRepo.getServiceReasonByname(name);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.ServiceSer#addSpindleServiceRequestR(com.maintenance.model.SpindleServiceRequest)
	 */
	@Override
	public SpindleServiceRequest addSpindleServiceRequestR(SpindleServiceRequest request) {
		// TODO Auto-generated method stub
		return spindleServiceRequestRepo.save(request);
	}

}



