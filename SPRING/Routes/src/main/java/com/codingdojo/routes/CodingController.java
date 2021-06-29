package com.codingdojo.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	
	@RequestMapping("")
	public String hello() {
		return "Hello Coding Dojo";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was Awesome!";
	}
	
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring should be ok too!";
	}
}
