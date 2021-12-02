/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Customer;
import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public class CustomerCustomeRepoImpl implements CustomerCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.CustomerCustomeRepo#getCustomerByPagination(int, int)
	 */
	@Override
	public List<Customer> getCustomerByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(c) FROM Customer c where c.delBit=0 ").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Customer c  where c.delBit=0 ", Customer.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Customer> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.CustomerCustomeRepo#getCustomerByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Customer> getCustomerByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(c)  from Customer c  where c.delBit=0 and (c.customerCode LIKE :searchText OR  c.contactPerson LIKE :searchText )").setParameter("searchText", "%"+search+"%").getSingleResult();

		int total_count=(int) result;
		Query q = entityManager.createQuery("from Customer c  where c.delBit=0 and  (c.customerCode LIKE :searchText OR  c.contactPerson LIKE :searchText)  ", Customer.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Customer> list = q.getResultList();
		return list;
	}

}



