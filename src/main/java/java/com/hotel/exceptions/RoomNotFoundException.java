package com.hotel.exceptions;

public class RoomNotFoundException extends  Exception {
    public RoomNotFoundException(String message){
        super(message);
    }
}
