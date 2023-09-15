package com.example.booking_service.adapter.out.persistence.booking;

import com.example.booking_service.adapter.out.BaseTimeEntity;
import com.example.booking_service.adapter.out.persistence.lecture.LectureEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="booking")
public class BookingEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userNo;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="lecture_id")
    private LectureEntity lectureEntity;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public void changeLecture(LectureEntity lectureEntity){
        this.lectureEntity = lectureEntity;
    }

    public enum BookingStatus{
        BOOKED,CANCELED,FINISHED
    }

}
