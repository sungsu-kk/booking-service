package com.example.booking_service.adapter.in.web;

import com.example.booking_service.application.port.in.CancelBookingUseCase;
import com.example.booking_service.application.port.in.FindBookingUsecase;
import com.example.booking_service.application.port.in.RegisterBookingUsecase;
import com.example.booking_service.common.mapper.BookingMapper;
import com.example.booking_service.common.response.CommonResponse;
import com.example.booking_service.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
class BookingController {
    private final BookingMapper bookingMapper;
    private final RegisterBookingUsecase registerBookingUsecase;
    private final FindBookingUsecase findBookingUsecase;
    private final CancelBookingUseCase cancelBookingUseCase;

    @PostMapping
    public CommonResponse<?> registerBooking(@RequestBody @Valid BookingRequest.RegisterBookingCommand command){
        Booking booking = bookingMapper.of(command);
        registerBookingUsecase.registerBooking(booking);
        return CommonResponse.success();
    }
    @GetMapping
    public CommonResponse<Booking> searchBooking(@RequestParam @NotEmpty(message = "사번은 반드시 입력되어야합니다.") String userNo){
        Booking booking = findBookingUsecase.searchBooking(userNo);
        return CommonResponse.success(booking);
    }

    @PutMapping
    public CommonResponse cancelBooking(@RequestParam @NotEmpty Long id){
        cancelBookingUseCase.cancelBooking(id);
        return CommonResponse.success();
    }

}
