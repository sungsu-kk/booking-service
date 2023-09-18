package com.example.booking_service.common.mapper;

import com.example.booking_service.adapter.in.web.BookingRequest;
import com.example.booking_service.adapter.out.persistence.booking.BookingEntity;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingMapper {

    private final LectureMapper lectureMapper;

    public Booking of(BookingRequest.RegisterBookingCommand command){
        return Booking.builder()
                .userNo(command.getUserNo())
                .lecture(Lecture.builder().id(Long.parseLong(command.getId())).build())
                .build();
    }

    public Booking of(BookingEntity entity){
        return Booking.builder()
                .id(entity.getId())
                .userNo(entity.getUserNo())
                .lecture(lectureMapper.of(entity.getLectureEntity()))
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
