package com.example.booking_service.adapter.out.persistence.booking;

import com.example.booking_service.application.port.out.booking.SaveBookingPort;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.common.mapper.LectureMapper;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookingPersistenceAdapter implements SaveBookingPort {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final LectureMapper lectureMapper;

    @Override
    public void saveBooking(Booking booking, Lecture lecture){
        BookingEntity bookingEntity = bookingMapper.of(booking);
        bookingEntity.setLecture(lectureMapper.of(lecture));
        bookingRepository.save(bookingEntity);
    }
}

