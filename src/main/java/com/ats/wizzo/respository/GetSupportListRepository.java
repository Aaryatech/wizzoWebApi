package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.wizzo.model.GetSupportList;

public interface GetSupportListRepository extends JpaRepository<GetSupportList, Integer>{

	
	
	@Query(value = "select s.*,u.user_name,e.emp_name from t_support s,m_employee e,m_user u  "
			+ "where  s.solution_datetime between :fDate and :tDate "
			+ "and e.emp_id = s.assigned_to and u.user_id = s.user_id", nativeQuery = true)
	List<GetSupportList> resolvedListFromSupprt(@Param("fDate") String fDate, @Param("tDate")String tDate);

	@Query(value = "select s.*,u.user_name,e.emp_name from t_support s,m_employee e,m_user u "
			+ "where  s.status=1 and e.emp_id = s.assigned_to and u.user_id = s.user_id", nativeQuery = true)
	List<GetSupportList> pendingListFromSupprt();
}
