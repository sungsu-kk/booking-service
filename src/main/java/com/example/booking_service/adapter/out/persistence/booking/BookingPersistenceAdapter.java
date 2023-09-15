package com.example.booking_service.adapter.out.persistence.booking;

import com.example.booking_service.application.port.out.booking.LoadBookingPort;
import com.example.booking_service.application.port.out.booking.SaveBookingPort;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.common.mapper.LectureMapper;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BookingPersistenceAdapter implements SaveBookingPort, LoadBookingPort {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final LectureMapper lectureMapper;

    @Override
    public void saveBooking(Booking booking, Lecture lecture) {
        BookingEntity bookingEntity = bookingMapper.of(booking);
        bookingEntity.changeLecture(lectureMapper.of(lecture));
        bookingRepository.save(bookingEntity);
    }

    @Override
    public Boolean isExisisBooking(Booking booking) {
        Optional<BookingEntity> existsBooking =
                bookingRepository.findBookingEntityByUserNoAndStatus(booking.getUserNo(), BookingEntity.BookingStatus.BOOKED);
        if (existsBooking.isPresent()) {
            throw new IllegalStateException("이미 신청한 강연이 존재합니다.");
        }
        return false;
    }

    @Override
    public Booking findBooking(String userNo) {
        BookingEntity bookingEntity = bookingRepository.findBookingEntityByUserNoAndStatus(userNo, BookingEntity.BookingStatus.BOOKED)
                .orElseThrow(() -> new NoSuchElementException("예약된 강연이 없습니다."));
        return bookingMapper.of(bookingEntity);
    }
}