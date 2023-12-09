package com.bigbang.bucktime.domain.cafe.service;

import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.cafe.dto.entity.CafeEntity;
import com.bigbang.bucktime.domain.cafe.dto.request.ModifyCafeInfoRequest;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMapper cafeMapper;
    private final JwtProvider jwtProvider;

    public void modifyCafe(ModifyCafeInfoRequest cafeInfo) {
        cafeMapper.updateCafeInfo(cafeInfo);
    }

    public List<CafeEntity> showCafeInfo() {
        List<CafeEntity> cafeInfoList = cafeMapper.showCafeInfo();
        return cafeInfoList == null ? new ArrayList<>() : cafeInfoList;
    }

    public CafeEntity showOwnerCafeInfo(HttpServletRequest request) {
        String ownerMail = jwtProvider.getUserMail(request);
        return cafeMapper.showOwnerCafeInfo(ownerMail);
    }

    public void createCafe(CafeEntity cafeInfo) {
        cafeMapper.createCafe(cafeInfo);
    }
}
