package com.codingdojo.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyCtrl {
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping(value="process", method=RequestMethod.POST)
	public String process( @RequestParam(value="name") String name,
						   @RequestParam(value="location") String location,
						   @RequestParam(value="language") String language,
						   @RequestParam(value="comment") String comment,
						   Model model
							
			) {
		
		model.addAttribute("name",name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		return "results.jsp";
	}

}
