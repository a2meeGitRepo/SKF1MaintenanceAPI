/**
 * Dattatray Bodhale
	19-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.Spare;
import com.maintenance.repo.SpareRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class SpareServiceImpl implements SpareService {
	@Autowired
	SpareRepo spareRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareByPagination(int, int)
	 */
	@Override
	public List<Spare> getSpareByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return spareRepo.getSpareByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareCount()
	 */
	@Override
	public int getSpareCount() {
		// TODO Auto-generated method stub
		return spareRepo.getSpareCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Spare> getSpareByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return spareRepo.getSpareByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareCountBySearch(java.lang.String)
	 */
	@Override
	public int getSpareCountBySearch(String search) {
		// TODO Auto-generated method stub
		return spareRepo.getSpareCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareByModels(java.lang.String)
	 */
	@Override
	public List<Spare> getSpareByModels(String model) {
		// TODO Auto-generated method stub
		return spareRepo.getSpareByModels(model);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getAllSpareList()
	 */
	@Override
	public List<Spare> getAllSpareList() {
		// TODO Auto-generated method stub
		return spareRepo.getAllSpareList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getActiceSpareList()
	 */
	@Override
	public List<Spare> getActiceSpareList() {
		// TODO Auto-generated method stub
		return spareRepo.getActiceSpareList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#getSpareBySpareNameAndSpindleModel(java.lang.String, java.lang.String)
	 */
	@Override
	public Optional<Spare> getSpareBySpareNameAndSpindleModel(String spareName, String spindleModel) {
		// TODO Auto-generated method stub
		return spareRepo.getSpareBySpareNameAndSpindleModel(spareName,spindleModel);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.SpareService#addSpare(com.maintenance.model.Spare)
	 */
	@Override
	public void addSpare(Spare spare) {
		// TODO Auto-generated method stub
		spareRepo.save(spare);
	}

}



