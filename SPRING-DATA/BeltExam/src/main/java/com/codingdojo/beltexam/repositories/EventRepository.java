package com.codingdojo.beltexam.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexam.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findAll();
//	Iterable<Event> findAllOrderByDateAsc();

//	List<Event> findAllOrderByDateAsc();
//	@Query("SELECT e from Event e WHERE e.id NOT IN (SELECT e.id FROM Event e LEFT OUTER JOIN e.user u WHERE u.id = :userId) ORDER BY e.createdAt")
	void deleteById(Long id);
}