package com.bigbang.bucktime.domain.notice.dto.request;

import lombok.Getter;

@Getter
public class ModifyNoticeRequest {
    private Integer noticeIdx;
    private String title;
    private String content;
}
