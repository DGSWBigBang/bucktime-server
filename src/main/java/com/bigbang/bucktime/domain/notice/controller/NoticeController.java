package com.bigbang.bucktime.domain.notice.controller;

import com.bigbang.bucktime.domain.notice.dto.request.ModifyNoticeRequest;
import com.bigbang.bucktime.domain.notice.dto.request.WriteNoticeRequest;
import com.bigbang.bucktime.domain.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
@Tag(name = "NOTICE CONTROLLER", description = "공지 생성, 수정, 불러오기, 삭제")
public class NoticeController {
    private final NoticeService noticeService;

    @Operation(summary = "공지 생성(관리자)")
    @PostMapping("/create")
    public ResponseEntity<String> writeNotice(@RequestBody WriteNoticeRequest writeNoticeRequest) {
        noticeService.createNotice(writeNoticeRequest);
        return ResponseEntity.ok("공지 등록 성공");
    }

    @Operation(summary = "공지 수정(관리자)")
    @PutMapping("/modify")
    public ResponseEntity<String> modifyNotice(@RequestBody ModifyNoticeRequest modifyNoticeRequest) {
        noticeService.modifyNotice(modifyNoticeRequest);
        return ResponseEntity.ok("공지 수정 완료");
    }

    @Operation(summary = "공지 불러오기(관리자)", description = "notice-idx 파람이 없을 때는 공지의 인덱스, 제목, 날짜를 리스트로 불러옴 <br/> notice-idx가 없다면 공지의 상세 정보를 불러옴")
    @GetMapping("/show")
    public ResponseEntity<?> showNotice(@RequestParam(value = "notice-idx", required = false) Integer noticeIdx) {
        if(noticeIdx == null) {
            return ResponseEntity.ok(noticeService.findAllNotice());
        } else {
            return ResponseEntity.ok(noticeService.findByNoticeIdx(noticeIdx));
        }
    }

    @Operation(summary = "공지 삭제(관리자)")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteNotice(@RequestParam(value = "notice-idx") Integer noticeIdx) {
        noticeService.deleteNotice(noticeIdx);
        return ResponseEntity.ok("공지 삭제 완료");
    }
}
