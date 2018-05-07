package com.ats.wizzo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.wizzo.model.Support;

public interface SupportRepository extends JpaRepository<Support, Integer> {

	Support findByStatus(int status);

	List<Support> findByAssignedTo(int assignedTo);

}
