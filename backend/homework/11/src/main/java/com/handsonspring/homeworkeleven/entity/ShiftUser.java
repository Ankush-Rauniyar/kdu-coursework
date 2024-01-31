package com.handsonspring.homeworkeleven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ShiftUser {
    private String shiftUserId;
    private String shiftId;
    private String userId;
    private String tenantId;
}
