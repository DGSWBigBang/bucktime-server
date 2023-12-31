package com.bigbang.bucktime.domain.menu.service;

import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.menu.dao.MenuMapper;
import com.bigbang.bucktime.domain.menu.dto.request.CreateMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.request.ModifyMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.response.ShowMenuResponse;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final CafeMapper cafeMapper;
    private final MenuMapper menuMapper;
    private final JwtProvider jwtProvider;

    public void createMenu(CreateMenuRequest createMenuRequest, HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        createMenuRequest.setCafeIdx(cafeMapper.showOwnerCafeInfo(userMail).getCafeIdx());
        menuMapper.createMenu(createMenuRequest);
    }

    public void modifyMenu(ModifyMenuRequest modifyMenuRequest) {
        menuMapper.modifyMenu(modifyMenuRequest);
    }

    public void deleteMenu(Integer menuIdx) {
        menuMapper.deleteMenu(menuIdx);
    }

    public List<ShowMenuResponse> showAllMenu(Integer cafeIdx) {
        return menuMapper.showAllMenu(cafeIdx);
    }

    public ShowMenuResponse showMenu(Integer menuIdx) {
        return menuMapper.showMenu(menuIdx);
    }

    public List<ShowMenuResponse> showMenuOwner(HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        Integer cafeIdx = cafeMapper.showOwnerCafeInfo(userMail).getCafeIdx();
        return menuMapper.showAllMenu(cafeIdx);
    }

    public Boolean haveDeskCheck(HttpServletRequest request, Integer menuIdx) {
        String userMail = jwtProvider.getUserMail(request);
        Integer cafeIdx = cafeMapper.showOwnerCafeInfo(userMail).getCafeIdx();
        return menuMapper.countMenuNumber(cafeIdx, menuIdx) >= 1;
    }
}
