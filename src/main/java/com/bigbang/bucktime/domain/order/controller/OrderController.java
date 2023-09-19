package com.bigbang.bucktime.domain.order.controller;

import com.bigbang.bucktime.domain.order.dto.entity.OrderEntity;
import com.bigbang.bucktime.domain.order.dto.reponse.ShowOrderResponse;
import com.bigbang.bucktime.domain.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestParam(value = "menu-idx") Integer menuIdx, HttpServletRequest request) {
        orderService.createOrder(menuIdx, request);
        return ResponseEntity.ok("주문 완료");
    }

    @GetMapping("/show/user")
    public ResponseEntity<List<ShowOrderResponse>> showUserPoint(HttpServletRequest request) {
        return ResponseEntity.ok(orderService.showUserPoint(request));
    }

    @GetMapping("/show/owner")
    public ResponseEntity<List<ShowOrderResponse>> showOwnerPoint(HttpServletRequest request) {
        return ResponseEntity.ok(orderService.showOwnerPoint(request));
    }

    @PutMapping("/modify/completion")
    public ResponseEntity<String> modifyCompletion(@RequestParam("order-idx") Integer orderIdx) {
        orderService.modifyCompletion(orderIdx);
        return ResponseEntity.ok("메뉴 완성");
    }
}
