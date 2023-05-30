package com.simplilearn.crs.service;

import java.util.List;

import com.simplilearn.crs.entity.Customer;


public interface CustomerService {
	
	List <Customer> fetchAllCustomers();
	void saveCustomer(Customer customer);
	Customer findCustomerById(String email);
	void deleteCustomer(Customer customer);
	Boolean validateCustomer(String customerEmail, String customerPassword);

}
