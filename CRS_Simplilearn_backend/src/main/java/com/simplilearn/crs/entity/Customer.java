package com.simplilearn.crs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer")
public class Customer {
	
	@Id
	private String customerEmail;
	
	private String customerPassword;
	private String customerName;
	private String customerMobile;
	private String customerAddress;
	private String customerPincode;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerEmail, String customerPassword, String customerName, String customerMobile,
			String customerAddress, String customerPincode) {
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerPincode = customerPincode;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	@Override
	public String toString() {
		return "Customer [customerEmail=" + customerEmail + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress
				+ ", customerPincode=" + customerPincode + "]";
	}
	
	
	
	

}
