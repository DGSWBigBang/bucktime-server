package com.bigbang.bucktime.domain.order.dao;

import com.bigbang.bucktime.domain.order.dto.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    void createOrder(@Param("menuIdx") Integer menuIdx, @Param("userMail") String userMail);

    List<OrderEntity> showUserPoint(String userMail);

    List<OrderEntity> showOwnerPoint(Integer cafeIdx);

    String findMenuName(Integer menuIdx);

    Integer findCafeIdx(Integer menuIdx);

    String findCafeName(Integer cafeIdx);

    Integer findCafeIdxByOwnerMail(String ownerMail);

    void modifyCompletion(Integer menuIdx);
}
