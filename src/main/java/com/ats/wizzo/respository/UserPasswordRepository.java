package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.wizzo.model.UserPassword;

public interface UserPasswordRepository extends JpaRepository<UserPassword, Integer> {

	@Query(value = "select u.*,up.* from m_user u, m_user_password up where u.user_id = up.user_id and u.user_mobile =:userMobile  and up.user_password=:userPassword and u.user_is_used=1"

			+ "", nativeQuery = true)
	UserPassword findByUserMobileAndUserPassword(@Param("userMobile") String userMobile, @Param("userPassword") String userPassword);

}
