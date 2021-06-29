package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
	@Query("SELECT ci.name, ci.population FROM City ci INNER JOIN ci.country c WHERE c.name = 'Mexico' AND ci.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> mexicanCitiesByPop();
	
	@Query("SELECT c.name, ci.name, ci.district, ci.population FROM City ci JOIN ci.country c WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
	List<Object[]> buenosAiresCities();
}