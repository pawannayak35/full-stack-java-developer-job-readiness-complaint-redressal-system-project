package com.simplilearn.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.crs.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String>{

}
