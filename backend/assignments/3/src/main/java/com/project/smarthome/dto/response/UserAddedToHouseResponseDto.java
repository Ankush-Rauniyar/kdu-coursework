package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddedToHouseResponseDto {
    private String message ="user added to house successfully";
    private String userId;
    private HttpStatus httpStatus = HttpStatus.OK;
}
