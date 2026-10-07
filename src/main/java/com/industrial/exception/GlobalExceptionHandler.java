package com.industrial.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice:
@RestControllerAdvice
public class GlobalExceptionHandler {
    //@ExceptionHandler:
    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<String> handleDeviceNotFound(DeviceNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
