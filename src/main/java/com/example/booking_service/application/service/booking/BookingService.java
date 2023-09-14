package com.example.booking_service.application.service.booking;

import com.example.booking_service.application.port.in.booking.RegisterBookingUsecase;
import com.example.booking_service.application.port.out.booking.SaveBookingPort;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BookingService implements RegisterBookingUsecase {

    private final SaveBookingPort saveBookingPort;
    private final LoadLecturePort loadLecturePort;

    @Override
    public void registerBooking(Booking booking) {
        Lecture lecture = loadLecturePort.findLecture(booking.getLectureName());
        saveBookingPort.saveBooking(booking,lecture);
    }
}
