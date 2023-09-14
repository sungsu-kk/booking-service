package com.example.booking_service.adapter.out.persistence.lecture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LectureRepository extends JpaRepository<LectureEntity,Long> {
    Page<LectureEntity> findAll(Pageable pageable);
}
