package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class ApiService {
	private NinjaRepository ninjaRepo;
	private DojoRepository dojoRepo;
	
	public ApiService(NinjaRepository ninjaRepo, DojoRepository dojoRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo; 
	}
	
	// Ninjas
	public List<Ninja> findAllNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja findOneNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		Optional<Ninja> temp = ninjaRepo.findById(ninja.getId());
		if (temp.isPresent()) {
			temp.get().setFirstName(ninja.getFirstName());
			temp.get().setLastName(ninja.getLastName());
			temp.get().setAge(ninja.getAge());
			temp.get().setDojo(ninja.getDojo());
			return ninjaRepo.save(temp.get());
		} else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	// Dojos
	public List<Dojo> findAllDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo findOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> temp = dojoRepo.findById(dojo.getId());
		if (temp.isPresent()) {
			temp.get().setName(dojo.getName());
			temp.get().setCity(dojo.getCity());
			temp.get().setState(dojo.getState());
			return dojoRepo.save(temp.get());
		} else {
			return null;
		}
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}