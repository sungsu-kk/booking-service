package com.example.booking_service.adapter.out.persistence.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    @Query("SELECT b From BookingEntity b where b.lectureEntity.id=:lectureId and b.userNo=:userNo")
    Optional<BookingEntity> findDuplicateBooking(@Param("lectureId") Long lectureId,
                                                 @Param("userNo") String userNo);
}
