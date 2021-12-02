/**
 * Dattatray Bodhale
	22-Jun-2021
 */
package com.maintenance.service;

import java.util.List;

import com.maintenance.model.SOPImage;

/**
 * @author Dattatray Bodhale
 *
 */
public interface ImageService {

	/**
	 * @param sopImage
	 */
	void saveSOPImage(SOPImage sopImage);

	/**
	 * @param sopId
	 * @return
	 */
	List<SOPImage> getSOPImage(int sopId,int stageNo);

}



