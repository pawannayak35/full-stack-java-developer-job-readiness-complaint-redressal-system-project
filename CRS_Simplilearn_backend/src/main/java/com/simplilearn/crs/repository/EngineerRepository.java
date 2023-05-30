package com.simplilearn.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.crs.entity.Engineer;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, String>{

}
