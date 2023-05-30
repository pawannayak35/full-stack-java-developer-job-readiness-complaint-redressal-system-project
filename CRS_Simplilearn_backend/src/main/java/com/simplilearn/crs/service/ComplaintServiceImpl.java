package com.simplilearn.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.crs.entity.Complaint;
import com.simplilearn.crs.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl {
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	public void saveComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		
	}
	
	public Complaint findComplaintById(int ticketId) {
		Complaint complaint = complaintRepository.findById(ticketId).orElse(null);
		return complaint;
	}
	
	public void deleteComplaint(Complaint complaint) {
		complaintRepository.delete(complaint);
		
	}
	
	public List<Complaint> findComplaintByEmail(String customerEmail) {
		return complaintRepository.findComplaintByCustomerEmail(customerEmail);
	}

}
