package com.project.smarthome.dto.response;

import com.project.smarthome.entity.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HousesAllResponseDto {
    private String message =" Successfully retrieved all list of Houses";
    private String houses;
    private HttpStatus httpStatus = HttpStatus.OK;
}
