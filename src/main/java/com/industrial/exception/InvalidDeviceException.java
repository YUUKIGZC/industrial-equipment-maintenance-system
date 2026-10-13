package com.industrial.exception;

public class InvalidDeviceException extends RuntimeException {
    public InvalidDeviceException(String message) {
        super(message);
    }
}
