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

@Controller
@RequestMapping("/front/cafe")
@RequiredArgsConstructor
public class OwnerController {
    private final MenuService menuService;


}
