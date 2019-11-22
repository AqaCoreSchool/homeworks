package com.company.hw.exceptions;

public class NoSuchBookException extends RuntimeException{
    public NoSuchBookException(String message){
        super(message);
    }
}