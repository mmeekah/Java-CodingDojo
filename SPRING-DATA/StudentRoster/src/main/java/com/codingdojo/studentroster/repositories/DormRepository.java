package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.models.Dormitory;

@Repository
public interface DormRepository extends CrudRepository<Dormitory, Long>{
	List<Dormitory> findByOrderByName();
}
