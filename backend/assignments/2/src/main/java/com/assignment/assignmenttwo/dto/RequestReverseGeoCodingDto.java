package com.assignment.assignmenttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestReverseGeoCodingDto {
    private String latitude;
    private String longitude;
}
