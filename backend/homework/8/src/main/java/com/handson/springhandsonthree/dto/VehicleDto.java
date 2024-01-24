package com.handson.springhandsonthree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class VehicleDto {
    private int index;
    private int id;
    private String factoryLocation;
    private String model;
    private int price;
}
