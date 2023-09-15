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
    public ResponseEntity<?> showNotice(@RequestParam(value = "noticeIdx", required = false) Integer noticeIdx) {
        if(noticeIdx == null) {
            return ResponseEntity.ok(noticeService.findAllNotice());
        } else {
            return ResponseEntity.ok(noticeService.findByNoticeIdx(noticeIdx));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteNotice(@RequestParam(value = "noticeIdx") Integer noticeIdx) {
        noticeService.deleteNotice(noticeIdx);
        return ResponseEntity.ok("공지 삭제 완료");
    }
}
