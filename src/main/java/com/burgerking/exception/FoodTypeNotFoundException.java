package com.burgerking.exception;

public class FoodTypeNotFoundException extends RuntimeException{
    public FoodTypeNotFoundException(String message){
        super(message);
    }
}
