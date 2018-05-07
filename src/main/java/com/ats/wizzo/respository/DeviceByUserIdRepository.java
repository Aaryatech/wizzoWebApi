package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.wizzo.model.Device;
import com.ats.wizzo.model.DeviceByUserId;

public interface DeviceByUserIdRepository extends JpaRepository<DeviceByUserId, Integer>{
	
	@Query(value = "\r\n"
			+ "SELECT m_device.dev_id, m_device.dev_mac, m_device.dev_ip, m_device.dev_type FROM m_device WHERE "
			+ "m_device.user_id=:userId and dev_is_used=1 GROUP BY m_device.dev_mac"
		 
			+ "", nativeQuery = true)
	List<DeviceByUserId> findAllDevicesByUserId(@Param("userId") int userId);

}
