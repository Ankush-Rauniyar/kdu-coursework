package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryResponseDto {
    private String message = "Added item to the Inventory successfully";
    private String object;
    private HttpStatus httpStatus = HttpStatus.OK;
}
