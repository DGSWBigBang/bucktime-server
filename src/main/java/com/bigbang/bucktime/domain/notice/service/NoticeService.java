package com.bigbang.bucktime.domain.notice.service;

import com.bigbang.bucktime.domain.notice.dao.NoticeMapper;
import com.bigbang.bucktime.domain.notice.dto.entity.NoticeEntity;
import com.bigbang.bucktime.domain.notice.dto.request.ModifyNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.request.WriteNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.response.ShowAllNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public void createNotice(WriteNoticeRequest writeNoticeRequest) {
        noticeMapper.createNotice(writeNoticeRequest);
    }

    public void modifyNotice(ModifyNoticeRequest modifyNoticeRequest) {
        noticeMapper.modifyNotice(modifyNoticeRequest);
    }

    public List<ShowAllNoticeResponse> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    public NoticeEntity findByNoticeIdx(Integer noticeIdx) {
        return noticeMapper.findByNoticeIdx(noticeIdx);
    }

    public void deleteNotice(Integer noticeIdx) {
        noticeMapper.deleteNotice(noticeIdx);
    }
}
