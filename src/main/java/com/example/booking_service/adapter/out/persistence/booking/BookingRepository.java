package com.example.booking_service.adapter.out.persistence.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    Optional<BookingEntity> findBookingEntityByUserNoAndStatus(String userNo, BookingEntity.BookingStatus status);
}
