package com.project.smarthome.service;

import com.project.smarthome.dao.DeviceRepository;
import com.project.smarthome.dao.InventoryRepository;
import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.dto.request.RegisterDeviceRequestDto;
import com.project.smarthome.dto.response.RegisterDeviceResponseDto;
import com.project.smarthome.entity.Device;
import com.project.smarthome.entity.Inventory;
import com.project.smarthome.entity.Users;
import com.project.smarthome.exception.*;
import com.project.smarthome.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;
    private InventoryRepository inventoryRepository;
    private UsersRepository usersRepository;
    private JWTUtil jwtUtil;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,
                         InventoryRepository inventoryRepository,
                         JWTUtil jwtUtil,
                         UsersRepository usersRepository){
        this.deviceRepository = deviceRepository;
        this.inventoryRepository = inventoryRepository;
        this.usersRepository = usersRepository;
    }

    public RegisterDeviceResponseDto addDevice(RegisterDeviceRequestDto registerDeviceRequestDto){


        Optional<Inventory> inventory = inventoryRepository.findByKickstonId(registerDeviceRequestDto.getKickstonId());
        if(inventory.isPresent() && inventory.get().getDeviceUsername().equals(registerDeviceRequestDto.getDeviceUserName())){

            Inventory current = inventory.get();
            if(current.getDevicePassword().equals(registerDeviceRequestDto.getDevicePassword())){
                RegisterDeviceResponseDto registerDeviceResponseDto = new RegisterDeviceResponseDto();
//                registerDeviceResponseDto.setObject();
                Device device = new Device();
                device.setKickstonId(registerDeviceRequestDto.getKickstonId());
                device.setDeviceUsername(registerDeviceRequestDto.getDeviceUserName());
                device.setDevicePassword(registerDeviceRequestDto.getDevicePassword());
                Device received = deviceRepository.save(device);
                registerDeviceResponseDto.setObject(received.getDeviceUsername());
                return registerDeviceResponseDto;
            }else{
                throw new PasswordMismatchException("wrong password");
            }
//
//            Optional<Device> check = deviceRepository.findByKickstonId(registerDeviceRequestDto.getKickstonId());
////            Device demo = check.get();
//
//            if(!check.isPresent()){
//                throw new DeviceNotRegisteredException("device is in inventory but not registered");
//            }
//            if(current.getDevicePassword().equals(registerDeviceRequestDto.getDevicePassword()) && current.getDeviceUsername().equals(registerDeviceRequestDto.getDeviceUserName())){
//                RegisterDeviceResponseDto registerDeviceResponseDto = new RegisterDeviceResponseDto();
//                Device device = new Device();
//                device.setKickstonId(registerDeviceRequestDto.getKickstonId());
//                device.setDeviceUsername(registerDeviceRequestDto.getDeviceUserName());
//                device.setDevicePassword(registerDeviceRequestDto.getDevicePassword());
//                Device received = deviceRepository.save(device);
//                registerDeviceResponseDto.setObject(received.getDeviceUsername());
//                return registerDeviceResponseDto;
//            }else{
//                throw new ErrorWhileExecutingQuery("Credentials mismatch");
//            }
        }else{
            throw new NoSuchDevicePresentException("No such device exists in inventory");
        }
    }
}
