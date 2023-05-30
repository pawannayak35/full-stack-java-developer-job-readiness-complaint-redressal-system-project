package com.simplilearn.crs.controller;

import java.util.LinkedHashMap;
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
import com.simplilearn.crs.entity.Manager;
import com.simplilearn.crs.repository.ManagerRepository;
import com.simplilearn.crs.service.ManagerService;
import com.simplilearn.crs.service.ManagerServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/managers")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	@GetMapping("/getAllManagers")
	public List<Manager> getAllManagers(){
		List<Manager> managers = (List<Manager>) managerRepository.findAll();
		return managers;
	}
	
	@PostMapping(path = "/addManager")
	public @ResponseBody void addManager(@RequestBody Manager manager) {
		managerService.saveManager(manager);
		
	}
	
	@PostMapping("/login")
	public Manager validateManager(@RequestBody Object loginDetails) throws NoSuchFieldException {
		
			String managerEmail = (String) ((LinkedHashMap) loginDetails).get("managerEmail");
			String managerPassword = (String) ((LinkedHashMap) loginDetails).get("managerPassword");
			
			Boolean managerLoginStatus = managerService.validateManager(managerEmail,managerPassword );
			if (managerLoginStatus) {
				Manager manager= managerRepository.findById(managerEmail).get();
				return manager;
			}
			return null;
	} 
	
	@GetMapping("/getAllComplaintsByPincode/{managerPincode}")
	public List<Complaint> getAllComplaintsByPincode(@PathVariable("managerPincode") String managerPincode){
		System.out.println("inside managers controller -- "+managerPincode);
		
		List<Complaint> complaints = (List<Complaint>) managerServiceImpl.findComplaintByPincode(managerPincode);
		return (List<Complaint>) complaints;
	}
	
	@DeleteMapping(path = "/deleteManager/{managerEmail}")
	public @ResponseBody void deleteManager(@PathVariable("managerEmail") String email) {
		Manager manager =managerService.findManagerById(email);
		managerService.deleteManager(manager);
		
	}
	@PutMapping("/updateManager/{managerEmail}")
	public boolean updateManager(@PathVariable("managerEmail") String email,@RequestBody String newPincode) {
		System.out.println(newPincode+"----------");
		Manager manager =managerService.findManagerById(email);
		manager.setManagerPincode(newPincode);
		managerRepository.save(manager);
		return true;
		
	}


}
