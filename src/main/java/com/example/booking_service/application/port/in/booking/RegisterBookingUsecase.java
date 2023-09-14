package com.example.booking_service.application.port.in.booking;

import com.example.booking_service.domain.Booking;

public interface RegisterBookingUsecase {
    void registerBooking(Booking booking);
}
