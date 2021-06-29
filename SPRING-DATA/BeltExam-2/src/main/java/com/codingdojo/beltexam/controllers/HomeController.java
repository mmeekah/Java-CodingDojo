package com.codingdojo.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.UserService;
import com.codingdojo.beltexam.validators.UserValidator;



@Controller
public class HomeController {
	private final UserService uServ;
	private final UserValidator uVal;
	
	public HomeController(UserService uServ, UserValidator uVal) {
		this.uServ = uServ;
		this.uVal = uVal;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "/index.jsp";
	}
	@RequestMapping(value="/registration/redir", method=RequestMethod.POST)
	public String indexRedir(@RequestParam(value="email") String email, @RequestParam(value="password") String password, @RequestParam(value="passwordConfirmation") String passwordConfirmation, @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uVal.validate(user, result);
		if (result.hasErrors()) {
			return "/index.jsp";
		} else {
			User u = uServ.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		}
	}
	@RequestMapping(value="login/redir", method=RequestMethod.POST)
	public String loginRedir(@RequestParam(value="email") String email, @RequestParam(value="password") String password, HttpSession session, Model model) {
		boolean isAuthenticated = uServ.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = uServ.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		} else {			
			return "redirect:/createError";
		}
	}
	
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Invalid Credentials. Please try again.");
        return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

