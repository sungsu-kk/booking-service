package com.example.booking_service.adapter.out.persistence.lecture;

import com.example.booking_service.adapter.out.BaseTimeEntity;
import com.example.booking_service.adapter.out.persistence.booking.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="lecture")
public class LectureEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String speaker;
    private String place;
    private String contents;
    private ZonedDateTime startDateTime;
    private Long capacity;

    @OneToMany(mappedBy = "lectureEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BookingEntity> bookingList = new ArrayList<>();

}
