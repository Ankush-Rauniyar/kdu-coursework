package com.handsonspring.homeworkeleven.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDto {
    private String msg;
    private int code;

}
