package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ats.wizzo.model.Order;

public interface OrderRepository  extends CrudRepository<Order,Integer> {

	
	
	@Query(value = "  SELECT COUNT(t_buy_now .order_id)  FROM t_buy_now  WHERE t_buy_now.status=0"
			+ "", nativeQuery = true)
	Integer totalCountOfOredrs();
	
}
