package com.assignment.assignmenttwo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InvalidInputProvidedException extends RuntimeException{
    private final String message;
}
