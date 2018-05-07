package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.wizzo.model.DeviceCount;



public interface DeviceConuntRepository extends JpaRepository<DeviceCount, Integer> {

	@Query(value = " SELECT COUNT(m_device.dev_id) as total_devices FROM m_device WHERE m_device.dev_is_used=1"
			+ "", nativeQuery = true)
	Integer totalCountOfUsers();
}
