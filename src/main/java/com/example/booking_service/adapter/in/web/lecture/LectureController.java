package com.example.booking_service.adapter.in.web.lecture;


import com.example.booking_service.application.port.in.lecture.FindLectureUsecase;
import com.example.booking_service.application.port.in.lecture.RegisterLectureUsecase;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final FindLectureUsecase findLectureUsecase;
    private final RegisterLectureUsecase registerLectureUsecase;

    @GetMapping
    public ResponseEntity<List<Lecture>> searchLecture(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            //단건조회
            return null;
        } else {
            return ResponseEntity.ok(findLectureUsecase.searchAllLecture());
        }
    }

    @PostMapping
    public ResponseEntity registerLecture(@RequestBody @Valid LectureRequest.RegisterLectureCommand command) {
        Lecture lecture = registerLectureUsecase.registerLecture(command);
        return ResponseEntity.ok(lecture);
    }
}
