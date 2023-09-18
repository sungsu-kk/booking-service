package com.example.booking_service.application.port.out.lecture;

import com.example.booking_service.domain.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LoadLecturePort {
   Lecture findLecture(Long id);

   Page<Lecture> findAllLecture(Pageable pageable);

   Page<Lecture> findAvailiableLecture(LocalDateTime start, LocalDateTime end,Pageable pageable);
}
