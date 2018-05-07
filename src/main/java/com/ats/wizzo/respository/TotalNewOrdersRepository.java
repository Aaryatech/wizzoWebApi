package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.wizzo.model.TotalNewOrders;

public interface TotalNewOrdersRepository extends JpaRepository<TotalNewOrders, Integer> {

	@Query(value = "  SELECT COUNT(t_buy_now .order_id) as total_new_orders FROM t_buy_now  WHERE t_buy_now.status=0"
			+ "", nativeQuery = true)
	Integer totalCountOfOredrs();
}
