package com.bigbang.bucktime.domain.notice.dao;

import com.bigbang.bucktime.domain.notice.dto.entity.NoticeEntity;
import com.bigbang.bucktime.domain.notice.dto.request.ModifyNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.request.WriteNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.response.ShowAllNoticeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    void createNotice(WriteNoticeRequest writeNoticeRequest);

    void modifyNotice(ModifyNoticeRequest modifyNoticeRequest);

    List<ShowAllNoticeResponse> findAllNotice();

    NoticeEntity findByNoticeIdx(Integer noticeIdx);
}
