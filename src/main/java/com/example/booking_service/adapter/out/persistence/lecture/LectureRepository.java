package com.example.booking_service.adapter.out.persistence.lecture;

import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity,Long> {
    Optional<LectureEntity> findByTitle(String name);
}
