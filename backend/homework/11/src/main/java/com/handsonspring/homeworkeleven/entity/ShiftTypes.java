package com.handsonspring.homeworkeleven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ShiftTypes {
    private String shiftTypeId;
    private String shiftTypeName;
    private String descripton;
    private String tenantId;
}
