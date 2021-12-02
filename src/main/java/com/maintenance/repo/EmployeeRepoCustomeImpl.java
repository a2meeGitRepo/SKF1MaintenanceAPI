/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.Employee;

/**
 * @author Dattatray Bodhale
 *
 */
public class EmployeeRepoCustomeImpl implements EmployeeRepoCustome {
	
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.EmployeeRepoCustome#getEmployeeByPagination(int, int)
	 */
	@Override
	public List<Employee> getEmployeeByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				long result = (long) entityManager.createQuery("SELECT count(e) FROM Employee e where e.delBit=0").getSingleResult();
				int total_count=(int) result;
				Query q = entityManager.createQuery("from Employee e where e.delBit=0", Employee.class);
				int firstR = total_count - (page_no * item_per_page);
				int maxR = total_count - ((page_no - 1) * item_per_page);
				

				if(firstR<0) {
					firstR=0;
				}
			
				q.setFirstResult(firstR); // modify this to adjust paging
				q.setMaxResults(maxR);
				
				List<Employee> list = q.getResultList();
				return list;
	}
	/* (non-Javadoc)
	 * @see com.maintenance.repo.EmployeeRepoCustome#getEmployeeByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Employee> getEmployeeByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
long result = (long) entityManager.createQuery("SELECT count(e) FROM Employee e where e.delBit=0 and (e.emoloyeeCode LIKE :searchText OR  e.fName LIKE :searchText) ").setParameter("searchText", "%"+search+"%").getSingleResult();

		
		int total_count=(int) result;
		Query q = entityManager.createQuery("from Employee e where e.delBit=0 and (e.emoloyeeCode LIKE :searchText OR  e.fName LIKE :searchText)  ", Employee.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		

		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<Employee> list = q.getResultList();
		return list;
	}

}



