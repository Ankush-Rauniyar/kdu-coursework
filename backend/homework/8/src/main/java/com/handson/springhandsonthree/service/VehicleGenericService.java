package com.handson.springhandsonthree.service;

import com.handson.springhandsonthree.dto.VehicleDto;
import org.springframework.stereotype.Service;

@Service
public interface VehicleGenericService {

    public VehicleDto createVehicle(VehicleDto vehicleDto);
    public VehicleDto accessVehicle(int id);

    public VehicleDto removeVehicle(int id);

    public VehicleDto upgradeVehicle(VehicleDto vehicleDto);
}
