package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.Scheduler;

public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {

	
	
	List<Scheduler> findByTimeAndSchStatus(String time , int status);

	List<Scheduler> findByUserIdAndDevMacAndDevType(int userId, String mac, int type);

	@Transactional
	int removeBySchId(int schId);
	
	
}
