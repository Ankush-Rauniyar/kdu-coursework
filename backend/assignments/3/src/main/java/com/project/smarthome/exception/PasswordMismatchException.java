package com.project.smarthome.exception;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException(String msg){
        super(msg);
    }
}
