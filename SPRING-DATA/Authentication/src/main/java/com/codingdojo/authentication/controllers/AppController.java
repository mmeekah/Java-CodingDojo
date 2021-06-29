package com.codingdojo.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;
import com.codingdojo.authentication.validators.UserValidator;

@Controller
public class AppController {
	@Autowired
	private UserService service;
	@Autowired
	private UserValidator validator;
	
	@RequestMapping({"/", "/register"})
	public String registerForm(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@RequestMapping("/login")
	public String loginForm(@ModelAttribute("loginUser") LoginUser loginUser) {
		return "login.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("user", session.getAttribute("user"));
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "register.jsp";
		} else {
			User u = service.registerUser(user);
			session.setAttribute("user", u);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "login.jsp"; 
		}
		
		if (service.authenticateUser(loginUser)) {
			User user = service.findByEmail(loginUser.getEmail());
			session.setAttribute("user", user);
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Invalid credentials");
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
