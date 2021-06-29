package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.models.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
 	List<Student> findAllByContactNullOrderByLastName();
	List<Student> findAllByDormitoryNullOrderByLastName();
	@Query("SELECT s FROM Student s WHERE s.id NOT IN (SELECT s.id FROM Student s LEFT OUTER JOIN s.courses c WHERE c.id = :courseId) ORDER BY s.lastName ASC")
	List<Student> findAllNotEnrolled(@Param("courseId") Long id);
}
