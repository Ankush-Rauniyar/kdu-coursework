package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseUpdateResponseDto {
    private String message ="House Address updated successfully";
    private String houses;
    private HttpStatus httpStatus = HttpStatus.OK;
}
