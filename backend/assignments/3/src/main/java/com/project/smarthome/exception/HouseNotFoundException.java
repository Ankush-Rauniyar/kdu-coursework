package com.project.smarthome.exception;

public class HouseNotFoundException extends RuntimeException{
    public HouseNotFoundException(String message){
        super(message);
    }
}