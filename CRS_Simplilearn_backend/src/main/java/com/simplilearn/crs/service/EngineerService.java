package com.simplilearn.crs.service;

import java.util.List;

import com.simplilearn.crs.entity.Engineer;

public interface EngineerService {
	
	List <Engineer> fetchAllEngineers();
	void saveEngineer(Engineer engineer);
	Engineer findEngineerById(String email);
	void deleteEngineer(Engineer engineer);
	Boolean validateEngineer(String engineerEmail, String engineerPassword);

}
