package com.handson.springhandsonthree.service;

import com.handson.springhandsonthree.dto.ResponseDto;
import com.handson.springhandsonthree.dto.VehicleDto;
import org.springframework.stereotype.Service;

@Service
public interface VehicleGenericService {

    public ResponseDto createVehicle(VehicleDto vehicleDto);
    public ResponseDto accessVehicle(int id);

    public ResponseDto removeVehicle(int id);

    public ResponseDto upgradeVehicle(VehicleDto vehicleDto);
}
