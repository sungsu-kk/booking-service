package com.example.booking_service.adapter.in.web.lecture;

import com.example.booking_service.domain.Lecture;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LectureRequest {
    @Data
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterLectureCommand{
        @NotBlank(message = "강연자의 정보를 입력해주세요")
        private String speaker;
        @NotBlank(message = "강연의 제목을 입력해주세요")
        private String title;
        @Min(value = 0)
        private Long quantity;
        @Future(message = "강연 시작 시간은 현재 시간보다 미래여야 합니다.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private ZonedDateTime startDateTime;
        private String description;
    }

}
