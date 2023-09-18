package com.example.booking_service.application.port.out;

import com.example.booking_service.adapter.out.persistence.booking.BookingEntity;

public interface DeleteBookingPort {

    void updateStatusBooking(Long id, String status);
}
