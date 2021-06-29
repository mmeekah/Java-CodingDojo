package com.codingdojo.human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {
		if (firstName == null) {
			return "Hello Human!\nWelcome to SpringBoot.";
		}
		return "Hello " + firstName + " " + lastName + "!\nWelcome to SpringBoot.";
	}
}