package com.project.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDeviceRequestDto {
    private String kickstonId;
    private String deviceUserName;
    private String devicePassword;
}
