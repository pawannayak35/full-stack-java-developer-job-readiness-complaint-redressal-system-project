package com.simplilearn.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.crs.entity.Customer;
import com.simplilearn.crs.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> fetchAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer findCustomerById(String email) {
		Customer customer = customerRepository.findById(email).orElse(null);
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		
	}

	@Override
	public Boolean validateCustomer(String customerEmail, String customerPassword) {
		
		if (customerRepository.findById(customerEmail).isPresent()) {
			Customer customer = customerRepository.findById(customerEmail).get();
			String dbPassword = customer.getCustomerPassword().toString();
			if (dbPassword.equals(customerPassword)) {
				return true;
			}
		}
		return false;
	}

}
