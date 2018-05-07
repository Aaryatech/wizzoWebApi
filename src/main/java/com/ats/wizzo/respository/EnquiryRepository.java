package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.wizzo.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	Enquiry findByStatus(int status);

}
