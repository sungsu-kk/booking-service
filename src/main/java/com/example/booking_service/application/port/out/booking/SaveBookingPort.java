package com.example.booking_service.application.port.out.booking;

import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;

public interface SaveBookingPort {
    void saveBooking(Booking booking, Lecture lecture);
}
