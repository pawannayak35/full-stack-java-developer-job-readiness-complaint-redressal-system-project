package com.simplilearn.crs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	
	private int ticketId;
	private String customerEmail;
	private String feedback;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackId, int ticketId, String customerEmail, String feedback) {
		this.feedbackId = feedbackId;
		this.ticketId = ticketId;
		this.customerEmail = customerEmail;
		this.feedback = feedback;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", ticketId=" + ticketId + ", customerEmail=" + customerEmail
				+ ", feedback=" + feedback + "]";
	}
	
	
	
	
}
