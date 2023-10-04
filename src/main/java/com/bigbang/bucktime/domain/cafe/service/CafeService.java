package com.bigbang.bucktime.domain.cafe.service;

import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import com.bigbang.bucktime.domain.cafe.dto.request.ModifyCafeInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMapper cafeMapper;

    public void modifyCafe(ModifyCafeInfoRequest cafeInfo) {
        cafeMapper.updateCafeInfo(cafeInfo);
    }

    public List<CafeEntity> showCafeInfo() {
        return cafeMapper.showCafeInfo();
    }
}
