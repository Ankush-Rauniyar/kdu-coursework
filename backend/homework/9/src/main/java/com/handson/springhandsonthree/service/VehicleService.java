package com.handson.springhandsonthree.service;

import com.handson.springhandsonthree.dto.ResponseDto;
import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.entity.Vehicle;
import com.handson.springhandsonthree.mapping.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handson.springhandsonthree.repository.VehicleRepository;

@Service
public class VehicleService implements VehicleGenericService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public ResponseDto accessVehicle(int id){
        Vehicle vehicle = vehicleRepository.getVehicle(id);
        return Mapper.convertToResponse(vehicle);
    }

    @Override
    public ResponseDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = Mapper.convertToVehicle(vehicleDto);
        Vehicle current = vehicleRepository.addVehicle(vehicle);
        return Mapper.convertToResponse(current);
    }

    @Override
    public ResponseDto removeVehicle(int id) {
        Vehicle vehicle = vehicleRepository.deleteVehicle(id);
        return Mapper.convertToResponse(vehicle);
    }

    @Override
    public ResponseDto upgradeVehicle(VehicleDto vehicleDto){
        Vehicle current = Mapper.convertToVehicle(vehicleDto);
        Vehicle vehicle = vehicleRepository.updateVehicle(vehicleDto.getIndex(),current);
        return Mapper.convertToResponse(vehicle);
    }

    public ResponseDto findVehicleExpense(String condition){
        return Mapper.convertToResponse(vehicleRepository.findRequired(condition));
    }
}
