package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.BuyNow;
import com.ats.wizzo.model.Enquiry;

public interface BuyNowRepository extends JpaRepository<BuyNow, Integer> {

	BuyNow findByStatus(int status);

	
	@Query(value = "SELECT * FROM t_buy_now WHERE  status=0"

			+ "", nativeQuery = true)
	List<BuyNow> findAllOrders();
	
	
	@Transactional
	@Modifying
	@Query("UPDATE BuyNow SET status=1  WHERE order_id=:orderId")
	int updateOrderStatus(@Param("orderId")int orderId);
	

	
}
