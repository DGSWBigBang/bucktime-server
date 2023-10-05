package com.bigbang.bucktime.domain.desk.dao;

import com.bigbang.bucktime.domain.desk.dto.entity.DeskEntity;
import com.bigbang.bucktime.domain.desk.dto.request.CreateDeskRequest;
import com.bigbang.bucktime.domain.desk.dto.request.ModifyDeskRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeskMapper {
    void createDesk(CreateDeskRequest createDeskRequest);

    void modifyDesk(ModifyDeskRequest modifyDeskRequest);

    void deleteDesk(Integer deskIdx);

    List<DeskEntity> findDesk(Integer cafeIdx);

    List<DeskEntity> findOwnerDesk(String ownerMail);
}
