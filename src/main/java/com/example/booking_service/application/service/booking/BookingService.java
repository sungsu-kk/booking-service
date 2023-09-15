package com.example.booking_service.application.service.booking;

import com.example.booking_service.application.port.in.booking.FindBookingUsecase;
import com.example.booking_service.application.port.in.booking.RegisterBookingUsecase;
import com.example.booking_service.application.port.out.booking.LoadBookingPort;
import com.example.booking_service.application.port.out.booking.SaveBookingPort;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BookingService implements RegisterBookingUsecase, FindBookingUsecase {

    private final SaveBookingPort saveBookingPort;
    private final LoadBookingPort loadBookingPort;
    private final LoadLecturePort loadLecturePort;

    @Override
    public void registerBooking(Booking booking) {
        if(!loadBookingPort.isExisisBooking(booking)){
            Lecture lecture = loadLecturePort.findLecture(booking.getLectureId());
            saveBookingPort.saveBooking(booking, lecture);
        }
    }

    @Override
    public Booking searchBooking(String userNo) {

        return loadBookingPort.findBooking(userNo);
    }
}
