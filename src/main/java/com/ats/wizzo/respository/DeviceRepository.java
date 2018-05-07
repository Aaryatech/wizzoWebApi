package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

	Device findByDevMacAndDevType(String mac, int type);

	List<Device> findByUserId(int userId);

	@Transactional
	@Modifying
	@Query("UPDATE Device SET devIsUsed=0  WHERE dev_id=:devId")
	int deleteDevice(@Param("devId")int devId);



}
