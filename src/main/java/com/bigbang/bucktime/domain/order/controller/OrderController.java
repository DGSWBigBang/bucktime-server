package com.bigbang.bucktime.domain.order.controller;

import com.bigbang.bucktime.domain.order.dto.reponse.ShowOrderResponse;
import com.bigbang.bucktime.domain.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "ORDER CONTROLLER", description = "주문, 주문 정보 불러오기, 메뉴 완성")
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "주문(유저)")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestParam(value = "menu-idx") Integer menuIdx, HttpServletRequest request) {
        orderService.createOrder(menuIdx, request);
        return ResponseEntity.ok("주문 완료");
    }

    @Operation(summary = "주문 정보 불러오기(유저)")
    @GetMapping("/show/user")
    public ResponseEntity<List<ShowOrderResponse>> showUserPoint(HttpServletRequest request) {
        return ResponseEntity.ok(orderService.showUserPoint(request));
    }

    @Operation(summary = "주문 정보 불러오기(사장)")
    @GetMapping("/show/owner")
    public ResponseEntity<List<ShowOrderResponse>> showOwnerPoint(HttpServletRequest request) {
        return ResponseEntity.ok(orderService.showOwnerPoint(request));
    }

    @Operation(summary = "메뉴 완성(사장)")
    @PutMapping("/modify/completion")
    public ResponseEntity<String> modifyCompletion(@RequestParam("order-idx") Integer orderIdx) {
        orderService.modifyCompletion(orderIdx);
        return ResponseEntity.ok("메뉴 완성");
    }
}
