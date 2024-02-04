package com.project.smarthome.dto.response;

import com.project.smarthome.entity.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseAddResponseDto {
    private String message="Added House successfully";
    private House house;
    private HttpStatus httpStatus = HttpStatus.OK;
}
