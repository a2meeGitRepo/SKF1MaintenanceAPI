/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Employee;
import com.maintenance.model.Spindle;
import com.maintenance.repo.SpindleCustomeRepo;

/**
 * @author Dattatray Bodhale
 *
 */
public class SpindleCustomeRepoImpl implements SpindleCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleCustomeRepo#getSpindleByPagination(int, int)
	 */
	@Override
	public List<Spindle> getSpindleByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM Spindle s where s.delBit=0").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Spindle s  where s.delBit=0", Spindle.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Spindle> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleCustomeRepo#getSpindleByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Spindle> getSpindleByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM Spindle s where s.delBit=0 and  s.spindleBrand  LIKE :searchText OR s.machineBrand  LIKE :searchText OR s.serialNo  LIKE :searchText OR s.spindleModel  LIKE :searchText OR s.machineModel  LIKE :searchText OR s.power  LIKE :searchText OR s.toolTaper  LIKE :searchText").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("FROM Spindle s where s.delBit=0 and   s.spindleBrand  LIKE :searchText OR s.machineBrand  LIKE :searchText OR s.serialNo  LIKE :searchText OR s.spindleModel  LIKE :searchText OR s.machineModel  LIKE :searchText OR s.power  LIKE :searchText OR s.toolTaper  LIKE :searchText", Spindle.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Spindle> list = q.getResultList();
		return list;	}

}



