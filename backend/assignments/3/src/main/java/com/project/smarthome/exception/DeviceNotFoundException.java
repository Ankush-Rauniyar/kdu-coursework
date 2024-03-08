package com.project.smarthome.exception;

public class DeviceNotFoundException extends RuntimeException{
    public DeviceNotFoundException(String msg){
        super(msg);
    }
}
