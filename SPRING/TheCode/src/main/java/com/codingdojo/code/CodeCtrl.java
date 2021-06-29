package com.codingdojo.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller 
public class CodeCtrl {
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/check", method = RequestMethod.POST)
	public String check(@RequestParam(value ="code") String code, RedirectAttributes flash) {
		if(code.equals("bushido")) {
			flash.addFlashAttribute("success", "Correct Code!");
			return "redirect:/code";
		}
		
		else {flash.addFlashAttribute("error", "Wrong Code!");
		return "redirect:/";
		}
	}
	
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
	

}
