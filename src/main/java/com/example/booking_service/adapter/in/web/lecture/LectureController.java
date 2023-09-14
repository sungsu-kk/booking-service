package com.example.booking_service.adapter.in.web.lecture;


import com.example.booking_service.application.port.in.lecture.FindLectureUsecase;
import com.example.booking_service.application.port.in.lecture.RegisterLectureUsecase;
import com.example.booking_service.common.mapper.LectureMapper;
import com.example.booking_service.common.response.CommonResponse;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("lecture")
class LectureController {

    private final FindLectureUsecase findLectureUsecase;
    private final RegisterLectureUsecase registerLectureUsecase;
    private final LectureMapper lectureMapper;

    @GetMapping
    public CommonResponse<?> searchLecture(@RequestParam(required = false) String name, Pageable pageable) {
        if (name != null && !name.isEmpty()) {
            return CommonResponse.success(findLectureUsecase.searchLecture(name));
        } else {
            return CommonResponse.success(findLectureUsecase.searchAllLecture(pageable));
        }
    }

    @PostMapping
    public CommonResponse<?> registerLecture(@RequestBody @Valid LectureRequest.RegisterLectureCommand command) {
        Lecture lecture = lectureMapper.of(command);
        registerLectureUsecase.registerLecture(lecture);
        return CommonResponse.success();
    }
}
