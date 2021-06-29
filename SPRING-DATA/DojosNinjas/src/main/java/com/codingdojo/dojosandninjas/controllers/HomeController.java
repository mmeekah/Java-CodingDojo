package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.ApiService;

@Controller
public class HomeController {
	private ApiService api;
	public HomeController(ApiService api) {
		this.api = api;
	}
	
	//Mapping
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dojos")
	public String dojos(Model model) {
		List<Dojo> dojos = api.findAllDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos/index.jsp";
	}
	
	@RequestMapping("/ninjas")
	public String ninjas(Model model) {
		List<Ninja> ninjas = api.findAllNinjas();
		model.addAttribute("ninjas", ninjas);
		return "/ninjas/index.jsp";
	}
	
	@RequestMapping("/ninjas/{id}")
	public String showNinja(@PathVariable("id") Long id, Model model) {
		Ninja ninja = api.findOneNinja(id);
		model.addAttribute("ninja", ninja);
		return "/ninjas/show.jsp";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = api.findOneDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = api.findAllDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/new.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			api.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			api.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}
}