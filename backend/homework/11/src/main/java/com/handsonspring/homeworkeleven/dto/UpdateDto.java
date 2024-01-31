package com.handsonspring.homeworkeleven.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateDto {
    private String userName;
    private String tenantId;
}
