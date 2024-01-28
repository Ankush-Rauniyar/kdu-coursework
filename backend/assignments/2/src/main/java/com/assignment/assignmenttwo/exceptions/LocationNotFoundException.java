package com.assignment.assignmenttwo.exceptions;


public class LocationNotFoundException extends RuntimeException{
    private final String message;

    public LocationNotFoundException(String message){
        this.message = message;
    }
}
