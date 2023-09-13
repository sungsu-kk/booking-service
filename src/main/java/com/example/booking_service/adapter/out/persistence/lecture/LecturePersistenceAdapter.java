package com.example.booking_service.adapter.out.persistence.lecture;

import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Component
public class LecturePersistenceAdapter implements LoadLecturePort, SaveLecturePort {

    private final LectureRepository lectureRepository;

    @Override
    public Optional<LectureEntity> findLecture(String name) {
        return lectureRepository.findByTitle(name);
    }
    @Override
    public Optional<List<LectureEntity>> findAllLecture() {
        return Optional.of(lectureRepository.findAll());
    }

    @Override
    public Optional<LectureEntity> saveLecture(Lecture lecture) {
        LectureEntity entity = lecture.toEntity();
        return Optional.of(lectureRepository.save(entity));
    }

}
