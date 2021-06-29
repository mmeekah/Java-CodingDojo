package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{
	List<Country> findAll();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c INNER JOIN c.languages l WHERE l.language LIKE %?1% ORDER BY l.percentage DESC")
	List<Object[]> findCountriesByLang(String lang);
	
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY COUNT(ci.id) DESC")
	List<Object[]> findCountriesByNumCitiesDesc();
	
	@Query("SELECT c FROM Country c WHERE surface_area < 501 AND population > 100000")
	List<Country> findCountriesSurfaceAreaPop();
	
	@Query("SELECT c FROM Country c WHERE government_form = 'Constitutional Monarchy' AND surface_area > 200 AND life_expectancy > 75")
	List<Country> findCountriesMonarchSaLe();
	
	@Query("SELECT c.region, COUNT(c.id) as num_countries FROM Country c GROUP BY c.region ORDER BY num_countries DESC")
	List<Object[]> regionsByNumCountries();
}