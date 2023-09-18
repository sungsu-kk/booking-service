package com.example.booking_service.application.port.in.lecture;

import com.example.booking_service.domain.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindLectureUsecase {
    Page<Lecture> searchAllLecture(Pageable pageable);

    Page<Lecture> searchAvailiableLecture(Pageable pageable);
}
