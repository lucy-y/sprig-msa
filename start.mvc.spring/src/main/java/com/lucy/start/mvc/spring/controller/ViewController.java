package com.lucy.start.mvc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucy.start.mvc.spring.service.MainNewsServiceImpl;

@Controller
public class ViewController {
	
	@Autowired
	MainNewsServiceImpl mainNewsServiceImpl;
	
	@RequestMapping("/")
	public String index(Model model) {
		//model.addAttribute("newsData", mainNewsServiceImpl.getNews());
		return "index";
	}

}
