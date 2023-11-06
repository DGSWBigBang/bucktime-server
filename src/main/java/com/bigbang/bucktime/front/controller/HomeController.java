package com.bigbang.bucktime.front.controller;

import com.bigbang.bucktime.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/front")
@RequiredArgsConstructor
public class HomeController {
	private final MenuService menuService;

	@GetMapping("")
	public String home() {
		return "home";
	}

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

	@GetMapping("/cafe/menu/modify")
	public String menuModify(Model model, @RequestParam("menu-idx") Integer menuIdx, HttpServletRequest request) {
		if(menuService.haveDeskCheck(request, menuIdx)) {
			model.addAttribute("menuIdx", menuIdx);
			model.addAttribute("menu", menuService.showMenu(menuIdx));
			return "cafe/menu/modify-menu";
		} else {
			return "redirect:/front/menu";
		}
	}

	@GetMapping("/cafe/menu/{pageName}")
	public String menuPages(@PathVariable("pageName") String pageName) {
		return "cafe/menu/" + pageName;
	}
}
