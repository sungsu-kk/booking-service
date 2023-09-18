package com.example.booking_service.application.service;

import com.example.booking_service.application.port.in.CancelBookingUseCase;
import com.example.booking_service.application.port.in.FindBookingUsecase;
import com.example.booking_service.application.port.in.RegisterBookingUsecase;
import com.example.booking_service.application.port.out.DeleteBookingPort;
import com.example.booking_service.application.port.out.LoadBookingPort;
import com.example.booking_service.application.port.out.SaveBookingPort;
import com.example.booking_service.application.port.out.lecture.LoadLecturePort;
import com.example.booking_service.application.port.out.lecture.SaveLecturePort;
import com.example.booking_service.domain.Booking;
import com.example.booking_service.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class BookingService implements RegisterBookingUsecase, FindBookingUsecase, CancelBookingUseCase {

    private final LoadBookingPort loadBookingPort;

    private final DeleteBookingPort deleteBookingPort;

    private final SaveLecturePort saveLecturePort;
    private final LoadLecturePort loadLecturePort;


    @Override
    @Transactional
    public void registerBooking(Booking booking) {
        if(!loadBookingPort.isExisisBooking(booking)){
            /*
            * 수강신청 정보 조회
            * 강의 조회 (Lock)
            * 강의 수강신청
            * 수강신청 정보 저장
            * */
            Lecture lecture = loadLecturePort.findLecture(booking.getLecture().getId());
            lecture.reduceCapacity();
            lecture.addBooking(booking);
            saveLecturePort.saveLecture(lecture);
        }
    }

    @Override
    public Booking searchBooking(String userNo) {

        return loadBookingPort.findBooking(userNo);
    }


    @Override
    public void cancelBooking(Long id) {

        Booking booking = loadBookingPort.findBooking(id);
        Lecture lecture=  loadLecturePort.findLecture(booking.getLecture().getId());
        lecture.addCapacity();
        lecture.addBooking(booking);

        deleteBookingPort.updateStatusBooking(id, "CANCELED");
    }
}
