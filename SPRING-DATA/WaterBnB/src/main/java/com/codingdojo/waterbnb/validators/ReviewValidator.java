package com.codingdojo.waterbnb.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.waterbnb.models.Review;
import com.codingdojo.waterbnb.services.ReviewService;

@Component
public class ReviewValidator implements Validator {
	private ReviewService reviewService;
	
	public ReviewValidator(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Review.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		Review review = (Review) object;
	}
}

