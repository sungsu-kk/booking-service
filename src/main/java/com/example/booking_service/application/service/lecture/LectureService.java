package com.example.booking_service.application.service.lecture;

import com.example.booking_service.adapter.in.web.lecture.LectureRequest;
import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import com.example.booking_service.application.port.in.lecture.FindLectureUsecase;
import com.example.booking_service.application.port.in.lecture.RegisterLectureUsecase;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService implements FindLectureUsecase, RegisterLectureUsecase {

    private final LoadLecturePort loadLecturePort;
    private final SaveLecturePort saveLecturePort;

    @Override
    public Lecture searchLecture(String name) {
        return loadLecturePort.findLecture(name)
                .orElseThrow(()->new RuntimeException("강의 조회 실패")).toDomain();
    }

    @Override
    public List<Lecture> searchAllLecture() {
       return loadLecturePort.findAllLecture()
                .orElseThrow(()->new RuntimeException("강의 목록 조회 실패"))
                .stream().map(LectureEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Lecture registerLecture(LectureRequest.RegisterLectureCommand command) {
        return saveLecturePort.saveLecture(command.toDomain()).
                orElseThrow(() -> new RuntimeException("강의 등록 실패")).toDomain();
    }
}
