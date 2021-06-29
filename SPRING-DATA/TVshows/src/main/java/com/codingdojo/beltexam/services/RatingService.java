package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Rating;
import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.repositories.RatingRepository;



@Service
public class RatingService {
	private final RatingRepository rRepo;
	
	public RatingService(RatingRepository rRepo) {
		this.rRepo = rRepo;
	}
	
	public List<Rating> findRatingsByShow(Show show){
		return rRepo.findByShowOrderByValueAsc(show);
	}
	public List<Rating> allRatings(){
		return rRepo.findAll();
	}
	public Rating createRating(Rating rating) {
		return rRepo.save(rating);
	}
	public Rating findRating(Long id) {
		Optional<Rating> optionalRating = rRepo.findById(id);
		if(optionalRating.isPresent()) {
			return optionalRating.get();
		} else {
			return null;
		}
	}

}