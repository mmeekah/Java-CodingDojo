package com.codingdojo.overflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.NewQuestion;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.services.AppService;

@Controller
public class HomeController {
	private AppService service;
	
	public HomeController(AppService service) {
		this.service = service;
	}
	
	// MAPPING
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = service.findAllQuestions();
		model.addAttribute("questions", questions);
		return "/questions/index.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") NewQuestion q) {
		return "/questions/new.jsp";
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question") NewQuestion q, BindingResult result) {
		if (result.hasErrors()) {
			return "/questions/new.jsp";
		} else {
			service.createQuestion(q);
			return "redirect:/questions";
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("ans") Answer answer, Model model) {
		Question question = service.findQuestion(id);
		model.addAttribute("question", question);
		return "/questions/show.jsp";
	}
	
	@RequestMapping(value="/answers", method=RequestMethod.POST)
	public String createAnswer(
			@Valid @ModelAttribute("ans") Answer answer,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Question question = service.findQuestion(answer.getQuestion().getId());
			model.addAttribute("question", question);
			return "/questions/show.jsp";
		} else {
			service.createAnswer(answer);
			return "redirect:/questions/" + answer.getQuestion().getId();
		}
	}
}
