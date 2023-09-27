package com.bigbang.bucktime.domain.menu.service;

import com.bigbang.bucktime.domain.menu.dao.MenuMapper;
import com.bigbang.bucktime.domain.menu.dto.request.CreateMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.request.ModifyMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.response.ShowAllMenuResponse;
import com.bigbang.bucktime.domain.menu.dto.response.ShowMenuResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuMapper menuMapper;

    public void createMenu(CreateMenuRequest createMenuRequest) {
        menuMapper.createMenu(createMenuRequest);
    }

    public void modifyMenu(ModifyMenuRequest modifyMenuRequest) {
        menuMapper.modifyMenu(modifyMenuRequest);
    }

    public void deleteMenu(Integer menuIdx) {
        menuMapper.deleteMenu(menuIdx);
    }

    public List<ShowAllMenuResponse> showAllMenu(Integer cafeIdx) {
        return menuMapper.showAllMenu(cafeIdx);
    }

    public ShowMenuResponse showMenu(Integer menuIdx) {
        return menuMapper.showMenu(menuIdx);
    }
}
