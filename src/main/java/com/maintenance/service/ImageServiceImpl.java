/**
 * Dattatray Bodhale
	22-Jun-2021
 */
package com.maintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.SOPImage;
import com.maintenance.repo.SOPImageRepo;
import com.maintenance.repo.SOPRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	SOPImageRepo sOPImageRepo;
	/* (non-Javadoc)
	 * @see com.maintenance.service.ImageService#saveSOPImage(com.maintenance.model.SOPImage)
	 */
	@Override
	public void saveSOPImage(SOPImage sopImage) {
		// TODO Auto-generated method stub
		sOPImageRepo.save(sopImage);
	}
	/* (non-Javadoc)
	 * @see com.maintenance.service.ImageService#getVisualIspectionImages(int)
	 */
	@Override
	public List<SOPImage> getSOPImage(int sopId,int stageNo) {
		// TODO Auto-generated method stub
		return sOPImageRepo.getSOPImage(sopId,stageNo);
	}

}



