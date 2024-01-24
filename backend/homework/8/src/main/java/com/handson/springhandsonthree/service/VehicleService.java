package com.handson.springhandsonthree.service;

import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.entity.Vehicle;
import com.handson.springhandsonthree.mapping.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handson.springhandsonthree.repository.VehicleRepository;

@Service
public class VehicleService implements VehicleGenericService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleDto accessVehicle(int id){
        Vehicle vehicle = vehicleRepository.getVehicle(id);
        if (vehicle == null) {
            return null;
        }
        return Mapper.convertToDto(vehicle);
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = Mapper.convertToVehicle(vehicleDto);
        Vehicle current = vehicleRepository.addVehicle(vehicle);
        return Mapper.convertToDto(current);
    }

    @Override
    public VehicleDto removeVehicle(int id) {
        Vehicle vehicle = vehicleRepository.deleteVehicle(id);
        return Mapper.convertToDto(vehicle);
    }

    @Override
    public VehicleDto upgradeVehicle(VehicleDto vehicleDto) {
        Vehicle current = Mapper.convertToVehicle(vehicleDto);
        Vehicle vehicle = vehicleRepository.updateVehicle(vehicleDto.getIndex(),current);
        return Mapper.convertToDto(vehicle);
    }

    public VehicleDto findVehicleExpense(String condition){
        return Mapper.convertToDto(vehicleRepository.findRequired(condition));

    }
}
