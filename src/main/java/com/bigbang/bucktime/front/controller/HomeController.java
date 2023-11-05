package com.bigbang.bucktime.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/front")
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/user/{pageName}")
	public String userPages(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageName") String pageName) {
		return "user/" + pageName;
	}

	@GetMapping("/cafe/{pageName}")
	public String cafePages(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageName") String pageName) {
		return "cafe/" + pageName;
	}

}
