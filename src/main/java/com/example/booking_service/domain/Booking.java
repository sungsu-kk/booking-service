package com.example.booking_service.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class Booking {
    private Long id;
    private String userNo;
    private String lectureName;
    private Boolean isCanceled;

}
