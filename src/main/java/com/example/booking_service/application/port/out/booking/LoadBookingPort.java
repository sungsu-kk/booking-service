package com.example.booking_service.application.port.out.booking;

import com.example.booking_service.domain.Booking;

public interface LoadBookingPort {

    Booking findBooking(Booking booking);

}
