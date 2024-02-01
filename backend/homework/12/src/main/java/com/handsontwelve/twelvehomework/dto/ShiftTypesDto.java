package com.handsontwelve.twelvehomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftTypesDto {
    private UUID shiftId;
    private String shiftTypeName;
    private UUID tenantId;
}
