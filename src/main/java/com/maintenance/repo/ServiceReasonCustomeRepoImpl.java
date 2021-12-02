/**
 * Dattatray Bodhale
	07-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.ServiceReason;
import com.maintenance.model.Spindle;

/**
 * @author Dattatray Bodhale
 *
 */
public class ServiceReasonCustomeRepoImpl implements ServiceReasonCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.ServiceReasonCustomeRepo#getServiceReasonByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<ServiceReason> getServiceReasonByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM ServiceReason s where s.deletBit=0 and  s.reasonName  LIKE :searchText ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("FROM ServiceReason s where s.deletBit=0 and   s.reasonName  LIKE :searchText ", ServiceReason.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<ServiceReason> list = q.getResultList();
		return list;	
		
		
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.ServiceReasonCustomeRepo#getServiceReasonByPagination(int, int)
	 */
	@Override
	public List<ServiceReason> getServiceReasonByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
				
				
				
				
				// TODO Auto-generated method stub
				long result = (long) entityManager.createQuery("SELECT count(s) FROM ServiceReason s where s.deletBit=0").getSingleResult();
				int total_count=(int) result;
				Query q = entityManager.createQuery("from ServiceReason s  where s.deletBit=0",ServiceReason.class);
				int firstR = total_count - (page_no * item_per_page);
				int maxR = total_count - ((page_no - 1) * item_per_page);
				

				if(firstR<0) {
					firstR=0;
				}
			
				q.setFirstResult(firstR); // modify this to adjust paging
				q.setMaxResults(maxR);
				
				List<ServiceReason> list = q.getResultList();
				return list;
	}

}



