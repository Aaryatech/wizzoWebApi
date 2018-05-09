package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.wizzo.model.Support;

public interface SupportRepository extends JpaRepository<Support, Integer> {

	Support findByStatus(int status);

	List<Support> findByAssignedTo(int assignedTo);

	Support findByTokenId(int tokenId);
	

	@Query(value = "  SELECT COUNT(t_support.token_id)  FROM t_support WHERE t_support.status=0"
			+ "", nativeQuery = true)
	Integer totalPendingIssues();

}
