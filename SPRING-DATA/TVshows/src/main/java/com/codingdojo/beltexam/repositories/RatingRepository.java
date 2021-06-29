package com.codingdojo.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexam.models.Rating;
import com.codingdojo.beltexam.models.Show;



@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	List<Rating> findAll();
	List<Rating> findByShowOrderByValueAsc(Show show);
}