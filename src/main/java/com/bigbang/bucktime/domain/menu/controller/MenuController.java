package com.bigbang.bucktime.domain.menu.controller;

import com.bigbang.bucktime.domain.menu.dto.request.CreateMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.request.ModifyMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.response.ShowMenuResponse;
import com.bigbang.bucktime.domain.menu.service.MenuService;
import com.bigbang.bucktime.global.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Tag(name = "MENU CONTROLLER", description = "메뉴 정보 추가, 수정, 삭제, 불러오기")
public class MenuController {
    private final MenuService menuService;

    @Operation(summary = "메뉴 생성")
    @PostMapping("/create")
    public ResponseEntity<Response> createMenu(@RequestBody CreateMenuRequest createMenuRequest) {
        menuService.createMenu(createMenuRequest);
        return ResponseEntity.ok(Response.of("메뉴 생성 완료"));
    }

    @Operation(summary = "메뉴 수정")
    @PutMapping("/modify")
    public ResponseEntity<Response> modifyMenu(@RequestBody ModifyMenuRequest modifyMenuRequest) {
        menuService.modifyMenu(modifyMenuRequest);
        return ResponseEntity.ok(Response.of("메뉴 수정 완료"));
    }

    @Operation(summary = "메뉴 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteMenu(@RequestParam(value = "menu-idx") Integer menuIdx) {
        menuService.deleteMenu(menuIdx);
        return ResponseEntity.ok(Response.of("메뉴 삭제 완료"));
    }

    @Operation(summary = "메뉴 정보 불러오기", description = "cafe-idx 파람만 있을 때는 그 카페의 메뉴 정보들이 리스트로 간소화 해서 불러옴 <br/> menu-idx 파람만 있을 때는 그 메뉴의 상세 정보를 불러옴 <br/> 둘다 있거나 없다면 bad request 반환")
    @GetMapping("/show")
    public ResponseEntity<?> showMenu(@RequestParam(value = "cafe-idx", required = false) Integer cafeIdx, @RequestParam(value = "menu-idx", required = false) Integer menuIdx) {
        if(menuIdx == null && cafeIdx != null) {
            return ResponseEntity.ok(menuService.showAllMenu(cafeIdx));
        } else if(menuIdx != null && cafeIdx == null) {
            return ResponseEntity.ok(menuService.showMenu(menuIdx));
        } else {
            return ResponseEntity.badRequest().body(Response.of("데이터가 유효하지 않음"));
        }
    }

    @Operation(summary = "메뉴 리스트 불러오기(사장)", description = "리스트로 불러옴")
    @GetMapping("/show/owner")
    public ResponseEntity<List<ShowMenuResponse>> showMenuList(HttpServletRequest request) {
        return ResponseEntity.ok(menuService.showMenuOwner(request));

    }
}