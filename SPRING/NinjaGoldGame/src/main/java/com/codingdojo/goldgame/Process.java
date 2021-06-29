package com.codingdojo.goldgame;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Process {
	@RequestMapping(value="/process", method= RequestMethod.POST)
	public String process(@RequestParam("location") String location, HttpSession session) {
		Random r = new Random();
		ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activities");
		Integer gold = (Integer)session.getAttribute("gold");
		
		if(location.equals("farm")) {
			int randNum = r.nextInt(20-10)+10;
			gold += randNum;
			activities.add("You found "+randNum + "gold in the farm!");
		}else if (location.equals("cave")) {
			int randNum = r.nextInt(10-5)+5;
			gold += randNum;
			activities.add("You found " + randNum + " gold in the cave!");
		} else if (location.equals("house")) {
			int randNum = r.nextInt(5-2)+2;
			gold += randNum;
			activities.add("You found " + randNum + " gold in the house!");
		} else if (location.equals("casino")) {
			int randNum = r.nextInt(50-(-50))+(-50);
			gold += randNum;
			activities.add("You won/lost " + randNum + " gold in the casino!");
		}
		
		session.setAttribute("gold", gold);
		session.setAttribute("activites", activities);
		return "redirect:/";
	}
}
