package com.codingdojo.routes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("{location}")
	public String dojo (@PathVariable("location") String location) {
		if(location.equals("dojo")) {
			return "The Dojo is awesome";
		}
		
		if(location.equals("east-dojo")) {
			return "Eastern Dojo is located in Boston";
		}
		
		if(location.equals("san-jose")) {
			return "DJ dojo is the headquarters.!";
		}
		
		return "";
	}
	

}
