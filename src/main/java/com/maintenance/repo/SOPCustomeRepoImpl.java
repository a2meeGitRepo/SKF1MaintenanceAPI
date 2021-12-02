/**
 * Dattatray Bodhale
	21-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Employee;
import com.maintenance.model.SOP;

/**
 * @author Dattatray Bodhale
 *
 */
public class SOPCustomeRepoImpl implements SOPCustomeRepo{
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.SOPCustomeRepo#getAllSOPByPagination(int, int)
	 */
	@Override
	public List<SOP> getAllSOPByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) from SOP s").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from SOP s ", SOP.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		//System.out.println("Page No : "+page_no+" Item Oer Page : "+item_per_page);

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<SOP> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SOPCustomeRepo#getAllSOPByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<SOP> getAllSOPByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
long result = (long) entityManager.createQuery("SELECT count(s) FROM SOP s where s.spindle.spindleBrand LIKE :searchText OR  s.spindle.spindleModel LIKE :searchText ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("from SOP s where  s.spindle.spindleBrand LIKE :searchText OR  s.spindle.spindleModel LIKE :searchText  ", Employee.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<SOP> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SOPCustomeRepo#getAllSOPCountBySearch(java.lang.String)
	 */
	@Override
	public int getAllSOPCountBySearch(String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) SOP s where s.emoloyeeCode LIKE :searchText").setParameter("searchText", "%"+search+"%").getSingleResult();
		int total_count=(int) result;
		return total_count;
	}

}



