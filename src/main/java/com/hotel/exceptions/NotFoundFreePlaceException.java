package com.hotel.exceptions;

public class NotFoundFreePlaceException extends RuntimeException {
    public NotFoundFreePlaceException(String message) {
        super(message);
    }
}
