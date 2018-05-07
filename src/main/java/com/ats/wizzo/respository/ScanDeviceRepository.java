package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.ScanDevices;

public interface ScanDeviceRepository  extends JpaRepository<ScanDevices, Integer> {

	List<ScanDevices> findByUserId(int userId);
	
	ScanDevices findByDevMac(String mac);



	@Transactional
	int removeByDevId(int devId);

	
	
	
}
