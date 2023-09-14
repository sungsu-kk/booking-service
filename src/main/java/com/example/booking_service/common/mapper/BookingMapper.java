package com.example.booking_service.common.mapper;

import com.example.booking_service.adapter.in.web.booking.BookingRequest;
import com.example.booking_service.adapter.out.persistence.booking.BookingEntity;
import com.example.booking_service.domain.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public Booking of(BookingRequest.RegisterBookingCommand command){
        return Booking.builder()
                .userNo(command.getUserNo())
                .lectureId(Long.parseLong(command.getId()))
                .build();
    }

    public Booking of(BookingEntity entity){
        return Booking.builder()
                .id(entity.getId())
                .userNo(entity.getUserNo())
                .lectureId(entity.getLectureEntity().getId())
                .status(entity.getStatus().toString())
                .build();
    }

    public BookingEntity of (Booking booking){
        return BookingEntity.builder()
                .userNo(booking.getUserNo())
                .status(BookingEntity.BookingStatus.BOOKED)
                .build();
    }

}
