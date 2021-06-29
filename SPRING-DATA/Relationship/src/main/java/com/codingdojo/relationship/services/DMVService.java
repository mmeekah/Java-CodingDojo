package com.codingdojo.relationship.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.repositories.LicenseRepository;
import com.codingdojo.relationship.repositories.PersonRepository;

@Service
public class DMVService {
	
	private PersonRepository personRepo;
	private LicenseRepository licenseRepo;
	
	public DMVService(PersonRepository personRepo, LicenseRepository licenseRepo) { 
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	
	// Methods
		public List<Person> findAllPersons() {
			return personRepo.findAll();
		}
		
		public List<Person> findUnlicensedPersons() {
			return personRepo.findByNoLicense();
		}
		
		public Person findOnePerson(Long id) {
			return personRepo.findById(id).orElse(null);
		}
		
		public Person createPerson(Person person) {
			return personRepo.save(person);
		}
		
		public License createLicense(License license) {
			license.setNumber(this.generateLicenseNumber());
			return licenseRepo.save(license);
		}
		
		public int generateLicenseNumber() {
			License l = licenseRepo.findTopByOrderByNumberDesc();
			if (l == null ) {
				return 1;
			}
			int largestNum = l.getNumber();
			largestNum++;
			return largestNum;
		}
}
