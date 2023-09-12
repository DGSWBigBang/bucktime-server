package com.bigbang.bucktime.domain.cafe.dao;

import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {
    CafeEntity getCafeById(Long id);

    void updateCafeInfo(CafeEntity cafe);
}