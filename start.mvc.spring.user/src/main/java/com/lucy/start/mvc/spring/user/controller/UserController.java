package com.lucy.start.mvc.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public String getUser() {
		return "user";
	}
	

}
