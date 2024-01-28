package com.assignment.assignmenttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseForwardGeocoding {
    private double latitude;
    private double longitude;
}
