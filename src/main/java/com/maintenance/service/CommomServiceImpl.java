/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.Branch;
import com.maintenance.model.City;
import com.maintenance.model.MailManager;
import com.maintenance.model.State;
import com.maintenance.repo.BranchRepo;
import com.maintenance.repo.CityRepo;
import com.maintenance.repo.MailManagerRepo;
import com.maintenance.repo.StateRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class CommomServiceImpl implements CommomService {
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	MailManagerRepo mailManagerRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllCity()
	 */
	@Override
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		return cityRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getCitiesByState(int)
	 */
	@Override
	public List<City> getCitiesByState(int stateId) {
		// TODO Auto-generated method stub
		return cityRepo.getCitiesByState(stateId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllState()
	 */
	@Override
	public List<State> getAllState() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getBranchByName(java.lang.String)
	 */
	@Override
	public Branch getBranchByName(String branchName) {
		// TODO Auto-generated method stub
		Optional<Branch> optional= branchRepo.getBranchByName(branchName);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getCityByName(java.lang.String)
	 */
	@Override
	public City getCityByName(String cityName) {
		// TODO Auto-generated method stub
		Optional<City> optional= cityRepo.getCityByName(cityName);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getMailManagerById(int)
	 */
	@Override
	public Optional<MailManager> getMailManagerById(int mailManageId) {
		// TODO Auto-generated method stub
		return mailManagerRepo.findById(mailManageId);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllMailManager()
	 */
	@Override
	public List<MailManager> getAllMailManager() {
		// TODO Auto-generated method stub
		return mailManagerRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#addNewMailManager(com.maintenance.model.MailManager)
	 */
	public void addNewMailManager(MailManager mailManager) {
		// TODO Auto-generated method stub
		mailManagerRepo.save(mailManager);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllMailManagerForNewService()
	 */
	@Override
	public List<MailManager> getAllMailManagerForNewService() {
		// TODO Auto-generated method stub
		return mailManagerRepo.getAllMailManagerForNewService();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllMailManagerForNewOffer()
	 */
	@Override
	public List<MailManager> getAllMailManagerForNewOffer() {
		// TODO Auto-generated method stub
		return mailManagerRepo.getAllMailManagerForNewOffer();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CommomService#getAllMailManagerForInspectionReport()
	 */
	@Override
	public List<MailManager> getAllMailManagerForInspectionReport() {
		// TODO Auto-generated method stub
		return mailManagerRepo.getAllMailManagerForInspectionReport();
	}

}



