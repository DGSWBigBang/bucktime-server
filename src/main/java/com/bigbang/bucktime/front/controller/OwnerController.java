package com.bigbang.bucktime.front.controller;

import com.bigbang.bucktime.domain.menu.dto.response.ShowMenuResponse;
import com.bigbang.bucktime.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final MenuService menuService;

    @GetMapping("/menu")
    public String menu(Model model, @CookieValue("accessToken") String accessToken) {
        System.out.println(accessToken);
        try {
            List<ShowMenuResponse> menuResponse = menuService.showMenuOwner(accessToken);
            model.addAttribute("menuList", menuResponse);
            return "owner/menu";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/menu/modify")
    public String menuModify(Model model, @RequestParam("menu-idx") Integer menuIdx, @CookieValue("accessToken") String accessToken) {
        if(menuService.haveDeskCheck(accessToken, menuIdx)) {
            model.addAttribute("menuIdx", menuIdx);
            model.addAttribute("menu", menuService.showMenu(menuIdx));
            return "owner/modify-menu";
        } else {
            return "redirect:/menu";
        }
    }
}
