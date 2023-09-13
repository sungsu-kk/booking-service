package com.example.booking_service.domain;

import lombok.Data;
import lombok.Value;

@Value
public class Booking {
    private final String userNo;
    private final Lecture lecture;
}
