package com.bigbang.bucktime.domain.desk.service;

import com.bigbang.bucktime.domain.cafe.dao.CafeMapper;
import com.bigbang.bucktime.domain.desk.dao.DeskMapper;
import com.bigbang.bucktime.domain.desk.dto.entity.DeskEntity;
import com.bigbang.bucktime.domain.desk.dto.request.CreateDeskRequest;
import com.bigbang.bucktime.domain.desk.dto.request.ModifyDeskRequest;
import com.bigbang.bucktime.global.jwt.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeskService {
    private final DeskMapper deskMapper;
    private final CafeMapper cafeMapper;
    private final JwtProvider jwtProvider;

    public void createDesk(CreateDeskRequest createDeskRequest, HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        Integer cafeIdx = cafeMapper.showOwnerCafeInfo(userMail).getCafeIdx();
        createDeskRequest.setCafeIdx(cafeIdx);
        deskMapper.createDesk(createDeskRequest);
    }

    public void modifyDesk(ModifyDeskRequest modifyDeskRequest) {
        deskMapper.modifyDesk(modifyDeskRequest);
    }

    public void deleteDesk(Integer deskIdx) {
        deskMapper.deleteDesk(deskIdx);
    }

    public List<DeskEntity> findDesk(Integer cafeIdx) {
        return deskMapper.findDesk(cafeIdx);
    }

    public List<DeskEntity> findOwnerDesk(HttpServletRequest request) {
        String userMail = jwtProvider.getUserMail(request);
        return deskMapper.findOwnerDesk(userMail);
    }
}
