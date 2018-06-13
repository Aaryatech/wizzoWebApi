package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.wizzo.model.Room;


public interface RoomRepository extends JpaRepository<Room, Integer>  {

	List<Room> findByUserId(int userId);

	List<Room> findByUserIdAndRoomIsUsed(int userId, int i);
	
	

}
