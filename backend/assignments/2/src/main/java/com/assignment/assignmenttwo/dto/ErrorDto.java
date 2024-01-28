package com.assignment.assignmenttwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDto {
    private String message;
    private int code;
}
