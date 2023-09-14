package com.example.booking_service.adapter.in.web.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookingRequest {

    @Data
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterBookingCommand{
        @NotBlank(message = "사번을 입력해주세요")
        private String userNo;

        @NotBlank(message = "강연 ID를 입력해주세요")
        private String id;
    }

}
