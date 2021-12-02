/**
 * Dattatray Bodhale
	14-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Employee;
import com.maintenance.model.InspectionCheckPoint;
import com.maintenance.model.InspectionStage;

/**
 * @author Dattatray Bodhale
 *
 */
public class InspectionStageCustomeRepoImpl implements InspectionStageCustomeRepo{
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.InspectionStageCustomeRepo#getInspectionStageByPagination(int, int)
	 */
	@Override
	public List<InspectionStage> getInspectionStageByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(i) FROM InspectionStage  i where i.delBit=0").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from InspectionStage i where i.delBit=0", InspectionStage.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<InspectionStage> list = q.getResultList();
		return list;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.repo.InspectionStageCustomeRepo#getNewStageNoByModel(java.lang.String)
	 */
	@Override
	public int getNewStageNoByModel(String model) {
		// TODO Auto-generated method stub
		long count = (long) entityManager.createQuery("SELECT count(i) FROM InspectionStage  i where i.delBit=0 and i.spindleModel=:model").setParameter("model", model).getSingleResult();
		if(count==0){
		return 1;	
		}else{
		
		String maxCode= (String) entityManager.createQuery("select MAX(i.stageNo) from InspectionStage i where i.delBit=0 and i.spindleModel=:model").setParameter("model", model).getSingleResult();
		int intCode=Integer.parseInt(maxCode);
		intCode++;
		return intCode;
		}
	}
	/* (non-Javadoc)
	 * @see com.maintenance.repo.InspectionStageCustomeRepo#getInspectionStageByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<InspectionStage> getInspectionStageByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
long result = (long) entityManager.createQuery("SELECT count(i) FROM InspectionStage i where i.delBit=0 and (i.stageNo LIKE :searchText OR  i.stageName LIKE :searchText OR  i.spindleModel LIKE :searchText ) ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("from InspectionStage i where i.delBit=0 and (i.stageName LIKE :searchText OR  i.spindleModel LIKE :searchText  OR  i.stageNo LIKE :searchText) ", InspectionStage.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<InspectionStage> list = q.getResultList();
		return list;
	}

}



