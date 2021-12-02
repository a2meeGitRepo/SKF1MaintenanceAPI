/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.BearringAccessoryCustReq;
import com.maintenance.model.CustomerSpindleRegistration;
import com.maintenance.model.Spindle;
import com.maintenance.repo.BearringAccessoryCustReqRepo;
import com.maintenance.repo.CustomerSpindleRegistrationRepo;
import com.maintenance.repo.SpindleRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class SpindleServiceImpl implements SpindleService{
	
	@Autowired
	SpindleRepo spindleRepo;
	@Autowired
	CustomerSpindleRegistrationRepo customerSpindleRegistrationRepo;
	@Autowired
	BearringAccessoryCustReqRepo bearringAccessoryCustReqRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleByPagination(int, int)
	 */
	@Override
	public List<Spindle> getSpindleByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return spindleRepo.getSpindleByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleCount()
	 */
	@Override
	public int getSpindleCount() {
		// TODO Auto-generated method stub
		return spindleRepo.getSpindleCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Spindle> getSpindleByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return spindleRepo.getSpindleByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleCountBySearch(java.lang.String)
	 */
	@Override
	public int getSpindleCountBySearch(String search) {
		// TODO Auto-generated method stub
		return spindleRepo.getSpindleCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getAllSpindleList()
	 */
	@Override
	public List<Spindle> getAllSpindleList() {
		// TODO Auto-generated method stub
		return spindleRepo.getAllSpindleList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#checkSerialNo(java.lang.String)
	 */
	@Override
	public boolean checkSerialNo(String serialNo) {
		// TODO Auto-generated method stub
		Optional<Spindle>  optional= spindleRepo.findBySerialNo(serialNo);
		if(optional.isPresent()){
			return true;
		}else{
			return false;
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleBySerialNo(java.lang.String)
	 */
	@Override
	public Optional<Spindle> getSpindleBySerialNo(String serialNo) {
		// TODO Auto-generated method stub
		return spindleRepo.findBySerialNo(serialNo);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#addSpindle(com.maintenance.model.Spindle)
	 */
	@Override
	public void addSpindle(Spindle spindle) {
		// TODO Auto-generated method stub
		spindleRepo.save(spindle);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getActiceSpindleList()
	 */
	@Override
	public List<Spindle> getActiceSpindleList() {
		// TODO Auto-generated method stub
		return spindleRepo.getActiceSpindleList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getSpindleModels()
	 */
	@Override
	public Set<String>  getSpindleModels() {
		// TODO Auto-generated method stub
		List<Spindle> list=spindleRepo.getActiceSpindleList();
		Set<String> models=new HashSet<String>();
		for(Spindle spindle:list){
			models.add(spindle.getSpindleModel());
			
		}
		return models;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#addCustomerSpindleRegistration(com.maintenance.model.CustomerSpindleRegistration)
	 */
	@Override
	public CustomerSpindleRegistration addCustomerSpindleRegistration(CustomerSpindleRegistration customerSpindleRegistration) {
		// TODO Auto-generated method stub
		return customerSpindleRegistrationRepo.save(customerSpindleRegistration);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getCustomerSpindleRegistrationById(int)
	 */
	@Override
	public Optional<CustomerSpindleRegistration> getCustomerSpindleRegistrationById(int cusSpindleRegId) {
		// TODO Auto-generated method stub
		return customerSpindleRegistrationRepo.findById(cusSpindleRegId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#saveBearringAccessory(com.maintenance.model.BearringAccessoryCustReq)
	 */
	@Override
	public void saveBearringAccessory(BearringAccessoryCustReq bearringAccessory) {
		// TODO Auto-generated method stub
		bearringAccessoryCustReqRepo.save(bearringAccessory);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getCustomerSpindleRegistrationByCustomer(int)
	 */
	@Override
	public List<CustomerSpindleRegistration> getCustomerSpindleRegistrationByCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerSpindleRegistrationRepo.getCustomerSpindleRegistrationByCustomer(customerId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#getAllCustomerSpindleRegistration()
	 */
	@Override
	public List<CustomerSpindleRegistration> getAllCustomerSpindleRegistration() {
		// TODO Auto-generated method stub
		return customerSpindleRegistrationRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpindleService#saveSpindle(com.maintenance.model.Spindle)
	 */
	@Override
	public Spindle saveSpindle(Spindle spindle) {
		// TODO Auto-generated method stub
		return spindleRepo.save(spindle);
	}

}



