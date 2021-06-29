package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;
@Service
public class LanguageService {
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	//Methods
		public List<Language> allLanguages() {
			return languageRepo.findAll();
		}
		
		public Language findLanguage(Long id) {
			Optional<Language> temp = languageRepo.findById(id);
			if (temp.isPresent()) {
				return temp.get();
			} else {
				return null;
			}
		}
		
		public Language createLanguage(Language language) {
			return languageRepo.save(language);
		}
		
		public Language updateLanguage(Language lang) {
			Optional<Language> temp = languageRepo.findById(lang.getId());
			if (temp.isPresent()) {
				temp.get().setName(lang.getName());
				temp.get().setCreator(lang.getCreator());
				temp.get().setVersion(lang.getVersion());
				return languageRepo.save(temp.get());
			} else {
				return null;
			}
		}
		
		public Language updateLanguage(Long id, String name, String creator, String version) {
			Optional<Language> temp = languageRepo.findById(id);
			if (temp.isPresent()) {
				temp.get().setName(name);
				temp.get().setCreator(creator);
				temp.get().setVersion(version);
				return languageRepo.save(temp.get());
			} else {
				return null;
			}
		}
		
		public void deleteLanguage(Long id) {
			languageRepo.deleteById(id);
		}
}
