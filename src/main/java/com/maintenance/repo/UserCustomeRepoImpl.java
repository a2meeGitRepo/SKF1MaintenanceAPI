/**
 * Dattatray Bodhale
	15-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Customer;
import com.maintenance.model.UserDetails;

/**
 * @author Dattatray Bodhale
 *
 */
public class UserCustomeRepoImpl implements UserCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.UserCustomeRepo#getUserCountBySearch(java.lang.String)
	 */
	@Override
	public int getUserCountBySearch(String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(u)  from UserDetails u  where u.deletbit=0 and (u.firstName LIKE :searchText OR  u.lastName LIKE :searchText OR  u.emailId LIKE :searchText  OR  u.contactNo LIKE :searchText )").setParameter("searchText", "%"+search+"%").getSingleResult();

		int total_count=(int) result;
		return total_count;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.UserCustomeRepo#getUserByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<UserDetails> getUserByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(u)  from UserDetails u  where u.deletbit=0 and (u.firstName LIKE :searchText OR  u.lastName LIKE :searchText OR  u.emailId LIKE :searchText  OR  u.contactNo LIKE :searchText )").setParameter("searchText", "%"+search+"%").getSingleResult();

		int total_count=(int) result;
		Query q = entityManager.createQuery("from UserDetails u  where u.deletbit=0 and  (u.firstName LIKE :searchText OR  u.lastName LIKE :searchText OR  u.emailId LIKE :searchText  OR  u.contactNo LIKE :searchText )  ", UserDetails.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<UserDetails> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.UserCustomeRepo#getUserCount()
	 */
	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(u) FROM UserDetails u where u.deletbit=0 ").getSingleResult();
		int total_count=(int) result;
		return total_count;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.UserCustomeRepo#getUserByPagination(int, int)
	 */
	@Override
	public List<UserDetails> getUserByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				long result = (long) entityManager.createQuery("SELECT count(u) FROM UserDetails u where u.deletbit=0 ").getSingleResult();
				int total_count=(int) result;
				Query q = entityManager.createQuery("FROM UserDetails u where u.deletbit=0 ", UserDetails.class);
				int firstR = total_count - (page_no * item_per_page);
				int maxR = total_count - ((page_no - 1) * item_per_page);
				

				if(firstR<0) {
					firstR=0;
				}
			
				q.setFirstResult(firstR); // modify this to adjust paging
				q.setMaxResults(maxR);
				
				List<UserDetails> list = q.getResultList();
				return list;
	}

}



