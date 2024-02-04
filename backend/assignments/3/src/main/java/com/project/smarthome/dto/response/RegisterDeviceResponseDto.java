package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDeviceResponseDto {
    private String message ="Device registered successully";
    private String object;
    private HttpStatus httpStatus = HttpStatus.OK;
}
