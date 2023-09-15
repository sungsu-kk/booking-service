package com.example.booking_service.application.port.in.booking;

import com.example.booking_service.domain.Booking;

public interface FindBookingUsecase {

    Booking searchBooking(String userNo);
}
