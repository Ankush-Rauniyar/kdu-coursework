package com.project.smarthome.exception;

public class ErrorWhileExecutingQuery extends RuntimeException{
    public ErrorWhileExecutingQuery(String msg){
        super(msg);
    }
}
