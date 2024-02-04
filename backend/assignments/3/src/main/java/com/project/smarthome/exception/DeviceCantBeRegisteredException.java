package com.project.smarthome.exception;

public class DeviceCantBeRegisteredException extends RuntimeException{
    public DeviceCantBeRegisteredException(String msg){
        super(msg);
    }
}
