package com.example.booking_service.application.port.out.lecture;

import com.example.booking_service.domain.Lecture;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LoadLecturePort {
   Lecture findLecture(Long id);
   List<Lecture> findAllLecture(Pageable pageable);
}
