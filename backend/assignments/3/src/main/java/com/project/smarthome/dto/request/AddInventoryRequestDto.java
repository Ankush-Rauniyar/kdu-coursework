package com.project.smarthome.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryRequestDto {
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
    private String manufactureDateTime;
    private String manufactureFactoryPlace;
}
