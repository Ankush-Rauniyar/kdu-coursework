package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDetailsResponseDto {
    private String message ="Successfully received rooms and device";
    private DeviceAndRooms roomsAndDevices;
    private HttpStatus httpStatus = HttpStatus.OK;
}
