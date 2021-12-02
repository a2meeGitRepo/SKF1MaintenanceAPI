/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.Order;
import com.maintenance.repo.OrderRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepo orderRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getOrderByPagination(int, int)
	 */
	@Override
	public List<Order> getOrderByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return orderRepo.getOrderByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getOrderCount()
	 */
	@Override
	public int getOrderCount() {
		// TODO Auto-generated method stub
		return orderRepo.getOrderCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getOrderByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Order> getOrderByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return orderRepo.getOrderByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getOrderCountBySearch(java.lang.String)
	 */
	@Override
	public int getOrderCountBySearch(String search) {
		// TODO Auto-generated method stub
		return orderRepo.getOrderCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getAllOrderList()
	 */
	@Override
	public List<Order> getAllOrderList() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#addNewOrder(com.maintenance.model.Order)
	 */
	@Override
	public void addNewOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepo.save(order);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.OrderService#getOrdeBySSCNo(java.lang.String)
	 */
	@Override
	public Optional<Order> getOrdeBySSCNo(String sscNo) {
		// TODO Auto-generated method stub
		return orderRepo.getOrdeBySSCNo(sscNo);
	}

}



