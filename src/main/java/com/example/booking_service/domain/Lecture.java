package com.example.booking_service.domain;

import com.example.booking_service.adapter.out.persistence.booking.BookingEntity;
import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Lecture {

    private Long id;
    private String speaker;
    private String place;
    private String contents;
    @Builder.Default
    private List<Booking> bookingList = new ArrayList<>();
    private LocalDateTime registerDateTime;
    private LocalDateTime startDateTime;
    private Long capacity;

    public void reduceCapacity() {
        if (this.capacity < 0) {
            throw new IllegalStateException();
        }
        this.capacity -= 1;
    }

    public void addCapacity() {
        this.capacity += 1;
    }

    public void addBooking(Booking booking){
        this.bookingList.add(booking);
    }


}
