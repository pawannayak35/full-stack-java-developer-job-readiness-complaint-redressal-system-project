package com.simplilearn.crs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_manager")
public class Manager {
	
	@Id
	private String managerEmail;
	
	private String managerPassword;
	private String managerName;
	private String managerPincode;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String managerEmail, String managerPassword, String managerName, String managerPincode) {
		this.managerEmail = managerEmail;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.managerPincode = managerPincode;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPincode() {
		return managerPincode;
	}

	public void setManagerPincode(String managerPincode) {
		this.managerPincode = managerPincode;
	}

	@Override
	public String toString() {
		return "Manager [managerEmail=" + managerEmail + ", managerPassword=" + managerPassword + ", managerName="
				+ managerName + ", managerPincode=" + managerPincode + "]";
	}
	
	

}
