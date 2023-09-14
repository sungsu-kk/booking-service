package com.example.booking_service.domain;

import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Value
@Builder
public class Lecture {
    private Long id;
    private String speaker;
    private  String title;
    private  String description;
    private  ZonedDateTime startDateTime;
    private  Long quantity;

}
