package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
public class LangsApi {
	
	private final LanguageService langService;
	
	public LangsApi(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return langService.allLanguages();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language  language = new Language (name, creator, version);
        return langService.createLanguage(language);
    }
	
  @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
	  Language language = langService.findLanguage(id);
        return language;
    }
  @RequestMapping(value="/api/languages/{id}", method = RequestMethod.PUT)
  public Language update(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
	  Language language = langService.updateLanguage(null, name, creator, version);
	  return language;
  }
  @RequestMapping(value="/api/languages/{id}", method =RequestMethod.DELETE)
  public void destroy(@PathVariable(value="id") Long id) {
	  langService.deleteLanguage(id);
  }
  
	
}
