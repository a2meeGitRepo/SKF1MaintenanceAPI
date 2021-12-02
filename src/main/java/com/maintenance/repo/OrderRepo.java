/**
 * Dattatray Bodhale
	02-Jun-2021
 */
package com.maintenance.repo;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maintenance.model.Order;

/**
 * @author Dattatray Bodhale
 *
 */
public interface OrderRepo extends JpaRepository<Order, Integer>,OrderCustomeRepo{

	/**
	 * @param search
	 * @return
	 */
	@Query("select count(*) from Order e where   e.orderNo  LIKE %:searchText% OR e.orderDate  LIKE %:searchText% OR e.orderPrice  LIKE %:searchText%")
	int getOrderCountBySearch(@Param("searchText")String searchText);

	/**
	 * @return
	 */
	@Query("select count(o)from Order o")
	int getOrderCount();

	/**
	 * @param sscNo
	 * @return
	 */
	@Query("from Order o where o.spindleServiceRequest.sscNo=?1")
	Optional<Order> getOrdeBySSCNo(String sscNo);

	

}



