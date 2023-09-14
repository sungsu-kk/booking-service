package com.example.booking_service.application.service.lecture;

import com.example.booking_service.application.port.in.lecture.FindLectureUsecase;
import com.example.booking_service.application.port.in.lecture.RegisterLectureUsecase;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LectureService implements FindLectureUsecase, RegisterLectureUsecase {

    private final LoadLecturePort loadLecturePort;
    private final SaveLecturePort saveLecturePort;

    @Override
    public Lecture searchLecture(String name) {
       return loadLecturePort.findLecture(name);
    }

    @Override
    public List<Lecture> searchAllLecture(Pageable pageable) {
        return loadLecturePort.findAllLecture(pageable);
    }

    @Override
    public void registerLecture(Lecture lecture) {
        saveLecturePort.saveLecture(lecture);
    }
}
