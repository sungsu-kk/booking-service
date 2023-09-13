package com.example.booking_service.application.port.out.lecture;

import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import com.example.booking_service.domain.Lecture;

import java.util.Optional;

public interface SaveLecturePort {
    Optional<LectureEntity> saveLecture(Lecture lecture);
}
