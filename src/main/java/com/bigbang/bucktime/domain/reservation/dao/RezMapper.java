package com.bigbang.bucktime.domain.reservation.dao;

import com.bigbang.bucktime.domain.reservation.dto.entity.ReservationEntity;
import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RezMapper {
    void createReservation(CreateRezRequest createRezRequest);

    List<ReservationEntity> showReservation(Integer cafeIdx);

    void modifyUsed(Integer rezIdx);
}
