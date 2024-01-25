package com.handson.springhandsonthree.mapping;

import com.handson.springhandsonthree.dto.ResponseDto;
import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.entity.Vehicle;

import java.util.Random;


public class Mapper {
    private Mapper() {
    }

    private static Random random = new Random();

    public static VehicleDto convertToDto(Vehicle vehicle){
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setFactoryLocation(vehicle.getFactoryLocation());
        vehicleDto.setIndex(vehicle.getId() + 100);
        vehicleDto.setPrice(vehicle.getPrice());
        return vehicleDto;
    }

    public static Vehicle convertToVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setFactoryLocation(vehicleDto.getFactoryLocation());
        vehicle.setId(random.nextInt(5000));
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setPrice(vehicleDto.getPrice());
        return vehicle;
    }

    public static ResponseDto convertToResponse(Vehicle vehicle){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(vehicle.getId());
        responseDto.setName(vehicle.getModel());
        return responseDto;
    }

    public static Mapper createMapper() {
        return new Mapper();
    }
}
