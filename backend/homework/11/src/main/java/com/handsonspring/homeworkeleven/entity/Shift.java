package com.handsonspring.homeworkeleven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Shift {
    private String shiftId;
    private String shiftName;
    private String dateStart;
    private String dateEnd;
    private String timeStart;
    private String timeEnd;
    private String tenantId;
}
