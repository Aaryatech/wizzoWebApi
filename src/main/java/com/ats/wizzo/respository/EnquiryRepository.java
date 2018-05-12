package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Enquiry findByStatus(int status);

	@Query(value = "SELECT * FROM t_enquiry WHERE enq_type=2 AND status=0"

			+ "", nativeQuery = true)
	List<Enquiry> findAllEnqByContactEnq();
	
	
	@Query(value = "SELECT * FROM t_enquiry WHERE enq_type=1 AND status=0"

			+ "", nativeQuery = true)
	List<Enquiry> findAllEnqByDistributerEnq();
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Enquiry SET status=1  WHERE enq_id=:enqId")
	int updateEnq(@Param("enqId")int enqId);
	

}
