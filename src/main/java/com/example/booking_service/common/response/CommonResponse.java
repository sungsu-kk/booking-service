package com.example.booking_service.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private Result result;
    private T data;
    private String errorCode;
    private String message;


    public static<T> CommonResponse<T> success(){
        return CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .build();
    }


    public static <T> CommonResponse<T> success(T data){
        return CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<T> fail(String errorCode,String message){
        return CommonResponse.<T>builder()
                .result(Result.FAIL)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
    public enum Result{
        SUCCESS, FAIL
    }

}
