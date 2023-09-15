package com.example.booking_service.adapter.in.web.booking;

import com.example.booking_service.application.port.in.booking.RegisterBookingUsecase;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.common.response.CommonResponse;
import com.example.booking_service.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
class BookingController {
    private final BookingMapper bookingMapper;
    private final RegisterBookingUsecase registerBookingUsecase;

    @PostMapping
    public CommonResponse<?> registerBooking(@RequestBody @Valid BookingRequest.RegisterBookingCommand command){
        Booking booking = bookingMapper.of(command);
        registerBookingUsecase.registerBooking(booking);
        return CommonResponse.success();
    }
    @GetMapping
    public CommonResponse<?> searchBooking(@RequestParam String userNo){

        return null;
    }

}
