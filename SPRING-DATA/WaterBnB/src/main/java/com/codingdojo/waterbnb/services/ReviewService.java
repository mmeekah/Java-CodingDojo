package com.codingdojo.waterbnb.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingdojo.waterbnb.models.Review;
import com.codingdojo.waterbnb.repositories.ReviewRepository;

@Transactional
@Service
public class ReviewService {
	private ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public List<Object[]> findPoolReviews(Long id) {
		return reviewRepository.findPoolReviews(id);
	}
	
	public void addReview(Review review) {
		reviewRepository.save(review);
	}
}

