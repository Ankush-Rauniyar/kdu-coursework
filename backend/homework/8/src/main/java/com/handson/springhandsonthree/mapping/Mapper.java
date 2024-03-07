package com.handson.springhandsonthree.mapping;

import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.entity.Vehicle;


public class Mapper {
    private Mapper() {
    }

    public static VehicleDto convertToDto(Vehicle vehicle){
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setFactoryLocation(vehicle.getFactoryLocation());
        vehicleDto.setIndex(1);
        vehicleDto.setPrice(vehicle.getPrice());
        return vehicleDto;
    }

    public static Vehicle convertToVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setFactoryLocation(vehicleDto.getFactoryLocation());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setPrice(vehicleDto.getPrice());
        return vehicle;
    }

    public static Mapper createMapper() {
        return new Mapper();
    }
}
