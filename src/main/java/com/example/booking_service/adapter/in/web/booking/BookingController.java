package com.example.booking_service.adapter.in.web.booking;

import com.example.booking_service.application.port.in.booking.RegisterBookingUsecase;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.common.response.CommonResponse;
import com.example.booking_service.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
class BookingController {
    private final BookingMapper bookingMapper;
    private final RegisterBookingUsecase registerBookingUsecase;
    /*
    * 강연 신청
    *   - 강연 신청을 위한 정보(사번, 강연 이름)를 받아서 강연 신청을 한다.
    */
    @PostMapping
    public CommonResponse<?> registerBooking(@RequestBody @Valid BookingRequest.RegisterBookingCommand command){
        Booking booking = bookingMapper.of(command);
        registerBookingUsecase.registerBooking(booking);
        return CommonResponse.success();
    }



}
