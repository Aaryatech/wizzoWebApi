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
	
	Device findByDevId(int id);


	@Transactional
	@Modifying
	@Query("UPDATE Device SET devIsUsed=0  WHERE devMac=:devMac")
	int deleteDeviceByMac(@Param("devMac")String devMac);

	@Query(value = " SELECT COUNT(m_device.dev_id) FROM m_device WHERE m_device.dev_is_used=1" + "", nativeQuery = true)
	Integer totalCountOfUsers();

	List<Device> findByRoomIdAndDevIsUsed(int roomId, int i);

	@Query(value = " select * from m_device where user_id =:userId and dev_is_used=:isUsed group by dev_mac", nativeQuery = true)
	List<Device> macAddByUserId(@Param("userId")int userId,@Param("isUsed") int isUsed);

}
