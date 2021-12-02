/**
 * Dattatray Bodhale
	06-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.Customer;
import com.maintenance.model.CustomerRegistratin;
import com.maintenance.repo.CustomerRegistrationRepo;
import com.maintenance.repo.CustomerRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	CustomerRegistrationRepo customerRegistrationRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerByPagination(int, int)
	 */
	@Override
	public List<Customer> getCustomerByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerCount()
	 */
	@Override
	public int getCustomerCount() {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Customer> getCustomerByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerCountBySearch(java.lang.String)
	 */
	@Override
	public int getCustomerCountBySearch(String search) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getAllCustomerList()
	 */
	@Override
	public List<Customer> getAllCustomerList() {
		// TODO Auto-generated method stub
		return customerRepo.getAllCustomerList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#checkCustomerCode(java.lang.String)
	 */
	@Override
	public boolean checkCustomerCode(String customerCode) {
		// TODO Auto-generated method stub
		Optional<Customer> optional= customerRepo.checkCustomerCode(customerCode);
		if(optional.isPresent()){
			return true;
		}else{
			return false;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerByCode(java.lang.String)
	 */
	@Override
	public Optional<Customer> getCustomerByCode(String customerCode) {
		// TODO Auto-generated method stub
		return customerRepo.checkCustomerCode(customerCode);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#addCustomer(com.maintenance.model.Customer)
	 */
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getActiveCustomerList()
	 */
	@Override
	public List<Customer> getActiveCustomerList() {
		// TODO Auto-generated method stub
		return customerRepo.getActiveCustomerList();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#addCustomerRegistration(com.maintenance.model.CustomerRegistratin)
	 */
	@Override
	public void addCustomerRegistration(CustomerRegistratin customer) {
		// TODO Auto-generated method stub
		customerRegistrationRepo.save(customer);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#getCustomerRegById(int)
	 */
	@Override
	public Customer getCustomerRegById(int custId) {
		// TODO Auto-generated method stub
		Optional<Customer> optional=customerRepo.findById(custId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.CustomerService#addCustomer1(com.maintenance.model.Customer)
	 */
	@Override
	public Customer addCustomer1(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

}



