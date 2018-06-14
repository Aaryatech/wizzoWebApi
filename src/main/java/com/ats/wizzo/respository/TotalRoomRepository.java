package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.wizzo.model.TotalRoom;

public interface TotalRoomRepository extends JpaRepository<TotalRoom, Integer>{

	@Query(value = "select * from m_rooms where user_id =:userId and room_is_used =:isUsed", nativeQuery = true)
	List<TotalRoom> findByUserIdAndRoomIsUsed(@Param("userId") int userId,@Param("isUsed") int isUsed);

}
