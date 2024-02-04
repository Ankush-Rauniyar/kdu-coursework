package com.project.smarthome.dto.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryRequestDto {
    @JsonProperty("kickston_id")
    private String kickstonId;

    @JsonProperty("device_username")
    private String deviceUsername;

    @JsonProperty("device_password")
    private String devicePassword;

    @JsonProperty("manufacture_date_time")
    private String manufactureDateTime;

    @JsonProperty("manufacture_factory_place")
    private String manufactureFactoryPlace;
}
