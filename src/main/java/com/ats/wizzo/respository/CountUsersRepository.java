package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.wizzo.model.TotalNoOfUsers;

public interface CountUsersRepository extends JpaRepository<TotalNoOfUsers, Integer> {

	@Query(value = "SELECT COUNT(m_user.user_id) as total_users FROM m_user WHERE m_user.user_is_used=1"
			+ "", nativeQuery = true)
	Integer totalCountOfUsers();

}
