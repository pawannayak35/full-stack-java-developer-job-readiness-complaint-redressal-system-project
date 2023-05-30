package com.simplilearn.crs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_engineer")
public class Engineer {
	
	@Id
	private String engineerEmail;
	
	private String engineerPassword;
	private String engineerName;
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}

	public Engineer(String engineerEmail, String engineerPassword, String engineerName) {
		this.engineerEmail = engineerEmail;
		this.engineerPassword = engineerPassword;
		this.engineerName = engineerName;
	}

	public String getEngineerEmail() {
		return engineerEmail;
	}

	public void setEngineerEmail(String engineerEmail) {
		this.engineerEmail = engineerEmail;
	}

	public String getEngineerPassword() {
		return engineerPassword;
	}

	public void setEngineerPassword(String engineerPassword) {
		this.engineerPassword = engineerPassword;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	@Override
	public String toString() {
		return "Engineer [engineerEmail=" + engineerEmail + ", engineerPassword=" + engineerPassword + ", engineerName="
				+ engineerName + "]";
	}
	
	

}
