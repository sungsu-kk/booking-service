package com.example.booking_service.common.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
        super("Entity Not Found");
    }
    public EntityNotFoundException(String message) {
        super(message);
    }

}
