/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.InspectionStage;
import com.maintenance.model.Order;

/**
 * @author Dattatray Bodhale
 *
 */
public class OrderCustomeRepoImpl implements OrderCustomeRepo{
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.OrderCustomeRepo#getOrderByPagination(int, int)
	 */
	@Override
	public List<Order> getOrderByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(o) FROM Order o ").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Order ", Order.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Order> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.OrderCustomeRepo#getOrderByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Order> getOrderByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
long result = (long) entityManager.createQuery("SELECT count(i) FROM Order i where i.orderNo LIKE :searchText OR  i.orderDate LIKE :searchText OR  i.orderPrice LIKE :searchText ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Order i where i.orderNo LIKE :searchText OR  i.orderDate LIKE :searchText  OR  i.orderPrice LIKE :searchText ", Order.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Order> list = q.getResultList();
		return list;
	}

}



