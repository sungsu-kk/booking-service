package com.example.booking_service.application.service.lecture;

import com.example.booking_service.application.port.in.lecture.FindLectureUsecase;
import com.example.booking_service.application.port.in.lecture.RegisterLectureUsecase;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
class LectureService implements FindLectureUsecase, RegisterLectureUsecase {

    private final LoadLecturePort loadLecturePort;
    private final SaveLecturePort saveLecturePort;

    @Override
    public Page<Lecture> searchAllLecture(Pageable pageable) {
        return loadLecturePort.findAllLecture(pageable);
    }

    @Override
    public Page<Lecture> searchAvailiableLecture(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now();
        return loadLecturePort.findAvailiableLecture(now,now.minusDays(1), pageable);
    }
    @Override
    public void registerLecture(Lecture lecture) {
        saveLecturePort.saveLecture(lecture);
    }
}
