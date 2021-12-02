/**
 * Dattatray Bodhale
	05-May-2021
 */
package com.maintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maintenance.model.Branch;
import com.maintenance.model.Department;
import com.maintenance.model.Designation;
import com.maintenance.model.Employee;
import com.maintenance.repo.BranchRepo;
import com.maintenance.repo.DepartmentRepo;
import com.maintenance.repo.DesignationRepo;
import com.maintenance.repo.EmployeeRepo;

/**
 * @author Dattatray Bodhale
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	DesignationRepo designationRepo;
	@Autowired
	DepartmentRepo departmentRepo;
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	EmployeeRepo employeeRepo;

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getDesignationList()
	 */
	@Override
	public List<Designation> getDesignationList() {
		// TODO Auto-generated method stub
		return designationRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getDesignationByName(java.lang.String)
	 */
	@Override
	public Optional<Designation> getDesignationByName(String designationName) {
		// TODO Auto-generated method stub
		return designationRepo.getDesignationByName(designationName);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#addDesignation(com.maintenance.model.Designation)
	 */
	@Override
	public void addDesignation(Designation designation) {
		// TODO Auto-generated method stub
		designationRepo.save(designation);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getDepartmentList()
	 */
	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getDepartmentByName(java.lang.String)
	 */
	@Override
	public Optional<Department> getDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepo.getDepartmentByName(departmentName);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#addDepartment(com.maintenance.model.Department)
	 */
	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepo.save(department);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getBranchList()
	 */
	@Override
	public List<Branch> getBranchList() {
		// TODO Auto-generated method stub
		return branchRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getBranchByCode(java.lang.String)
	 */
	@Override
	public Optional<Branch> getBranchByCode(String branchCode) {
		// TODO Auto-generated method stub
		return branchRepo.getBranchByCode(branchCode);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#addBranch(com.maintenance.model.Branch)
	 */
	@Override
	public void addBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchRepo.save(branch);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getAllEmployeeList()
	 */
	@Override
	public List<Employee> getAllEmployeeList() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#addEmployee(com.maintenance.model.Employee)
	 */
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepo.save(employee);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeByCode(java.lang.String)
	 */
	@Override
	public Optional<Employee> getEmployeeByCode(String emoloyeeCode) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeByCode(emoloyeeCode);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeByPagination(int, int)
	 */
	@Override
	public List<Employee> getEmployeeByPagination(int page_no, int item_per_page) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeByPagination(page_no,item_per_page);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeCount()
	 */
	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeCount();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeByPaginationAndSerach(int, int, java.lang.String)
	 */
	@Override
	public List<Employee> getEmployeeByPaginationAndSerach(int page_no, int item_per_page, String search) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeByPaginationAndSerach(page_no,item_per_page,search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeCountBySearch(java.lang.String)
	 */
	@Override
	public int getEmployeeCountBySearch(String search) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeeCountBySearch(search);
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getAllManagers()
	 */
	@Override
	public List<Employee> getAllManagers() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllManagers();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#checkEmployeeCode(java.lang.String)
	 */
	@Override
	public boolean checkEmployeeCode(String employeeCode) {
		// TODO Auto-generated method stub
		Optional<Employee> optional= employeeRepo.getEmployeeByEmployeeCode(employeeCode);
		if(optional.isPresent()){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getBranchById(int)
	 */
	@Override
	public Branch getBranchById(int branchId) {
		// TODO Auto-generated method stub
		Optional<Branch> optional= branchRepo.getBranchById(branchId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getAllEngineer()
	 */
	@Override
	public List<Employee> getAllEngineer() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllEngineer();
	}

	/* (non-Javadoc)
	 * @see com.maintenance.service.EmployeeService#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int engineerId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional=employeeRepo.findById(engineerId);
		return optional.isPresent()?optional.get():null;
	}

}



