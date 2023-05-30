package com.simplilearn.crs.controller;

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

import com.simplilearn.crs.entity.Feedback;
import com.simplilearn.crs.repository.FeedbackRepository;
import com.simplilearn.crs.service.FeedbackService;
import com.simplilearn.crs.service.FeedbackServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/feedbacks")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@GetMapping("/getAllFeedbacks")
	public List<Feedback> getAllFeedbacks(){
		List<Feedback> feedbacks = (List<Feedback>) feedbackService.fetchAllFeedbacks();
		return feedbacks;
	}
	
	@PostMapping(path = "/addFeedback")
	public @ResponseBody void addFeedback(@RequestBody Feedback feedback) {
		System.out.println(feedback.getFeedback());
		feedbackService.saveFeedback(feedback);
		
	}
	
	@DeleteMapping(path = "/deleteFeedbackById/{feedbackId}")
	public @ResponseBody void deleteComplaintById(@PathVariable("feedbackId") int feedbackId) {
		System.out.println(feedbackId+"----------- ");
		Feedback feedback =feedbackServiceImpl.findFeedbackById(feedbackId);
		feedbackServiceImpl.deleteFeedback(feedback);
		
	}
	@PutMapping("/updateFeedback")
	public boolean updateFeedback(@RequestBody Feedback feedback)
	{
		System.out.println(feedback.getTicketId()+"-------");
		Feedback existingFeedbacks = feedbackServiceImpl.findFeedbackById(feedback.getFeedbackId());
		existingFeedbacks.setTicketId(feedback.getTicketId());
		existingFeedbacks.setCustomerEmail(feedback.getCustomerEmail());
		existingFeedbacks.setFeedback(feedback.getFeedback());
		
		feedbackRepository.save(existingFeedbacks);
		
		return true;
	}


}
