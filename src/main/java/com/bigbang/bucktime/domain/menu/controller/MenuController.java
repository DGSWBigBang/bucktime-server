package com.bigbang.bucktime.domain.menu.controller;

import com.bigbang.bucktime.domain.menu.dto.request.CreateMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.request.ModifyMenuRequest;
import com.bigbang.bucktime.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/create")
    public ResponseEntity<String> createMenu(@RequestBody CreateMenuRequest createMenuRequest) {
        menuService.createMenu(createMenuRequest);
        return ResponseEntity.ok("메뉴 생성 완료");
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyMenu(@RequestBody ModifyMenuRequest modifyMenuRequest) {
        menuService.modifyMenu(modifyMenuRequest);
        return ResponseEntity.ok("메뉴 수정 완료");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMenu(@RequestParam(value = "menu-idx") Integer menuIdx) {
        menuService.deleteMenu(menuIdx);
        return ResponseEntity.ok("메뉴 삭제 완료");
    }

    @GetMapping("/show")
    public ResponseEntity<?> showMenu(@RequestParam(value = "cafe-idx") Integer cafeIdx, @RequestParam(value = "menuIdx", required = false) Integer menuIdx) {
        if(menuIdx == null) {
            return ResponseEntity.ok(menuService.showAllMenu(cafeIdx));
        } else {
            return ResponseEntity.ok(menuService.showMenu(cafeIdx, menuIdx));
        }
    }
}
