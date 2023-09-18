package com.example.booking_service.adapter.out.persistence.lecture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity,Long> {
    Page<LectureEntity> findAll(Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<LectureEntity> findById(Long id);
    @Query("select l from LectureEntity l where l.registerDateTime <= :start and l.startDateTime >= :end")
    Page<LectureEntity> findAviableLecture(@Param("start") LocalDateTime start,
                                           @Param("end") LocalDateTime end,
                                           Pageable pageable);
}
