package com.example.booking_service.adapter.out.persistence.booking;

import com.example.booking_service.application.port.out.DeleteBookingPort;
import com.example.booking_service.application.port.out.LoadBookingPort;
import com.example.booking_service.application.port.out.SaveBookingPort;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BookingPersistenceAdapter implements SaveBookingPort, LoadBookingPort, DeleteBookingPort {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public void saveBooking(Booking booking) {
        bookingRepository.save(bookingMapper.of(booking));
    }

    @Override
    public Boolean isExisisBooking(Booking booking) {
        Optional<BookingEntity> existsBooking = bookingRepository.findBookingEntityByUserNoAndStatus(booking.getUserNo(), BookingEntity.BookingStatus.BOOKED);
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

    @Override
    public Booking findBooking(Long id) {
        BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 예약정보가 존재하지 않습니다"));
        return bookingMapper.of(bookingEntity);
    }

    @Override
    public void updateStatusBooking(Long id, String status) {

    }
}