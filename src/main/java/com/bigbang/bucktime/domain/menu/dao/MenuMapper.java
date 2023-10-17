package com.bigbang.bucktime.domain.menu.dao;

import com.bigbang.bucktime.domain.menu.dto.request.CreateMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.request.ModifyMenuRequest;
import com.bigbang.bucktime.domain.menu.dto.response.ShowAllMenuResponse;
import com.bigbang.bucktime.domain.menu.dto.response.ShowMenuResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    void createMenu(CreateMenuRequest createMenuRequest);

    void modifyMenu(ModifyMenuRequest modifyMenuRequest);

    void deleteMenu(Integer menuIdx);

    List<ShowAllMenuResponse> showAllMenu(Integer cafeIdx);

    ShowMenuResponse showMenu(Integer menuIdx);
}
