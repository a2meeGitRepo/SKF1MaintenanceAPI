/**
 * Dattatray Bodhale
	13-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Employee;
import com.maintenance.model.InspectionCheckPoint;

/**
 * @author Dattatray Bodhale
 *
 */
public class InspectionCheckPointCustomeRepoImpl  implements InspectionCheckPointCustomeRepo{
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.InspectionCheckPointCustomeRepo#getInspectionCheckPointByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<InspectionCheckPoint> getInspectionCheckPointByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub
				long result = (long) entityManager.createQuery("SELECT count(i) FROM InspectionCheckPoint i where i.delBit=0 and i.checkPointName LIKE :searchText OR  i.defaultValue LIKE :searchText OR  i.defaultCondistion LIKE :searchText  OR  i.remark LIKE :searchText ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("from InspectionCheckPoint i where i.delBit=0 and i.checkPointName LIKE :searchText OR  i.defaultValue LIKE :searchText  OR  i.defaultCondistion LIKE :searchText OR  i.remark LIKE :searchText ", InspectionCheckPoint.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<InspectionCheckPoint> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.InspectionCheckPointCustomeRepo#getInspectionCheckPointByPagination(int, int)
	 */
	@Override
	public List<InspectionCheckPoint> getInspectionCheckPointByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(i) FROM InspectionCheckPoint  i where i.delBit=0").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from InspectionCheckPoint i where i.delBit=0", InspectionCheckPoint.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<InspectionCheckPoint> list = q.getResultList();
		return list;
	}

}



