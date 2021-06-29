package com.codingdojo.countires.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.countries.models.Country;
import com.codingdojo.countries.services.ApiService;

@RestController
public class ApiController {
	@Autowired
	private ApiService api;
	
	@GetMapping("/")
	public List<Country> index() {
		return api.getCountries();
	}
	
	@GetMapping("/countries/{lang}")
	public List<Object[]> countriesByLang(@PathVariable("lang") String lang) {
		return api.getCountriesByLanguage(lang);
	}
	
	@GetMapping("/countries/citycount")
	public List<Object[]> countriesByCityCount() {
		return api.getCountriesByNumCities();
	}
	
	@GetMapping("/cities/Mexico")
	public List<Object[]> mexicoCitiesByPop() {
		return api.getMexicoCitiesByPop();
	}
	
	@GetMapping("/languages/ninetypercent")
	public List<Object[]> languagesNinetyPercent() {
		return api.getCountryLanguagesOver89Perc();
	}
	
	@GetMapping("/countries/sapop")
	public List<Country> countriesSaPop() {
		return api.getCountriesSurfaceAreaPop();
	}
	
	@GetMapping("/countries/monarchsale")
	public List<Country> countriesMonarchSaLe() {
		return api.getCountriesMonarchSaLe();
	}
	
	@GetMapping("/buenosaires")
	public List<Object[]> buenosAires() {
		return api.buenosAires();
	}
	
	@GetMapping("/countriesperregion")
	public List<Object[]> countiesPerRegion() {
		return api.regionsByNumCountries();
	}
	
}