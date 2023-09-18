package com.example.booking_service.adapter.out.persistence.lecture;

import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.common.mapper.LectureMapper;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class LecturePersistenceAdapter implements LoadLecturePort, SaveLecturePort {

    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;


    @Override
    public Lecture findLecture(Long id) {
        LectureEntity lectureEntity = lectureRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return lectureMapper.of(lectureEntity);
    }

    @Override
    public Page<Lecture> findAllLecture(Pageable pageable) {
        Page<LectureEntity> result = lectureRepository.findAll(pageable);
        if(result.isEmpty()){
            throw new NoSuchElementException("등록된 강연이 존재하지 않습니다.");
        }
        return result.map(lectureMapper::of);
    }

    @Override
    public Page<Lecture> findAvailiableLecture(LocalDateTime start, LocalDateTime end,Pageable pageable) {
        Page<LectureEntity> result = lectureRepository.findAviableLecture(start,end,pageable);
        if(result.isEmpty()){
            throw new NoSuchElementException("신청 가능한 강연이 없습니다.");
        }
        return result.map(lectureMapper::of);
    }

    @Override
    public void saveLecture(Lecture lecture) {
        lectureRepository.save(lectureMapper.of(lecture));
    }
}
