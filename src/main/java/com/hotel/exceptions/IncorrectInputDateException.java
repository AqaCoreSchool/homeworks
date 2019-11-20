package com.hotel.exceptions;

public class IncorrectInputDateException extends RuntimeException {
    public IncorrectInputDateException(String message){
        super(message);
    }
}
