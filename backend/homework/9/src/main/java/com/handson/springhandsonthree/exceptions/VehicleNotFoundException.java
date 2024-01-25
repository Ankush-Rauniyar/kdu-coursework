package com.handson.springhandsonthree.exceptions;

import lombok.Data;

@Data
public class VehicleNotFoundException extends RuntimeException {
    private int vehicleId;
    public String msg;

    public VehicleNotFoundException(int vehicleId) {
        super("Vehicle with ID: " + vehicleId + " does not exist");
        this.vehicleId = vehicleId;
        this.msg = getMessage();
    }
}

