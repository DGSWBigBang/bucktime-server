package com.bigbang.bucktime.domain.reservation.dao;

import com.bigbang.bucktime.domain.reservation.dto.InsertReservationData;
import com.bigbang.bucktime.domain.reservation.dto.entity.ReservationEntity;
import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RezMapper {
    void createReservation(InsertReservationData insertReservationData);

    List<ReservationEntity> showReservationList(Integer cafeIdx);

    ReservationEntity showReservationByUserMail(@Param("userMail") String userMail);

    String getFinishTimeByDeskIdx(Integer deskIdx);

    void extensionFinishTime(@Param(value = "deskIdx") Integer deskIdx, @Param(value = "finishTime") String finishTime);
}
