/**
 * Dattatray Bodhale
	22-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maintenance.model.SOPImage;

/**
 * @author Dattatray Bodhale
 *
 */
public interface SOPImageRepo extends JpaRepository<SOPImage, Integer>{

	/**
	 * @param sopId
	 * @return
	 */
	@Query("From SOPImage s where s.sopId=?1 and s.stageNo=?2")
	List<SOPImage> getSOPImage(int sopId,int stageNo);

}



