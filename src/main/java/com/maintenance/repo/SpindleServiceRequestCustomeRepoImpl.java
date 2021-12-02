/**
 * Dattatray Bodhale
	12-May-2021
 */
package com.maintenance.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.maintenance.model.ServiceReason;
import com.maintenance.model.SpindleServiceRequest;

/**
 * @author Dattatray Bodhale
 *
 */
public class SpindleServiceRequestCustomeRepoImpl implements SpindleServiceRequestCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleServiceRequestCustomeRepo#getSpindleServiceRequestByPagination(int, int)
	 */
	@Override
	public List<SpindleServiceRequest> getSpindleServiceRequestByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		
		
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM SpindleServiceRequest s where s.delBit=0").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from SpindleServiceRequest s  where s.delBit=0",SpindleServiceRequest.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		
		if(firstR<0) {
			firstR=0;
		}
	
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<SpindleServiceRequest> list = q.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleServiceRequestCustomeRepo#getSpindleServiceRequestByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<SpindleServiceRequest> getSpindleServiceRequestByPaginationAndSerach(int page_no, int item_per_page,
			String search) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM SpindleServiceRequest s where s.delBit=0 and (s.sscNo LIKE :searchText OR s.customer.customerCode LIKE :searchText OR  s.customer.companyName LIKE :searchText OR  s.spindle.spindleBrand LIKE :searchText OR  s.spindle.spindleModel LIKE :searchText OR  s.spindle.serialNo LIKE :searchText OR  s.branch.branchName LIKE :searchText OR  s.reason.reasonName LIKE :searchText OR  s.spindleDesign LIKE :searchText OR  s.drive LIKE :searchText OR  s.moutingType LIKE :searchText OR  s.orientation LIKE :searchText OR  s.orientation LIKE :searchText)").setParameter("searchText", "%"+search+"%").getSingleResult();
		int total_count=(int) result;
		Query q = entityManager.createQuery("from SpindleServiceRequest s   where s.delBit=0 and (s.sscNo LIKE :searchText OR s.customer.customerCode LIKE :searchText OR  s.customer.companyName LIKE :searchText OR  s.spindle.spindleBrand LIKE :searchText OR  s.spindle.spindleModel LIKE :searchText OR  s.spindle.serialNo LIKE :searchText OR  s.branch.branchName LIKE :searchText OR  s.reason.reasonName LIKE :searchText OR  s.spindleDesign LIKE :searchText OR  s.drive LIKE :searchText OR  s.moutingType LIKE :searchText OR  s.orientation LIKE :searchText OR  s.orientation LIKE :searchText)",SpindleServiceRequest.class);
		int firstR = total_count - (page_no * item_per_page);
		int maxR = total_count - ((page_no - 1) * item_per_page);
		
		if(firstR<0) {
			firstR=0;
		}
		q.setParameter("searchText", "%"+search+"%");
		q.setFirstResult(firstR); // modify this to adjust paging
		q.setMaxResults(maxR);
		
		List<SpindleServiceRequest> list = q.getResultList();
		return list;
	}

	

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleServiceRequestCustomeRepo#getMaxSSCNoBybranchCode(java.lang.String)
	 */
	@Override
	public String getMaxSSCNoBybranchCode(String branchCode) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM SpindleServiceRequest s where  substr(s.sscNo,1,4)=:branchCode").setParameter("branchCode", branchCode).getSingleResult();
		int total_count=(int) result;
		if(total_count==0){
			return branchCode+"0001";
		}else{
			String maxCode= (String) entityManager.createQuery("select MAX(s.sscNo) from SpindleServiceRequest s where substr(s.sscNo,1,4)=:branchCode").setParameter("branchCode", branchCode).getSingleResult();
			String subCode="1"+maxCode.substring(4,8);
			int intCode=Integer.parseInt(subCode);
			intCode++;
			String code=String.valueOf(intCode).substring(1,5);
			return branchCode+code;
		}
	}

	/* (non-Javadoc)
	 * @see com.maintenance.repo.SpindleServiceRequestCustomeRepo#getSpindleServiceRequestCountBySearch(java.lang.String)
	 */
	@Override
	public int getSpindleServiceRequestCountBySearch(String search) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(s) FROM SpindleServiceRequest s where s.delBit=0 and (s.sscNo LIKE :searchText OR s.customer.customerCode LIKE :searchText OR  s.customer.companyName LIKE :searchText OR  s.spindle.spindleBrand LIKE :searchText OR  s.spindle.spindleModel LIKE :searchText OR  s.spindle.serialNo LIKE :searchText OR  s.branch.branchName LIKE :searchText OR  s.reason.reasonName LIKE :searchText OR  s.spindleDesign LIKE :searchText OR  s.drive LIKE :searchText OR  s.moutingType LIKE :searchText OR  s.orientation LIKE :searchText OR  s.orientation LIKE :searchText)").setParameter("searchText", "%"+search+"%").getSingleResult();
		int total_count=(int) result;
		return total_count;
	}
}



