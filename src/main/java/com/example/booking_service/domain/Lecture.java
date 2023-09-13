package com.example.booking_service.domain;

import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Lecture {
    private final String speaker;
    private final String title;
    private final String description;
    private final LocalDateTime startDateTime;
    private final Long quantity;

    public LectureEntity toEntity() {
        return new LectureEntity(null, speaker, title, description, startDateTime, quantity);
    }
}
