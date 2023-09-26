package com.bigbang.bucktime.domain.reservation.dao;

import com.bigbang.bucktime.domain.reservation.dto.request.CreateRezRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RezMapper {
    void createReservation(CreateRezRequest createRezRequest);
}
