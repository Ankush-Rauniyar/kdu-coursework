package com.handsonspring.homeworkeleven.exceptions;

public class ErrorWhileExecutingQuery extends RuntimeException{
    public ErrorWhileExecutingQuery(String msg){
        super(msg);
    }
}
