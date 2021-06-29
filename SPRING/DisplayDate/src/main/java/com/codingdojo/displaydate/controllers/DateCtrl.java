package com.codingdojo.displaydate.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateCtrl {
	@RequestMapping("/date")
	public String date(Model model) {
		String datePattern = "EEEE, dd MMMM, yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		String date = dateFormat.format(new Date());
		model.addAttribute("date", date);
		return "/DisplayDate/date.jsp";
	}
}
