package com.example.booking_service.application.port.out.lecture;

import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;

import java.util.List;
import java.util.Optional;

public interface LoadLecturePort {

    Optional<LectureEntity> findLecture(String name);

    Optional<List<LectureEntity>> findAllLecture();
}
