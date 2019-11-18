package com.burgerking.exception;

public class FilteredListIsEmptyException extends RuntimeException{
    public FilteredListIsEmptyException(String message){
        super(message);
    }
}
