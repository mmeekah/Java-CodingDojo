package com.codingdojo.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.events.models.UsersEvents;

@Repository
public interface UsersEventsRepository extends CrudRepository <UsersEvents, Long>{

	List<UsersEvents> findByUserId(Long id);
	
	
}