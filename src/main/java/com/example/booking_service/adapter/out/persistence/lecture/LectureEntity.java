package com.example.booking_service.adapter.out.persistence.lecture;

import com.example.booking_service.adapter.out.BaseTimeEntity;
import com.example.booking_service.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LectureEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String speaker;
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private Long quantity;


    public Lecture toDomain(){
        return new Lecture(speaker, title, description, startDateTime, quantity);
    }
}
