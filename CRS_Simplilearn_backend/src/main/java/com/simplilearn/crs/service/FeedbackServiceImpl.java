package com.simplilearn.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.crs.entity.Feedback;
import com.simplilearn.crs.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> fetchAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		
	}
	
	public Feedback findFeedbackById(int feedbackId) {
		Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
		return feedback;
	}

	public void deleteFeedback(Feedback feedback) {
		feedbackRepository.delete(feedback);
		
	}

}
