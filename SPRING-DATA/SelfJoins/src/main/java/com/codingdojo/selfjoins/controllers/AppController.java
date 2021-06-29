package com.codingdojo.selfjoins.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.selfjoins.models.User;
import com.codingdojo.selfjoins.services.UserService;

@Controller
public class AppController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/users")
	public String userIndex(Model model) {
		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);
		return "/users/index.jsp";
	}
	
	@RequestMapping("/users/{id}")
	public String show(@PathVariable("id") Long id, Model model)   {
		User user = service.findOneUser(id);
		List<User> possibleFriends = service.findAllUsers();
		model.addAttribute("user", user);
		model.addAttribute("possibleFriends", possibleFriends);
		return "/users/show.jsp";
	}
	
	@RequestMapping("/users/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "/users/new.jsp";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "/users/new.jsp";
		} else  {
			service.createUser(user);
			return "redirect:/users";
		}
	}
	
	@RequestMapping(value="/addFriend", method=RequestMethod.POST)
	public String addFriend(
			@RequestParam(name="userId") Long userId,
			@RequestParam(name="friendId") Long friendId) {
		service.addFriend(userId, friendId);
		return "redirect:/users/" + userId;
	}
	
	@RequestMapping("/dropFriend/{userId}/{friendId}")
	public String dropFriend(
			@PathVariable("userId") Long userId,
			@PathVariable("friendId") Long friendId) {
		service.dropFriend(userId, friendId);
		return "redirect:/users/" + userId;
	}
}
