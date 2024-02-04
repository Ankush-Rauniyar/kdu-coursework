package com.project.smarthome.service;

import com.project.smarthome.dao.DeviceRepository;
import com.project.smarthome.dao.InventoryRepository;
import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.dto.request.RegisterDeviceRequestDto;
import com.project.smarthome.dto.response.RegisterDeviceResponseDto;
import com.project.smarthome.entity.Device;
import com.project.smarthome.entity.Inventory;
import com.project.smarthome.entity.Users;
import com.project.smarthome.exception.DeviceCantBeRegisteredException;
import com.project.smarthome.exception.DeviceNotRegisteredException;
import com.project.smarthome.exception.ErrorWhileExecutingQuery;
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

    public RegisterDeviceResponseDto addDevice(RegisterDeviceRequestDto registerDeviceRequestDto,String token){
        if(token == null){
            throw new DeviceCantBeRegisteredException("only admin can add the device");
        }
        String username = jwtUtil.decodeToken(token);
        Optional<Users> adminUser = usersRepository.findByUsername(username);
        if(adminUser.isPresent()){
            if(!adminUser.get().getRole().equals("ROLE_ADMIN")){
                throw new DeviceCantBeRegisteredException("only admin can add the device");
            }
        }


        Optional<Inventory> inventory = inventoryRepository.findById(registerDeviceRequestDto.getKickstonId());
        if(inventory.isPresent()){
            Inventory current = inventory.get();
            Optional<Device> check = deviceRepository.findById(registerDeviceRequestDto.getKickstonId());
            if(check.isEmpty()){
                throw new DeviceNotRegisteredException("device is in inventory but not registered");
            }
            if(current.getDevicePassword().equals(registerDeviceRequestDto.getDevicePassword()) && current.getDeviceUsername().equals(registerDeviceRequestDto.getDeviceUserName())){
                RegisterDeviceResponseDto registerDeviceResponseDto = new RegisterDeviceResponseDto();
                Device device = new Device();
                device.setKickstonId(registerDeviceRequestDto.getKickstonId());
                device.setDeviceUsername(registerDeviceRequestDto.getDeviceUserName());
                device.setDevicePassword(registerDeviceRequestDto.getDevicePassword());
                Device received = deviceRepository.save(device);
                registerDeviceResponseDto.setObject(received.getDeviceUsername());
                return registerDeviceResponseDto;
            }else{
                throw new ErrorWhileExecutingQuery("Credentials mismatch");
            }
        }else{
            throw new ErrorWhileExecutingQuery("No such device exists in inventory");
        }
    }
}
