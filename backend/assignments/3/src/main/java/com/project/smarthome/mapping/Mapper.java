package com.project.smarthome.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.smarthome.dto.request.AddInventoryRequestDto;
import com.project.smarthome.dto.request.HouseAddRequestDto;
import com.project.smarthome.dto.request.UserRegisterRequestDto;
import com.project.smarthome.entity.House;
import com.project.smarthome.entity.Inventory;
import com.project.smarthome.entity.Users;

import java.util.List;

public class Mapper {
    public static Users convertToUser(UserRegisterRequestDto userRegisterRequestDto){
        Users current = new Users();
        current.setUsername(userRegisterRequestDto.getUsername());
        current.setPassword(userRegisterRequestDto.getPassword());
        current.setName(userRegisterRequestDto.getName());
        current.setFirstName(userRegisterRequestDto.getFirstName());
        current.setLastName(userRegisterRequestDto.getLastName());
        current.setEmailId(userRegisterRequestDto.getEmailId());
        return current;
    }
    public static <T> String convertToJson(List<T> objList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(objList);
    }

    public static House convertToHouse(HouseAddRequestDto houseAddRequestDto){
        House house = new House();
        house.setHouseName(houseAddRequestDto.getHouseName());
        house.setAddress(houseAddRequestDto.getAddress());
        return house;
    }

    public static Inventory convertToInventory(AddInventoryRequestDto addInventoryRequestDto){
        Inventory inventory = new Inventory();
        inventory.setKickstonId(addInventoryRequestDto.getKickstonId());
        inventory.setDeviceUsername(addInventoryRequestDto.getDeviceUsername());
        inventory.setDevicePassword(addInventoryRequestDto.getDevicePassword());
        inventory.setManufactureDateTime(addInventoryRequestDto.getManufactureDateTime());
        inventory.setManufactureFactoryPlace(addInventoryRequestDto.getManufactureFactoryPlace());
        return inventory;
    }
}
