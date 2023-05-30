package com.simplilearn.crs.service;

import java.util.List;

import com.simplilearn.crs.entity.Feedback;


public interface FeedbackService {
	
	List<Feedback> fetchAllFeedbacks();
	void saveFeedback (Feedback feedback);

}
