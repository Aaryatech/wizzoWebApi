package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.wizzo.model.BuyNow;

public interface BuyNowRepository extends JpaRepository<BuyNow, Integer> {

	BuyNow findByStatus(int status);

}
