package com.ats.wizzo.respository;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.wizzo.model.GetTouch;

public interface GetTouchRepository extends JpaRepository<GetTouch, Integer>{
	
	@Query(value = "SELECT * FROM t_get_touch WHERE  status=0 ", nativeQuery = true)
	List<GetTouch> findAllByStatus();
	
	
	@Transactional
	@Modifying
	@Query("UPDATE GetTouch SET status=1  WHERE tr_id=:trId")
	int updateGetTouchStatus( @Param("trId") int trId);

}
