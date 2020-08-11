package com.lucy.start.mvc.spring.news.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsContrller {
	
	@RequestMapping("/")
	public String getNews() {
		return "news";
	}

}
