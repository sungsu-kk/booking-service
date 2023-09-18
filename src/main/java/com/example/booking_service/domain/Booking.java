package com.example.booking_service.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class Booking {
    private Long id;
    private String userNo;
    private Lecture lecture;
    private String status;
}
