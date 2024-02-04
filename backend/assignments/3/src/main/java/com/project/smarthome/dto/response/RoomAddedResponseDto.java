package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomAddedResponseDto {
    private String message ="Added room successfully";
    private RoomResponseDto room;
    private HttpStatus httpStatus = HttpStatus.OK;
}
