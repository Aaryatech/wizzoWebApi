package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.AdminUser;
import com.ats.wizzo.model.BuyNow;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

	AdminUser findByUserMobileAndUserPassword(String userMobile, String userPassword);

	@Transactional
	@Modifying
	@Query("UPDATE AdminUser SET token=:token  WHERE user_id=:userId")
	int updateToken(@Param("userId") int userId, @Param("token") String token);

	@Query(value = "SELECT token FROM m_admin WHERE  is_used=1"

			+ "", nativeQuery = true)
	List<String> findTokens();
}
