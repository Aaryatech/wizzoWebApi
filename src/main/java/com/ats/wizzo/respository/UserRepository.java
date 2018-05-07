package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserMobile(String userMob);

	User findByUserId(int userId);

	User findByUserIsUsed(int userIsUsed);

	List<User> findAllByUserIsUsed(int userIsUsed);

	@Query(value = "\r\n" + " select * from m_user where user_id NOT IN (select user_id from m_scan_devices)"
			+ "", nativeQuery = true)
	List<User> findAllUsersWithNoScanDevices();
	
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET userIsUsed=0  WHERE user_id=:userId")
	int deleteUser(@Param("userId")int userId);


}
