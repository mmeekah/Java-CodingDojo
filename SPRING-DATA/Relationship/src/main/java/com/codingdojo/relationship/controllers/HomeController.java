package com.codingdojo.relationship.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.services.DMVService;

@Controller
public class HomeController {
private DMVService dmv;
	
	public HomeController(DMVService dmv) {
		this.dmv = dmv;
		this.dmv = dmv;
	}
	
	// RequestMapping
		@RequestMapping({"/", "/persons"})
		public String index(Model model) {
			List<Person> persons = dmv.findAllPersons();
			model.addAttribute("persons", persons);
			return "index.jsp";
		}
	
		@RequestMapping("/persons/new")
		public String newPerson(@ModelAttribute("person") Person person) {
			return "new.jsp";
		}
		
		@RequestMapping(value="/persons", method=RequestMethod.POST)
		public String createPerson(
				@Valid @ModelAttribute("person") Person person,
				BindingResult result) {
			if (result.hasErrors()) {
				return "new.jsp";
			} else {
				dmv.createPerson(person);
				return "redirect:/";
			}
		}
		
		@RequestMapping("/persons/{id}")
		public String showPerson(@PathVariable("id")Long id, Model model) {
			Person person = dmv.findOnePerson(id);
			if (person != null) {
				model.addAttribute("person", person);
				return "show.jsp";
			} else {
				return "redirect:/";
			}
		}
		
		@RequestMapping("/licenses/new")
		public String newLicense(@ModelAttribute("license") License license, Model model) {
			List<Person> persons = dmv.findAllPersons();
			model.addAttribute("persons", persons);
			return "licenses/new.jsp";
		}
		
		@RequestMapping(value="/licenses", method=RequestMethod.POST)
		public String createLicense(
				@Valid @ModelAttribute("license") License license,
				BindingResult result) {
			if (result.hasErrors()) {
				return "licenses/new.jsp";
			} else {
				dmv.createLicense(license);
				return "redirect:/";
			}
		}
		
}
