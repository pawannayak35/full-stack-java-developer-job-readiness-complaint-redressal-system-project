package com.simplilearn.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.crs.entity.Engineer;
import com.simplilearn.crs.repository.EngineerRepository;

@Service
public class EngineerServiceImpl implements EngineerService{

	@Autowired
	EngineerRepository engineerRepository;
	
	@Override
	public List<Engineer> fetchAllEngineers() {
		return engineerRepository.findAll();
	}

	@Override
	public void saveEngineer(Engineer engineer) {
		engineerRepository.save(engineer);
		
	}

	@Override
	public Engineer findEngineerById(String email) {
		Engineer engineer = engineerRepository.findById(email).orElse(null);
		return engineer;
	}

	@Override
	public void deleteEngineer(Engineer engineer) {
		engineerRepository.delete(engineer);
		
	}

	@Override
	public Boolean validateEngineer(String engineerEmail, String engineerPassword) {
		
		if (engineerRepository.findById(engineerEmail).isPresent()) {
			Engineer engineer= engineerRepository.findById(engineerEmail).get();
			String dbPassword = engineer.getEngineerPassword().toString();
			if (dbPassword.equals(engineerPassword)) {
				return true;
			}
		}
		return false;
	}

}
