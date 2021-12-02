/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maintenance.dto.Email;
import com.maintenance.dto.ResponceObj;
import com.maintenance.model.BearringAccessory;
import com.maintenance.model.Branch;
import com.maintenance.model.Employee;
import com.maintenance.model.Order;
import com.maintenance.model.SpindleServiceRequest;
import com.maintenance.service.OrderService;

/**
 * @author Dattatray Bodhale
 *
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService  orderService;
	
	

/*
 *  Dattatray Bodhale
 *  
 *  01-06-2021
 *  
 *    List Of  Order By Pagination
 * 
 * */
@RequestMapping(value = "/getOrderByPagination", method = RequestMethod.GET)
public @ResponseBody List<Order> getOrderByPagination(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page) {
	List<Order> list= new  ArrayList<Order>();
	try {	
		list=orderService.getOrderByPagination(page_no,item_per_page);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  01-06-2021
 *  
 *   Count Of  Order
 * 
 * */
@RequestMapping(value = "/getOrderCount", method = RequestMethod.GET)
public @ResponseBody int  getOrderCount() {
	int  count= 0;
	try {
		count= orderService.getOrderCount();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}


/*
 *  Dattatray Bodhale
 *  
 *  01-06-2021
 *  
 *    List Of  Order By Pagination And Search
 * 
 * */
@RequestMapping(value = "/getOrderByPaginationAndSerach", method = RequestMethod.GET)
public @ResponseBody List<Order> getOrderByPaginationAndSerach(@RequestParam("page_no") int page_no,@RequestParam("item_per_page") int item_per_page,@RequestParam("search") String search) {
	List<Order> list= new  ArrayList<Order>();
	try {	
		list=orderService.getOrderByPaginationAndSerach(page_no,item_per_page,search);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}


/*
 *  Dattatray Bodhale
 *  
 *  01-06-2021
 *  
 *   Count Of  Order by Search
 * 
 * */
@RequestMapping(value = "/getOrderCountBySearch", method = RequestMethod.GET)
public @ResponseBody int  getOrderCountBySearch(@RequestParam("search") String search) {
	int  count= 0;
	try {
		count= orderService.getOrderCountBySearch(search);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return count;
}



	/*
	 *  Dattatray Bodhale
	 *  
	 *  01-06-2021
	 *  
	 *   Get List Of All Order
	 * 
	 * */
	
	
	@RequestMapping(value = "/getAllOrderList", method = RequestMethod.GET)
	public @ResponseBody List<Order> getAllOrderList() {
		List<Order> list = null;

		list= orderService.getAllOrderList();

		return list;
	}
	
	
	/*
	 *  Dattatray Bodhale
	 *  
	 *  01-06-2021
	 *  
	 *    Add New  Service Reason 
	 * 
	 * */
	
	

	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> updateOrder(@RequestBody Order  order) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
				

				order.setUpdDatetime(new Date());
				orderService.addNewOrder(order);
				
				
				
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Order updated Successfully");
			
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}
	/*
	 *  Dattatray Bodhale
	 *  
	 *  01-06-2021
	 *  
	 *    Add New  Service Reason 
	 * 
	 * */
	
	

	@RequestMapping(value = "/addNewOrder", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> addNewOrder(@RequestBody Order  order) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			System.out.println("ORDER CALL"+order.toString());
			Optional<Order> optional= orderService.getOrdeBySSCNo(order.getSpindleServiceRequest().getSscNo());
			System.out.println(" CODE IS PRESEN "+optional.isPresent());
			if(optional.isPresent()){
				responceDTO.setCode(500);
				responceDTO.setMessage("Order is  already .....Exits");
			}else{
				
			
				
				order.setActive(1);
				order.setAddedDate(new Date());
				orderService.addNewOrder(order);
				
				
				
				
				responceDTO.setCode(200);
				responceDTO.setMessage("Order Added Successfully");
			}
				
		
			
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponceObj> changeStatus(@RequestBody Order  order) {
		ResponceObj responceDTO= new ResponceObj();

		try {
			
			
			
			order.setUpdDatetime(new Date());;
			orderService.addNewOrder(order);
				responceDTO.setCode(200);
				responceDTO.setMessage("Order status updated successfully");
			
				
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
			
		} catch (Exception e) {
			// TODO: handle exception
			responceDTO.setCode(500);
			responceDTO.setMessage(e.getMessage());
			return new ResponseEntity<ResponceObj>(responceDTO,HttpStatus.ACCEPTED)	;
		}
		
			
		}

}



