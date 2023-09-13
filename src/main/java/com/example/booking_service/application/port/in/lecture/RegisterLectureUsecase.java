package com.example.booking_service.application.port.in.lecture;

import com.example.booking_service.adapter.in.web.lecture.LectureRequest;
import com.example.booking_service.domain.Lecture;

public interface RegisterLectureUsecase {
    Lecture registerLecture(LectureRequest.RegisterLectureCommand command);
}
