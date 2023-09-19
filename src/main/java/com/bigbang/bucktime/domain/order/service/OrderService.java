package com.bigbang.bucktime.domain.order.service;

import com.bigbang.bucktime.domain.order.dao.OrderMapper;
import com.bigbang.bucktime.domain.order.dto.entity.OrderEntity;
import com.bigbang.bucktime.domain.order.dto.reponse.ShowOrderResponse;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final JwtProvider jwtProvider;
    private final OrderMapper orderMapper;

    public void createOrder(Integer menuIdx, HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        orderMapper.createOrder(menuIdx, userMail);
    }

    public List<ShowOrderResponse> showUserPoint(HttpServletRequest request) {
        List<OrderEntity> orderList = orderMapper.showUserPoint(jwtProvider.getUserMail(request));
        List<ShowOrderResponse> orderResponseList = new ArrayList<>();
        for (OrderEntity order: orderList) {
            Integer cafeIdx = orderMapper.findCafeIdx(order.getMenuIdx());
            ShowOrderResponse orderResponse = new ShowOrderResponse();
            orderResponse.setOrderIdx(order.getOrderIdx());
            orderResponse.setOrderTime(order.getOrderTime());
            orderResponse.setMenuName(orderMapper.findMenuName(order.getMenuIdx()));
            orderResponse.setCafeName(orderMapper.findCafeName(cafeIdx));
            orderResponse.setCompletion(order.getCompletion() == 1 ? "완료" : "대기중");
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

    public List<ShowOrderResponse> showOwnerPoint(HttpServletRequest request) {
        Integer cafeIdx = orderMapper.findCafeIdxByOwnerMail(jwtProvider.getUserMail(request));
        List<OrderEntity> orderList = orderMapper.showOwnerPoint(cafeIdx);
        List<ShowOrderResponse> orderResponseList = new ArrayList<>();
        for (OrderEntity order: orderList) {
            ShowOrderResponse orderResponse = new ShowOrderResponse();
            orderResponse.setOrderIdx(order.getOrderIdx());
            orderResponse.setOrderTime(order.getOrderTime());
            orderResponse.setMenuName(orderMapper.findMenuName(order.getMenuIdx()));
            orderResponse.setCafeName(orderMapper.findCafeName(cafeIdx));
            orderResponse.setCompletion(order.getCompletion() == 1 ? "완료" : "대기중");
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

    public void modifyCompletion(Integer orderIdx) {
        orderMapper.modifyCompletion(orderIdx);
    }
}
