package com.handsontwelve.twelvehomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ShiftUserDto {
    private UUID shiftUserId;
}
