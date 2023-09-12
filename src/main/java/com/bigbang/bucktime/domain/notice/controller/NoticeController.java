package com.bigbang.bucktime.domain.notice.controller;

import com.bigbang.bucktime.domain.notice.dto.entity.NoticeEntity;
import com.bigbang.bucktime.domain.notice.dto.request.ModifyNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.request.WriteNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.response.ShowAllNoticeResponse;
import com.bigbang.bucktime.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/create")
    public ResponseEntity<String> writeNotice(@RequestBody WriteNoticeRequest writeNoticeRequest) {
        System.out.println(writeNoticeRequest.getTitle());
        System.out.println(writeNoticeRequest.getContent());
        noticeService.createNotice(writeNoticeRequest);
        return ResponseEntity.ok("공지 등록 성공");
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyNotice(@RequestBody ModifyNoticeRequest modifyNoticeRequest) {
        noticeService.modifyNotice(modifyNoticeRequest);
        return ResponseEntity.ok("공지 수정 완료");
    }

    @GetMapping("/show")
    public ResponseEntity<List<ShowAllNoticeResponse>> showAllNotice() {
        return ResponseEntity.ok(noticeService.findAllNotice());
    }

    @GetMapping("/show/{noticeIdx}")
    public ResponseEntity<NoticeEntity> showNotice(@PathVariable("noticeIdx") Integer noticeIdx) {
        return ResponseEntity.ok(noticeService.findByNoticeIdx(noticeIdx));
    }
}
