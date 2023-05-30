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

import com.simplilearn.crs.entity.Customer;
import com.simplilearn.crs.repository.CustomerRepository;
import com.simplilearn.crs.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> customers = (List<Customer>) customerService.fetchAllCustomers();
		return customers;
	}
	
	
	
	
	
	
	@PostMapping("/login")
	public Boolean validateCustomer(@RequestBody Object loginDetails) throws NoSuchFieldException {
		
			String customerEmail = (String) ((LinkedHashMap) loginDetails).get("customerEmail");
			String customerPassword = (String) ((LinkedHashMap) loginDetails).get("customerPassword");
			
			Boolean customerLoginStatus = customerService.validateCustomer(customerEmail,customerPassword);
			return customerLoginStatus;
	} 
	
	@PostMapping(path = "/addCustomer")
	public @ResponseBody void addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		
	}

	@DeleteMapping(path = "/deleteCustomer/{customerEmail}")
	public @ResponseBody void deleteCustomer(@PathVariable("customerEmail") String email) {
		Customer customer =customerService.findCustomerById(email);
		customerService.deleteCustomer(customer);
		
	}
	@PutMapping("/updateCustomer/{customerEmail}")
	public boolean updateManager(@PathVariable("customerEmail") String email,@RequestBody String newPincode) {
		System.out.println(newPincode+"----------");
		Customer customer =customerService.findCustomerById(email);
		customer.setCustomerPincode(newPincode);
		customerRepository.save(customer);
		return true;
		
	}

}
