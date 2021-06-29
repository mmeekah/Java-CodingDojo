package com.codingdojo.goldgame;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		} else {
			session.getAttribute("gold");
		}
		
		if(session.getAttribute("activities") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}else {
			session.getAttribute("activities");
		}
		
		return "index.jsp";
		
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("activities", null);
		return "redirect:/";
	}
	
	
		

}
