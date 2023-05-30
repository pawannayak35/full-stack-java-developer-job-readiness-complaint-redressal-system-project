package com.simplilearn.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.crs.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	List<Complaint> findComplaintByCustomerEmail(String customerEmail);
	
	List<Complaint> findComplaintByPincode(String managerPincode);
}
