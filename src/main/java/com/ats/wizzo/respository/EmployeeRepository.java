package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.wizzo.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmpMobileAndEmpPassword(String empMobile, String empPassword);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee SET isUsed=0  WHERE emp_id=:empId")
	int deleteEmployee(@Param("empId")int empId);


}
