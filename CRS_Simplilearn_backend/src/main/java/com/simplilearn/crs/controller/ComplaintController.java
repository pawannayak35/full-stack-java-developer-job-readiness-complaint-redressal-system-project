package com.simplilearn.crs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.crs.entity.Complaint;
import com.simplilearn.crs.repository.ComplaintRepository;
import com.simplilearn.crs.service.ComplaintServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/complaints")
public class ComplaintController {
	
	@Autowired
	ComplaintServiceImpl complaintServiceImpl;
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	@GetMapping("/getAllComplaints")
	public List<Complaint> getAllComplaints(){
		List<Complaint> complaints = (List<Complaint>) complaintRepository.findAll();
		return complaints;
	}
	@GetMapping("/getAllComplaintsByEmail/{customerEmail}")
	public List<Complaint> getAllComplaintsByEmail(@PathVariable("customerEmail") String customerEmail){
		System.out.println("inside complaints controller -- "+customerEmail);
		
		List<Complaint> complaints = (List<Complaint>) complaintServiceImpl.findComplaintByEmail(customerEmail);
		return (List<Complaint>) complaints;
	}
	

	@PostMapping("/getAllComplaintsByTicketIds")
	public List<Complaint> getAllComplaintsByTicketIds(@RequestBody int[] ticketIds){
		
		System.out.println("ticket Ids from Backend -- "+ticketIds);
		List<Complaint> complaints = new ArrayList<Complaint>();
		for (int i=0; i<ticketIds.length;i++ ) {
			System.out.println(ticketIds[i]);
			complaints.add(complaintServiceImpl.findComplaintById(ticketIds[i]));
		}
		return  (List<Complaint>) complaints;
		
	}
	
	@GetMapping("/getComplaintById/{ticketId}")
	public Complaint getComplaintById(@PathVariable("ticketId") int ticketId){
		Complaint complaint = complaintServiceImpl.findComplaintById(ticketId);
		return complaint;
	}
	
	@PostMapping(path = "/addComplaint")
	public @ResponseBody void addComplaint(@RequestBody Complaint complaint) {
		complaintServiceImpl.saveComplaint(complaint);
		
	}
	
	@DeleteMapping(path = "/deleteComplaintById/{ticketId}")
	public @ResponseBody void deleteComplaintById(@PathVariable("ticketId") int ticketId) {
		Complaint complaint =complaintServiceImpl.findComplaintById(ticketId);
		complaintServiceImpl.deleteComplaint(complaint);
		
	}
	@PutMapping("/updateComplaint")
	public boolean updateComplaint(@RequestBody Complaint complaint)
	{
		System.out.println(complaint.getTicketId()+"-------");
		Complaint existingComplaint = complaintServiceImpl.findComplaintById(complaint.getTicketId());
		existingComplaint.setComplaint(complaint.getComplaint());
		existingComplaint.setCustomerEmail(complaint.getCustomerEmail());
		existingComplaint.setPincode(complaint.getPincode());
		existingComplaint.setStatus(complaint.getStatus());
		complaintRepository.save(existingComplaint);
		
		return true;
	}


}
