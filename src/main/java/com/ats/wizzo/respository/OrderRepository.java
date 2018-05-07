package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ats.wizzo.model.Order;

public interface OrderRepository  extends CrudRepository<Order,Integer> {

}
