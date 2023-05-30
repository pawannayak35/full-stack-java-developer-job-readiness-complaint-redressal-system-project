//package com.simplilearn.crs.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.simplilearn.crs.entity.Complaint;
//import com.simplilearn.crs.repository.ComplaintRepository;
//
//@Service
//public class ComplaintService {
//	
//	@Autowired
//	private ComplaintRepository complaintRepository;
//	
//	// 1. save the data into database (Post Method)
//	public Complaint saveComplaint(Complaint complaint) {
//		return complaintRepository.save(complaint);	
//	}
//	
//	// 2. fetch the data from database
//	public List<Complaint> getAllComplaints() {
//		return complaintRepository.findAll();
//	}
//	
//	public Complaint getComplaintById(int ticketId) {
//		return complaintRepository.findById(ticketId).orElse(null);
//	}
//	
//	public List<Complaint> getComplaintByEmail(String customerEmail) {
//		return complaintRepository.findComplaintByCustomerEmail(customerEmail);
//	}
//	
//	// 3. delete the data from database
//	
//	
//	
//	
//	
//
//}
