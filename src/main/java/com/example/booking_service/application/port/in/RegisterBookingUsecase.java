package com.example.booking_service.application.port.in;

import com.example.booking_service.domain.Booking;

public interface RegisterBookingUsecase {
    void registerBooking(Booking booking);
}
