package com.bigbang.bucktime.domain.cafe.dao;

import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import com.bigbang.bucktime.domain.cafe.dto.request.ModifyCafeInfoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CafeMapper {
    CafeEntity getCafeById(Long id);

    void updateCafeInfo(ModifyCafeInfoRequest cafe);

    List<CafeEntity> showCafeInfo();
}