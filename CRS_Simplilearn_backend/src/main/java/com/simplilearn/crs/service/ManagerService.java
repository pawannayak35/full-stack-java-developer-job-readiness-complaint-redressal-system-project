package com.simplilearn.crs.service;

import com.simplilearn.crs.entity.Manager;

public interface ManagerService {
	
	void saveManager(Manager manager);
	Manager findManagerById(String email);
	void deleteManager(Manager manager);
	Boolean validateManager(String managerEmail, String managerPassword);


}
