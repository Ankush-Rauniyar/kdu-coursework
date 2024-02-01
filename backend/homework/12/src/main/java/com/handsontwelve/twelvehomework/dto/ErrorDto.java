package com.handsontwelve.twelvehomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDto {
    private String msg;
    private int code;
}
