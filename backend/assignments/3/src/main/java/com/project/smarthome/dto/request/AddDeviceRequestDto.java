package com.project.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceRequestDto {
    private String houseId;
    private String roomId;
    private String kickstonId;
}
