/**
 * Dattatray Bodhale
	19-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Spare;
import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public class SpareCustomeRepoImpl implements SpareCustomeRepo{

	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpareCustomeRepo#getSpareByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Spare> getSpareByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM Spare s where s.delBit=0 and  s.spareName  LIKE :searchText OR s.description  LIKE :searchText OR s.spindleModel  LIKE :searchText OR s.price  LIKE :searchText OR s.uom  LIKE :searchText").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("FROM Spare s where s.delBit=0 and    s.spareName  LIKE :searchText OR s.description  LIKE :searchText OR s.spindleModel  LIKE :searchText OR s.price  LIKE :searchText OR s.uom  LIKE :searchText", Spare.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Spare> list = q.getResultList();
		return list;	

	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpareCustomeRepo#getSpareByPagination(int, int)
	 */
	@Override
	public List<Spare> getSpareByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM Spare s where s.delBit=0").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Spare s  where s.delBit=0", Spare.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Spare> list = q.getResultList();
		return list;
	}

}



