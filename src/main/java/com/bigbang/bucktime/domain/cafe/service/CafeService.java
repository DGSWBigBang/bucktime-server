package com.bigbang.bucktime.domain.cafe.service;

import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMapper cafeMapper;

    public void modifyCafe(CafeEntity cafe) {
        cafeMapper.updateCafeInfo(cafe);
    }
}
