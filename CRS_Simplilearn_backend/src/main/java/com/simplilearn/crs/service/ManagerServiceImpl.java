package com.simplilearn.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.crs.entity.Complaint;
import com.simplilearn.crs.entity.Manager;
import com.simplilearn.crs.repository.ComplaintRepository;
import com.simplilearn.crs.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	@Override
	public void saveManager(Manager manager) {
		managerRepository.save(manager);
		
	}

	@Override
	public Manager findManagerById(String email) {
		return managerRepository.findById(email).orElse(null);
	}

	@Override
	public void deleteManager(Manager manager) {
		managerRepository.delete(manager);
		
	}

	@Override
	public Boolean validateManager(String managerEmail, String managerPassword) {
		
		if (managerRepository.findById(managerEmail).isPresent()) {
			Manager manager= managerRepository.findById(managerEmail).get();
			String dbPassword = manager.getManagerPassword().toString();
			if (dbPassword.equals(managerPassword)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Complaint> findComplaintByPincode(String managerPincode) {
		return complaintRepository.findComplaintByPincode(managerPincode);
	}

}
