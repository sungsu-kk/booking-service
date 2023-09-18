package com.example.booking_service.application.port.in;

import com.example.booking_service.domain.Booking;

public interface FindBookingUsecase {

    Booking searchBooking(String userNo);
}
