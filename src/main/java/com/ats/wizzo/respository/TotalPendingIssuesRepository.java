package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.wizzo.model.TotalPendingIssues;

public interface TotalPendingIssuesRepository extends JpaRepository<TotalPendingIssues, Integer> {

	@Query(value = "  SELECT COUNT(t_support.token_id) as total_pending_issues FROM t_support WHERE t_support.status=0"
			+ "", nativeQuery = true)
	Integer totalPendingIssues();
}
