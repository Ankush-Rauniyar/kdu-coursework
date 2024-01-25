package com.handson.springhandsonthree.exceptions;

import lombok.Data;

@Data
public class VehicleNotFoundException extends RuntimeException {
    public final String msg;

    /**
     *
     * @param vehicleId
     */
    public VehicleNotFoundException(int vehicleId) {
        super("Vehicle with ID: " + vehicleId + " does not exist");
        this.msg = getMessage();
    }
}

