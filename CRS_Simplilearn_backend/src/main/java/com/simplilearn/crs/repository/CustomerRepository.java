package com.simplilearn.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.crs.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
