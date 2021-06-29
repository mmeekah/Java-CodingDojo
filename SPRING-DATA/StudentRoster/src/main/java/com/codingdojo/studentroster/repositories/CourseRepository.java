package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	List<Course> findByOrderByName(); 
	@Query("SELECT c FROM Course c WHERE c.id NOT IN (SELECT c.id FROM Course c LEFT OUTER JOIN c.students s WHERE s.id = :studentId) ORDER BY c.name")
	List<Course> findAllNotEnrolled(@Param("studentId") Long studentId);
}