package com.bigbang.bucktime.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
