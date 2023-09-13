package com.example.booking_service.application.port.in.lecture;

import com.example.booking_service.domain.Lecture;

import java.util.List;

public interface FindLectureUsecase {
    Lecture searchLecture(String name);
    List<Lecture> searchAllLecture();
}
