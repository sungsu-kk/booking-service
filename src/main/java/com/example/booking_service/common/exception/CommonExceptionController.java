package com.example.booking_service.common.exception;

import com.example.booking_service.common.response.CommonResponse;
import com.example.booking_service.common.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
@Slf4j
public class CommonExceptionController {

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleException(Exception e) {
        log.error("[exception] = {}", e);
        return CommonResponse.fail("INTERNAL_SERVER_ERROR", "internal server error");
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public CommonResponse<?> noSuchElementException(NoSuchElementException e){
        log.error("[exception] = {}","test", e);
        return CommonResponse.fail("NOT_FOUND", "no data found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<?> InvalidArgumentException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError fe = bindingResult.getFieldError();
        if (fe != null) {
            String message = "Request Error" + " " + fe.getField() + "=" + fe.getRejectedValue() + " (" + fe.getDefaultMessage() + ")";
            return CommonResponse.fail(message, ErrorCode.COMMON_INVALID_PARAMETER.name());
        } else {
            return CommonResponse.fail(ErrorCode.COMMON_INVALID_PARAMETER.name(),ErrorCode.COMMON_INVALID_PARAMETER.getErrorMsg() );
        }
    }

}
